package com.zd.entity;

public class Config_major_kind {
	private int mfk_id;	//�������Զ������� 
	private String major_kind_id;	//ְλ������
	private String major_kind_name;//	ְ����λ����
	public int getMfk_id() {
		return mfk_id;
	}
	public void setMfk_id(int mfk_id) {
		this.mfk_id = mfk_id;
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
	public Config_major_kind(int mfk_id, String major_kind_id, String major_kind_name) {
		super();
		this.mfk_id = mfk_id;
		this.major_kind_id = major_kind_id;
		this.major_kind_name = major_kind_name;
	}
	public Config_major_kind() {
		super();
	}
	
	
}
