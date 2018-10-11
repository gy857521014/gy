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

public interface IUserDao {
	//�û��������½��½
	@Select("select * from user where user_name=#{user_phone} and user_password=#{user_password}")
	@ResultMap("userMapper")
	public User login(User u);

	//�ֻ������½
	@Select("select * from user where user_phone=#{user_phone}")
	@ResultMap("userMapper")
	public User loginByphone(User u);
	
	//��ѯ�ֻ����Ƿ����
	@Select("SELECT COUNT(*) FROM USER WHERE user_phone=#{user_phone}")
	public int byuser_phone(String user_phone);
	
	//��ѯ�����û�
	//@Select("select * from user LIMIT #{start},10")
	//@ResultMap("userMapper")
	public List<User> queryAll(Map selMap);
	
	//��ҳ��ѯ
	@Select("select count(*) from user")
	public int queryAll2();
	
	//����û�
	@Insert("INSERT INTO USER VALUES(NULL,#{user_name},#{user_true_name},#{user_password},null)")
	@SelectKey(resultType=int.class,
				statement="SELECT MAX(userid) FROM USER",
				keyProperty="userid",
				before=false)
	public void userAdd(User user);
	
	//��ѯ�û����Ƿ��ظ�
	@Select("SELECT COUNT(*) FROM USER WHERE user_name=#{user_name}")
	public int byuser_name(String user_name);
	
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
	
	//�޸��û���Ϣ���޸ģ�
	@Update("update user set user_true_name=#{user_true_name},user_password=#{user_password} where userid=#{userid} ")
	public void userUpdate(User user);
	
	//���ֻ���
	@Update("update user set user_phone=#{user_phone} where userid=#{userid}")
	public void phoneUpdate(User user);
	
}
