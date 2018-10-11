package com.zd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.ISalary_standardDao;
import com.zd.entity.Compensation_item;
import com.zd.entity.Config_public_char;
import com.zd.entity.Salary_standard;
import com.zd.entity.Salary_standard_details;
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

	//薪酬标准登记复核页面例
	public int selSalary_standardli() {
		return Salary_standardDao.selSalary_standardli();
	}

	//薪酬标准登记复核页面查询*****
	public List<Salary_standard> selSalary_standard(int start) {
		return Salary_standardDao.selSalary_standard(start);
	}

	//单条查询薪酬标准登记
	public Salary_standard selOneSalary_standard(String standard_id) {
		return Salary_standardDao.selOneSalary_standard(standard_id);
	}

	//根据薪酬编号查询薪酬项目名称
	public List<Compensation_item> selCompensation_item(String standard_id) {
		return Salary_standardDao.selCompensation_item(standard_id);
	}

	//根据薪酬编号修改薪酬标准
	public void updSalary_standard(Salary_standard ss) {
		Salary_standardDao.updSalary_standard(ss);
		
	}

	//根据项目id修改项目金额
	public void updcompensation_item(Map map) {
		Salary_standardDao.updcompensation_item(map);
		
	}

	//添加薪酬标准单详细信息
	public void addSalary_standard_details(Map map) {
		Salary_standardDao.addSalary_standard_details(map);
		
	}

	//薪酬标准模糊查询
	public List<Salary_standard> selLikeSalary_standard(Map map) {
		return Salary_standardDao.selLikeSalary_standard(map);
	}

	//模糊查询薪酬标准例
	public int selLikeSalary_standardli(Map map) {
		return Salary_standardDao.selLikeSalary_standardli(map);
	}

	//根据薪酬编号修改薪酬标准(变更)
	public void updSalary_standardbg(Salary_standard ss) {
		Salary_standardDao.updSalary_standardbg(ss);
	}

	//修改薪酬标准单详细信息
	public void updSalary_standard_details(Map map) {
		Salary_standardDao.updSalary_standard_details(map);
		
	}

	//根据项目id修改项目金额(变更)
	public void updcompensation_itembg(Map map) {
		Salary_standardDao.updcompensation_itembg(map);
		
	}

	//单条查询薪酬标准单详细信息
	public Salary_standard_details sonedelSalary_standard_details(Map map) {
		return Salary_standardDao.sonedelSalary_standard_details(map);
	}

	

	
	
}
