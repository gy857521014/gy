package com.zd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IConfig_file_first_kindDao;
import com.zd.entity.Config_file_first_kind;
import com.zd.service.IConfig_file_first_kindService;

@Service
public class Config_file_first_kindService implements IConfig_file_first_kindService{
	@Autowired
	private IConfig_file_first_kindDao icffkdao;
	
	//查询所有
	public List<Config_file_first_kind> selcffk() {
		return icffkdao.selcffk();
	}
	//添加
	public void addcffk(Config_file_first_kind config_file_first_kind) {
		icffkdao.addcffk(config_file_first_kind);
	}
	//查询修改
	public Config_file_first_kind selcffkid(String first_kind_id) {
		Config_file_first_kind cffk = icffkdao.selcffkid(first_kind_id);
		return cffk;
	}
	//修改
	public void updatecffk(Config_file_first_kind config_file_first_kind) {
		icffkdao.updatecffk(config_file_first_kind);
	}
	//删除
	public void deletecffk(int ffk_id) {
		icffkdao.deletecffk(ffk_id);
	}
}
