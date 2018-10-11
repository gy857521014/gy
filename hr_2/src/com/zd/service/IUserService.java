package com.zd.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.zd.entity.User;
import com.zd.entity.User_role;

public interface IUserService {

	//�û��������½��½
	public User login(User u);
	
	//�ж��ֻ����Ƿ����
	public int byuser_phone(String user_phone);
	//�ж��û����Ƿ����
	public int byuser_name(String user_name);
	//�ֻ������½
	public User loginByphone(User u);
	
	//��ѯ�û�
	public List<User> queryAll(int start);
	//��ҳ��ѯ
	public int queryAll2();
	
	//����û�
	public void userAdd(User user,List<Integer> userIds);

	//ɾ���û�
	public void userDel(int userid);
	
	//��ѯ�û����޸ģ�
	public User userByid(int userid);
	
	//�޸��û���Ϣ
	public void userUpdate(User user,List<Integer> uroleid);
	
	//���ֻ���
	public void phoneUpdate(User user);

}
