package com.zd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.zd.dao.IR_q_connDao;
import com.zd.entity.R_q_conn;
import com.zd.service.IR_q_connService;

@Service
public class R_q_connService implements IR_q_connService {

	@Autowired
	private IR_q_connDao r_q_connDao;

	//根据角色id查询权限关系表里的权限值
	public List<R_q_conn> rqconnAll(int uroleid) {
		return r_q_connDao.rqconnAll(uroleid);
	}
}
