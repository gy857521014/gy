package com.zd.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zd.entity.Config_file_first_kind;
import com.zd.service.IConfig_file_first_kindService;

@Controller
public class Config_file_first_kindController {
	@Autowired
	private IConfig_file_first_kindService icffkservice;
	
	//��ѯ����
	@RequestMapping("page/selcffk")
	public  String selcffk(Map<String, Object> map) {
		Logger logger = LoggerFactory.getLogger(Config_file_first_kindController.class);
		try{
		List<Config_file_first_kind> cffklist = 
				icffkservice.selcffk();
		map.put("cffklist", cffklist);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("��ѯ��Ϣ����",e);
		}
		return "/page/client/first_kind";
	}
	//��ת��ӻ�ȡʱ���
	@RequestMapping("page/toadd")
	public String toadd(Map<String, Object> map) {
		Logger logger = LoggerFactory.getLogger(Config_file_first_kindController.class);
		try{
		long sytime = System.currentTimeMillis();
		map.put("sytime", sytime);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("��ת��ӻ�ȡʱ������",e);
		}
		return "/page/client/first_kind_register";
	}
	
	//���
	@RequestMapping("page/addcffk")
	public String addcffk(Config_file_first_kind config_file_first_kind) {
		Logger logger = LoggerFactory.getLogger(Config_file_first_kindController.class);
		try{
		icffkservice.addcffk(config_file_first_kind);
			}catch (Exception e) {
				e.printStackTrace();
				logger.error("��Ӵ���",e);
			}
		return "/page/client/first_kind_register_success";
	}
	// ��ѯ�޸�
	@RequestMapping("page/selcffkid")
	public String selcffkid(Map<String, Object> map,String first_kind_id){
		Logger logger = LoggerFactory.getLogger(Config_file_first_kindController.class);
		try{
		Config_file_first_kind cffks = icffkservice.selcffkid(first_kind_id);
		map.put("cffks", cffks);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("��ѯ��Ϣ����",e);
		}
		return "/page/client/first_kind_change";
	}
		
	// �޸�
	@RequestMapping("page/updatecffk")
	public String updatecffk(Config_file_first_kind config_file_first_kind){
		Logger logger = LoggerFactory.getLogger(Config_file_first_kindController.class);
		try{
		icffkservice.updatecffk(config_file_first_kind);;
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("�޸���Ϣ����",e);
				}
		return "/page/client/first_kind_change_success";
	}
	//ɾ��
	@RequestMapping("page/deletecffk")
	public String deletecffk(int ffk_id) {
		Logger logger = LoggerFactory.getLogger(Config_file_first_kindController.class);
		try{
		icffkservice.deletecffk(ffk_id);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("ɾ����Ϣ����",e);
				}
		return "/page/client/first_delete_success";
	}
}
