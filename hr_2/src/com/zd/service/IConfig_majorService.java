package com.zd.service;

import java.util.List;

import com.zd.entity.Config_major;

public interface IConfig_majorService {
	
	//��ѯְλ���������Ӧ����ְλ
	public List<Config_major> selzhiwei(String majorid);
	
	//����id��ѯְλ
	public Config_major selzhiweiid(String id);
	
	
	public List<Config_major> selallzhi();
}
