package com.zd.service;

import java.util.List;

import com.zd.entity.Config_major;

public interface IConfig_majorService {
	
	//查询职位分类下面对应所有职位
	public List<Config_major> selzhiwei(String majorid);
	
	//根据id查询职位
	public Config_major selzhiweiid(String id);
	
	
	public List<Config_major> selallzhi();
}
