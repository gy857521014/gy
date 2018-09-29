package com.zd.entity;

import java.util.List;

/*
 * 角色表
 */

public class User_role {

	private int uroleid;
	private String urole_name;
	private String urole_exp;
	private int urole_state;
	// 定义属性表示角色是否被选中, 1-选中 0-不选中
	private int check = 0;
	
	//用户表
	private List<User> user;
	
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	public int getUroleid() {
		return uroleid;
	}
	public void setUroleid(int uroleid) {
		this.uroleid = uroleid;
	}
	public String getUrole_name() {
		return urole_name;
	}
	public void setUrole_name(String urole_name) {
		this.urole_name = urole_name;
	}
	public String getUrole_exp() {
		return urole_exp;
	}
	public void setUrole_exp(String urole_exp) {
		this.urole_exp = urole_exp;
	}
	public int getUrole_state() {
		return urole_state;
	}
	public void setUrole_state(int urole_state) {
		this.urole_state = urole_state;
	}
	public int getCheck() {
		return check;
	}
	public void setCheck(int check) {
		this.check = check;
	}
	
	

}
