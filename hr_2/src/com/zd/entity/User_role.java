package com.zd.entity;

import java.util.List;

/*
 * ��ɫ��
 */

public class User_role {

	private int uroleid;
	private String urole_name;
	private String urole_exp;
	private int urole_state;
	// �������Ա�ʾ��ɫ�Ƿ�ѡ��, 1-ѡ�� 0-��ѡ��
	private int check = 0;
	
	//�û���
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
