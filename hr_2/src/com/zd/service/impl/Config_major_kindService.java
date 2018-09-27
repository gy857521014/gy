package com.zd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IConfig_major_kindDao;
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

}
