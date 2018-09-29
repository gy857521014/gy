package com.zd.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.zd.entity.User;
import com.zd.entity.User_role;

public interface IUserDao {
	//��½
	@Select("select * from user where user_name=#{user_name} and user_password=#{user_password}")
	@ResultMap("userMapper")
	public User login(User u);

	//��ѯ�����û�
	@Select("select * from user")
	@ResultMap("userMapper")
	public List<User> queryAll();
	
	//����û�
	@Insert("INSERT INTO USER VALUES(NULL,#{user_name},#{user_true_name},#{user_password})")
	@SelectKey(resultType=int.class,
				statement="SELECT MAX(userid) FROM USER",
				keyProperty="userid",
				before=false)
	public void userAdd(User user);
	
	//����û���ϵ
	@Insert("INSERT INTO u_r_conn VALUES(#{u_id},#{r_id})")
	public void u_r_connAdd(Map<String, Integer> map);
	
	//ɾ���û�
	@Delete("DELETE FROM USER WHERE userid=#{userid}")
	public void userDel(int userid);
	
	//ɾ����ϵ������
	@Delete("delete from u_r_conn where u_id=#{userid}")
	public void u_r_connDel(int userid);
	
	//��ѯ�û����޸ģ�
	@Select("select * from user where userid=#{userid}")
	@ResultMap("userMapper")
	public User userByid(int userid);
	//��ѯ��ǰ�û��Ľ�ɫ
	/*@Select("select * from user_role where uroleid=#{r_id}")
	@ResultMap("userMapper")
	public List<User_role> userroleByid(int r_id);*/
	
	//�޸��û���Ϣ���޸ģ�
	@Update("update user set user_name=#{user_name},user_true_name=#{user_true_name},user_password=#{user_password} where userid=#{userid} ")
	public void userUpdate(User user);
	
}
