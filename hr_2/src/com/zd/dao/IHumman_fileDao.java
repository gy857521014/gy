package com.zd.dao;


import org.apache.ibatis.annotations.Select;


/**
 * ������Դ����dao
 * @author ������
 *
 */
public interface IHumman_fileDao {
	
	
	
	@Select("SELECT COUNT(*) FROM humman_file WHERE first_king_id !=''")
	public int sel1all();
}
