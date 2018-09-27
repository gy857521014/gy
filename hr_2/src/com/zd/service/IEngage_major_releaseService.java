package com.zd.service;

import java.util.List;

import com.zd.entity.Engage_major_release;

public interface IEngage_major_releaseService {
	
	public List<Engage_major_release> selallrelease();
	
	public Engage_major_release selidrelease(int id);
}
