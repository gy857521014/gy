package com.zd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IConfig_file_first_kindDao;
import com.zd.dao.IHumman_fileDao;
import com.zd.dao.ISalary_grantDao;
import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Humman_file;
import com.zd.service.IHumman_fileService;

/**
 * 人力资源管理的Servie
 * @author 周泽旭
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
	//三级联动
		//一级机构查询
	public List<Config_file_first_kind> selcffk() {
		return config_file_first_kindDao.selcffk();
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
