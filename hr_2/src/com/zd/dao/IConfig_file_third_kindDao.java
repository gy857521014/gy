package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;

/**
 * 三级机构dao
 * @author 周泽旭
 *
 */



public interface IConfig_file_third_kindDao {
	//查询所有
		@Select("select * from Config_file_third_kind")
		@ResultMap("cftk")
		public List<Config_file_third_kind>  selcftk();
	//删除
		@Delete("delete from Config_file_third_kind where ftk_id=#{ftk_id}")
		public void deletecftk(int ftk_id);
	//根据一级编号删除
		@Delete("delete from Config_file_third_kind where first_kind_id=#{first_kind_id}")
		public void deletebh(String first_kind_id);
	//根据二级编号删除
		@Delete("delete from Config_file_third_kind where second_kind_id=#{second_kind_id}")
		public void deleteej(String second_kind_id);
	//添加
		@Insert("insert into Config_file_third_kind values(null,#{first_kind_id},#{first_kind_name},#{second_kind_id},#{second_kind_name},#{third_kind_id},#{third_kind_name},#{third_kind_sale_id},#{third_kind_is_retail})")
		public void addcftk(Config_file_third_kind config_file_third_kind);
	//根据编号查询用户
		@Select("select * from Config_file_third_kind where third_kind_id=#{third_kind_id}")
		@ResultMap("cftk")
		public Config_file_third_kind  selcftkid(String third_kind_id);	
	//修改用户
		@Update("update Config_file_third_kind set third_kind_sale_id=#{third_kind_sale_id},third_kind_is_retail=#{third_kind_is_retail} where third_kind_id=#{third_kind_id}")
		public void updatecftk(Config_file_third_kind config_file_third_kind);
	//根据二级机构编号查询三级机构
		@Select("SELECT * FROM config_file_third_kind WHERE second_kind_id = #{fsk_id}")
		@ResultMap("cftk")
		public List<Config_file_third_kind> selsanji(String fsk_id);
	
	@Select("select * from Config_file_third_kind where third_kind_id=#{id}")
	@ResultMap("cftk")
	public Config_file_third_kind selsanjiid(String id);
}
