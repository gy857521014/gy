package com.zd.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zd.entity.Engage_interview;
import com.zd.entity.Engage_resume;

public interface IEngage_interviewDao {

	//面试登记
	@Insert("insert into Engage_interview value(null,#{human_name},1,#{human_major_kind_id},#{human_major_kind_name},#{human_major_id},#{human_major_name},#{image_degree},#{native_language_degree},#{foreign_language_degree},#{response_speed_degree},#{eQ_degree},#{iQ_degree},#{multi_quality_degree},#{register},#{checker},#{registe_time},#{check_time},#{resume_id},#{result},#{interview_comment},#{check_comment},2,0)")
	public void interviewadd(Engage_interview engage_interview );
	
	//模糊查询
	public List<Engage_interview> selresume(Map map);
	
	//查询单条
	@Select("select * from Engage_interview where ein_id=#{id}")
	@ResultMap("Engage_interviewmapper")
	public Engage_interview Engage_interview_queryDan(int id);
	
	//录用申请修改
	@Update("update Engage_resume set pass_passComment=#{pass_passComment} where res_id=#{res_id}")
	public void check_list_update(Engage_resume engage_resume);
	
	
	@Update("update Engage_interview set checker=#{checker},check_time=#{check_time},check_status=#{check_status} where ein_id=#{ein_id}")
	public void Engage_interview_upd(Engage_interview engage_interview);
	
	@Select("select * from  Engage_interview")
	@ResultMap("Engage_interviewmapper")
	public List<Engage_interview> Engage_interview_query();
	
	@Update("update Engage_resume set pass_checkComment=#{pass_checkComment} where res_id=#{res_id}")
	public void register_sift_update(Engage_resume engage_resume);
	
	
}
