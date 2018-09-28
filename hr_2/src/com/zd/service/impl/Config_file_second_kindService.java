package com.zd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IConfig_file_second_kindDao;
import com.zd.entity.Config_file_second_kind;
import com.zd.service.IConfig_file_second_kindService;

@Service
public class Config_file_second_kindService implements IConfig_file_second_kindService{
	@Autowired
	private IConfig_file_second_kindDao icfskdao;
	
	@Override
	public List<Config_file_second_kind> selcfsk() {
		return icfskdao.selcfsk();
	}
	//���
	public void addcfsk(Config_file_second_kind config_file_second_kind) {
		icfskdao.addcfsk(config_file_second_kind);
	}
	//��ѯ�޸�
	public Config_file_second_kind selcfskid(String second_kind_id) {
		Config_file_second_kind cfsk = icfskdao.selcfskid(second_kind_id);
		return cfsk;
	}
	//�޸�
	public void updatecfsk(Config_file_second_kind config_file_second_kind) {
		icfskdao.updatecfsk(config_file_second_kind);
	}
	//ɾ��
	public void deletecfsk(int fsk_id) {
		icfskdao.deletecfsk(fsk_id);
	}
	//����һ��������Ų�ѯ��������
	public List<Config_file_second_kind> selerji(String fsk_id) {
		return icfskdao.selerji(fsk_id);
	}
	
}
