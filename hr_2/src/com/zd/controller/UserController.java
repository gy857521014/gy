package com.zd.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zd.entity.User;
import com.zd.entity.User_role;
import com.zd.service.IUserService;
import com.zd.service.IUser_roleService;
import com.zd.sms.SendSms;


@Controller
public class UserController {

	@Autowired
	private IUserService userService;
	@Autowired
	private IUser_roleService user_roleService;
	
	//��½��ת
	@RequestMapping("/tologin")
	public String tologin() {
		return "page/login";
	}
	@RequestMapping("page/tologin")
	public String pagetologin() {
		return "page/login";
	}
	
	//�û��������½��½
	@RequestMapping("/login")
	public String login(User u,HttpSession session,String ucode) {
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	
	try {
			if(ucode == null || "".equals(ucode)) {
				User user = userService.login(u);
				if(user != null) {
					session.setAttribute("loginUser", user);
					return "page/index";
				}else {
					System.out.println("��½ʧ��");
					return "redirect:tologin";
				}
			}
			if(ucode != null &&  !"".equals(ucode)) {
				User user = userService.loginByphone(u);
				if(user != null) {
					session.setAttribute("loginUser", user);
					return "page/index";
				}else {
					System.out.println("��½ʧ��");
					return "redirect:tologin";
				}
			}
		}catch (Exception e) {
			logger.error("�ֻ������½����",e);
		}
		return "redirect:/tologin";
	}
	
	//�ж��ֻ����Ƿ����
	@RequestMapping("/byuser_phone")
	@ResponseBody
	public int byuser_phone(String user_phone) {
		int count = userService.byuser_phone(user_phone);
		return count;
	}
	
	//�˳�
	@RequestMapping("page/esc")
	public String esc(HttpSession session){
		session.removeAttribute("loginUser");
		return "page/login";
	}
	
	//��תҳ��ķ���
	@RequestMapping({"/page/top","/page/left","/page/main"})
	public String toPath(HttpServletRequest request) {
		String path = request.getServletPath();
		path = path.substring(1, path.length());
		return path;
	}
	
	//��ѯ�����û���Ϣ
	@RequestMapping("page/queryAll")
	public String queryAll(Map<String, Object> map) {
		Logger logger = LoggerFactory.getLogger(UserController.class);
		
		try {
			List<User> userList = userService.queryAll();
			map.put("userList", userList);
		}catch(Exception e) {
			logger.error("��ѯ�����û���Ϣ����",e);
		}
		return "page/power/user_list";
	}
	
	//����û�
	@RequestMapping("page/userAdd")
	public String userAdd(User user, @RequestParam List<Integer> userIds) {
		Logger logger = LoggerFactory.getLogger(UserController.class);
		try {
		userService.userAdd(user,userIds);
		}catch (Exception e) {
			logger.error("����û���Ϣ����",e);
		}
		return "redirect:/page/queryAll";
	}
	
	//ɾ���û�
	@RequestMapping("page/userDel")
	public String userDel(int userid){
		Logger logger = LoggerFactory.getLogger(UserController.class);
		try {
		userService.userDel(userid);
		}catch (Exception e) {
			logger.error("ɾ���û���Ϣ����",e);
		}
		return "page/power/success";
	}
	
	//��ѯ�û����޸ģ�
	@RequestMapping("page/userById")
	public String userById(int userid,Map<String, Object> map) {
		Logger logger = LoggerFactory.getLogger(UserController.class);
		try {
			User user = userService.userByid(userid);// 1, 2
			List<User_role> urList = user_roleService.queryUr();// 1, 2, 3
			// �ж��û��Ľ�ɫ��Щ��ѡ��
			for (User_role user_role : urList) {
				for (User_role r2 : user.getUrole()) {
					if(user_role.getUroleid() == r2.getUroleid()) {
						// ˵��user_role�����ɫҪѡ��
						user_role.setCheck(1);
					}
				}
			}
			map.put("urList", urList);
			map.put("user", user);
		}catch (Exception e) {
			logger.error("�޸�ǰ��ѯ��Ϣ����",e);
		}
		return "page/power/user_edit";
	}

	//ע���ֻ�ǰ��ѯ�û���id���û���
	@RequestMapping("page/phoneByid")
	public String phoneByid(int userid,Map<String, Object> map) {
		Logger logger = LoggerFactory.getLogger(UserController.class);
		try{
			User user = userService.userByid(userid);
			map.put("user", user);
		}catch (Exception e) {
			logger.error("ע���ֻ�ǰ��ѯ�û���id���û�������",e);
		}
		return "page/power/user_phone";
	}
	
	//�޸��û���Ϣ
	@RequestMapping("page/userUpdate")
	public String userUpdate(User user,@RequestParam List<Integer> uroleid) {
		Logger logger = LoggerFactory.getLogger(UserController.class);
		try {
			userService.userUpdate(user, uroleid);
		}catch (Exception e) {
			logger.error("�޸��û���Ϣ����",e);
		}
		return "redirect:/page/queryAll";
	}
	
	//ע���ȡ��֤��
	@RequestMapping("page/upSms")
	@ResponseBody
	public String upSms(String user_phone) {
		String code = SendSms.send(user_phone);
		return code;
	}
	//��½��ȡ��֤��
	@RequestMapping("/upCode")
	@ResponseBody
	public String upCode(String user_phone) {
		String code = SendSms.send(user_phone);
		return code;
	}
	
	//���ֻ���
	@RequestMapping("page/phoneUpdate")
	public String phoneUpdate(User user) {
		Logger logger = LoggerFactory.getLogger(UserController.class);
		try {
		userService.phoneUpdate(user);
		}catch (Exception e) {
			logger.error("���ֻ��Ŵ���",e);
		}
		return "redirect:/page/queryAll";
	}
}
