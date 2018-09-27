package com.zd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.ISalary_standardDao;
import com.zd.entity.Config_public_char;
import com.zd.entity.Salary_standard;
import com.zd.service.ISalary_standardService;

@Service
public class Salary_standardService implements ISalary_standardService{
	@Autowired
	private ISalary_standardDao Salary_standardDao;
	
	//��ѯ��������н����Ŀ
	public List<Config_public_char> selConfig_public_char() {
		return Salary_standardDao.selConfig_public_char();
	}
	
	//н���׼�Ǽ�
	public void addSalary_standard(Salary_standard ss) {
		Salary_standardDao.addSalary_standard(ss);
	}
	//�Ǽ�н���׼н����Ŀ
	public void addCompensation_item(Map map) {
		Salary_standardDao.addCompensation_item(map);
		
	}
	
	
}
