package com.zd.service;

import java.util.List;

import com.zd.entity.Config_major;
import com.zd.entity.Config_major_kind;

public interface IConfig_majorService {
	
	//��ѯְλ���������Ӧ����ְλ
	public List<Config_major> selzhiwei(int majorid);
	
	//����id��ѯְλ
	public Config_major selzhiweiid(int id);
	public List<Config_major> selallzhi();
	//���
	public void addcm(Config_major config_major);
	// ɾ���û�
	public void deletecm(String major_kind_id);
}
