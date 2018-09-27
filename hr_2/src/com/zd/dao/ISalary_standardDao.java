package com.zd.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.Compensation_item;
import com.zd.entity.Config_public_char;
import com.zd.entity.Salary_standard;

public interface ISalary_standardDao {
	
	//��ѯ��������н����Ŀ
	@Select("SELECT * FROM config_public_char WHERE attribute_kind='н������'")
	public List<Config_public_char> selConfig_public_char();
	
	//�Ǽ�н���׼
	@Insert("insert into Salary_standard values(null,#{standard_id},#{standard_name},#{designer},#{register},null,null,#{regist_time},null,null,#{salary_sum},2,0,null,#{remark})")
	public void addSalary_standard(Salary_standard ss);
	//�Ǽ�н���׼н����Ŀ
	@Insert("insert into Compensation_item values(#{standard_id},#{pbc_id},#{money})")
	public void addCompensation_item(Map map);
}
