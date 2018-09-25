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
	//²éÑ¯ËùÓÐ
		@Autowired
		public List<Config_file_first_kind> selcffk() {
			return icffkdao.selcffk();
		}
}
