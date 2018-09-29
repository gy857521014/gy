package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.Config_file_third_kind;
import com.zd.entity.Config_major_kind;




public interface IConfig_major_kindDao {
	
		//查询所有职位分类
		@Select("select * from Config_major_kind")
		@ResultMap("majorkind")
		public List<Config_major_kind> selconfigmajor();
		//添加
		@Insert("insert into Config_major_kind values(null,#{major_kind_id},#{major_kind_name})")
		public void addcmk(Config_major_kind config_major_kind);
		//删除
		@Delete("delete from Config_major_kind where major_kind_id=#{major_kind_id}")
		public void deletecmk(String major_kind_id);
		
	//根据职位分类id查询名称major_kind_id
	@Select("select * from Config_major_kind where major_kind_id=#{id}")
	@ResultMap("majorkind")
	public Config_major_kind selmajorkindid(int id);
}
