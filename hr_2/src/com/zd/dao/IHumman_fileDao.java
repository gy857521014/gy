package com.zd.dao;



import java.util.List;


import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.Salary_standard;


/**
 * ������Դ����dao
 * @author ������
 *
 */
public interface IHumman_fileDao {
	
	@Select("SELECT COUNT(*) FROM humman_file WHERE first_king_id !=''")
	public int sel1all();
}

