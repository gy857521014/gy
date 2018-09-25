package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.Config_file_first_kind;

public interface IConfig_file_first_kindDao {
	//查询所有用户
	@Select("select * from Config_file_first_kind")
	@ResultMap("cffk")
	public List<Config_file_first_kind>  selcffk();
}
