package com.zd.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.zd.entity.User_role;

public interface IUser_roleService {

	//��ѯ״ֵ̬Ϊ1�����н�ɫ
	public List<User_role> queryUr();
	
	//��ѯ���н�ɫ
	public List<User_role> user_roleAll();
	
	//���ݽ�ɫidɾ����ɫ
	public void user_roleDel(int uroleid);
	
	//��ӽ�ɫ
	public void user_roleAdd(User_role ur);
	
	//�޸Ľ�ɫǰ�Ĳ�ѯ
	public User_role user_roleByid(int uroleid);
	
	//�޸Ľ�ɫ��Ϣ
	public void user_roleUpdate(User_role ur,List<Integer> q_id);
	
	//�жϽ�ɫ�����Ƿ����
	public int byurole_name(String urole_name);
}
