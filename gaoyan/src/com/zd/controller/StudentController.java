package com.zd.controller;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.ResultMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zd.entity.student;
import com.zd.service.IStudentService;

@Controller
public class StudentController {

	@Autowired
	private IStudentService studentService;
	
	@RequestMapping("SelallStudent")
	public String SelallStudent(Map<String, Object> map){
		Logger  logger = LoggerFactory.getLogger(StudentController.class);
		
		try{
			List<student> stuList = studentService.SelallStudent();
			map.put("stuList", stuList);
		}catch (Exception e) {
			logger.error("查询学生信息错误",e);
		}
		return"text";
	}
	//跳转添加页面
	@RequestMapping("/toAdd")
	public String toAdd(){
		return "addStudent";
	}
	//添加学生信息
	@RequestMapping("Addstudent")
	public String Addstudent(@RequestParam Map<String,String> map){
		Logger logger = LoggerFactory.getLogger(StudentController.class);
		try{
			studentService.Addstudent(map);
		}catch (Exception e) {
			logger.error("添加信息错误",e);
		}
		return "redirect:SelallStudent";
		
	}
	//根据id删除学生信息
	@RequestMapping("/Delstudent")
	public String Delstudent(int sid){
		Logger logger = LoggerFactory.getLogger(StudentController.class);
		try{
			studentService.Delstudent(sid);
		}catch (Exception e) {
			logger.error("删除信息错误",e);
		}
		return null;
	}
	//修改前的查询
	@RequestMapping("/studentByid")
	public String studentByid(int sid,Map<String, Object> map){
		Logger logger = LoggerFactory.getLogger(StudentController.class);
		try{
			student s = studentService.studentByid(sid);
			map.put("s", s);
		}catch (Exception e) {
			logger.error("修改前的错误",e);
		}
		return "updateStu";
	}
	//修改学生信息
	@RequestMapping("/upStu")
	public String upStu(@RequestParam Map<String, String> map){
		Logger logger = LoggerFactory.getLogger(StudentController.class);
		try{
			studentService.upStu(map);
		}catch (Exception e) {
			logger.error("修改信息报错",e);
		}
		return "redirect:SelallStudent";
	}
}
