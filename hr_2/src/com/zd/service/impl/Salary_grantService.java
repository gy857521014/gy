package com.zd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.ISalary_grantDao;
import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;
import com.zd.entity.Config_public_char;
import com.zd.entity.Humman_file;
import com.zd.entity.Salary_grant;
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

	public Config_file_first_kind selall(String fname) {
		return dao.selall(fname);
	}

	public void addsg(Salary_grant sg) {
		dao.addsg(sg);
	}
	
	public List<Salary_grant> selallsg(){
		return dao.selallsg();
	}
	
	public Salary_grant selone(String salary_grant_id) {
		return dao.selone(salary_grant_id);
	}

	public List<Salary_grant_details> selsgdall() {
		return dao.selsgdall();
	}

	public List<Humman_file> selhuman2(String second_kind_name) {
		return dao.selhuman2(second_kind_name);
	}

	public Config_file_second_kind selall2(String fname) {
		return dao.selall2(fname);
	}

	public int selhum2(String second_kind_name) {
		return dao.selhum2(second_kind_name);
	}

	public int selsum2(String second_kind_name) {
		return dao.selsum2(second_kind_name);
	}
	
	public List<Humman_file> selhuman3(String third_kind_name){
		return dao.selhuman3(third_kind_name);
	}
	
	public int selsum3(String third_kind_name) {
		return dao.selsum3(third_kind_name);
	}
	
	public int selhum3(String third_kind_name) {
		return dao.selhum3(third_kind_name);
	}

	public Config_file_third_kind selall3(String fname) {
		return dao.selall3(fname);
	}
}
