package com.zd.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.ILoginDao;
import com.zd.service.ILoginService;

@Service
public class LoginService implements ILoginService {

	@Autowired
	private ILoginDao loginDao;
	
	//µÇÂ½
	public Map login(Map map) {
		return loginDao.login(map);
	}

}
