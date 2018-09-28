package com.zd.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IUserDao;
import com.zd.dao.IUser_roleDao;
import com.zd.entity.User;
import com.zd.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserDao userDao;
	

	//登陆
	@Override
	public User login(User u) {
		return userDao.login(u);
	}

	//查询所有用户信息
	@Override
	public List<User> queryAll() {
		return userDao.queryAll();
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
	
	
}
