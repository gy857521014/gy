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
	//用户名密码登陆登陆
	@Select("select * from user where user_name=#{user_phone} and user_password=#{user_password}")
	@ResultMap("userMapper")
	public User login(User u);

	//手机号码登陆
	@Select("select * from user where user_phone=#{user_phone}")
	@ResultMap("userMapper")
	public User loginByphone(User u);
	
	//查询手机号是否存在
	@Select("SELECT COUNT(*) FROM USER WHERE user_phone=#{user_phone}")
	public int byuser_phone(String user_phone);
	
	//查询所有用户
	//@Select("select * from user LIMIT #{start},10")
	//@ResultMap("userMapper")
	public List<User> queryAll(Map selMap);
	
	//分页查询
	@Select("select count(*) from user")
	public int queryAll2();
	
	//添加用户
	@Insert("INSERT INTO USER VALUES(NULL,#{user_name},#{user_true_name},#{user_password},null)")
	@SelectKey(resultType=int.class,
				statement="SELECT MAX(userid) FROM USER",
				keyProperty="userid",
				before=false)
	public void userAdd(User user);
	
	//查询用户名是否重复
	@Select("SELECT COUNT(*) FROM USER WHERE user_name=#{user_name}")
	public int byuser_name(String user_name);
	
	//添加用户关系
	@Insert("INSERT INTO u_r_conn VALUES(#{u_id},#{r_id})")
	public void u_r_connAdd(Map<String, Integer> map);
	
	//删除用户
	@Delete("DELETE FROM USER WHERE userid=#{userid}")
	public void userDel(int userid);
	
	//删除关系表数据
	@Delete("delete from u_r_conn where u_id=#{userid}")
	public void u_r_connDel(int userid);
	
	//查询用户（修改）
	@Select("select * from user where userid=#{userid}")
	@ResultMap("userMapper")
	public User userByid(int userid);
	
	//修改用户信息（修改）
	@Update("update user set user_true_name=#{user_true_name},user_password=#{user_password} where userid=#{userid} ")
	public void userUpdate(User user);
	
	//绑定手机号
	@Update("update user set user_phone=#{user_phone} where userid=#{userid}")
	public void phoneUpdate(User user);
	
}
