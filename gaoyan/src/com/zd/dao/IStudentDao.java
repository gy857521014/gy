package com.zd.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zd.entity.student;

public interface IStudentDao {

	//查询所有学生信息
	@Select("select * from student")
	@ResultMap("studentMapper")
	public List<student> SelallStudent();
	
	//添加学生信息
	@Insert("insert into student values(null,#{sname},#{ssex},#{sage})")
	public void Addstudent(Map map);
	
	//根据id删除学生
	@Delete("delete from student where sid=#{sid}")
	public void Delstudent(int sid);
	
	//修改前的查询
	@Select("select * from student where sid=#{sid}")
	@ResultMap("studentMapper")
	public student studentByid(int sid);
	
	//修改学生信息
	@Update("update student set sname=#{sname},ssex=#{ssex},sage=#{sage} where sid=#{sid}")
	public void upStu(Map map);
}
