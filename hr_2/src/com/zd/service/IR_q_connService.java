package com.zd.service;

import java.util.List;

import com.zd.entity.R_q_conn;

public interface IR_q_connService {

	//根据角色id查询权限关系表里的权限值
	public List<R_q_conn> rqconnAll(int uroleid);
}
