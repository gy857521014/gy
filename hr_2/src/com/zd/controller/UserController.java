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
	
	//登陆跳转
	@RequestMapping("/tologin")
	public String tologin() {
		return "page/login";
	}
	@RequestMapping("page/tologin")
	public String pagetologin() {
		return "page/login";
	}
	
	//用户名密码登陆登陆
	@RequestMapping("/login")
	public String login(User u,HttpSession session,String ucode,@RequestParam Map<String, String> map,Map resultMap ) {
	Logger logger = LoggerFactory.getLogger(UserController.class);
	try {
			if("".equals(ucode)) {
				User user = userService.login(u);
				if(user != null) {
					session.setAttribute("loginUser", user);
					//保存pojo到session
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
			logger.error("手机号码登陆错误",e);
		}
		return "redirect:/tologin";
	}
	
	//判断手机号是否存在
	@RequestMapping("/byuser_phone")
	@ResponseBody
	public int byuser_phone(String user_phone) {
		int count = userService.byuser_phone(user_phone);
		return count;
	}
	//判断手机号是否存在
	@RequestMapping("page/by_phone")
	@ResponseBody
	public int by_phone(String user_phone) {
		int count = userService.byuser_phone(user_phone);
		return count;
	}
	//判断用户名是否存在
	@RequestMapping("page/by_name")
	@ResponseBody
	public int by_name(String user_name) {
		int count = userService.byuser_name(user_name);
		return count;
	}
	
	//退出
	@RequestMapping("page/esc")
	public String esc(HttpSession session){
		session.removeAttribute("loginUser");
		return "page/login";
	}
	
	//跳转页面的方法
	@RequestMapping({"/page/top","/page/left","/page/main"})
	public String toPath(HttpServletRequest request) {
		String path = request.getServletPath();
		path = path.substring(1, path.length());
		return path;
	}
	
	//查询所有用户信息
	@RequestMapping("page/queryAll")
	public String queryAll(Map map,Integer start, HttpSession session) {
		Logger logger = LoggerFactory.getLogger(UserController.class);
		
		try {
			int total = 0;
			int li = userService.queryAll2();
			map.put("li", li);
			if(li % 10 == 0) {
				total = li/10;
				//总条数 / 每页显示的条数
				map.put("total",total);
			} else {
				total = li/10+1;
				//总条数 / 每页显示的条数+1
				map.put("total",total);
			}
			if(li==0) {
				map.put("starttrue", 0);
			}else {
				Map selMap = new HashMap();
				//selMap.put("isAdmin", "1");//默认不是管理员
				// 判断登陆用户是否有管理员的权限
				User user = (User)session.getAttribute("loginUser");
				List<R_q_conn> rq = user.getRq();
				for (R_q_conn r_q_conn : rq) {
					int qid = r_q_conn.getQ_id();
					if(qid == 8) {
						selMap.put("isAdmin", "2");// 是管理员
					}
				}
				map.put("starttrue", start+1);
				map.put("start", start);
				selMap.put("start1", start*10);// 保存分页参数
				selMap.put("loginUserId", user.getUserid());// 保存当前用户的Id
				List<User> userList = userService.queryAll(selMap);
				map.put("userList", userList);
			}
		}catch(Exception e) {
			logger.error("查询所有用户信息错误",e);
		}
		return "page/power/user_list";
	}
	
	//添加用户
	@RequestMapping("page/userAdd")
	public String userAdd(User user, @RequestParam List<Integer> userIds) {
		Logger logger = LoggerFactory.getLogger(UserController.class);
		try {
		userService.userAdd(user,userIds);
		}catch (Exception e) {
			logger.error("添加用户信息错误",e);
		}
		return "redirect:/page/queryAll?start=0";
	}
	
	//删除用户
	@RequestMapping("page/userDel")
	public String userDel(int userid){
		Logger logger = LoggerFactory.getLogger(UserController.class);
		try {
		userService.userDel(userid);
		}catch (Exception e) {
			logger.error("删除用户信息错误",e);
		}
		return "page/power/success";
	}
	
	//查询用户（修改）
	@RequestMapping("page/userById")
	public String userById(int userid,Map<String, Object> map,Integer start) {
		Logger logger = LoggerFactory.getLogger(UserController.class);
		try {
			User user = userService.userByid(userid);// 1, 2
			List<User_role> urList = user_roleService.queryUr();// 1, 2, 3
			// 判断用户的角色哪些被选中
			for (User_role user_role : urList) {
				for (User_role r2 : user.getUrole()) {
					if(user_role.getUroleid() == r2.getUroleid()) {
						// 说明user_role这个角色要选中
						user_role.setCheck(1);
					}
				}
			}
			map.put("start", start);
			map.put("urList", urList);
			map.put("user", user);
		}catch (Exception e) {
			logger.error("修改前查询信息错误",e);
		}
		return "page/power/user_edit";
	}

	//注册手机前查询用户的id和用户名
	@RequestMapping("page/phoneByid")
	public String phoneByid(int userid,Map<String, Object> map,Integer start) {
		Logger logger = LoggerFactory.getLogger(UserController.class);
		try{
			User user = userService.userByid(userid);
			map.put("start", start);
			map.put("user", user);
		}catch (Exception e) {
			logger.error("注册手机前查询用户的id和用户名错误",e);
		}
		return "page/power/user_phone";
	}
	
	//修改用户信息
	@RequestMapping("page/userUpdate")
	public String userUpdate(User user,@RequestParam List<Integer> uroleid,Integer start) {
		Logger logger = LoggerFactory.getLogger(UserController.class);
		try {
			userService.userUpdate(user, uroleid);
		}catch (Exception e) {
			logger.error("修改用户信息错误",e);
		}
		return "forward:/page/queryAll";
	}
	
	//注册获取验证码
	@RequestMapping("page/upSms")
	@ResponseBody
	public String upSms(String user_phone) {
		String code = SendSms.send(user_phone);
		return code;
	}
	//登陆获取验证码
	@RequestMapping("/upCode")
	@ResponseBody
	public String upCode(String user_phone) {
		String code = SendSms.send(user_phone);
		return code;
	}
	
	//绑定手机号
	@RequestMapping("page/phoneUpdate")
	public String phoneUpdate(User user) {
		Logger logger = LoggerFactory.getLogger(UserController.class);
		try {
		userService.phoneUpdate(user);
		}catch (Exception e) {
			logger.error("绑定手机号错误",e);
		}
		return "redirect:/page/queryAll?start=0";
	}
}
