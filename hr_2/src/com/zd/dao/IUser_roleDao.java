package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.User_role;

public interface IUser_roleDao {
	
	public List<User_role> queryByUid(int userid);
	
	//查询状态值为1的所有角色
	@Select("select * from user_role where urole_state = 1")
	@ResultMap("user_roleMapper")
	public List<User_role> queryUr();
}
