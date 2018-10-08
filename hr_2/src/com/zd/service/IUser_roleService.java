package com.zd.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.zd.entity.User_role;

public interface IUser_roleService {

	public List<User_role> queryUr();
	
}
