package com.zd.entity;

public class Config_major {
	private int mak_id;//	�������Զ�������
	private String major_kind_id;//ְλ������(�⽡��Config_major_kind ���еģ�major_kind_id)
	private String major_kind_name;//	ְλ�������� 
	private String major_id;//	 ְλ���
	private String major_name;//	ְλ����
	//private int test_amount;
	public int getMak_id() {
		return mak_id;
	}
	public void setMak_id(int mak_id) {
		this.mak_id = mak_id;
	}
	public String getMajor_kind_id() {
		return major_kind_id;
	}
	public void setMajor_kind_id(String major_kind_id) {
		this.major_kind_id = major_kind_id;
	}
	public String getMajor_kind_name() {
		return major_kind_name;
	}
	public void setMajor_kind_name(String major_kind_name) {
		this.major_kind_name = major_kind_name;
	}
	public String getMajor_id() {
		return major_id;
	}
	public void setMajor_id(String major_id) {
		this.major_id = major_id;
	}
	public String getMajor_name() {
		return major_name;
	}
	public void setMajor_name(String major_name) {
		this.major_name = major_name;
	}
	
	
	public Config_major(int mak_id, String major_kind_id, String major_kind_name, String major_id, String major_name) {
		super();
		this.mak_id = mak_id;
		this.major_kind_id = major_kind_id;
		this.major_kind_name = major_kind_name;
		this.major_id = major_id;
		this.major_name = major_name;
	}
	public Config_major() {
		super();
	}
	
	
}
