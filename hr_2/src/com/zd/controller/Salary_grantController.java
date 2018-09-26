package com.zd.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zd.entity.Config_file_first_kind;
import com.zd.service.IConfig_file_first_kindService;


@Controller
public class Salary_grantController {
	@Autowired
	private IConfig_file_first_kindService icffkservice;
	
	@RequestMapping("tolog")
	public String tologin() {
		return "redirect:selnum";
	}
	
	@RequestMapping("selnum")
	public String selnum(Map map) {
		int num = 0;
		if(num==0) {
			List<Config_file_first_kind> arr = icffkservice.selcffk();
			map.put("arr", arr);
		}
		return "page/salaryGrant/register_list";
	}
	
}
