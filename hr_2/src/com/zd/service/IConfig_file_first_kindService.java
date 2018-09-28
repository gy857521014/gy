package com.zd.service;

import java.util.List;
import java.util.Map;

import com.zd.entity.Config_file_first_kind;

public interface IConfig_file_first_kindService {
	//查询
	public List<Config_file_first_kind> selcffk();
	//添加
	public void addcffk(Config_file_first_kind config_file_first_kind);
	// 根据id查询（修改）
	public Config_file_first_kind selcffkid(String first_kind_id);
	// 修改
	public void updatecffk(Config_file_first_kind config_file_first_kind);
	// 删除用户
	public void deletecffk(int ffk_id);
	
	public int selhumnum();
	// 通过一级名称统计人数、薪酬
	public List<Map> tongjiByFname();
}
