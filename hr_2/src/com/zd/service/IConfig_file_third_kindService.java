package com.zd.service;

import java.util.List;

import com.zd.entity.Config_file_third_kind;

/**
 * ��������service
 * @author ������
 *
 */
public interface IConfig_file_third_kindService {
	//��ѯ
	public List<Config_file_third_kind> selcftk();

	//���ݶ���������Ų�ѯ��������
	public List<Config_file_third_kind> selsanji(String fsk_id);
}
