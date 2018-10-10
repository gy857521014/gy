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
	
	//查询状态值为1的所有角色
	@Select("select * from user_role where urole_state = 1")
	@ResultMap("user_roleMapper")
	public List<User_role> queryUr();
	
	//查询所有角色
	@Select("select * from user_role")
	@ResultMap("user_roleMapper")
	public List<User_role> user_roleAll();
	
	//根据角色id删除角色
	@Delete("delete from user_role where uroleid=#{uroleid}")
	public void user_roleDel(int uroleid);
	
	//添加角色
	@Insert("INSERT INTO user_role VALUES(NULL,#{urole_name},#{urole_exp},#{urole_state})")
	public void user_roleAdd(User_role ur);
	
	//修改角色前的查询
	@Select("select * from user_role where uroleid=#{uroleid}")
	@ResultMap("user_roleMapper")
	public User_role user_roleByid(int uroleid);
	
	//修改角色信息
	@Update("update user_role set urole_name=#{urole_name},urole_exp=#{urole_exp},urole_state=#{urole_state} where uroleid=#{uroleid}")
	public void user_roleUpdate(User_role ur);
	//删除权限关系表数据
	@Delete("delete from r_q_conn where r_id=#{uroleid}")
	public void u_r_connDel(int uroleid);
	//添加用户关系
	@Insert("INSERT INTO r_q_conn VALUES(#{r_id},#{q_id})")
	public void u_r_connAdd(Map<String, Integer> map);
}
