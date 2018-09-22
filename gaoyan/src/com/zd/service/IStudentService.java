package com.zd.service;

import java.util.List;
import java.util.Map;

import com.zd.entity.student;


public interface IStudentService {

	//查询学生信息
	public List<student> SelallStudent();
	
	//添加学生信息
	public void Addstudent(Map map); 
	
	//根据ID删除学生信息
	public void Delstudent(int sid);
	
	//修改前的查询
	public student studentByid(int sid);
	
	//修改学生信息
	public void upStu(Map map);
}
