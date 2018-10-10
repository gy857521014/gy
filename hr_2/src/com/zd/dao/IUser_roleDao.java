package com.zd.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zd.entity.User_role;

public interface IUser_roleDao {
	
	public List<User_role> queryByUid(int userid);
	
	//��ѯ״ֵ̬Ϊ1�����н�ɫ
	@Select("select * from user_role where urole_state = 1")
	@ResultMap("user_roleMapper")
	public List<User_role> queryUr();
	
	//��ѯ���н�ɫ
	@Select("select * from user_role")
	@ResultMap("user_roleMapper")
	public List<User_role> user_roleAll();
	
	//���ݽ�ɫidɾ����ɫ
	@Delete("delete from user_role where uroleid=#{uroleid}")
	public void user_roleDel(int uroleid);
	
	//��ӽ�ɫ
	@Insert("INSERT INTO user_role VALUES(NULL,#{urole_name},#{urole_exp},#{urole_state})")
	public void user_roleAdd(User_role ur);
	
	//�޸Ľ�ɫǰ�Ĳ�ѯ
	@Select("select * from user_role where uroleid=#{uroleid}")
	@ResultMap("user_roleMapper")
	public User_role user_roleByid(int uroleid);
	
	//�޸Ľ�ɫ��Ϣ
	@Update("update user_role set urole_name=#{urole_name},urole_exp=#{urole_exp},urole_state=#{urole_state} where uroleid=#{uroleid}")
	public void user_roleUpdate(User_role ur);
	//ɾ��Ȩ�޹�ϵ������
	@Delete("delete from r_q_conn where r_id=#{uroleid}")
	public void u_r_connDel(int uroleid);
	//����û���ϵ
	@Insert("INSERT INTO r_q_conn VALUES(#{r_id},#{q_id})")
	public void u_r_connAdd(Map<String, Integer> map);
}
