package com.zd.service;

import java.util.List;

import com.zd.entity.Config_major_kind;


public interface IConfig_major_kindService {
	
	//��ѯ����ְλ����
	public List<Config_major_kind> selconfigmajor();
	//���ݷ���id��ѯ����
	public Config_major_kind selmajorkindid(int id);
}
