package com.zd.service;

import java.util.List;

import com.zd.entity.Config_major;
import com.zd.entity.Config_major_kind;

public interface IConfig_majorService {
	
	//查询职位分类下面对应所有职位
	public List<Config_major> selzhiwei(int majorid);
	
	//根据id查询职位
	public Config_major selzhiweiid(int id);
	public List<Config_major> selallzhi();
	//添加
	public void addcm(Config_major config_major);
	// 删除用户
	public void deletecm(String major_kind_id);
}
