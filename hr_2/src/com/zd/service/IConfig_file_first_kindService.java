package com.zd.service;

import java.util.List;
import java.util.Map;

import com.zd.entity.Config_file_first_kind;

public interface IConfig_file_first_kindService {
	//��ѯ
	public List<Config_file_first_kind> selcffk();
	//���
	public void addcffk(Config_file_first_kind config_file_first_kind);
	// ����id��ѯ���޸ģ�
	public Config_file_first_kind selcffkid(String first_kind_id);
	// �޸�
	public void updatecffk(Config_file_first_kind config_file_first_kind);
	// ɾ���û�
	public void deletecffk(int ffk_id);
	
	public int selhumnum();
	// ͨ��һ������ͳ��������н��
	public List<Map> tongjiByFname();
}
