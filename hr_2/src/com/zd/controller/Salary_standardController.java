package com.zd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

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
	
	//薪酬标准登记页面获取时间搓和项目名称
	@RequestMapping("page/tosalarystandard_register")
	public String tosalarystandard_register(Map map,HttpSession session) {
		long sytime = System.currentTimeMillis();
		map.put("sytime", sytime);
		List<Config_public_char> xm = Salary_standardService.selConfig_public_char();
		map.put("xm", xm);
		return "page/salaryCriterion/salarystandard_register";
	}
	
	//薪酬标准登记页面登记
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
			logger.error("薪资标准登记错误",e);
		}
		return "/page/salaryCriterion/salarystandard_register_success";
	}
	
	//薪酬标准登记复核首页
	@RequestMapping("page/tosalarystandard_check_list")
	public String tosalarystandard_check_list(Map map) {
		Logger logger = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			int total = 0;
			int start = 1;
			int li = Salary_standardService.selSalary_standardli();
			map.put("li", li);
			if(li % 10 == 0) {
				total = li/10;
				//总条数 / 每页显示的条数
				map.put("total",total);
			} else {
				total = li/10+1;
				//总条数 / 每页显示的条数+1
				map.put("total",total);
			}
			map.put("start", start);
			List<Salary_standard>  ss = Salary_standardService.selSalary_standard((start-1)*10);
			map.put("ss", ss);
		} catch (Exception e) {
			logger.error("薪酬标准登记复核首页错误",e);
		}
		
		return "/page/salaryCriterion/salarystandard_check_list";
	}
	
	//薪酬标准登记复核尾页
	@RequestMapping("page/tosalarystandard_check_listwy")
	public String tosalarystandard_check_listwy(Map map) {
		Logger logger = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			int total = 0;//总页数
			int li = Salary_standardService.selSalary_standardli();
			map.put("li", li);
			if(li % 10 == 0) {
				total = li/10;
				//总条数 / 每页显示的条数
				map.put("total",total);
			} else {
				total = li/10+1;
				//总条数 / 每页显示的条数+1
				map.put("total",total);
			}
			map.put("start", total);
			List<Salary_standard>  ss = Salary_standardService.selSalary_standard((total-1)*10);
			map.put("ss", ss);
		} catch (Exception e) {
			logger.error("薪酬标准登记复核末页错误",e);
		}
		
		return "/page/salaryCriterion/salarystandard_check_list";
	}
	//薪酬标准登记复核上一页
	@RequestMapping("page/tosalarystandard_check_listup")
	public String tosalarystandard_check_listup(Map map,int start) {
		Logger logger = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			int total = 0;//总页数
			int li = Salary_standardService.selSalary_standardli();
			map.put("li", li);
			if(li % 10 == 0) {
				total = li/10;
				//总条数 / 每页显示的条数
				map.put("total",total);
			} else {
				total = li/10+1;
				//总条数 / 每页显示的条数+1
				map.put("total",total);
			}
			map.put("start", start-1);
			List<Salary_standard>  ss = Salary_standardService.selSalary_standard((start-2)*10);
			map.put("ss", ss);
		} catch (Exception e) {
			logger.error("薪酬标准登记复核上一页错误",e);
		}
		
		return "/page/salaryCriterion/salarystandard_check_list";
	}
	
	
	//薪酬标准登记复核下一页
		@RequestMapping("page/tosalarystandard_check_listdown")
		public String tosalarystandard_check_listdown(Map map,int start) {
			Logger logger = LoggerFactory.getLogger(Salary_standardController.class);
			try {
				int total = 0;//总页数
				int li = Salary_standardService.selSalary_standardli();
				map.put("li", li);
				if(li % 10 == 0) {
					total = li/10;
					//总条数 / 每页显示的条数
					map.put("total",total);
				} else {
					total = li/10+1;
					//总条数 / 每页显示的条数+1
					map.put("total",total);
				}
				map.put("start", start+1);
				List<Salary_standard>  ss = Salary_standardService.selSalary_standard((start)*10);
				map.put("ss", ss);
			} catch (Exception e) {
				logger.error("薪酬标准登记复核下一页错误",e);
			}
			
			return "/page/salaryCriterion/salarystandard_check_list";
		}
	
		//薪酬标准登记复核页跳转
				@RequestMapping("page/tosalarystandard_check_listtz")
				public String tosalarystandard_check_listtz(Map map,int pages) {
					Logger logger = LoggerFactory.getLogger(Salary_standardController.class);
					try {
						int li = Salary_standardService.selSalary_standardli();
						map.put("li", li);
						if(li % 10 == 0) {
							int total = li/10;
							//总条数 / 每页显示的条数
							map.put("total",total);
						} else {
							int total = li/10+1;
							//总条数 / 每页显示的条数+1
							map.put("total",total);
						}
						map.put("start", pages);
						List<Salary_standard>  ss = Salary_standardService.selSalary_standard((pages-1)*10);
						map.put("ss", ss);
					} catch (Exception e) {
						logger.error("薪酬标准登记复核页跳转错误",e);
					}
					return "/page/salaryCriterion/salarystandard_check_list";
				}
				
				//跳转至复核页面
				@RequestMapping("page/tosalarystandard_check")
				public String tosalarystandard_check(Map map,String standard_id) {
					
					Salary_standard ssd = Salary_standardService.selOneSalary_standard(standard_id);
					map.put("ssd", ssd);
					List<Compensation_item> ci = Salary_standardService.selCompensation_item(standard_id);
					map.put("ci", ci);
					return "page/salaryCriterion/salarystandard_check";
				}
	
}
