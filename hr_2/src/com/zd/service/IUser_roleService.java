package com.zd.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.zd.entity.User_role;

public interface IUser_roleService {

	//查询状态值为1的所有角色
	public List<User_role> queryUr();
	
	//查询所有角色
	public List<User_role> user_roleAll();
	
	//根据角色id删除角色
	public void user_roleDel(int uroleid);
	
	//添加角色
	public void user_roleAdd(User_role ur);
	
	//修改角色前的查询
	public User_role user_roleByid(int uroleid);
	
	//修改角色信息
	public void user_roleUpdate(User_role ur,List<Integer> q_id);
	
	//判断角色名名是否存在
	public int byurole_name(String urole_name);
}
