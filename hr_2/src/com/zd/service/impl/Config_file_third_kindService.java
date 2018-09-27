package com.zd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IConfig_file_third_kindDao;
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
	private IConfig_file_third_kindDao config_file_third_kindDao;

	//根据二级机构编号查询三级机构
	public List<Config_file_third_kind> selsanji(String fsk_id) {
		return config_file_third_kindDao.selsanji(fsk_id);
	}
	

	
}
