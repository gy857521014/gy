package com.zd.service;

import java.util.List;
import java.util.Map;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_public_char;
import com.zd.entity.Humman_file;
import com.zd.entity.Salary_standard;

/**
 * ������Դ����Service
 * @author ������
 *
 */
public interface IHumman_fileService {

	//��������
		//һ��������ѯ
		public List<Config_file_first_kind> selcffk();
	
	public int selnumz();
	//��ѯ����
	public List<Config_public_char> listguoji();
	//��ѯ����
	public List<Config_public_char> listmingzu();
	//��ѯ�ڽ�����
	public List<Config_public_char> listzongjiao();
	//��ѯ������ò
	public List<Config_public_char> listzhengzhi();
	//��ѯѧ��
	public List<Config_public_char> listxueli();
	//��ѯ��������
	public List<Config_public_char> listjiaoyu();
	//��ѯѧ��רҵ
	public List<Config_public_char> listzhuanye();
	//��ѯ�س�
	public List<Config_public_char> listtechang();
	//��ѯ����
	public List<Config_public_char> listaihao();
	//��ѯ��Ƹ����
	public List<Config_public_char> listzhaopin();
	//��ѯְ��
	public List<Config_public_char> listzhicheng();
	//��ѯн���׼
	public List<Salary_standard> xinchoulist();
	//����н���ע��Ų�ѯн���׼name
	public Salary_standard xinchouid(String id);
	//���
	public void add(Humman_file humman_file);
	//�޸��ϴ�ͼƬ
	public void uploadUpdate(Map map);
	//��ѯ������Դ������
	public List<Humman_file> Humman_fileList();
	//��ѯ����������Դ���ѯ��������
	public Humman_file human_check(String human_id);
	//�޸�������Դ��
	public void humman_chack_update(Humman_file humman_file);
	//������ѯ
	public List<Humman_file> query_list(Map map);
	//������Դ����޸�
	public void register_choose_picture_update(Humman_file humman_file);
	//��������ѯ������Դɾ��
	public List<Humman_file> delete_list(Map map);
	//������Դɾ���޸�
	public void success_update(Humman_file humman_file);
	//������Դ�ָ�������ѯ
	public List<Humman_file> recovery_list(Map map);
	//������Դ�ָ��޸�
	public void success_update1(Humman_file humman_file);
	//������Դɾ����ѯ
	public List<Humman_file> Humman_fileList1();
	//������Դɾ��
	public void Delete(String human_id);
	public int shifa();
	
	public int zong();
}
