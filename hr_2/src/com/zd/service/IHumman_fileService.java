package com.zd.service;

import java.util.List;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Humman_file;

/**
 * 人力资源管理Service
 * @author 周泽旭
 *
 */
public interface IHumman_fileService {

	//三级联动
		//一级机构查询
	public List<Config_file_first_kind> selcffk();
	
	public int selnumz();
	
	public int shifa();
	
	public int zong();
}
