package com.zd.dao;

import java.util.Map;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;


public interface ILoginDao {

	//µÇÂ½
	@Select("select * from suser where sname=#{sname} and spwd=#{spwd}")
	@ResultMap("mapMapper")
	public Map login(Map<String, String> map);
}
