package com.zd.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.zd.entity.User_role;

public interface IUser_roleService {

	public List<User_role> queryUr();
	//��ѯ��ǰ�û��Ľ�ɫ
	/*@Select("select * from user_role where uroleid=#{r_id}")
	public List<User_role> userroleByid();*/
}
