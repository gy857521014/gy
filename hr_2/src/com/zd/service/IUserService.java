package com.zd.service;

import java.util.List;

import com.zd.entity.User;
import com.zd.entity.User_role;

public interface IUserService {

	//登陆
	public User login(User u);
	
	//查询用户
	public List<User> queryAll();
	
	//添加用户
	public void userAdd(User user,List<Integer> userIds);

	//删除用户
	public void userDel(int userid);
	
	//查询用户（修改）
	public User userByid(int userid);
	//public List<User_role> userroleByid(int r_id);
	
	//修改用户信息
	public void userUpdate(User user,List<Integer> uroleid);

}
