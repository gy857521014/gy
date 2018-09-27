package com.zd.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;
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
	
		//��ѯ����
		@RequestMapping("page/selcftk")
		public  String selcftk(Map<String, Object> map) {
			Logger logger = LoggerFactory.getLogger(Config_file_second_kindController.class);
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
}
