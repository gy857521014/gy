package com.zd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IConfig_file_second_kindDao;
import com.zd.entity.Config_file_second_kind;
import com.zd.service.IConfig_file_second_kindService;

@Service
public class Config_file_second_kindService implements IConfig_file_second_kindService{
	@Autowired
	private IConfig_file_second_kindDao icfskdao;
	
	@Override
	public List<Config_file_second_kind> selcfsk() {
		return icfskdao.selcfsk();
	}
	//添加
	public void addcfsk(Config_file_second_kind config_file_second_kind) {
		icfskdao.addcfsk(config_file_second_kind);
	}
	//查询修改
	public Config_file_second_kind selcfskid(String second_kind_id) {
		Config_file_second_kind cfsk = icfskdao.selcfskid(second_kind_id);
		return cfsk;
	}
	//修改
	public void updatecfsk(Config_file_second_kind config_file_second_kind) {
		icfskdao.updatecfsk(config_file_second_kind);
	}
	//删除
	public void deletecfsk(String second_kind_id) {
		icfskdao.deletecfsk(second_kind_id);
	}
	//根据一级机构编号查询二级机构
	public List<Config_file_second_kind> selerji(String fsk_id) {
		return icfskdao.selerji(fsk_id);
	}
	
	
	public List<Map> tongjiByFname() {
		return icfskdao.tongjiByFname();
	}
	
	//根据二级机构id查询名称
	public Config_file_second_kind selerjiid(String id) {
		
		Config_file_second_kind second=icfskdao.selerjiid(id);
		return second;
	}
	//根据一级编号删除
	public void deletebh(String first_kind_id) {
		icfskdao.deletebh(first_kind_id);
	}
}
