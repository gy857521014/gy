package com.zd.service;

import java.util.List;

import com.zd.entity.User;

public interface IUserService {

	//µÇÂ½
	public User login(User u);
	
	//²éÑ¯ÓÃ»§
	public List<User> queryAll();

}
