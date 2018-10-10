package com.zd.service;

import java.util.List;

import com.zd.entity.e_mail;

public interface IEmailService {
	//查询
	public List<e_mail> selm();
	// 删除用户
	public void deletem(int mid);
	//添加	
	public void adde(e_mail e_mail);
	
}
