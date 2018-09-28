package com.zd.service;

import java.util.List;

import com.zd.entity.User;

public interface IUserService {

	//��½
	public User login(User u);
	
	//��ѯ�û�
	public List<User> queryAll();
	
	//����û�
	public void userAdd(User user,List<Integer> userIds);

	//ɾ���û�
	public void userDel(int userid);
	
	//��ѯ�û����޸ģ�
	public User userByid(int userid);
	
	//�޸��û���Ϣ
	public void userUpdate(User user,List<Integer> uroleid);

}
