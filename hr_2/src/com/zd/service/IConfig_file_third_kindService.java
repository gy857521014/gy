package com.zd.service;

import java.util.List;

import com.zd.entity.Config_file_third_kind;

/**
 * 三级机构service
 * @author 周泽旭
 *
 */
public interface IConfig_file_third_kindService {
	//查询
	public List<Config_file_third_kind> selcftk();

	//根据二级机构编号查询三级机构
	public List<Config_file_third_kind> selsanji(String fsk_id);
}
