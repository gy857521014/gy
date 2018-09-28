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
import com.zd.service.IHumman_fileService;


@Controller
public class Salary_grantController {
	@Autowired
	private IConfig_file_first_kindService ffk;
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
				return "page/salaryGrant/register_list";
			}
			if(num==2) {
				return "page/salaryGrant/register_list2";
			}
			if(num==3) {
				return "page/salaryGrant/register_list3";
			}
			
		} catch (Exception e) {
			log.error("´íÎó",e);
		}
		return null;
	}
	
}
