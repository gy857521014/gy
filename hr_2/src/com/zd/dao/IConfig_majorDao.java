package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.Config_major;

public interface IConfig_majorDao {
	
	//查询所有职业名称
	@Select("select * from Config_major where major_kind_id=#{majorid}")
	@ResultMap("major")
	public List<Config_major> selzhiwei(int majorid);
	
	//根据职位id查询名称
	@Select("select * from Config_major where major_id=#{id}")
	@ResultMap("major")
	public Config_major selzhiweiid(int id);
	
	@Select("select * from Config_major")
	@ResultMap("major")
	public List<Config_major> selallzhi();
}
