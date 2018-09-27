package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.Engage_major_release;

public interface IEngage_major_releaseDao {
	
	@Select("select * from Engage_major_release")
	@ResultMap("releaseMapper")
	public List<Engage_major_release> selallrelease();
	
	@Select("select * from Engage_major_release where mre_id=#{id}")
	@ResultMap("releaseMapper")
	public Engage_major_release selidrelease(int id);
}
