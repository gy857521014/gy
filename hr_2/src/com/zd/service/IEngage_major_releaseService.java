package com.zd.service;

import java.util.List;

import com.zd.entity.Engage_major_release;

public interface IEngage_major_releaseService {
	
	//查询所有招聘
	public List<Engage_major_release> selallrelease();
	//查询单条招聘信息
	public Engage_major_release selidrelease(int id);
	
	//修改招聘信息
	public void updaterelease(Engage_major_release release);
	
	//删除招聘信息
	public void deleterelease(int id);
}
