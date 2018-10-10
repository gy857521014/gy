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
	//��ѯ����
	@RequestMapping("page/selcpc")
	public  String selcpc(Map<String, Object> map) {
		Logger logger = LoggerFactory.getLogger(Config_public_charController.class);
		try{
		List<Config_public_char> cpclist = 
				icpcservice.selcpc();
		map.put("cpclist", cpclist);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("��ѯ��Ϣ����",e);
		}
		return "/page/client/public_char";
	}
	//��ת���
	@RequestMapping("page/topadd")
	public String topadd() {
		return "/page/client/public_char_add";
	}
	//���
	@RequestMapping("page/addcpc")
	public String addcpc(Config_public_char Config_public_char) {
		Logger logger = LoggerFactory.getLogger(Config_public_charController.class);
		try{
			//������ӷ���
			icpcservice.addcpc(Config_public_char);
			}catch (Exception e) {
				e.printStackTrace();
				logger.error("��Ӵ���",e);
			}
		return "redirect:selcpc";
	}
	//ɾ��
	@RequestMapping("page/deletecpc")
	public String deletecpc(int pbc_id) {
		Logger logger = LoggerFactory.getLogger(Config_public_charController.class);
		try{
			icpcservice.deletecpc(pbc_id);;
			}catch (Exception e) {
				e.printStackTrace();
				logger.error("ɾ����Ϣ����",e);
			}
		return null;
		}
		//��ѯְ��
		@RequestMapping("page/selzc")
		public  String selzc(Map<String, Object> map) {
			Logger logger = LoggerFactory.getLogger(Config_public_charController.class);
			try{
			List<Config_public_char> zclist = 
					ihfservice.listzhicheng();
			map.put("zclist", zclist);
			}catch (Exception e) {
				e.printStackTrace();
				logger.error("��ѯ��Ϣ����",e);
			}
			return "/page/client/profession_design";
		}
		//��ѯн��
		@RequestMapping("page/selxc")
		private String selxc(Map<String, Object> map) {
			Logger logger = LoggerFactory.getLogger(Config_public_charController.class);
			try{
			List<Config_public_char> xclist = 
					Salary_standardService.selConfig_public_char();
			map.put("xclist", xclist);
			}catch (Exception e) {
				e.printStackTrace();
				logger.error("��ѯ��Ϣ����",e);
			}
			return "/page/client/salary_item";
		}
		//��ת���(н��)
		@RequestMapping("page/toxcadd")
		public String toxcdd() {
			return "/page/client/salary_item_register";
		}
		//���(н��)
		@RequestMapping("page/addxc")
		public String addxc(Config_public_char Config_public_char) {
			Logger logger = LoggerFactory.getLogger(Config_public_charController.class);
			try{
				//������ӷ���
				icpcservice.addxc(Config_public_char);
				}catch (Exception e) {
					e.printStackTrace();
					logger.error("��Ӵ���",e);
				}
			return "redirect:selxc";
		}
		
}
