package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.Config_major;

public interface IConfig_majorDao {
	
	@Select("select * from Config_major where major_kind_id=#{majorid}")
	@ResultMap("major")
	public List<Config_major> selzhiwei(int majorid);
}