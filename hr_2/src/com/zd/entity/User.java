package com.zd.entity;

import java.util.List;

/*
 * 用户表
 */

public class User {

	private int userid ;
	private String user_name; //
	private String user_true_name;// VARCHAR(60),
	private String user_password;// VARCHAR(60)
	private String user_phone;
	
	//角色表
	private List<User_role> urole;
	
	
	public List<User_role> getUrole() {
		return urole;
	}
	public void setUrole(List<User_role> urole) {
		this.urole = urole;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_true_name() {
		return user_true_name;
	}
	public void setUser_true_name(String user_true_name) {
		this.user_true_name = user_true_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	@Override
	public String toString() {
		return "User [user_phone=" + user_phone + "]";
	}
	
}
