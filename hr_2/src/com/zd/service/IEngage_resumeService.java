package com.zd.service;

import java.util.List;
import java.util.Map;

import com.zd.entity.Engage_resume;

public interface IEngage_resumeService {
	//���
	public void addresume(Engage_resume resume);
	
	//ģ����ѯ
	public List<Engage_resume> selresume(Map map);
	
	//����id��ѯ����
	public Engage_resume selresumeid(int id);
	
	public void updateresume(Engage_resume resume);
	
	//�޸�����״ֵ̬Ϊ3
	public void resumeupdate(int res_id);
	
	public void updemail(int res_id);
	
	public void updemail2(int res_id);
}
