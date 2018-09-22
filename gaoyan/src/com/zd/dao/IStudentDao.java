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

	//��ѯ����ѧ����Ϣ
	@Select("select * from student")
	@ResultMap("studentMapper")
	public List<student> SelallStudent();
	
	//���ѧ����Ϣ
	@Insert("insert into student values(null,#{sname},#{ssex},#{sage})")
	public void Addstudent(Map map);
	
	//����idɾ��ѧ��
	@Delete("delete from student where sid=#{sid}")
	public void Delstudent(int sid);
	
	//�޸�ǰ�Ĳ�ѯ
	@Select("select * from student where sid=#{sid}")
	@ResultMap("studentMapper")
	public student studentByid(int sid);
	
	//�޸�ѧ����Ϣ
	@Update("update student set sname=#{sname},ssex=#{ssex},sage=#{sage} where sid=#{sid}")
	public void upStu(Map map);
}
