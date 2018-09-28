package com.zd.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zd.entity.Config_file_first_kind;
import com.zd.service.IConfig_file_first_kindService;
import com.zd.service.IConfig_file_second_kindService;
import com.zd.service.IHumman_fileService;
import com.zd.service.ISalary_grantService;


@Controller
public class Salary_grantController {
	@Autowired
	private ISalary_grantService isg;
	@Autowired
	private IConfig_file_second_kindService fsk;
	@Autowired
	private IConfig_file_first_kindService icffkservice;
	@Autowired
	private IHumman_fileService hf;
	
	@RequestMapping("page/tolo")
	public String tolo() {
		return "page/salaryGrant/register_locate";
	}
	
	@RequestMapping("page/selnum")
	public String selnum(Map map,int num) {
		Logger log = LoggerFactory.getLogger(Salary_grantController.class);
		try {
			if(num==1) {
				List<Config_file_first_kind> arr = icffkservice.selcffk();
				map.put("arr", arr);
				//������
				int numz = hf.selnumz();
				//�ܻ���
				int hsum = icffkservice.selhumnum();
				//ʵ������
				int shifa = hf.shifa();
				//��н��
				int zong = hf.zong();
				map.put("numz", numz);
				map.put("hsum", hsum);
				map.put("shifa", shifa);
				map.put("zong", zong);
				List<Map> mapList = icffkservice.tongjiByFname();
				map.put("mapList", mapList);
				return "page/salaryGrant/register_list";
			}
			if(num==2) {
				int numzz = isg.selnumzz();
				int hsumm = isg.selhumnumm();
				int shifaa = isg.shifaa();
				int zongg = isg.zongg();
				map.put("shifaa", shifaa);
				map.put("zongg", zongg);
				map.put("hsumm", hsumm);
				map.put("numzz", numzz);
				List<Map> maplist =  fsk.tongjiByFname();
				map.put("maplist", maplist);
				return "page/salaryGrant/register_list2";
			}
			if(num==3) {
				return "page/salaryGrant/register_list3";
			}
			
		} catch (Exception e) {
			log.error("����",e);
		}
		return null;
	}
	@RequestMapping("page/toregister_commit")
	public String toregister_commit() {
		return "page/salaryGrant/register_commit";
	}
	
}
