package com.zd.entity;

public class e_mail {
	private int mid;
	private String mhead;
	private String mcontent;
	private String newmcontent;// 为了在页面显示20个字符所用
	private int mtype;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMhead() {
		return mhead;
	}
	public void setMhead(String mhead) {
		this.mhead = mhead;
	}
	public String getMcontent() {
		return mcontent;
	}
	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}
	public int getMtype() {
		return mtype;
	}
	public void setMtype(int mtype) {
		this.mtype = mtype;
	}
	public String getNewmcontent() {
		return newmcontent;
	}
	public void setNewmcontent(String newmcontent) {
		this.newmcontent = newmcontent;
	}
	
}
