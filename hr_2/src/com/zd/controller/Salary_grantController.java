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


@Controller
public class Salary_grantController {
	@Autowired
	private IConfig_file_second_kindService fsk;
	@Autowired
	private IConfig_file_first_kindService icffkservice;
	@Autowired
	public IHumman_fileService hf;
	
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
				//总人数
				int numz = hf.selnumz();
				//总机构
				int hsum = icffkservice.selhumnum();
				//实发工资
				int shifa = hf.shifa();
				//总薪资
				int zong = hf.zong();
				map.put("numz", numz);
				map.put("hsum", hsum);
				map.put("shifa", shifa);
				map.put("zong", zong);
				List<Map> mapList = icffkservice.tongjiByFname();
				// fname=一级机构  fsum=11111  fcount=2
				map.put("mapList", mapList);
				return "page/salaryGrant/register_list";
			}
			if(num==2) {
				List<Map> maplist =  fsk.tongjiByFname();
				map.put("maplist", maplist);
				System.out.println(map);
				return "page/salaryGrant/register_list2";
			}
			if(num==3) {
				return "page/salaryGrant/register_list3";
			}
			
		} catch (Exception e) {
			log.error("错误",e);
		}
		return null;
	}
	
}
