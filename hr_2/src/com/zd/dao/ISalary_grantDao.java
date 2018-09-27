package com.zd.dao;

import org.apache.ibatis.annotations.Select;

public interface ISalary_grantDao {
	@Select("SELECT COUNT(*) FROM config_file_first_kind")
	public int selhumnum();
	@Select("SELECT COUNT(*) FROM humman_file WHERE first_king_name !=''")
	public int selnumz();
	@Select("SELECT SUM(demand_salaray_sum) FROM humman_file WHERE first_king_name !=''")
	public int shifa();
	@Select("SELECT SUM(salary_sum) FROM humman_file WHERE first_king_name !=''")
	public int zong();
}
