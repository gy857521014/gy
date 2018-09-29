package com.zd.service.impl;

import java.util.List;
import java.util.Map;

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

	public List<Map> tongjiByFname() {
		return dao.tongjiByFname();
	}

	public int selnumzzz() {
		return dao.selnumzzz();
	}

	public int selhumnummm() {
		return dao.selhumnummm();
	}

	public int shifaaa() {
		return dao.shifaaa();
	}

	public int zonggg() {
		return dao.zonggg();
	}


}
