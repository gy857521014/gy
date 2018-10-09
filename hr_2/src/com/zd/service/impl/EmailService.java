package com.zd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zd.dao.IE_mailDao;
import com.zd.entity.e_mail;
import com.zd.service.IEmailService;

@Service
public class EmailService implements IEmailService{
	@Autowired
	private IE_mailDao imdao;
	//查询所有
	public List<e_mail> selm() {
		return imdao.selm();
	}
	//删除
	public void deletem(int mid) {
		imdao.deletem(mid);
	}
	//添加
	public void adde(e_mail e_mail) {
		imdao.adde(e_mail);
	}
}
