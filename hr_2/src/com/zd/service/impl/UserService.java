package com.zd.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IUserDao;
import com.zd.entity.User;
import com.zd.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserDao userDao;
	

	//�û��������½��½
	@Override
	public User login(User u) {
		return userDao.login(u);
	}

	//�ֻ������½
	@Override
	public User loginByphone(User u) {
		return userDao.loginByphone(u);
	}
	//�ж��ֻ����Ƿ����
	@Override
	public int byuser_phone(String user_phone) {
		return userDao.byuser_phone(user_phone);
	}


	//��ѯ�����û���Ϣ
	@Override
	public List<User> queryAll() {
		return userDao.queryAll();
	}

	//����û�
	@Override
	public void userAdd(User user,List<Integer> userIds) {
		userDao.userAdd(user);
		//��ӹ�ϵ
		//List<User_role> roleList = user.getUrole();
		if(userIds != null) {
			for (Integer rid : userIds) {
				Map<String, Integer> map = new HashMap<String,Integer>();
				map.put("r_id", rid);
				map.put("u_id", user.getUserid());
				userDao.u_r_connAdd(map);
			}
		}
	}

	//ɾ���û�
	@Override
	public void userDel(int userid) {
		userDao.userDel(userid);
		userDao.u_r_connDel(userid);
	}

	//��ѯ�û����޸ģ�
	@Override
	public User userByid(int userid) {
		return userDao.userByid(userid);
	}

	//�޸Ŀͻ���Ϣ
	@Override
	public void userUpdate(User user,List<Integer> uroleid) {
		userDao.userUpdate(user);
		if(uroleid != null) {
			userDao.u_r_connDel(user.getUserid());
			for (Integer rid : uroleid) {
				Map<String, Integer> map = new HashMap<String,Integer>();
				map.put("r_id", rid);
				map.put("u_id", user.getUserid());
				userDao.u_r_connAdd(map);
			}
		}
		
	}

	//���ֻ���
	@Override
	public void phoneUpdate(User user) {
		userDao.phoneUpdate(user);
	}

	
}
