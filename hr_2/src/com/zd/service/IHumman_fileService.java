package com.zd.service;

import java.util.List;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_public_char;
import com.zd.entity.Humman_file;

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
	
	public int shifa();
	
	public int zong();
}
