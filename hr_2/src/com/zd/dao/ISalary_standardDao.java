package com.zd.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zd.entity.Config_public_char;
import com.zd.entity.Salary_standard;

public interface ISalary_standardDao {
	
	//查询公共属性薪酬项目
	@Select("SELECT * FROM config_public_char WHERE attribute_kind='薪酬设置'")
	public List<Config_public_char> selConfig_public_char();
	
	//登记薪酬标准
	@Insert("insert into Salary_standard values(null,#{standard_id},#{standard_name},#{designer},#{register},null,null,#{regist_time},null,null,#{salary_sum},2,0,null,#{remark})")
	public void addSalary_standard(Salary_standard ss);
	//登记薪酬标准薪酬项目
	@Insert("insert into Compensation_item values(#{standard_id},#{pbc_id},#{money})")
	public void addCompensation_item(Map map);
	//薪酬标准登记复核页面例
	@Select("SELECT COUNT(*) FROM salary_standard")
	public int selSalary_standardli();
	//薪酬标准登记复核页面查询*****
	public List<Salary_standard> selSalary_standard(int start);
}
