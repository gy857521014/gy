package com.zd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IConfig_majorDao;
import com.zd.entity.Config_major;
import com.zd.service.IConfig_majorService;

@Service
public class Config_majorService implements IConfig_majorService{
	
	@Autowired
	private IConfig_majorDao majordao;
	
	//查询职位分类下对应的职位
	public List<Config_major> selzhiwei(int majorid) {
		List<Config_major> list=majordao.selzhiwei(majorid);
		return list;
	}

	//查询职位id对应的名称
	public Config_major selzhiweiid(int id) {
		Config_major major=majordao.selzhiweiid(id);
		return major;
	}

	
	public List<Config_major> selallzhi() {
		return majordao.selallzhi();
		
	}
}
