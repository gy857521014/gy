package com.zd.controller;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.ResultMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zd.entity.R_q_conn;
import com.zd.entity.User_role;
import com.zd.service.IR_q_connService;
import com.zd.service.IUser_roleService;

@Controller
public class User_roleController {

	@Autowired
	private IUser_roleService user_roleService;
	@Autowired
	private IR_q_connService r_q_connService;
	
	//��ѯ״ֵ̬Ϊ1�����н�ɫת�������ҳ��
	@RequestMapping("page/queryUr")
	public String queryUr(Map<String, Object> map) {
		Logger logger = LoggerFactory.getLogger(User_roleController.class);
		try {
			List<User_role> urList = user_roleService.queryUr();
			map.put("urList", urList);
		}catch (Exception e) {
			logger.error("���ǰ��ѯ��ɫ��Ϣ����",e);
		}
		return "page/power/user_add";
	}
	
	//��ѯ���н�ɫת������ɫ�������
	@RequestMapping("page/user_roleAll")
	public String user_roleAll(Map<String, Object> map,Integer start) {
		Logger logger = LoggerFactory.getLogger(User_roleController.class);
		try {
			int total = 0;
			int li = user_roleService.queryAll2();
			map.put("li", li);
			if(li % 10 == 0) {
				total = li/10;
				//������ / ÿҳ��ʾ������
				map.put("total",total);
			} else {
				total = li/10+1;
				//������ / ÿҳ��ʾ������+1
				map.put("total",total);
			}
			if(li==0) {
				map.put("starttrue", 0);
			}else {
				map.put("starttrue", start+1);
				map.put("start", start);
				List<User_role> urList = user_roleService.user_roleAll(start*10);
				map.put("urList", urList);
			}
		}catch (Exception e) {
			logger.error("��ѯ���н�ɫ��Ϣ����",e);
		}
		return "page/power/right_list";
	}

	//���ݽ�ɫidɾ����ɫ
	@RequestMapping("page/user_roleDel")
	public String user_roleDel(int uroleid) {
		Logger logger = LoggerFactory.getLogger(User_roleController.class);
		try {
			user_roleService.user_roleDel(uroleid);
		}catch (Exception e) {
			logger.error("ɾ����ɫ����",e);
		}
		return "page/power/success2";
	}
	//��ӽ�ɫǰ����ת����
	@RequestMapping("page/toright_add")
	public String toright_add() {
		return "page/power/right_add";
	}
	
	//��ӽ�ɫ
	@RequestMapping("page/user_roleAdd")
	public String user_roleAdd(User_role ur) {
		Logger logger = LoggerFactory.getLogger(User_roleController.class);
		try {
			user_roleService.user_roleAdd(ur);
		}catch (Exception e) {
			logger.error("��ӽ�ɫ����",e);
		}
		return "redirect:/page/user_roleAll";
	}
	
	//�޸Ľ�ɫǰ�Ĳ�ѯ
	@RequestMapping("page/user_roleByid")
	public String user_roleByid(int uroleid,Map<String, Object> map,Integer start) {
		Logger logger = LoggerFactory.getLogger(User_roleController.class);
		try {
			User_role ur = user_roleService.user_roleByid(uroleid);
			List<R_q_conn> rq = r_q_connService.rqconnAll(uroleid);
			map.put("start", start);
			map.put("rq", rq);
			map.put("ur", ur);
		}catch (Exception e) {
			logger.error("�޸Ľ�ɫǰ�Ĳ�ѯ����",e);
		}
		return "page/power/right_list_information";
	}
	
	//�޸Ľ�ɫ��Ϣ
	@RequestMapping("page/user_roleUpdate")
	public String user_roleUpdate(User_role ur,@RequestParam List<Integer> q_id,Integer start) {
		Logger logger = LoggerFactory.getLogger(UserController.class);
		try {
			user_roleService.user_roleUpdate(ur, q_id);
		}catch (Exception e) {
			logger.error("�޸Ľ�ɫ��Ϣ����",e);
		}
		return "forward:/page/user_roleAll";
	}
	
	//�жϽ�ɫ���Ƿ����
	@RequestMapping("page/byurole_name")
	@ResponseBody
	public int byurole_name(String roleName) {
	int count = user_roleService.byurole_name(roleName);
	return count;
	}
}
