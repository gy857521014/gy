package com.zd.dao;


import org.apache.ibatis.annotations.Select;

public interface ISalary_grantDao {
	@Select("SELECT COUNT(*) FROM (SELECT COUNT(*) FROM humman_file GROUP BY first_king_name)AS a")
	public int selhumnum();
	
	@Select("SELECT COUNT(*) FROM humman_file WHERE first_king_name !=''")
	public int selnumz();
	
	@Select("SELECT SUM(demand_salaray_sum) FROM humman_file WHERE first_king_name !=''")
	public int shifa();
	
	@Select("SELECT SUM(salary_sum) FROM humman_file WHERE first_king_name !=''")
	public int zong();
	
	@Select("SELECT COUNT(*) FROM humman_file WHERE second_kind_name !=''")
	public int selnumzz();
	
	@Select("SELECT COUNT(*) FROM (SELECT COUNT(*) FROM humman_file GROUP BY second_kind_name)AS a")
	public int selhumnumm();
	
	@Select("SELECT SUM(demand_salaray_sum) FROM humman_file WHERE second_kind_name !=''")
	public int shifaa();
	
	@Select("SELECT SUM(salary_sum) FROM humman_file WHERE second_kind_name !=''")
	public int zongg();
}
