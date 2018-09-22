package com.zd.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zd.service.ILoginService;

@Controller
public class LoginController {

	@Autowired
	private ILoginService loginService;
	
	@RequestMapping("/toLogin")
	public String toLogin(){
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam Map<String, String> map){
		//´´½¨ÈÕÖ¾
		Logger logger = LoggerFactory.getLogger(LoginController.class);
		try{
			Map loginMap = loginService.login(map);
			if(loginMap != null){
				//µÇÂ½³É¹¦
				return "redirect:SelallStudent";
			}else{
				//µÇÂ½Ê§°Ü
				return "redirect:toLogin";
			}
		}catch (Exception e) {
			logger.error("µÇÂ½Ê§°Ü", e);
		}
		return "redirect:toLogin";
	}
}
