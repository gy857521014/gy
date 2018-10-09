package com.zd.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;
import com.zd.entity.Config_public_char;
import com.zd.service.IConfig_public_charService;
import com.zd.service.IHumman_fileService;
import com.zd.service.ISalary_standardService;


@Controller
public class Config_public_charController {
	@Autowired
	private IConfig_public_charService icpcservice;
	@Autowired
	private IHumman_fileService ihfservice;
	@Autowired
	private ISalary_standardService Salary_standardService;
	//查询所有
	@RequestMapping("page/selcpc")
	public  String selcpc(Map<String, Object> map) {
		Logger logger = LoggerFactory.getLogger(Config_public_charController.class);
		try{
		List<Config_public_char> cpclist = 
				icpcservice.selcpc();
		map.put("cpclist", cpclist);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("查询信息错误",e);
		}
		return "/page/client/public_char";
	}
	//跳转添加
	@RequestMapping("page/topadd")
	public String topadd() {
		return "/page/client/public_char_add";
	}
	//添加
	@RequestMapping("page/addcpc")
	public String addcpc(Config_public_char Config_public_char) {
		Logger logger = LoggerFactory.getLogger(Config_public_charController.class);
		try{
			//调用添加方法
			icpcservice.addcpc(Config_public_char);
			}catch (Exception e) {
				e.printStackTrace();
				logger.error("添加错误",e);
			}
		return "redirect:selcpc";
	}
	//删除
	@RequestMapping("page/deletecpc")
	public String deletecpc(int pbc_id) {
		Logger logger = LoggerFactory.getLogger(Config_public_charController.class);
		try{
			icpcservice.deletecpc(pbc_id);;
			}catch (Exception e) {
				e.printStackTrace();
				logger.error("删除信息错误",e);
			}
		return null;
		}
		//查询职称
		@RequestMapping("page/selzc")
		public  String selzc(Map<String, Object> map) {
			Logger logger = LoggerFactory.getLogger(Config_public_charController.class);
			try{
			List<Config_public_char> zclist = 
					ihfservice.listzhicheng();
			map.put("zclist", zclist);
			}catch (Exception e) {
				e.printStackTrace();
				logger.error("查询信息错误",e);
			}
			return "/page/client/profession_design";
		}
		//查询薪酬
		@RequestMapping("page/selxc")
		private String selxc(Map<String, Object> map) {
			Logger logger = LoggerFactory.getLogger(Config_public_charController.class);
			try{
			List<Config_public_char> xclist = 
					Salary_standardService.selConfig_public_char();
			map.put("xclist", xclist);
			}catch (Exception e) {
				e.printStackTrace();
				logger.error("查询信息错误",e);
			}
			return "/page/client/salary_item";
		}
		//跳转添加(薪酬)
		@RequestMapping("page/toxcadd")
		public String toxcdd() {
			return "/page/client/salary_item_register";
		}
		//添加(薪酬)
		@RequestMapping("page/addxc")
		public String addxc(Config_public_char Config_public_char) {
			Logger logger = LoggerFactory.getLogger(Config_public_charController.class);
			try{
				//调用添加方法
				icpcservice.addxc(Config_public_char);
				}catch (Exception e) {
					e.printStackTrace();
					logger.error("添加错误",e);
				}
			return "redirect:selxc";
		}
		
}
