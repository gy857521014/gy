package com.zd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IConfig_major_kindDao;
import com.zd.entity.Config_file_third_kind;
import com.zd.entity.Config_major_kind;
import com.zd.service.IConfig_major_kindService;

@Service
public class Config_major_kindService implements IConfig_major_kindService{

	@Autowired
	private IConfig_major_kindDao majorkinddao;
	
	//查询职位分类
	public List<Config_major_kind> selconfigmajor() {
		List<Config_major_kind> list=majorkinddao.selconfigmajor();
		return list;
	}
	//添加
	public void addcmk(Config_major_kind config_major_kind) {
		majorkinddao.addcmk(config_major_kind);
	}

	//根据分类id查询名称
	public Config_major_kind selmajorkindid(String id) {
		Config_major_kind majorkind=majorkinddao.selmajorkindid(id);
		return majorkind;
	}
	//根据分类id查询名称
	public Config_major_kind selcmkid(String major_kind_id) {
		Config_major_kind selid=majorkinddao.selcmkid(major_kind_id);
		return selid;
	}
	//删除
	public void deletecmk(String major_kind_id) {
		majorkinddao.deletecmk(major_kind_id);
	}
}
