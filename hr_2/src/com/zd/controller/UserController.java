package com.zd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.lookup.IQualifiedTypeResolutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zd.dao.IR_q_connDao;
import com.zd.dao.IUserDao;
import com.zd.entity.R_q_conn;
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
	@Autowired 
	private IR_q_connDao rqDao;
	
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
	public String login(User u,HttpSession session,String ucode,@RequestParam Map<String, String> map,Map resultMap ) {
	Logger logger = LoggerFactory.getLogger(UserController.class);
	try {
			if("".equals(ucode)) {
				User user = userService.login(u);
				if(user != null) {
					session.setAttribute("loginUser", user);
					//����pojo��session
					return "page/index";
				}else {
					return "redirect:tologin";
				}
			}  
			if(!"".equals(ucode)) {
				User user = userService.loginByphone(u);
				if(user != null) {
					session.setAttribute("loginUser", user);
					return "page/index";
				}else {
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
	//�ж��ֻ����Ƿ����
	@RequestMapping("page/by_phone")
	@ResponseBody
	public int by_phone(String user_phone) {
		int count = userService.byuser_phone(user_phone);
		return count;
	}
	//�ж��û����Ƿ����
	@RequestMapping("page/by_name")
	@ResponseBody
	public int by_name(String user_name) {
		int count = userService.byuser_name(user_name);
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
	public String queryAll(Map map,Integer start, HttpSession session) {
		Logger logger = LoggerFactory.getLogger(UserController.class);
		
		try {
			int total = 0;
			int li = userService.queryAll2();
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
				Map selMap = new HashMap();
				//selMap.put("isAdmin", "1");//Ĭ�ϲ��ǹ���Ա
				// �жϵ�½�û��Ƿ��й���Ա��Ȩ��
				User user = (User)session.getAttribute("loginUser");
				List<R_q_conn> rq = user.getRq();
				for (R_q_conn r_q_conn : rq) {
					int qid = r_q_conn.getQ_id();
					if(qid == 8) {
						selMap.put("isAdmin", "2");// �ǹ���Ա
					}
				}
				map.put("starttrue", start+1);
				map.put("start", start);
				selMap.put("start1", start*10);// �����ҳ����
				selMap.put("loginUserId", user.getUserid());// ���浱ǰ�û���Id
				List<User> userList = userService.queryAll(selMap);
				map.put("userList", userList);
			}
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
		return "redirect:/page/queryAll?start=0";
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
	public String userById(int userid,Map<String, Object> map,Integer start) {
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
			map.put("start", start);
			map.put("urList", urList);
			map.put("user", user);
		}catch (Exception e) {
			logger.error("�޸�ǰ��ѯ��Ϣ����",e);
		}
		return "page/power/user_edit";
	}

	//ע���ֻ�ǰ��ѯ�û���id���û���
	@RequestMapping("page/phoneByid")
	public String phoneByid(int userid,Map<String, Object> map,Integer start) {
		Logger logger = LoggerFactory.getLogger(UserController.class);
		try{
			User user = userService.userByid(userid);
			map.put("start", start);
			map.put("user", user);
		}catch (Exception e) {
			logger.error("ע���ֻ�ǰ��ѯ�û���id���û�������",e);
		}
		return "page/power/user_phone";
	}
	
	//�޸��û���Ϣ
	@RequestMapping("page/userUpdate")
	public String userUpdate(User user,@RequestParam List<Integer> uroleid,Integer start) {
		Logger logger = LoggerFactory.getLogger(UserController.class);
		try {
			userService.userUpdate(user, uroleid);
		}catch (Exception e) {
			logger.error("�޸��û���Ϣ����",e);
		}
		return "forward:/page/queryAll";
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
		return "redirect:/page/queryAll?start=0";
	}
}
