package com.zd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.ISalary_grantDao;
import com.zd.service.ISalary_grantService;

@Service
public class Salary_grantService implements ISalary_grantService{
	@Autowired
	private ISalary_grantDao dao;

	public int selnumzz() {
		return dao.selnumzz();
	}

	public int selhumnumm() {
		return dao.selhumnumm();
	}

	public int shifaa() {
		return dao.shifaa();
	}

	public int zongg() {
		return dao.zongg();
	}


}
