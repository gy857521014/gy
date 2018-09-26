package com.zd.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zd.entity.User;
import com.zd.service.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService userService;
	
	//��½��ת
	@RequestMapping("/tologin")
	public String tologin() {
		return "login";
	}
	
	//��½��ת
	@RequestMapping("/login")
	public String login(User u) {
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	try {
		User user = userService.login(u);
			if(user != null) {
				return "page/index";
			}
			else {
				return "redirect:tologin";
			}
		}catch (Exception e) {
			logger.error("��½ʧ��",e);
		}
	return "redirect:tologin";
	}
	//��תҳ��ķ���
	@RequestMapping({"/page/top","/page/left","/page/main"})
	public String toPath(HttpServletRequest request) {
		String path = request.getServletPath();
		path = path.substring(1, path.length());
		return path;
	}
	
}
