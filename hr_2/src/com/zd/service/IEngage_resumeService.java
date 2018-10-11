package com.zd.service;

import java.util.List;
import java.util.Map;

import com.zd.entity.Engage_resume;

public interface IEngage_resumeService {
	//添加
	public void addresume(Engage_resume resume);
	
	//模糊查询
	public List<Engage_resume> selresume(Map map);
	
	//根据id查询单条
	public Engage_resume selresumeid(int id);
	
	public void updateresume(Engage_resume resume);
	
	//修改面试状态值为3
	public void resumeupdate(int res_id);
	
	public void updemail(int res_id);
	
	public void updemail2(int res_id);
}
