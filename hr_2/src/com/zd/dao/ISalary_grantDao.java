package com.zd.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.Config_public_char;
import com.zd.entity.Humman_file;
import com.zd.entity.Salary_grant_details;
import com.zd.entity.Salary_standard_details;

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
	
	@Select("SELECT third_kind_name fname, COUNT(*) fcount,SUM(salary_sum) fsum FROM humman_file GROUP BY third_kind_name")
	@ResultMap("mapMapper")
	public List<Map> tongjiByFname();
	
	
	@Select("SELECT COUNT(*) FROM humman_file WHERE third_kind_name !=''")
	public int selnumzzz();
	
	@Select("SELECT COUNT(*) FROM (SELECT COUNT(*) FROM humman_file GROUP BY third_kind_name)AS a")
	public int selhumnummm();
	
	@Select("SELECT SUM(demand_salaray_sum) FROM humman_file WHERE third_kind_name !=''")
	public int shifaaa();
	
	@Select("SELECT SUM(salary_sum) FROM humman_file WHERE third_kind_name !=''")
	public int zonggg();
	
	@Select("SELECT * FROM config_public_char WHERE attribute_kind='–Ω≥Í…Ë÷√'")
	@ResultMap("Config_public_char")
	public List<Config_public_char> selpubulic();
	
	@Select("SELECT human_id,human_name,salary_standard_id,salary_sum FROM humman_file WHERE first_king_name=#{first_king_name}")
	@ResultMap("selhumanmapper")
	public List<Humman_file> selhuman(String first_king_name);
	
	@Select("SELECT SUM(salary_sum) FROM humman_file WHERE first_king_name=#{first_king_name}")
	public int selsum(String first_king_name);
	
	@Select("SELECT COUNT(*) FROM humman_file WHERE first_king_name=#{first_king_name}")
	public int selhum(String first_king_name);
	
	@Select("SELECT * FROM Salary_standard_details WHERE standard_id=#{ssd}")
	@ResultMap("ssdmapper")
	public List<Salary_standard_details> selBySSD(String ssd);
	
	@Insert("INSERT INTO salary_grant_details VALUES(NULL,#{salary_grant_id},#{human_id},#{human_name},#{bouns_sum},#{sale_sum},#{deduct_sum},#{salary_standard_sum},#{salary_paid_sum})")
	public void add(Salary_grant_details sgd);
	
}
