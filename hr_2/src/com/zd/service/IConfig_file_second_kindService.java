package com.zd.service;

import java.util.List;

import com.zd.entity.Config_file_second_kind;

public interface IConfig_file_second_kindService {
	//��ѯ
	public List<Config_file_second_kind> selcfsk();
	//���
	public void addcfsk(Config_file_second_kind config_file_second_kind);
	// ����id��ѯ���޸ģ�
	public Config_file_second_kind selcfskid(String second_kind_id);
	// �޸�
	public void updatecfsk(Config_file_second_kind config_file_second_kind);
	// ɾ���û�
	public void deletecfsk(int fsk_id);
	//����һ��������Ų�ѯ��������
	public List<Config_file_second_kind> selerji(String fsk_id);
}
