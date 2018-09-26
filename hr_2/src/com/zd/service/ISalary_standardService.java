package com.zd.service;

import com.zd.entity.Compensation_item;
import com.zd.entity.Salary_standard;

public interface ISalary_standardService {
	
	//薪酬标准登记
	public void addSalary_standard(Salary_standard ss);
	//登记薪酬标准薪酬项目
	public void addCompensation_item(Compensation_item ci);
}
