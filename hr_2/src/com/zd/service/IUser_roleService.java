package com.zd.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.zd.entity.User_role;

public interface IUser_roleService {

	public List<User_role> queryUr();
	//查询当前用户的角色
	/*@Select("select * from user_role where uroleid=#{r_id}")
	public List<User_role> userroleByid();*/
}
