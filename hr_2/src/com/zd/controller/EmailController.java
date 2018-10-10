package com.zd.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zd.entity.e_mail;
import com.zd.service.IEmailService;

@Controller
public class EmailController {
		@Autowired
		private IEmailService iemservice;
		//查询所有
		@RequestMapping("page/selm")
		public  String selm(Map<String, Object> map) {
			Logger logger = LoggerFactory.getLogger(EmailController.class);
			try{
			List<e_mail> mlist = 
					iemservice.selm();
			for (e_mail m : mlist) {
				// 正文
				String content = m.getMcontent();
				if(content.length() > 20) {
					// 截取前20个字符,后面加...
					String showContent = content.substring(0, 13) + "...";
					m.setNewmcontent(showContent);
				} else {
					m.setNewmcontent(content);
				}
			}
			map.put("mlist", mlist);
			}catch (Exception e) {
				e.printStackTrace();
				logger.error("查询信息错误",e);
			}
			return "/page/client/email";
		}
		//删除
		@RequestMapping("page/deletem")
		public String deletem(int mid) {
			Logger logger = LoggerFactory.getLogger(EmailController.class);
			try{
				iemservice.deletem(mid);;
				}catch (Exception e) {
					e.printStackTrace();
					logger.error("删除信息错误",e);
				}
			return null;
			}
		//跳转添加
		@RequestMapping("page/madd")
		public String todelete(){
			return "/page/client/emailadd";
		}
		//添加
		@RequestMapping("page/addm")
		public String addm(e_mail e_mail) {
			Logger logger = LoggerFactory.getLogger(EmailController.class);
			try{
				//调用添加方法
				iemservice.adde(e_mail);
				}catch (Exception e) {
					e.printStackTrace();
					logger.error("添加错误",e);
				}
			return "redirect:selm";
		}
		
		@RequestMapping("/page/emailselid")
		@ResponseBody
		private e_mail emailselid(int id){
			e_mail email = iemservice.emailselid(id);
			return email;
		}
}
