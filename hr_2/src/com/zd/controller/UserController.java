package com.zd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Remove;
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
	
	//µÇÂ½Ìø×ª
	@RequestMapping("/tologin")
	public String tologin() {
		return "login";
	}
	
	//µÇÂ½Ìø×ª
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
			logger.error("µÇÂ½Ê§°Ü",e);
		}
	return "redirect:tologin";
	}
	
	//ÍË³ö
	@RequestMapping("page/esc")
	public String esc(HttpSession session){
		session.removeAttribute("loginUser");
		return "login";
	}
	
	//Ìø×ªÒ³ÃæµÄ·½·¨
	@RequestMapping({"/page/top","/page/left","/page/main"})
	public String toPath(HttpServletRequest request) {
		String path = request.getServletPath();
		path = path.substring(1, path.length());
		return path;
	}
	
}
