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
		//��ѯ����
		@RequestMapping("page/selm")
		public  String selm(Map<String, Object> map) {
			Logger logger = LoggerFactory.getLogger(EmailController.class);
			try{
			List<e_mail> mlist = 
					iemservice.selm();
			for (e_mail m : mlist) {
				// ����
				String content = m.getMcontent();
				if(content.length() > 20) {
					// ��ȡǰ20���ַ�,�����...
					String showContent = content.substring(0, 13) + "...";
					m.setNewmcontent(showContent);
				} else {
					m.setNewmcontent(content);
				}
			}
			map.put("mlist", mlist);
			}catch (Exception e) {
				e.printStackTrace();
				logger.error("��ѯ��Ϣ����",e);
			}
			return "/page/client/email";
		}
		//ɾ��
		@RequestMapping("page/deletem")
		public String deletem(int mid) {
			Logger logger = LoggerFactory.getLogger(EmailController.class);
			try{
				iemservice.deletem(mid);;
				}catch (Exception e) {
					e.printStackTrace();
					logger.error("ɾ����Ϣ����",e);
				}
			return null;
			}
		//��ת���
		@RequestMapping("page/madd")
		public String todelete(){
			return "/page/client/emailadd";
		}
		//���
		@RequestMapping("page/addm")
		public String addm(e_mail e_mail) {
			Logger logger = LoggerFactory.getLogger(EmailController.class);
			try{
				//������ӷ���
				iemservice.adde(e_mail);
				}catch (Exception e) {
					e.printStackTrace();
					logger.error("��Ӵ���",e);
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
