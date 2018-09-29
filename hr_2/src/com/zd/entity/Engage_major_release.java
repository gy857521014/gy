package com.zd.entity;

public class Engage_major_release {
	private int mre_id;//	主键，自动增长列
	private String first_kind_id;//一级机构编号
	private String first_kind_name;//一级机构名称 
	private String second_kind_id;//二级机构编号
	private String second_kind_name;//二级机构名称
	private String third_kind_id;//三级机构编号
	private String third_kind_name;//三级机构名称
	private int major_kind_id;//职位分类编号
	private String major_kind_name;//三级机构名称
	private int major_id;//职位编号
	private String major_name;//职位名称
	private int human_amount;//招聘人数
	private String engage_type;//招聘类型
	private String deadline;//截至日期
	private String register;//登记人
	private String changer;//变更人 
	private String regist_time;//登记时间
	private String change_time;//变更时间
	private String major_describe;//职位描述
	private String engage_required;//招聘要求
	private int state;//状态列
	public int getMre_id() {
		return mre_id;
	}
	public void setMre_id(int mre_id) {
		this.mre_id = mre_id;
	}
	
	public String getFirst_kind_name() {
		return first_kind_name;
	}
	public void setFirst_kind_name(String first_kind_name) {
		this.first_kind_name = first_kind_name;
	}
	
	public String getSecond_kind_name() {
		return second_kind_name;
	}
	public void setSecond_kind_name(String second_kind_name) {
		this.second_kind_name = second_kind_name;
	}
	
	public String getThird_kind_name() {
		return third_kind_name;
	}
	public void setThird_kind_name(String third_kind_name) {
		this.third_kind_name = third_kind_name;
	}
	public int getMajor_kind_id() {
		return major_kind_id;
	}
	public void setMajor_kind_id(int major_kind_id) {
		this.major_kind_id = major_kind_id;
	}
	public String getMajor_kind_name() {
		return major_kind_name;
	}
	public void setMajor_kind_name(String major_kind_name) {
		this.major_kind_name = major_kind_name;
	}
	public int getMajor_id() {
		return major_id;
	}
	public void setMajor_id(int major_id) {
		this.major_id = major_id;
	}
	public String getMajor_name() {
		return major_name;
	}
	public void setMajor_name(String major_name) {
		this.major_name = major_name;
	}
	public int getHuman_amount() {
		return human_amount;
	}
	public void setHuman_amount(int human_amount) {
		this.human_amount = human_amount;
	}
	public String getEngage_type() {
		return engage_type;
	}
	public void setEngage_type(String engage_type) {
		this.engage_type = engage_type;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
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
	public String getChange_time() {
		return change_time;
	}
	public void setChange_time(String change_time) {
		this.change_time = change_time;
	}
	public String getMajor_describe() {
		return major_describe;
	}
	public void setMajor_describe(String major_describe) {
		this.major_describe = major_describe;
	}
	public String getEngage_required() {
		return engage_required;
	}
	public void setEngage_required(String engage_required) {
		this.engage_required = engage_required;
	}
	
	public Engage_major_release() {
		super();
	}
	public String getFirst_kind_id() {
		return first_kind_id;
	}
	public void setFirst_kind_id(String first_kind_id) {
		this.first_kind_id = first_kind_id;
	}
	public String getSecond_kind_id() {
		return second_kind_id;
	}
	public void setSecond_kind_id(String second_kind_id) {
		this.second_kind_id = second_kind_id;
	}
	public String getThird_kind_id() {
		return third_kind_id;
	}
	public void setThird_kind_id(String third_kind_id) {
		this.third_kind_id = third_kind_id;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Engage_major_release(int mre_id, String first_kind_id, String first_kind_name, String second_kind_id,
			String second_kind_name, String third_kind_id, String third_kind_name, int major_kind_id,
			String major_kind_name, int major_id, String major_name, int human_amount, String engage_type,
			String deadline, String register, String changer, String regist_time, String change_time,
			String major_describe, String engage_required, int state) {
		super();
		this.mre_id = mre_id;
		this.first_kind_id = first_kind_id;
		this.first_kind_name = first_kind_name;
		this.second_kind_id = second_kind_id;
		this.second_kind_name = second_kind_name;
		this.third_kind_id = third_kind_id;
		this.third_kind_name = third_kind_name;
		this.major_kind_id = major_kind_id;
		this.major_kind_name = major_kind_name;
		this.major_id = major_id;
		this.major_name = major_name;
		this.human_amount = human_amount;
		this.engage_type = engage_type;
		this.deadline = deadline;
		this.register = register;
		this.changer = changer;
		this.regist_time = regist_time;
		this.change_time = change_time;
		this.major_describe = major_describe;
		this.engage_required = engage_required;
		this.state = state;
	}
	
	

	
	
}
