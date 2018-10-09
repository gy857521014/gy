package com.zd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IEngage_resumeDao;
import com.zd.entity.Engage_resume;
import com.zd.service.IEngage_resumeService;

@Service
public class Engage_resumeService implements IEngage_resumeService{
	
	@Autowired
	private IEngage_resumeDao resumedao;
	
	//添加
	public void addresume(Engage_resume resume) {
		
		resumedao.addresume(resume);
	}
	
	//模糊查询
	public List<Engage_resume> selresume(Map map) {
		
		return resumedao.selresume(map);
	}
	
	//查询单条
	public Engage_resume selresumeid(int id) {
		
		return resumedao.selresumeid(id);
	}
	
	//修改
	public void updateresume(Engage_resume resume) {
		
		resumedao.updateresume(resume);
	}
	
	public void resumeupdate(int res_id) {
		resumedao.resumeupdate(res_id);
	}
}


