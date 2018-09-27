package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.Config_file_third_kind;

/**
 * 三级机构dao
 * @author 周泽旭
 *
 */
public interface IConfig_file_third_kindDao {
	//查询所有
		@Select("select * from Config_file_third_kind")
		@ResultMap("cftk")
		public List<Config_file_third_kind>  selcftk();
}
