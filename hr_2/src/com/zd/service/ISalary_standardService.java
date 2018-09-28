package com.zd.service;

import java.util.List;
import java.util.Map;

import com.zd.entity.Compensation_item;
import com.zd.entity.Config_public_char;
import com.zd.entity.Salary_standard;

public interface ISalary_standardService {
	
	//查询公共属性薪酬项目
	public List< Config_public_char> selConfig_public_char();
	//薪酬标准登记
	public void addSalary_standard(Salary_standard ss);
	//登记薪酬标准薪酬项目
	public void addCompensation_item(Map map);
	//薪酬标准登记复核页面例
	public int selSalary_standardli();
	//薪酬标准登记复核页面查询*****
	public List<Salary_standard> selSalary_standard(int start);
	//单条查询薪酬标准登记
	public Salary_standard selOneSalary_standard(String standard_id);
	//根据薪酬编号查询薪酬项目名称
	public List<Compensation_item> selCompensation_item(String standard_id);
}
