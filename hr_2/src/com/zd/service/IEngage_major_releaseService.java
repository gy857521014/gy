package com.zd.service;

import java.util.List;

import com.zd.entity.Engage_major_release;

public interface IEngage_major_releaseService {
	
	//��ѯ������Ƹ
	public List<Engage_major_release> selallrelease();
	//��ѯ������Ƹ��Ϣ
	public Engage_major_release selidrelease(int id);
	
	//�޸���Ƹ��Ϣ
	public void updaterelease(Engage_major_release release);
	
	//ɾ����Ƹ��Ϣ
	public void deleterelease(int id);
}
