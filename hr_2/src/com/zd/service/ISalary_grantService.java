package com.zd.service;

import java.util.List;
import java.util.Map;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;
import com.zd.entity.Config_public_char;
import com.zd.entity.Humman_file;
import com.zd.entity.Salary_grant;
import com.zd.entity.Salary_grant_details;
import com.zd.entity.Salary_standard_details;

public interface ISalary_grantService {

	public int selnumzz();
	
	public int selhumnumm();
	
	public int shifaa();
	
	public int zongg();
	
	public List<Map> tongjiByFname();
	
	public int selnumzzz();
	
	public int selhumnummm();
	
	public int shifaaa();
	
	public int zonggg();
	
	public List<Config_public_char> selpubulic();
	
	public List<Humman_file> selhuman(String first_king_name);
	
	public List<Humman_file> selhuman2(String second_kind_name);
	
	public int selsum(String first_king_name);
	
	public int selsum2(String second_kind_name);
	
	public int selsum3(String third_kind_name);
	
	public int selhum(String first_king_name);
	
	public List<Salary_standard_details> selBySSD(String ssd);
	
	public void add(Salary_grant_details sgd);
	
	public Config_file_first_kind selall(String fname);
	
	public Config_file_second_kind selall2(String fname);
	
	public Config_file_third_kind selall3(String fname);
	
	public List<Humman_file> selhuman3(String third_kind_name);
	
	public void addsg(Salary_grant sg);
	
	public List<Salary_grant> selallsg();
	
	public Salary_grant selone(String salary_grant_id);
	
	public List<Salary_grant_details> selsgdall();
	
	public int selhum2(String second_kind_name);
	
	public int selhum3(String third_kind_name);
	
	
}
