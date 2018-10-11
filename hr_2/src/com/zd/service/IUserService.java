package com.zd.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.zd.entity.User;
import com.zd.entity.User_role;

public interface IUserService {

	//用户名密码登陆登陆
	public User login(User u);
	
	//判断手机号是否存在
	public int byuser_phone(String user_phone);
	//判断用户名是否存在
	public int byuser_name(String user_name);
	//手机号码登陆
	public User loginByphone(User u);
	
	//查询用户
	public List<User> queryAll(int start);
	//分页查询
	public int queryAll2();
	
	//添加用户
	public void userAdd(User user,List<Integer> userIds);

	//删除用户
	public void userDel(int userid);
	
	//查询用户（修改）
	public User userByid(int userid);
	
	//修改用户信息
	public void userUpdate(User user,List<Integer> uroleid);
	
	//绑定手机号
	public void phoneUpdate(User user);

}
