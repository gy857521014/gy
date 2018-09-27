package com.zd.dao;

import java.util.List;

import com.zd.entity.User_role;

public interface IUser_roleDao {
	
	public List<User_role> queryByUid(int userid);
}
