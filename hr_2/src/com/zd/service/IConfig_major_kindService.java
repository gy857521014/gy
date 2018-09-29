package com.zd.service;

import java.util.List;

import com.zd.entity.Config_major_kind;


public interface IConfig_major_kindService {
	
	//查询所有职位分类
	public List<Config_major_kind> selconfigmajor();
	//添加
	public void addcmk(Config_major_kind config_major_kind);
	//根据分类id查询名称
	public Config_major_kind selmajorkindid(int id);
	// 删除用户
	public void deletecmk(String major_kind_id);
}
