package com.zd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IUser_roleDao;
import com.zd.entity.User_role;
import com.zd.service.IUser_roleService;

@Service
public class User_roleService implements IUser_roleService {
	@Autowired
	private IUser_roleDao user_roleDao;

	//查询所有角色
	@Override
	public List<User_role> queryUr() {
		return user_roleDao.queryUr();
	}

}
