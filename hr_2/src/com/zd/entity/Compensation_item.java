package com.zd.entity;

public class Compensation_item {
	private String standard_id;
	private int pbc_id;
	private double money;
	private String attribute_name;
	public String getStandard_id() {
		return standard_id;
	}
	public void setStandard_id(String standard_id) {
		this.standard_id = standard_id;
	}
	public int getPbc_id() {
		return pbc_id;
	}
	public void setPbc_id(int pbc_id) {
		this.pbc_id = pbc_id;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getAttribute_name() {
		return attribute_name;
	}
	public void setAttribute_name(String attribute_name) {
		this.attribute_name = attribute_name;
	}
	public Compensation_item(String standard_id, int pbc_id, double money, String attribute_name) {
		super();
		this.standard_id = standard_id;
		this.pbc_id = pbc_id;
		this.money = money;
		this.attribute_name = attribute_name;
	}
	public Compensation_item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
