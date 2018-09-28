package com.zd.service;

import java.util.List;

import com.zd.entity.Config_major_kind;


public interface IConfig_major_kindService {
	
	//查询所有职位分类
	public List<Config_major_kind> selconfigmajor();
	//根据分类id查询名称
	public Config_major_kind selmajorkindid(int id);
}
