package com.zd.service;

import java.util.List;
import java.util.Map;

import com.zd.entity.Config_public_char;
import com.zd.entity.Salary_standard;

public interface ISalary_standardService {
	
	//查询公共属性薪酬项目
	public List< Config_public_char> selConfig_public_char();
	//薪酬标准登记
	public void addSalary_standard(Salary_standard ss);
	//登记薪酬标准薪酬项目
	public void addCompensation_item(Map map);
}
