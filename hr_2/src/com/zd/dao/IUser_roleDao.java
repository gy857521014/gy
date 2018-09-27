package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.User_role;

public interface IUser_roleDao {
	
	public List<User_role> queryByUid(int userid);
	
	//查询所有角色
	@Select("select * from User_role")
	@ResultMap("user_roleMapper")
	public List<User_role> queryUr();
}
