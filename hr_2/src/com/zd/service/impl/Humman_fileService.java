package com.zd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IConfig_file_first_kindDao;
import com.zd.dao.IHumman_fileDao;
import com.zd.entity.Config_file_first_kind;
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
	private IHumman_fileDao dao;

	@Autowired
	private IConfig_file_first_kindDao config_file_first_kindDao;
	//��������
		//һ��������ѯ
	public List<Config_file_first_kind> selcffk() {
		return config_file_first_kindDao.selcffk();
	}
	@Override
	public int sel1all() {
		return dao.sel1all();
	}
	
}
