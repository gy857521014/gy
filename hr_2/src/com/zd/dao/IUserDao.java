package com.zd.dao;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.User;

public interface IUserDao {
	
	@Select("select * from user where user_name=#{user_name} and user_password=#{user_password}")
	@ResultMap("userMapper")
	public User login(User u);

}
