package com.zd.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IUserDao;
import com.zd.entity.User;
import com.zd.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserDao userDao;
	

	//用户名密码登陆登陆
	@Override
	public User login(User u) {
		return userDao.login(u);
	}

	//手机号码登陆
	@Override
	public User loginByphone(User u) {
		return userDao.loginByphone(u);
	}
	//判断手机号是否存在
	@Override
	public int byuser_phone(String user_phone) {
		return userDao.byuser_phone(user_phone);
	}


	//查询所有用户信息
	@Override
	public List<User> queryAll(Map selMap) {
		return userDao.queryAll(selMap);
	}

	//添加用户
	@Override
	public void userAdd(User user,List<Integer> userIds) {
		userDao.userAdd(user);
		//添加关系
		//List<User_role> roleList = user.getUrole();
		if(userIds != null) {
			for (Integer rid : userIds) {
				Map<String, Integer> map = new HashMap<String,Integer>();
				map.put("r_id", rid);
				map.put("u_id", user.getUserid());
				userDao.u_r_connAdd(map);
			}
		}
	}

	//删除用户
	@Override
	public void userDel(int userid) {
		userDao.userDel(userid);
		userDao.u_r_connDel(userid);
	}

	//查询用户（修改）
	@Override
	public User userByid(int userid) {
		return userDao.userByid(userid);
	}

	//修改客户信息
	@Override
	public void userUpdate(User user,List<Integer> uroleid) {
		userDao.userUpdate(user);
		if(uroleid != null) {
			userDao.u_r_connDel(user.getUserid());
			for (Integer rid : uroleid) {
				Map<String, Integer> map = new HashMap<String,Integer>();
				map.put("r_id", rid);
				map.put("u_id", user.getUserid());
				userDao.u_r_connAdd(map);
			}
		}
		
	}

	//绑定手机号
	@Override
	public void phoneUpdate(User user) {
		userDao.phoneUpdate(user);
	}

	//判断用户名是否存在
	@Override
	public int byuser_name(String user_name) {
		return userDao.byuser_name(user_name);
	}
	//分页查询
	@Override
	public int queryAll2() {
		return userDao.queryAll2();
	}

	
}
