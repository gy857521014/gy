package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zd.entity.Engage_major_release;

public interface IEngage_major_releaseDao {
	
	//��ѯ������Ƹ
	@Select("select * from Engage_major_release")
	@ResultMap("releaseMapper")
	public List<Engage_major_release> selallrelease();
	
	//��ѯ������Ƹ
	@Select("select * from Engage_major_release where mre_id=#{id}")
	@ResultMap("releaseMapper")
	public Engage_major_release selidrelease(int id);
	
	//�޸�
	@Update("update Engage_major_release set engage_type=#{engage_type},human_amount=#{human_amount},changer=#{changer},major_describe=#{major_describe},engage_required=#{engage_required},deadline=#{deadline} where mre_id=#{mre_id}")
	public void updaterelease(Engage_major_release release);
	
	//ɾ��
	@Delete("delete from Engage_major_release where mre_id=#{id}")
	public void deleterelease(int id);
}
