package com.zd.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zd.entity.User;
import com.zd.entity.User_role;
import com.zd.service.IUserService;
import com.zd.service.IUser_roleService;

@Controller
public class UserController {

	@Autowired
	private IUserService userService;
	@Autowired
	private IUser_roleService user_roleService;
	
	//登陆跳转
	@RequestMapping("/tologin")
	public String tologin() {
		return "page/login";
	}
	@RequestMapping("page/tologin")
	public String pagetologin() {
		return "page/login";
	}
	
	//登陆跳转
	@RequestMapping("/login")
	public String login(User u,HttpSession session) {
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	try {
		User user = userService.login(u);
			if(user != null) {
				session.setAttribute("loginUser", user);
				return "page/index";
			}
			else {
				return "redirect:tologin";
			}
		}catch (Exception e) {
			logger.error("登陆失败",e);
		}
	return "redirect:/tologin";
	}
	
	//退出
	@RequestMapping("page/esc")
	public String esc(HttpSession session){
		session.removeAttribute("loginUser");
		return "page/login";
	}
	
	//跳转页面的方法
	@RequestMapping({"/page/top","/page/left","/page/main"})
	public String toPath(HttpServletRequest request) {
		String path = request.getServletPath();
		path = path.substring(1, path.length());
		return path;
	}
	
	//查询所有用户信息
	@RequestMapping("page/queryAll")
	public String queryAll(Map<String, Object> map) {
		Logger logger = LoggerFactory.getLogger(UserController.class);
		
		try {
			List<User> userList = userService.queryAll();
			map.put("userList", userList);
		}catch(Exception e) {
			logger.error("查询所有用户信息错误",e);
		}
		return "page/power/user_list";
	}
	
	//添加用户
	@RequestMapping("page/userAdd")
	public String userAdd(User user, @RequestParam List<Integer> userIds) {
		Logger logger = LoggerFactory.getLogger(UserController.class);
		try {
		userService.userAdd(user,userIds);
		}catch (Exception e) {
			logger.error("添加用户信息错误",e);
		}
		return "redirect:/page/queryAll";
	}
	
	//删除用户
	@RequestMapping("page/userDel")
	public String userDel(int userid){
		Logger logger = LoggerFactory.getLogger(UserController.class);
		try {
		userService.userDel(userid);
		}catch (Exception e) {
			logger.error("删除用户信息错误",e);
		}
		return "page/power/success";
	}
	
	//查询用户（修改）
	@RequestMapping("page/userById")
	public String userById(int userid,Map<String, Object> map) {
		Logger logger = LoggerFactory.getLogger(UserController.class);
		try {
		User user = userService.userByid(userid);
		List<User_role> urList = user_roleService.queryUr();
		map.put("urList", urList);
		map.put("user", user);
		}catch (Exception e) {
			logger.error("修改前查询信息错误",e);
		}
		return "page/power/user_edit";
	}

	//修改用户信息
	@RequestMapping("page/userUpdate")
	public String userUpdate(User user,@RequestParam List<Integer> uroleid) {
		userService.userUpdate(user, uroleid);
		return "redirect:/page/queryAll";
	}
	
}
