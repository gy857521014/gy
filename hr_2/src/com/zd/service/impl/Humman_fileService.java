package com.zd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IConfig_file_first_kindDao;
import com.zd.dao.IConfig_public_charDao;
import com.zd.dao.IHumman_fileDao;
import com.zd.dao.ISalary_grantDao;
import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_public_char;
import com.zd.entity.Humman_file;
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
	private IHumman_fileDao dao;

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
	@Override
	public int sel1all() {
		return dao.sel1all();
	}
	//��ѯְ��
	public List<Config_public_char> listzhicheng() {
		return config_public_charDao.listzhicheng();
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
