package com.zd.dao;

import org.apache.ibatis.annotations.Insert;

import com.zd.entity.Compensation_item;
import com.zd.entity.Salary_standard;

public interface ISalary_standardDao {
	
	//�Ǽ�н���׼
	@Insert("insert into Salary_standard values(null,#{standard_id},#{standard_name},#{designer},#{register},null,null,#{regist_time},null,#{salary_sum},null,null,null,#{remark})")
	public void addSalary_standard(Salary_standard ss);
	//�Ǽ�н���׼н����Ŀ
	@Insert("insert into Compensation_item values(#{standard_id},#{travel},#{traffic},#{housing},#{basic},#{year_end},#{mistakes})")
	public void addCompensation_item(Compensation_item ci);
}
