package com.zd.service;

import java.util.List;
import java.util.Map;

import com.zd.entity.Config_public_char;
import com.zd.entity.Humman_file;
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
	
	public int selsum(String first_king_name);
	
	public int selhum(String first_king_name);
	
	public List<Salary_standard_details> selBySSD(String ssd);
	
	public void add(Salary_grant_details sgd);
	
}
