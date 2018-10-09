package com.zd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IConfig_file_third_kindDao;
import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;
import com.zd.service.IConfig_file_third_kindService;
/**
 * ��������service
 * @author ������
 *
 */
@Service
public class Config_file_third_kindService implements IConfig_file_third_kindService {
	@Autowired
	private IConfig_file_third_kindDao icftkdao;
	
	
	@Override
	public List<Config_file_third_kind> selcftk() {
		return icftkdao.selcftk();
	}
	//ɾ��
	public void deletecftk(int ftk_id) {
		icftkdao.deletecftk(ftk_id);
	}
	//���
	public void addcftk(Config_file_third_kind config_file_third_kind) {
		icftkdao.addcftk(config_file_third_kind);
	}
	//��ѯ�޸�
	public Config_file_third_kind selcftkid(String third_kind_id) {
		Config_file_third_kind cftk = icftkdao.selcftkid(third_kind_id);
		return cftk;
	}

	//���ݶ���������Ų�ѯ��������
	public List<Config_file_third_kind> selsanji(String fsk_id) {
		return icftkdao.selsanji(fsk_id);
	}
	//�޸�
	public void updatecftk(Config_file_third_kind config_file_third_kind) {
		icftkdao.updatecftk(config_file_third_kind);
	}
	
	//������������id��ѯ����
	public Config_file_third_kind selsanjiid(String id) {
		Config_file_third_kind third=icftkdao.selsanjiid(id);
		return third;
	}
	//����һ�����ɾ��
	public void deletebh(String first_kind_id) {
		icftkdao.deletebh(first_kind_id);
	}
	//���ݶ������ɾ��
	public void deleteej(String second_kind_id) {
		icftkdao.deleteej(second_kind_id);
	}
	
}
