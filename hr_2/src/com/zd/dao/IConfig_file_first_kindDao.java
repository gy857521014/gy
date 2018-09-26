package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zd.entity.Config_file_first_kind;

public interface IConfig_file_first_kindDao {
	//查询所有
	@Select("select * from Config_file_first_kind")
	@ResultMap("cffk")
	public List<Config_file_first_kind>  selcffk();
	//添加
	@Insert("insert into Config_file_first_kind values(null,#{first_kind_id},#{first_kind_name},#{first_kind_salary_id},#{first_kind_sale_id})")
	public void addcffk(Config_file_first_kind config_file_first_kind);
	//根据id查询用户
	@Select("select * from Config_file_first_kind where first_kind_id=#{first_kind_id}")
	@ResultMap("cffk")
	public Config_file_first_kind  selcffkid(String first_kind_id);
	//修改用户
	@Update("update Config_file_first_kind set first_kind_salary_id=#{first_kind_salary_id},first_kind_sale_id=#{first_kind_sale_id} where first_kind_id=#{first_kind_id}")
	public void updatecffk(Config_file_first_kind config_file_first_kind);
	//删除
	@Delete("delete from Config_file_first_kind where ffk_id=#{ffk_id}")
	public void deletecffk(int ffk_id);
}
