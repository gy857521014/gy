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
	@Autowired
	private IConfig_public_charDao config_public_charDao; 
	
	//三级联动
		//一级机构查询
		public List<Config_file_first_kind> selcffk() {
			return config_file_first_kindDao.selcffk();
		}
	
	//查询国籍
	public List<Config_public_char> listguoji() {
		return config_public_charDao.listguoji();
	}
	//查询民族
	public List<Config_public_char> listmingzu() {
		return config_public_charDao.listmingzu();
	}
	//查询宗教信仰
	public List<Config_public_char> listzongjiao() {
		return config_public_charDao.listzongjiao();
	}
	//查询政治面貌
	public List<Config_public_char> listzhengzhi() {
		return config_public_charDao.listzhengzhi();
	}
	//查询学历
	public List<Config_public_char> listxueli() {
		return config_public_charDao.listxueli();
	}
	//查询教育年限
	public List<Config_public_char> listjiaoyu() {
		return config_public_charDao.listjiaoyu();
	}
	//查询学历专业
	public List<Config_public_char> listzhuanye() {
		return config_public_charDao.listzhuanye();
	}
	//查询特长
	public List<Config_public_char> listtechang() {
		return config_public_charDao.listtechang();
	}
	//查询爱好
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
	//查询职称
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
