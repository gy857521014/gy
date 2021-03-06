package com.zd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IConfig_file_first_kindDao;
import com.zd.dao.ISalary_grantDao;
import com.zd.entity.Config_file_first_kind;
import com.zd.service.IConfig_file_first_kindService;

@Service
public class Config_file_first_kindService implements IConfig_file_first_kindService{
	@Autowired
	private IConfig_file_first_kindDao icffkdao;
	@Autowired
	private ISalary_grantDao dao;
	
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
	public void deletecffk(String first_kind_id) {
		icffkdao.deletecffk(first_kind_id);
	}
	public int selhumnum() {
		return dao.selhumnum();
	}
	
	// 通过一级名称统计人数、薪酬
	public List<Map> tongjiByFname(){
		return icffkdao.tongjiByFname();
	}
	
}
