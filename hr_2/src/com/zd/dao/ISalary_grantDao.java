package com.zd.dao;

import org.apache.ibatis.annotations.Select;

public interface ISalary_grantDao {
	@Select("SELECT COUNT(*) FROM config_file_first_kind")
	public int selhumnum();
}
