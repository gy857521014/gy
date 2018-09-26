package com.zd.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zd.entity.Config_major;
import com.zd.entity.Config_major_kind;
import com.zd.service.IConfig_majorService;
import com.zd.service.IConfig_major_kindService;

@Controller
public class EngageMajotController {
	
	@Autowired
	private IConfig_major_kindService kindservice;
	
	@Autowired
	private IConfig_majorService majorservice;
	
	@RequestMapping("/page/torecruit")
	public String tosel(Map map) {
		List<Config_major_kind> kindlist=kindservice.selconfigmajor();
		map.put("kindlist", kindlist);
		return "page/recruit/position/position_register";
	}
	
	@RequestMapping("/page/selzhiwei")
	@ResponseBody
	public List<Config_major> selzhiwei(int majorid) {
		List<Config_major> majorlist=majorservice.selzhiwei(majorid);
		return majorlist;
	}
}
