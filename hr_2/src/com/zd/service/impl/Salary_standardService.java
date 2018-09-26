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
	
	//查询公共属性薪酬项目
	public List<Config_public_char> selConfig_public_char() {
		return Salary_standardDao.selConfig_public_char();
	}
	
	//薪酬标准登记
	public void addSalary_standard(Salary_standard ss) {
		Salary_standardDao.addSalary_standard(ss);
	}
	//登记薪酬标准薪酬项目
	public void addCompensation_item(Map map) {
		Salary_standardDao.addCompensation_item(map);
		
	}
	
	
}
