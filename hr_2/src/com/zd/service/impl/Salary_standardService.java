package com.zd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.ISalary_standardDao;
import com.zd.entity.Compensation_item;
import com.zd.entity.Salary_standard;
import com.zd.service.ISalary_standardService;

@Service
public class Salary_standardService implements ISalary_standardService{
	@Autowired
	private ISalary_standardDao Salary_standardDao;
	
	
	//н���׼�Ǽ�
	public void addSalary_standard(Salary_standard ss) {
		Salary_standardDao.addSalary_standard(ss);
	}
	//�Ǽ�н���׼н����Ŀ
	public void addCompensation_item(Compensation_item ci) {
		Salary_standardDao.addCompensation_item(ci);
		
	}
	
	
}
