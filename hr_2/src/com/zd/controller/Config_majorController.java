package com.zd.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_major;
import com.zd.entity.Config_major_kind;
import com.zd.service.IConfig_file_first_kindService;
import com.zd.service.IConfig_file_second_kindService;
import com.zd.service.IConfig_file_third_kindService;
import com.zd.service.IConfig_majorService;
import com.zd.service.IConfig_major_kindService;

@Controller
public class Config_majorController {
	@Autowired
	private IConfig_majorService icmservice;
	@Autowired
	private IConfig_major_kindService icmkservice;
	//��ѯ����
	@RequestMapping("page/selcm")
	public  String selcm(Map<String, Object> map) {
		Logger logger = LoggerFactory.getLogger(Config_majorController.class);
		try{
		List<Config_major> cmlist = 
				icmservice.selallzhi();
		map.put("cmlist", cmlist);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("��ѯ��Ϣ����",e);
		}
		return "/page/client/major";
	}
	//��ת��ӻ�ȡʱ���
	@RequestMapping("page/tocmadd")
	public String tocmadd(Map<String, Object> map) {
		Logger logger = LoggerFactory.getLogger(Config_majorController.class);
		try{
		List<Config_major_kind> cmklist = 
				icmkservice.selconfigmajor();
		map.put("cmklist", cmklist);
		long sytime = System.currentTimeMillis();
		map.put("sytime", sytime);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("��ת��ӻ�ȡʱ������",e);
		}
		return "/page/client/major_add";
	}
	
	//���
	@RequestMapping("page/addcm")
	public String addcmk(Config_major config_major) {
		Logger logger = LoggerFactory.getLogger(Config_majorController.class);
		try{
			//����һ���鵥��
			Config_major_kind cmkid = 
					icmkservice.selcmkid(config_major.getMajor_kind_id());
			//ͨ��ID�����ֲ�����ȥ
			config_major.setMajor_kind_name(cmkid.getMajor_kind_name());
			icmservice.addcm(config_major);
			}catch (Exception e) {
				e.printStackTrace();
				logger.error("��Ӵ���",e);
			}
		return "redirect:selcm";
	}
	//ɾ��
	@RequestMapping("page/deletecm")
	public String deletecm(String major_kind_id) {
		Logger logger = LoggerFactory.getLogger(Config_majorController.class);
		try{
		icmservice.deletecm(major_kind_id);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("ɾ����Ϣ����",e);
				}
		return null;
	}
}
