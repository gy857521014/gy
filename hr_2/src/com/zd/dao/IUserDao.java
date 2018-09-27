package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.User;

public interface IUserDao {
	//��½
	@Select("select * from user where user_name=#{user_name} and user_password=#{user_password}")
	@ResultMap("userMapper")
	public User login(User u);

	//��ѯ�����û�
	@Select("select * from user")
	@ResultMap("userMapper")
	public List<User> queryAll();
}
