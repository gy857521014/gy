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
	//登陆
	@Select("select * from user where user_name=#{user_name} and user_password=#{user_password}")
	@ResultMap("userMapper")
	public User login(User u);

	//查询所有用户
	@Select("select * from user")
	@ResultMap("userMapper")
	public List<User> queryAll();
	
	//添加用户
	@Insert("INSERT INTO USER VALUES(NULL,#{user_name},#{user_true_name},#{user_password})")
	@SelectKey(resultType=int.class,
				statement="SELECT MAX(userid) FROM USER",
				keyProperty="userid",
				before=false)
	public void userAdd(User user);
	
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
	//查询当前用户的角色
	/*@Select("select * from user_role where uroleid=#{r_id}")
	@ResultMap("userMapper")
	public List<User_role> userroleByid(int r_id);*/
	
	//修改用户信息（修改）
	@Update("update user set user_name=#{user_name},user_true_name=#{user_true_name},user_password=#{user_password} where userid=#{userid} ")
	public void userUpdate(User user);
	
}
