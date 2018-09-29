package com.zd.dao;



import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zd.entity.Humman_file;
import com.zd.entity.Salary_standard;


/**
 * 人力资源管理dao
 * @author 周泽旭
 *
 */
public interface IHumman_fileDao {
	@Select("SELECT COUNT(*) FROM humman_file WHERE first_king_id !=''")
	public int sel1all();
	
	//查询薪资标准
	@Select("SELECT * FROM salary_standard")
	public List<Salary_standard> xinchoulist();
	//根据薪酬标注编号查询薪酬标准name
	@Select("select * from salary_standard where standard_id=#{id}")
	public Salary_standard xinchouid(String id);
	//添加
	@Insert("insert into humman_file values(null,#{human_id},#{first_king_id},#{first_king_name},#{second_kind_id},#{second_kind_name},#{third_kind_id},#{third_kind_name},"
			+ "#{human_name},#{human_address},#{human_postcode},#{human_pro_designation},"
			+ "#{human_major_kind_id},#{human_major_kind_name},#{human_major_id},#{hunma_major_name},"
			+ "#{human_telephone},#{human_mobilephone},#{human_bank},#{human_account},#{human_qq},#{human_email},#{human_hobby},"
			+ "#{human_speciality},#{human_sex},#{human_religion},#{human_party},#{human_nationality},#{human_race},"
			+ "#{human_birthday},#{human_birthplace},#{human_age},#{human_educated_degree},#{human_educated_years},#{human_educated_major},"
			+ "#{human_society_security_id},#{human_id_card},#{remark},#{salary_standard_id},#{salary_standard_name},"
			+ "#{salary_sum},#{demand_salaray_sum},null,null,null,null,null,#{human_histroy_records},#{human_family_membership},null,null,2,#{register},null,null,"
			+ "#{regist_time},null,null,null,null,null,1)")
	public void add(Humman_file humman_file);
	
	//查询人力资源档案表
	@Select("SELECT * FROM humman_file")
	@ResultMap("Humman_file")
	public List<Humman_file> Humman_fileList();
	
	//查询根据人力资源表查询单条数据
	@Select("select * from humman_file where human_id = #{human_id}")
	@ResultMap("Humman_file")
	public Humman_file human_check(String human_id);
	//修改
	@Update("UPDATE humman_file SET human_name=#{human_name},human_address=#{human_address},human_postcode=#{human_postcode},human_pro_designation=#{human_pro_designation},human_telephone=#{human_telephone},"
			+ "human_mobilephone=#{human_mobilephone},human_bank=#{human_bank},human_account=#{human_account},human_qq=#{human_qq},human_email=#{human_email},human_hobby=#{human_hobby},human_speciality=#{human_speciality},"
			+ "human_sex=#{human_sex},human_religion=#{human_religion},human_party=#{human_party},human_nationality=#{human_nationality},human_race=#{human_race},human_birthday=#{human_birthday},human_birthplace=#{human_birthplace},"
			+ "human_age=#{human_age},human_educated_degree=#{human_educated_degree},human_educated_years=#{human_educated_years},human_educated_major=#{human_educated_major},human_society_security_id=#{human_society_security_id},"
			+ "human_id_card=#{human_id_card},remark=#{remark},salary_standard_id=#{salary_standard_id},salary_standard_name=#{salary_standard_name},salary_sum=#{salary_sum},demand_salaray_sum=#{demand_salaray_sum},"
			+ "human_histroy_records=#{human_histroy_records},human_family_membership=#{human_family_membership},check_status=1,checker=#{checker},check_time=#{check_time},human_file_status=2 WHERE human_id = #{human_id}")
	public void humman_chack_update(Humman_file humman_file);
}

