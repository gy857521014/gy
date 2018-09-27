package com.zd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IUserDao;
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

}
