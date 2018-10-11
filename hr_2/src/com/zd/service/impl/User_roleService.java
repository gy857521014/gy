package com.zd.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IUser_roleDao;
import com.zd.entity.User_role;
import com.zd.service.IUser_roleService;

@Service
public class User_roleService implements IUser_roleService {
	@Autowired
	private IUser_roleDao user_roleDao;

	//查询状态值为1的所有角色
	@Override
	public List<User_role> queryUr() {
		return user_roleDao.queryUr();
	}

	//查询所有角色
	@Override
	public List<User_role> user_roleAll() {
		return user_roleDao.user_roleAll();
	}

	//根据角色id删除角色
	@Override
	public void user_roleDel(int uroleid) {
		user_roleDao.user_roleDel(uroleid);
	}

	//添加角色
	@Override
	public void user_roleAdd(User_role ur) {
		user_roleDao.user_roleAdd(ur);
	}

	//修改角色前的查询
	@Override
	public User_role user_roleByid(int uroleid) {
		return user_roleDao.user_roleByid(uroleid);
	}

	//修改角色信息
	@Override
	public void user_roleUpdate(User_role ur,List<Integer> q_id) {
		user_roleDao.user_roleUpdate(ur);
		if(q_id != null) {
			user_roleDao.u_r_connDel(ur.getUroleid());
			for (Integer qid : q_id) {
				Map<String, Integer> map = new HashMap<String,Integer>();
				map.put("q_id", qid);
				map.put("r_id", ur.getUroleid());
				user_roleDao.u_r_connAdd(map);
			}
		}
	}

	//查询角色名是否存在
	@Override
	public int byurole_name(String urole_name) {
		return user_roleDao.byurole_name(urole_name);
	}

}
