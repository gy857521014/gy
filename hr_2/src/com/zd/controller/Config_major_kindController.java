package com.zd.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_major_kind;
import com.zd.service.IConfig_file_first_kindService;
import com.zd.service.IConfig_file_second_kindService;
import com.zd.service.IConfig_file_third_kindService;
import com.zd.service.IConfig_major_kindService;

@Controller
public class Config_major_kindController {
	@Autowired
	private IConfig_major_kindService icmkservice;
	//查询所有
	@RequestMapping("page/selcmk")
	public  String selcmk(Map<String, Object> map) {
		Logger logger = LoggerFactory.getLogger(Config_major_kindController.class);
		try{
		List<Config_major_kind> cmklist = 
				icmkservice.selconfigmajor();
		map.put("cmklist", cmklist);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("查询信息错误",e);
		}
		return "/page/client/major_kind";
	}
	//跳转添加获取时间搓
	@RequestMapping("page/tomadd")
	public String tomadd(Map<String, Object> map) {
		Logger logger = LoggerFactory.getLogger(Config_major_kindController.class);
		try{
		long sytime = System.currentTimeMillis();
		map.put("sytime", sytime);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("跳转添加获取时间搓错误",e);
		}
		return "/page/client/major_kind_add";
	}
	
	//添加
	@RequestMapping("page/addcmk")
	public String addcmk(Config_major_kind  config_major_kind) {
		Logger logger = LoggerFactory.getLogger(Config_major_kindController.class);
		try{
			icmkservice.addcmk(config_major_kind);
			}catch (Exception e) {
				e.printStackTrace();
				logger.error("添加错误",e);
			}
		return "redirect:selcmk";
	}
	//删除
	@RequestMapping("page/deletecmk")
	public String deletecmk(String major_kind_id) {
		Logger logger = LoggerFactory.getLogger(Config_major_kindController.class);
		try{
		icmkservice.deletecmk(major_kind_id);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("删除信息错误",e);
				}
		return null;
	}
}
