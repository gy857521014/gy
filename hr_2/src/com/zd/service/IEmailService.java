package com.zd.service;

import java.util.List;

import com.zd.entity.e_mail;

public interface IEmailService {
	//��ѯ
	public List<e_mail> selm();
	// ɾ���û�
	public void deletem(int mid);
	//���	
	public void adde(e_mail e_mail);
	
}
