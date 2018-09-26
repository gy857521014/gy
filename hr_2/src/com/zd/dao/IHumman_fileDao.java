package com.zd.dao;


import org.apache.ibatis.annotations.Select;


/**
 * 人力资源管理dao
 * @author 周泽旭
 *
 */
public interface IHumman_fileDao {
	
	
	
	@Select("SELECT COUNT(*) FROM humman_file WHERE first_king_id !=''")
	public int sel1all();
}
