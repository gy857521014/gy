package com.zd.entity;

public class Salary_standard {
	private int ssd_id;
	private String standard_id;
	private String standard_name;
	private String designer;
	private String register;
	private String checker;
	private String changer;
	private String regist_time;
	private String check_time;
	private String change_time;
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
	public String getRegist_time() {
		return regist_time;
	}
	public void setRegist_time(String regist_time) {
		this.regist_time = regist_time;
	}
	public String getCheck_time() {
		return check_time;
	}
	public void setCheck_time(String check_time) {
		this.check_time = check_time;
	}
	public String getChange_time() {
		return change_time;
	}
	public void setChange_time(String change_time) {
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
			String checker, String changer, String regist_time, String check_time, String change_time,
			double salary_sum, int check_status, int change_status, String check_comment, String remark) {
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
	@Override
	public String toString() {
		return "Salary_standard [standard_id=" + standard_id + ", standard_name=" + standard_name + ", remark=" + remark
				+ "]";
	}
	
	
	
	
	
}
