package com.zd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zd.entity.Compensation_item;
import com.zd.entity.Config_public_char;
import com.zd.entity.Salary_standard;
import com.zd.entity.User;
import com.zd.service.ISalary_standardService;

@Controller
public class Salary_standardController {
	
	@Autowired
	private ISalary_standardService Salary_standardService;
	
	//н���׼�Ǽ�ҳ���ȡʱ������Ŀ����
	@RequestMapping("page/tosalarystandard_register")
	public String tosalarystandard_register(Map map,HttpSession session) {
		long sytime = System.currentTimeMillis();
		map.put("sytime", sytime);
		List<Config_public_char> xm = Salary_standardService.selConfig_public_char();
		map.put("xm", xm);
		map.put("xmsize", xm.size());
		return "page/salaryCriterion/salarystandard_register";
	}
	
	//н���׼�Ǽ�ҳ��Ǽ�
	@RequestMapping("page/addSalary_standard")
	public String addSalary_standard(Salary_standard ss,@RequestParam Map map) {
		Logger logger = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			Salary_standardService.addSalary_standard(ss);
			Map moneyMap = new HashMap<>();
			String  Standard_id = ss.getStandard_id();
			Set<String> keySet = map.keySet();
			for(String key:keySet) {
				if(key.startsWith("x_")) {
					String attribute_name = key.split("_")[2];
					int pbc_id = Integer.parseInt(key.split("_")[1]);
					double money = Double.parseDouble((String) map.get(key));
					moneyMap.put("pbc_id", pbc_id);
					moneyMap.put("money", money);
					moneyMap.put("standard_id",Standard_id);
					moneyMap.put("attribute_name", attribute_name);
					Salary_standardService.addCompensation_item(moneyMap);
				}
				
			}
		} catch (Exception e) {
			logger.error("н�ʱ�׼�ǼǴ���",e);
		}
		return "/page/salaryCriterion/salarystandard_register_success";
	}
	
	
	//н���׼�ǼǸ�����ҳ
		@RequestMapping("page/tosalarystandard_check_list")
		public String tosalarystandard_check_list(Map map,int start) {
			int total = 0;
			int li = Salary_standardService.selSalary_standardli();
			map.put("li", li);
			if(li % 10 == 0) {
				total = li/10;
				//������ / ÿҳ��ʾ������
				map.put("total",total);
			} else {
				total = li/10+1;
				//������ / ÿҳ��ʾ������+1
				map.put("total",total);
			}
			map.put("starttrue", start+1);
			map.put("start", start);
			List<Salary_standard> ss = Salary_standardService.selSalary_standard(start*10);
			map.put("ss", ss);
			return "/page/salaryCriterion/salarystandard_check_list";
		}
	
				//��ת������ҳ��
				@RequestMapping("page/tosalarystandard_check")
				public String tosalarystandard_check(Map map,String standard_id) {
					
					Salary_standard ssd = Salary_standardService.selOneSalary_standard(standard_id);
					map.put("ssd", ssd);
					List<Compensation_item> ci = Salary_standardService.selCompensation_item(standard_id);
					map.put("ci", ci);
					map.put("cisize", ci.size());
					return "page/salaryCriterion/salarystandard_check";
				}
				//�޸Ĳ����н���׼��н���׼����ϸ��Ϣ
				@RequestMapping("page/tosalarystandard_check_success")
				public String tosalarystandard_check_success(Salary_standard ss,@RequestParam Map map) {
					Salary_standardService.updSalary_standard(ss);
					Map moneyMap = new HashMap<>();
					Map ssdMap = new HashMap<>();
					String Standard_id = ss.getStandard_id();
					String standard_name = ss.getStandard_name();
					Set<String> keySet = map.keySet();
					for(String key:keySet) {
						if(key.startsWith("x_")) {
							String attribute_name = key.split("_")[2];
							int pbc_id = Integer.parseInt(key.split("_")[1]);
							double money = Double.parseDouble((String) map.get(key));
							moneyMap.put("pbc_id", pbc_id);
							moneyMap.put("money", money);
							moneyMap.put("standard_id",Standard_id);
							moneyMap.put("item_name", attribute_name);
							Salary_standardService.updcompensation_item(moneyMap);
							ssdMap.put("standard_id", Standard_id);
							ssdMap.put("standard_name",standard_name);
							ssdMap.put("item_id", pbc_id);
							ssdMap.put("item_name", attribute_name);
							ssdMap.put("salary", money);
							Salary_standardService.addSalary_standard_details(ssdMap);
						}
						}
					
					return "page/salaryCriterion/salarystandard_check_success";
				}
				//��ת��н���׼��ѯ����
				@RequestMapping("page/tosalarystandard_query_locate")
				public String tosalarystandard_query_locate() {
					return "page/salaryCriterion/salarystandard_query_locate";
					
				}
				
				//н���׼ģ����ѯ����ҳ��
				@RequestMapping("page/selLikeSalary_standardsy")
				public String selLikeSalary_standardsy(@RequestParam Map map,Map smp,Map startmap) {
					int total = 0;
					smp.put("startDate", map.get("startDate"));
					smp.put("endDate", map.get("endDate"));
					smp.put("standard_id", map.get("standard_id"));
					smp.put("Keyword", map.get("Keyword"));
					smp.put("start",map.get("start"));
					String startStr = (String)map.get("start");
					int startInt = Integer.parseInt(startStr);//�����ѯҳ��
					map.put("start", startInt*10);
					int li = Salary_standardService.selLikeSalary_standardli(map);
					if(li % 10 == 0) {
						total = li/10;
						//������ / ÿҳ��ʾ������
						smp.put("total", total);
					} else {
						total = li/10+1;
						//������ / ÿҳ��ʾ������+1
						smp.put("total", total);
					}
					smp.put("li", li);
					startmap.put("starttrue", startInt+1);//ʵ��ҳ��
					List<Salary_standard> ss = Salary_standardService.selLikeSalary_standard(map);
					smp.put("ss", ss);
					return "page/salaryCriterion/salarystandard_query_list";
				}
				//����н���׼���
				@RequestMapping("page/selsalarystandard_query")
				public String selsalarystandard_query(Map map,String standard_id) {
					Salary_standard ssd = Salary_standardService.selOneSalary_standard(standard_id);
					map.put("ssd", ssd);
					List<Compensation_item> ci = Salary_standardService.selCompensation_item(standard_id);
					map.put("ci", ci);
					map.put("cisize", ci.size());
					return "page/salaryCriterion/salarystandard_query";
				}
				
	
}
