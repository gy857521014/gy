package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zd.entity.Engage_major_release;

public interface IEngage_major_releaseDao {
	
	//查询所有招聘
	@Select("select * from Engage_major_release")
	@ResultMap("releaseMapper")
	public List<Engage_major_release> selallrelease();
	
	//查询单条招聘
	@Select("select * from Engage_major_release where mre_id=#{id}")
	@ResultMap("releaseMapper")
	public Engage_major_release selidrelease(int id);
	
	//修改
	@Update("update Engage_major_release set engage_type=#{engage_type},human_amount=#{human_amount},changer=#{changer},major_describe=#{major_describe},engage_required=#{engage_required},deadline=#{deadline} where mre_id=#{mre_id}")
	public void updaterelease(Engage_major_release release);
	
	//删除
	@Delete("delete from Engage_major_release where mre_id=#{id}")
	public void deleterelease(int id);
	
	//添加
	@Insert("insert into Engage_major_release values(null,#{first_kind_id}"
			+ ",#{first_kind_name},#{second_kind_id},#{second_kind_name},"
			+ "#{third_kind_id},#{third_kind_name},#{major_kind_id},#{major_kind_name},"
			+ "#{major_id},#{major_name},#{human_amount},#{engage_type},"
			+ "#{deadline},#{register},null,#{regist_time},null,#{major_describe},#{engage_required},1)")
	public void addrelease(Engage_major_release release);
	
}
