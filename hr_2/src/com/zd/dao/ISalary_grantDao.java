package com.zd.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;
import com.zd.entity.Config_public_char;
import com.zd.entity.Humman_file;
import com.zd.entity.Salary_grant;
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
	
	@Select("SELECT human_id,human_name,salary_standard_id,salary_sum,salary_standard_id FROM humman_file WHERE first_king_name=#{first_king_name}")
	@ResultMap("selhumanmapper")
	public List<Humman_file> selhuman(String first_king_name);
	@Select("SELECT human_id,human_name,salary_standard_id,salary_sum,salary_standard_id FROM humman_file WHERE second_kind_name=#{second_kind_name}")
	@ResultMap("selhumanmapper")
	public List<Humman_file> selhuman2(String second_kind_name);
	@Select("SELECT human_id,human_name,salary_standard_id,salary_sum,salary_standard_id FROM humman_file WHERE third_kind_name=#{third_kind_name}")
	@ResultMap("selhumanmapper")
	public List<Humman_file> selhuman3(String third_kind_name);
	
	@Select("SELECT SUM(salary_sum) FROM humman_file WHERE first_king_name=#{first_king_name}")
	public int selsum(String first_king_name);
	@Select("SELECT SUM(salary_sum) FROM humman_file WHERE second_kind_name=#{second_kind_name}")
	public int selsum2(String second_kind_name);
	@Select("SELECT SUM(salary_sum) FROM humman_file WHERE third_kind_name=#{third_kind_name}")
	public int selsum3(String third_kind_name);
	
	@Select("SELECT COUNT(*) FROM humman_file WHERE first_king_name=#{first_king_name}")
	public int selhum(String first_king_name);
	@Select("SELECT COUNT(*) FROM humman_file WHERE second_kind_name=#{second_kind_name}")
	public int selhum2(String second_kind_name);
	@Select("SELECT COUNT(*) FROM humman_file WHERE third_kind_name=#{third_kind_name}")
	public int selhum3(String third_kind_name);
	
	@Select("SELECT * FROM Config_file_first_kind WHERE first_kind_name=#{first_kind_name}")
	@ResultMap("cffk")
	public Config_file_first_kind selall(String fname);
	
	@Select("SELECT * FROM Config_file_second_kind WHERE second_kind_name=#{second_kind_name}")
	@ResultMap("cfsk")
	public Config_file_second_kind selall2(String fname);
	
	@Select("SELECT * FROM Config_file_third_kind WHERE third_kind_name=#{third_kind_name}")
	@ResultMap("cftk")
	public Config_file_third_kind selall3(String fname);
	
	@Select("SELECT * FROM Salary_standard_details WHERE standard_id=#{ssd}")
	@ResultMap("ssdmapper")
	public List<Salary_standard_details> selBySSD(String ssd);
	
	@Insert("INSERT INTO salary_grant_details VALUES(NULL,#{salary_grant_id},#{human_id},#{human_name},#{bouns_sum},#{sale_sum},#{deduct_sum},#{salary_standard_sum},#{salary_paid_sum})")
	public void add(Salary_grant_details sgd);
	
	@Insert("INSERT INTO salary_grant VALUES(NULL,#{salary_grant_id},#{salary_standard_id},#{first_kind_id},#{first_kind_name},#{second_kind_id},#{second_kind_name},#{third_kind_id},#{third_kind_name},#{human_amount},#{salary_standard_sum},#{salary_paid_sum},#{register},#{regist_time},'','',0)")
	public void addsg(Salary_grant sg);

	@Select("select * from Salary_grant")
	@ResultMap("sgmapper")
	public List<Salary_grant> selallsg();
	
	@Select("SELECT * FROM Salary_grant WHERE salary_grant_id=#{salary_grant_id}")
	@ResultMap("sgmapper")
	public Salary_grant selone(String salary_grant_id);
	
	@Select("SELECT a.*,b.salary_standard_id FROM salary_grant_details a,salary_grant b WHERE a.salary_grant_id=b.salary_grant_id AND b.salary_grant_id=#{salary_grant_id}")
	@ResultMap("sgdmapper2")
	public List<Salary_grant_details> selsgdall(String salary_grant_id);
	
	@Update("UPDATE salary_grant SET salary_standard_sum=#{salary_standard_sum},salary_paid_sum=#{salary_paid_sum},register=#{register},regist_time=#{regist_time},checker=#{checker},check_time=#{check_time},check_status=1 where salary_grant_id=#{salary_grant_id}")
	public void upd(Salary_grant sg);
	
	public List<Salary_grant> sgall(Map map);
}
