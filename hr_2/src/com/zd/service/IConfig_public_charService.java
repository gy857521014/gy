package com.zd.service;

import java.util.List;

import com.zd.entity.Config_public_char;

public interface IConfig_public_charService {
	//��ѯ
	public List<Config_public_char> selcpc();
	//���
	public void addcpc(Config_public_char config_public_char);
	// ɾ���û�
	public void deletecpc(int pbc_id);
}
