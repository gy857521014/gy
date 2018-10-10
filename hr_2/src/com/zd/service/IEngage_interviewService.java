package com.zd.service;

import java.util.List;
import java.util.Map;

import com.zd.entity.Engage_interview;
import com.zd.entity.Engage_resume;

public interface IEngage_interviewService {

	public void interviewadd(Engage_interview engage_interview );
	
	public List<Engage_interview> selresume(Map map);
	
	public Engage_interview Engage_interview_queryDan(int id);
	
	public void Engage_interview_upd(Engage_interview engage_interview);
	
	public List<Engage_interview> Engage_interview_query();
	
	public void register_sift_update(Engage_resume engage_resume);
	
	public void check_list_update(Engage_resume engage_resume);
}
