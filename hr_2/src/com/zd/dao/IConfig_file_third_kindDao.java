package com.zd.dao;
/**
 * 三级机构dao
 * @author 周泽旭
 *
 */
import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.Config_file_third_kind;

public interface IConfig_file_third_kindDao {

	//根据二级机构编号查询三级机构
	@Select("SELECT * FROM config_file_third_kind WHERE second_kind_id = #{fsk_id}")
	@ResultMap("Config_file_third_kind")
	public List<Config_file_third_kind> selsanji(String fsk_id);
}
