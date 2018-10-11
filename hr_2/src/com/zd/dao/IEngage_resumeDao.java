package com.zd.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zd.entity.Engage_resume;

public interface IEngage_resumeDao {
	
	@Insert("insert into Engage_resume value(null,#{human_name},#{engage_type},#{human_address},"
			+ "#{human_postcode},#{human_major_kind_id},#{human_major_kind_name},"
			+ "#{human_major_id},#{human_major_name},#{human_telephone},#{human_homephone},"
			+ "#{human_mobilephone},#{human_email},#{human_hobby},#{human_specility},"
			+ "#{human_sex},#{human_religion},#{human_party},#{human_nationality},"
			+ "#{human_race},#{human_birthday},#{human_age},#{human_educated_degree},#{human_educated_years},"
			+ "#{human_educated_major},#{human_college},#{human_idcard},#{human_birthplace},"
			+ "#{demand_salary_standard},#{human_history_records},#{remark},"
			+ "#{recomandation},null,null,1,#{register},#{regist_time},null,null,2,"
			+ "null,null,null,null,null,null,null,null,0,null,null)")  
	public void addresume(Engage_resume resume);
	
	
	public List<Engage_resume> selresume(Map map);
	
	public Engage_resume selresumeid(int id);
	
	@Update("update  Engage_resume set human_major_kind_id=#{human_major_kind_id},"
			+ "human_major_kind_name=#{human_major_kind_name},human_major_id=#{human_major_id},"
			+ "human_major_name=#{human_major_name},engage_type=#{engage_type},"
			+ "human_name=#{human_name},human_sex=#{human_sex},human_email=#{human_email},"
			+ "human_telephone=#{human_telephone},human_homephone=#{human_homephone},"
			+ "human_mobilephone=#{human_mobilephone},human_address=#{human_address},"
			+ "human_postcode=#{human_postcode},human_nationality=#{human_nationality},"
			+ "human_birthplace=#{human_birthplace},human_birthday=#{human_birthday},"
			+ "human_race=#{human_race},human_religion=#{human_religion},"
			+ "human_party=#{human_party},human_idcard=#{human_idcard},"
			+ "human_age=#{human_age},human_college=#{human_college},"
			+ "human_educated_degree=#{human_educated_degree},"
			+ "human_educated_years=#{human_educated_years},"
			+ "human_educated_major=#{human_educated_major},"
			+ "demand_salary_standard=#{demand_salary_standard},"
			+ "human_specility=#{human_specility},human_hobby=#{human_hobby},checker=#{checker},"
			+ "check_time=#{check_time},recomandation=#{recomandation},"
			+ "check_status=2,interview_status=1,pass_check_status=1,"
			+ "pass_checker=#{pass_checker},pass_check_time=#{pass_check_time} where res_id=#{res_id}")
	public void updateresume(Engage_resume resume);
	
	@Update("update Engage_resume set interview_status=3 where res_id=#{res_id}")
	public void resumeupdate(int res_id);
	
	@Update("update Engage_resume set pass_check_status=2 where res_id=#{res_id}")
	public void updemail(int res_id);
	
	@Update("update Engage_resume set pass_check_status=3 where res_id=#{res_id}")
	public void updemail2(int res_id);
}
