package com.zd.service;

import java.util.List;

import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;

/**
 * 三级机构service
 * @author 周泽旭
 *
 */
public interface IConfig_file_third_kindService {
	//查询
	public List<Config_file_third_kind> selcftk();
	// 删除用户
	public void deletecftk(int ftk_id);
	// 根据一级编号删除用户
	public void deletebh(String first_kind_id);
	//根据二级编号删除用户
	public void deleteej(String second_kind_id);
	//添加
	public void addcftk(Config_file_third_kind config_file_third_kind);
	// 根据id查询（修改）
	public Config_file_third_kind selcftkid(String third_kind_id);
	// 修改
	public void updatecftk(Config_file_third_kind config_file_third_kind);
	//根据二级机构编号查询三级机构
	public List<Config_file_third_kind> selsanji(String fsk_id);
	
	//根据三级机构id查询名称
	public Config_file_third_kind selsanjiid(String id);
}
