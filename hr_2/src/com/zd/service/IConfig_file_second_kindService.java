package com.zd.service;

import java.util.List;
import java.util.Map;

import com.zd.entity.Config_file_second_kind;

public interface IConfig_file_second_kindService {
	//查询
	public List<Config_file_second_kind> selcfsk();
	//添加
	public void addcfsk(Config_file_second_kind config_file_second_kind);
	// 根据id查询（修改）
	public Config_file_second_kind selcfskid(String second_kind_id);
	// 修改
	public void updatecfsk(Config_file_second_kind config_file_second_kind);
	// 删除用户
	public void deletecfsk(String second_kind_id);
	// 根据一级编号删除用户
	public void deletebh(String first_kind_id);
	//根据一级机构编号查询二级机构
	public List<Config_file_second_kind> selerji(String fsk_id);
	
	
	public List<Map> tongjiByFname();
	
	//根据二级机构id查询名称
	public Config_file_second_kind selerjiid(String id);
}
