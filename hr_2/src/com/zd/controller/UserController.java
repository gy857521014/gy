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
	
	//��½��ת
	@RequestMapping("/tologin")
	public String tologin() {
		return "page/login";
	}
	@RequestMapping("page/tologin")
	public String pagetologin() {
		return "page/login";
	}
	
	//��½��ת
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
			logger.error("��½ʧ��",e);
		}
	return "redirect:/tologin";
	}
	
	//�˳�
	@RequestMapping("page/esc")
	public String esc(HttpSession session){
		session.removeAttribute("loginUser");
		return "page/login";
	}
	
	//��תҳ��ķ���
	@RequestMapping({"/page/top","/page/left","/page/main"})
	public String toPath(HttpServletRequest request) {
		String path = request.getServletPath();
		path = path.substring(1, path.length());
		return path;
	}
	
	//��ѯ�����û���Ϣ
	@RequestMapping("page/queryAll")
	public String queryAll(Map<String, Object> map) {
		Logger logger = LoggerFactory.getLogger(UserController.class);
		
		try {
			List<User> userList = userService.queryAll();
			map.put("userList", userList);
		}catch(Exception e) {
			logger.error("��ѯ�����û���Ϣ����",e);
		}
		return "page/power/user_list";
	}
	
	//����û�
	@RequestMapping("page/userAdd")
	public String userAdd(User user, @RequestParam List<Integer> userIds) {
		Logger logger = LoggerFactory.getLogger(UserController.class);
		try {
		userService.userAdd(user,userIds);
		}catch (Exception e) {
			logger.error("����û���Ϣ����",e);
		}
		return "redirect:/page/queryAll";
	}
	
	//ɾ���û�
	@RequestMapping("page/userDel")
	public String userDel(int userid){
		Logger logger = LoggerFactory.getLogger(UserController.class);
		try {
		userService.userDel(userid);
		}catch (Exception e) {
			logger.error("ɾ���û���Ϣ����",e);
		}
		return "page/power/success";
	}
	
	//��ѯ�û����޸ģ�
	@RequestMapping("page/userById")
	public String userById(int userid,Map<String, Object> map) {
		Logger logger = LoggerFactory.getLogger(UserController.class);
		try {
		User user = userService.userByid(userid);
		List<User_role> urList = user_roleService.queryUr();
		map.put("urList", urList);
		map.put("user", user);
		}catch (Exception e) {
			logger.error("�޸�ǰ��ѯ��Ϣ����",e);
		}
		return "page/power/user_edit";
	}

	//�޸��û���Ϣ
	@RequestMapping("page/userUpdate")
	public String userUpdate(User user,@RequestParam List<Integer> uroleid) {
		userService.userUpdate(user, uroleid);
		return "redirect:/page/queryAll";
	}
	
}
