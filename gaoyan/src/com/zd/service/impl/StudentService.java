package com.zd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IStudentDao;
import com.zd.entity.student;
import com.zd.service.IStudentService;

@Service
public class StudentService implements IStudentService {
	
	@Autowired
	private IStudentDao studentdao;

	//查询所有学生信息
	public List<student> SelallStudent() {
		return studentdao.SelallStudent();
	}

	@Override
	public void Addstudent(Map map) {
		studentdao.Addstudent(map);
		
	}

	@Override
	public void Delstudent(int sid) {
		studentdao.Delstudent(sid);
		
	}

	@Override
	public student studentByid(int sid) {
		return studentdao.studentByid(sid);
	}

	@Override
	public void upStu(Map map) {
		studentdao.upStu(map);
		
	}

	

	

}
