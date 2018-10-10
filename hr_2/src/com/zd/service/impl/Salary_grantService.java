package com.zd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.ISalary_grantDao;
import com.zd.entity.Config_public_char;
import com.zd.entity.Humman_file;
import com.zd.entity.Salary_grant_details;
import com.zd.entity.Salary_standard_details;
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

	public List<Config_public_char> selpubulic() {
		return dao.selpubulic();
	}


	public int selsum(String first_king_name) {
		return dao.selsum(first_king_name);
	}
	
	
	public int selhum(String first_king_name) {
		return dao.selhum(first_king_name);
	}

	public List<Humman_file> selhuman(String first_king_name) {
		return dao.selhuman(first_king_name);
	}

	public List<Salary_standard_details> selBySSD(String ssd){
		return dao.selBySSD(ssd);
	}

	public void add(Salary_grant_details sgd) {
		dao.add(sgd);
	}

}
