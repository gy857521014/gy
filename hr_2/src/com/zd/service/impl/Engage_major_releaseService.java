package com.zd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IEngage_major_releaseDao;
import com.zd.entity.Engage_major_release;
import com.zd.service.IEngage_major_releaseService;

@Service
public class Engage_major_releaseService implements IEngage_major_releaseService{

	@Autowired
	private IEngage_major_releaseDao releasedao;
	
	//查询所有招聘
	public List<Engage_major_release> selallrelease() {
		
		List<Engage_major_release> list=releasedao.selallrelease();
		return list;
	}
	
	//根据id查询招聘
	public Engage_major_release selidrelease(int id) {
		
		Engage_major_release release=releasedao.selidrelease(id);
		return release;
	}
	
}
