package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.Config_major_kind;




public interface IConfig_major_kindDao {
	
	//查询所有职位分类
		@Select("select * from Config_major_kind")
		@ResultMap("majorkind")
		public List<Config_major_kind> selconfigmajor();
}
