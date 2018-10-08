package com.zd.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zd.entity.User_role;
import com.zd.service.IUser_roleService;

@Controller
public class User_roleController {

	@Autowired
	private IUser_roleService user_roleService;
	
	//查询所有角色转发的添加页面
	@RequestMapping("page/queryUr")
	public String queryUr(Map<String, Object> map) {
		Logger logger = LoggerFactory.getLogger(User_roleController.class);
		try {
			List<User_role> urList = user_roleService.queryUr();
			map.put("urList", urList);
		}catch (Exception e) {
			logger.error("添加前查询角色信息错误",e);
		}
		return "page/power/user_add";
	}
	
	//查询所有角色转发到角色管理界面
}
