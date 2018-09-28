package com.zd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IConfig_file_third_kindDao;
import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;
import com.zd.service.IConfig_file_third_kindService;
/**
 * 三级机构service
 * @author 周泽旭
 *
 */
@Service
public class Config_file_third_kindService implements IConfig_file_third_kindService {
	@Autowired
	private IConfig_file_third_kindDao icftkdao;
	
	@Override
	public List<Config_file_third_kind> selcftk() {
		return icftkdao.selcftk();
	}
	//删除
	public void deletecftk(int ftk_id) {
		icftkdao.deletecftk(ftk_id);
	}
	//添加
	public void addcftk(Config_file_third_kind config_file_third_kind) {
		icftkdao.addcftk(config_file_third_kind);
	}
	//查询修改
	public Config_file_third_kind selcftkid(String third_kind_id) {
		Config_file_third_kind cftk = icftkdao.selcftkid(third_kind_id);
		return cftk;
	}

	//根据二级机构编号查询三级机构
	public List<Config_file_third_kind> selsanji(String fsk_id) {
		return icftkdao.selsanji(fsk_id);
	}
	//修改
	public void updatecftk(Config_file_third_kind config_file_third_kind) {
		icftkdao.updatecftk(config_file_third_kind);
	}
}
