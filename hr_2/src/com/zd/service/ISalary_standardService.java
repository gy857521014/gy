package com.zd.service;

import com.zd.entity.Compensation_item;
import com.zd.entity.Salary_standard;

public interface ISalary_standardService {
	
	//н���׼�Ǽ�
	public void addSalary_standard(Salary_standard ss);
	//�Ǽ�н���׼н����Ŀ
	public void addCompensation_item(Compensation_item ci);
}
