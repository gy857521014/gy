package com.zd.service;

import java.util.List;

import com.zd.entity.User;

public interface IUserService {

	//��½
	public User login(User u);
	
	//��ѯ�û�
	public List<User> queryAll();

}
