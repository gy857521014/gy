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
		
	//根据职位分类id查询名称major_kind_id
	@Select("select * from Config_major_kind where major_kind_id=#{id}")
	@ResultMap("majorkind")
	public Config_major_kind selmajorkindid(int id);
}
