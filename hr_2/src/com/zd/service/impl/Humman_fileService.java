package com.zd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IConfig_file_first_kindDao;
import com.zd.dao.IConfig_public_charDao;
import com.zd.dao.IHumman_fileDao;
import com.zd.dao.ISalary_grantDao;
import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_public_char;
import com.zd.entity.Humman_file;
import com.zd.entity.Salary_standard;
import com.zd.service.IHumman_fileService;

/**
 * ������Դ�����Servie
 * @author ������
 *
 */
@Service
public class Humman_fileService implements IHumman_fileService {
	@Autowired
	private ISalary_grantDao gdao;
	
	@Autowired
	private IHumman_fileDao humman_fileDao;

	@Autowired
	private IConfig_file_first_kindDao config_file_first_kindDao;
	@Autowired
	private IConfig_public_charDao config_public_charDao; 
	
	//��������
		//һ��������ѯ
		public List<Config_file_first_kind> selcffk() {
			return config_file_first_kindDao.selcffk();
		}
	
	//��ѯ����
	public List<Config_public_char> listguoji() {
		return config_public_charDao.listguoji();
	}
	//��ѯ����
	public List<Config_public_char> listmingzu() {
		return config_public_charDao.listmingzu();
	}
	//��ѯ�ڽ�����
	public List<Config_public_char> listzongjiao() {
		return config_public_charDao.listzongjiao();
	}
	//��ѯ������ò
	public List<Config_public_char> listzhengzhi() {
		return config_public_charDao.listzhengzhi();
	}
	//��ѯѧ��
	public List<Config_public_char> listxueli() {
		return config_public_charDao.listxueli();
	}
	//��ѯ��������
	public List<Config_public_char> listjiaoyu() {
		return config_public_charDao.listjiaoyu();
	}
	//��ѯѧ��רҵ
	public List<Config_public_char> listzhuanye() {
		return config_public_charDao.listzhuanye();
	}
	//��ѯ�س�
	public List<Config_public_char> listtechang() {
		return config_public_charDao.listtechang();
	}
	//��ѯ����
	public List<Config_public_char> listaihao() {
		return config_public_charDao.listaihao();
	}

	public List<Config_public_char> listzhaopin(){
		
		return config_public_charDao.listzhaopin();
	}
	//��ѯְ��
	public List<Config_public_char> listzhicheng() {
		return config_public_charDao.listzhicheng();
	}
	//��ѯн���׼
	public List<Salary_standard> xinchoulist() {
		return humman_fileDao.xinchoulist();
	}
	//����н���ע��Ų�ѯн���׼name
	public Salary_standard xinchouid(String id) {
		return humman_fileDao.xinchouid(id);
	}
	//���
	public void add(Humman_file humman_file) {
		humman_fileDao.add(humman_file);
	}
	//�޸��ϴ�ͼƬ·��
	public void uploadUpdate(Map map) {
		humman_fileDao.uploadUpdate(map);
	}
	//��ѯ������Դ������
	public List<Humman_file> Humman_fileList() {
		return humman_fileDao.Humman_fileList();
	}
	//��ѯ����������Դ���ѯ��������
	public Humman_file human_check(String human_id) {
		return humman_fileDao.human_check(human_id);
	}
	//�޸�������Դ����
	public void humman_chack_update(Humman_file humman_file) {
		humman_fileDao.humman_chack_update(humman_file);
	}
	//������ѯ
	public List<Humman_file> query_list(Map map) {
		return humman_fileDao.query_list(map);
	}
	//������Դ����޸�
	public void register_choose_picture_update(Humman_file humman_file) {
		humman_fileDao.register_choose_picture_update(humman_file);
	}
	//��������ѯ������Դɾ��
	public List<Humman_file> delete_list(Map map) {
		return humman_fileDao.delete_list(map);
	}
	//������Դɾ���޸�
	public void success_update(Humman_file humman_file) {
		humman_fileDao.success_update(humman_file);
	}
	//������Դ�ָ�������ѯ
	public List<Humman_file> recovery_list(Map map) {
		return humman_fileDao.recovery_list(map);
	}
	//������Դ�ָ��޸�
	public void success_update1(Humman_file humman_file) {
		humman_fileDao.success_update1(humman_file);
	}
	//������Դɾ����ѯ
	public List<Humman_file> Humman_fileList1() {
		return humman_fileDao.Humman_fileList1();
	}
	//������Դɾ��
	public void Delete(String human_id) {
		humman_fileDao.Delete(human_id);
	}
	public int selnumz() {
		return gdao.selnumz();
	}
	public int shifa() {
		return gdao.shifa();
	}
	public int zong() {
		return gdao.zong();
	}













}
