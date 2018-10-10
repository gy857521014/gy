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
	
	//��ѯ������Ƹ
	public List<Engage_major_release> selallrelease() {
		
		List<Engage_major_release> list=releasedao.selallrelease();
		return list;
	}
	
	//����id��ѯ��Ƹ
	public Engage_major_release selidrelease(int id) {
		
		Engage_major_release release=releasedao.selidrelease(id);
		return release;
	}
	
	//�޸�
	public void updaterelease(Engage_major_release release) {
		releasedao.updaterelease(release);
	}
	
	//ɾ��
	public void deleterelease(int id) {
		releasedao.deleterelease(id);
	}
	
	//�����Ƹ��Ϣ
	public void addrelease(Engage_major_release release) {
		
		releasedao.addrelease(release);
	}
	public void addrelease2(Engage_major_release release) {
		releasedao.addrelease2(release);
	}
	
	public void addrelease3(Engage_major_release release) {
		releasedao.addrelease3(release);
	}
	
	public void updatejigou(Engage_major_release release) {
		
		releasedao.updatejigou(release);
	}
}
