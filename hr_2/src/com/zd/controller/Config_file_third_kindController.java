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
import com.zd.service.IConfig_file_first_kindService;
import com.zd.service.IConfig_file_second_kindService;
import com.zd.service.IConfig_file_third_kindService;

/**
 * ��������controller
 * @author ������
 *
 */
@Controller
public class Config_file_third_kindController {
	@Autowired
	private IConfig_file_third_kindService icftkservice;
	@Autowired
	private IConfig_file_first_kindService icffkservice;
	@Autowired
	private IConfig_file_second_kindService icfskservice;
	
		//��ѯ����
		@RequestMapping("page/selcftk")
		public  String selcftk(Map<String, Object> map) {
			Logger logger = LoggerFactory.getLogger(Config_file_third_kindController.class);
			try{
			List<Config_file_third_kind> cftklist = 
					icftkservice.selcftk();
			map.put("cftklist", cftklist);
			}catch (Exception e) {
				e.printStackTrace();
				logger.error("��ѯ��Ϣ����",e);
			}
			return "/page/client/third_kind";
		}
		//ɾ��
		@RequestMapping("page/deletecftk")
		public String deletecftk(int ftk_id) {
			Logger logger = LoggerFactory.getLogger(Config_file_third_kindController.class);
			try{
			icftkservice.deletecftk(ftk_id);
			}catch (Exception e) {
				e.printStackTrace();
				logger.error("ɾ����Ϣ����",e);
					}
			return "/page/client/third_delete_success";
		}
		//��ת��ӻ�ȡʱ���
		@RequestMapping("page/totadd")
		public String totadd(Map<String, Object> map) {
			Logger logger = LoggerFactory.getLogger(Config_file_third_kindController.class);
			try{
			List<Config_file_first_kind> cffklist = 
					icffkservice.selcffk();
			map.put("cffklist", cffklist);
			List<Config_file_second_kind> cfsklist = 
					icfskservice.selcfsk();
			map.put("cfsklist", cfsklist);
			long sytime = System.currentTimeMillis();
			map.put("sytime", sytime);
			}catch (Exception e) {
				e.printStackTrace();
				logger.error("��ת��ӻ�ȡʱ������",e);
			}
			return "/page/client/third_kind_register";
		}
		//���
		@RequestMapping("page/addcftk")
		public String addcftk(Config_file_third_kind config_file_third_kind) {
			Logger logger = LoggerFactory.getLogger(Config_file_third_kindController.class);
			try{
				//����һ���鵥��
				Config_file_first_kind cffkid = 
						icffkservice.selcffkid(config_file_third_kind.getFirst_kind_id());
				//���ö�����ѯ
				Config_file_second_kind cfskid = 
						icfskservice.selcfskid(config_file_third_kind.getSecond_kind_id());
				//ͨ��ID��һ�����ֲ�����ȥ
				config_file_third_kind.setFirst_kind_name(cffkid.getFirst_kind_name());
				//ͨ��ID��������ֲ�����ȥ
				config_file_third_kind.setSecond_kind_name(cfskid.getSecond_kind_name());
				//������ӷ���
				icftkservice.addcftk(config_file_third_kind);
				}catch (Exception e) {
					e.printStackTrace();
					logger.error("��Ӵ���",e);
				}
			return "/page/client/third_kind_register_success";
		}
		// ��ѯ�޸�
		@RequestMapping("page/selcftkid")
		public String selcfskid(Map<String, Object> map,String third_kind_id){
			Logger logger = LoggerFactory.getLogger(Config_file_third_kindController.class);
			try{
				Config_file_third_kind cftks = icftkservice.selcftkid(third_kind_id);
			map.put("cftks", cftks);
			}catch (Exception e) {
				e.printStackTrace();
				logger.error("��ѯ��Ϣ����",e);
			}
			return "/page/client/third_kind_change";
		}
		// �޸�
		@RequestMapping("page/updatecftk")
		public String updatecftk(Config_file_third_kind config_file_third_kind){
			icftkservice.updatecftk(config_file_third_kind);
			return "/page/client/third_kind_change_success";
		}
}


