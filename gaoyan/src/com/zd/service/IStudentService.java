package com.zd.service;

import java.util.List;
import java.util.Map;

import com.zd.entity.student;


public interface IStudentService {

	//��ѯѧ����Ϣ
	public List<student> SelallStudent();
	
	//���ѧ����Ϣ
	public void Addstudent(Map map); 
	
	//����IDɾ��ѧ����Ϣ
	public void Delstudent(int sid);
	
	//�޸�ǰ�Ĳ�ѯ
	public student studentByid(int sid);
	
	//�޸�ѧ����Ϣ
	public void upStu(Map map);
}
