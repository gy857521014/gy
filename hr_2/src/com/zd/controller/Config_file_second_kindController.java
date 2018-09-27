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
import com.zd.service.IConfig_file_first_kindService;
import com.zd.service.IConfig_file_second_kindService;

@Controller
public class Config_file_second_kindController {
	@Autowired
	private IConfig_file_second_kindService icfskservice;
	@Autowired
	private IConfig_file_first_kindService icffkservice;
	
	//��ѯ����
	@RequestMapping("page/selcfsk")
	public  String selcffk(Map<String, Object> map) {
		Logger logger = LoggerFactory.getLogger(Config_file_second_kindController.class);
		try{
		List<Config_file_second_kind> cfsklist = 
				icfskservice.selcfsk();
		map.put("cfsklist", cfsklist);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("��ѯ��Ϣ����",e);
		}
		return "/page/client/second_kind";
	}
	//��ת��ӻ�ȡʱ���
	@RequestMapping("page/tosadd")
	public String tosadd(Map<String, Object> map) {
		Logger logger = LoggerFactory.getLogger(Config_file_second_kindController.class);
		try{
		List<Config_file_first_kind> cffklist = 
				icffkservice.selcffk();
		map.put("cffklist", cffklist);
		long sytime = System.currentTimeMillis();
		map.put("sytime", sytime);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("��ת��ӻ�ȡʱ������",e);
		}
		return "/page/client/second_kind_register";
	}
	
	//���
	@RequestMapping("page/addcfsk")
	public String addcfsk(Config_file_second_kind config_file_second_kind,String first_kind_id) {
		Logger logger = LoggerFactory.getLogger(Config_file_second_kindController.class);
		try{
			//����һ���鵥��
			Config_file_first_kind cffkid = 
					icffkservice.selcffkid(first_kind_id);
			//ͨ��ID�����ֲ�����ȥ
			config_file_second_kind.setFirst_kind_name(cffkid.getFirst_kind_name());
			//������ӷ���
		icfskservice.addcfsk(config_file_second_kind);
			}catch (Exception e) {
				e.printStackTrace();
				logger.error("��Ӵ���",e);
			}
		return "/page/client/second_kind_register_success";
	}
	// ��ѯ�޸�
	@RequestMapping("page/selcfskid")
	public String selcfskid(Map<String, Object> map,int fsk_id){
		Logger logger = LoggerFactory.getLogger(Config_file_second_kindController.class);
		try{
			Config_file_second_kind cfsks = icfskservice.selcfskid(fsk_id);
		map.put("cfsks", cfsks);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("��ѯ��Ϣ����",e);
		}
		return "/page/client/second_kind_change";
	}
		
	// �޸�
	@RequestMapping("page/updatecfsk")
	public String updatecfsk(Config_file_second_kind config_file_second_kind){
		icfskservice.updatecfsk(config_file_second_kind);
		return "/page/client/second_kind_change_success";
	}
	//ɾ��
	@RequestMapping("page/deletecfsk")
	public String deletecfsk(int fsk_id) {
		Logger logger = LoggerFactory.getLogger(Config_file_second_kindController.class);
		try{
		icfskservice.deletecfsk(fsk_id);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("ɾ����Ϣ����",e);
				}
		return "/page/client/second_delete_success";
	}
}
