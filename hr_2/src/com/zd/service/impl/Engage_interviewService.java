package com.zd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IEngage_interviewDao;
import com.zd.entity.Engage_interview;
import com.zd.entity.Engage_resume;
import com.zd.service.IEngage_interviewService;

@Service
public class Engage_interviewService implements IEngage_interviewService{

	@Autowired
	private IEngage_interviewDao engage_interviewDao;
	public void interviewadd(Engage_interview engage_interview ) {
		engage_interviewDao.interviewadd(engage_interview);
	}
	
	public List<Engage_interview> selresume(Map map){
		return engage_interviewDao.selresume(map);
	}
	

	public Engage_interview Engage_interview_queryDan(int id) {
		return engage_interviewDao.Engage_interview_queryDan(id);
	}
	
	public void Engage_interview_upd(Engage_interview engage_interview) {
		engage_interviewDao.Engage_interview_upd(engage_interview);
	}
	
	public List<Engage_interview> Engage_interview_query(){
		return engage_interviewDao.Engage_interview_query();
	}
	
	public void register_sift_update(Engage_resume engage_resume) {
		engage_interviewDao.register_sift_update(engage_resume);
	}
	
	public void check_list_update(Engage_resume engage_resume) {
		engage_interviewDao.check_list_update(engage_resume);
	}
}
