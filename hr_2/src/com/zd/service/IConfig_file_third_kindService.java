package com.zd.service;

import java.util.List;

import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;

/**
 * ��������service
 * @author ������
 *
 */
public interface IConfig_file_third_kindService {
	//��ѯ
	public List<Config_file_third_kind> selcftk();
	// ɾ���û�
	public void deletecftk(int ftk_id);
	//���
	public void addcftk(Config_file_third_kind config_file_third_kind);
	// ����id��ѯ���޸ģ�
	public Config_file_third_kind selcftkid(String third_kind_id);
	// �޸�
	public void updatecftk(Config_file_third_kind config_file_third_kind);
	//���ݶ���������Ų�ѯ��������
	public List<Config_file_third_kind> selsanji(String fsk_id);
	
	//������������id��ѯ����
	public Config_file_third_kind selsanjiid(String id);
}
