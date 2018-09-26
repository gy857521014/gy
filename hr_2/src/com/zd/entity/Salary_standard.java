package com.zd.entity;

import java.sql.Date;

public class Salary_standard {
	private int ssd_id;
	private String standard_id;
	private String standard_name;
	private String designer;
	private String register;
	private String checker;
	private String changer;
	private Date regist_time;
	private Date check_time;
	private Date change_time;
	private double salary_sum;
	private int check_status;
	private int change_status;
	private String check_comment;
	private String remark;
	public int getSsd_id() {
		return ssd_id;
	}
	public void setSsd_id(int ssd_id) {
		this.ssd_id = ssd_id;
	}
	public String getStandard_id() {
		return standard_id;
	}
	public void setStandard_id(String standard_id) {
		this.standard_id = standard_id;
	}
	public String getStandard_name() {
		return standard_name;
	}
	public void setStandard_name(String standard_name) {
		this.standard_name = standard_name;
	}
	public String getDesigner() {
		return designer;
	}
	public void setDesigner(String designer) {
		this.designer = designer;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	public String getChecker() {
		return checker;
	}
	public void setChecker(String checker) {
		this.checker = checker;
	}
	public String getChanger() {
		return changer;
	}
	public void setChanger(String changer) {
		this.changer = changer;
	}
	public Date getRegist_time() {
		return regist_time;
	}
	public void setRegist_time(Date regist_time) {
		this.regist_time = regist_time;
	}
	public Date getCheck_time() {
		return check_time;
	}
	public void setCheck_time(Date check_time) {
		this.check_time = check_time;
	}
	public Date getChange_time() {
		return change_time;
	}
	public void setChange_time(Date change_time) {
		this.change_time = change_time;
	}
	public double getSalary_sum() {
		return salary_sum;
	}
	public void setSalary_sum(double salary_sum) {
		this.salary_sum = salary_sum;
	}
	public int getCheck_status() {
		return check_status;
	}
	public void setCheck_status(int check_status) {
		this.check_status = check_status;
	}
	public int getChange_status() {
		return change_status;
	}
	public void setChange_status(int change_status) {
		this.change_status = change_status;
	}
	public String getCheck_comment() {
		return check_comment;
	}
	public void setCheck_comment(String check_comment) {
		this.check_comment = check_comment;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Salary_standard(int ssd_id, String standard_id, String standard_name, String designer, String register,
			String checker, String changer, Date regist_time, Date check_time, Date change_time, double salary_sum,
			int check_status, int change_status, String check_comment, String remark) {
		super();
		this.ssd_id = ssd_id;
		this.standard_id = standard_id;
		this.standard_name = standard_name;
		this.designer = designer;
		this.register = register;
		this.checker = checker;
		this.changer = changer;
		this.regist_time = regist_time;
		this.check_time = check_time;
		this.change_time = change_time;
		this.salary_sum = salary_sum;
		this.check_status = check_status;
		this.change_status = change_status;
		this.check_comment = check_comment;
		this.remark = remark;
	}
	public Salary_standard() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
