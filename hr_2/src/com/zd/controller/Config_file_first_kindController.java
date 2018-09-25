package com.zd.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zd.entity.Config_file_first_kind;
import com.zd.service.IConfig_file_first_kindService;

@Controller
public class Config_file_first_kindController {
	
	
	@Autowired
	private IConfig_file_first_kindService icffkservice;
	
	@RequestMapping("tologin")
	public String tologin() {
		return "redirect:selcffk";
	}
	
	
	@RequestMapping("/selcffk")
	public  String selcffk(Map<String, Object> map) {
		List<Config_file_first_kind> cffklist = 
				icffkservice.selcffk();
		map.put("cffklist", cffklist);
		return "/page/client/first_kind";
	}
}
