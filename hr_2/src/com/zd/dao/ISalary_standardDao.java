package com.zd.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zd.entity.Compensation_item;
import com.zd.entity.Config_public_char;
import com.zd.entity.Salary_standard;
import com.zd.entity.Salary_standard_details;

public interface ISalary_standardDao {
	
	//查询公共属性薪酬项目
	@Select("SELECT * FROM config_public_char WHERE attribute_kind='薪酬设置'")
	public List<Config_public_char> selConfig_public_char();
	
	//登记薪酬标准
	@Insert("insert into Salary_standard values(null,#{standard_id},#{standard_name},#{designer},#{register},null,null,#{regist_time},null,null,#{salary_sum},2,0,null,#{remark})")
	public void addSalary_standard(Salary_standard ss);
	//登记薪酬标准薪酬项目
	@Insert("insert into Compensation_item values(#{standard_id},#{pbc_id},#{money},#{attribute_name})")
	public void addCompensation_item(Map map);
	//薪酬标准登记复核页面例
	@Select("SELECT COUNT(*) FROM salary_standard where check_status=2")
	public int selSalary_standardli();
	//薪酬标准登记复核页面查询*****
	public List<Salary_standard> selSalary_standard(int start);
	//单条查询薪酬标准登记
	@Select("select * from salary_standard where standard_id=#{standard_id}")
	@ResultMap("Salary_standardMapper")
	public Salary_standard selOneSalary_standard(String standard_id);
	//根据薪酬编号查询薪酬项目名称
	@Select("select * from compensation_item where standard_id=#{standard_id}")
	public List<Compensation_item> selCompensation_item(String standard_id);
	//根据薪酬编号修改薪酬标准
	@Update("UPDATE salary_standard SET standard_name=#{standard_name},designer=#{designer},salary_sum=#{salary_sum},checker=#{checker},check_time=#{check_time},check_comment=#{check_comment},check_status=1 WHERE standard_id=#{standard_id}")
	public void updSalary_standard(Salary_standard ss);
	//根据项目id修改项目金额
	@Update("UPDATE compensation_item set money=#{money} where pbc_id=#{pbc_id} and standard_id=#{standard_id}")
	public void updcompensation_item(Map map);
	//添加薪酬标准单详细信息
	@Insert("insert into Salary_standard_details values(null,#{standard_id},#{standard_name},#{item_id},#{item_name},#{salary})")
	public void addSalary_standard_details(Map map);
	//薪酬标准模糊查询
	public List<Salary_standard> selLikeSalary_standard(Map map);
	//模糊查询薪酬标准例
	public int selLikeSalary_standardli(Map map);
	//根据薪酬编号修改薪酬标准(变更)
	@Update("UPDATE salary_standard SET standard_name=#{standard_name},designer=#{designer},salary_sum=#{salary_sum},changer=#{changer},change_time=#{change_time},remark=#{remark} WHERE standard_id=#{standard_id}")
	public void updSalary_standardbg(Salary_standard ss);
	//修改薪酬标准单详细信息(变更)
	@Update("UPDATE salary_standard_details SET standard_name=#{standard_name},salary=#{salary} where standard_id=#{standard_id} and item_id=#{item_id}")
	public void updSalary_standard_details(Map map);
	//根据项目id修改项目金额(变更)
	@Update("UPDATE compensation_item set money=#{money} where pbc_id=#{pbc_id} and standard_id=#{standard_id}")
	public void updcompensation_itembg(Map map);
}
