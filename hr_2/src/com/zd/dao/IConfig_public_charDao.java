package com.zd.dao;
/**
 * 公共字段dao
 * @author 周泽旭
 *
 */

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.Config_public_char;

public interface IConfig_public_charDao {

	//查询国籍
	@Select("select * from config_public_char WHERE attribute_kind ='国籍'")
	@ResultMap("Config_public_char")
	public List<Config_public_char> listguoji();
	//查询民族
	@Select("select * from config_public_char WHERE attribute_kind ='民族'")
	@ResultMap("Config_public_char")
	public List<Config_public_char> listmingzu();
	//查询宗教信仰
	@Select("select * from config_public_char WHERE attribute_kind ='宗教信仰'")
	@ResultMap("Config_public_char")
	public List<Config_public_char> listzongjiao();
	//查询政治面貌
	@Select("select * from config_public_char WHERE attribute_kind ='政治面貌'")
	@ResultMap("Config_public_char")
	public List<Config_public_char> listzhengzhi();
	//查询学历
	@Select("select * from config_public_char WHERE attribute_kind ='学历'")
	@ResultMap("Config_public_char")
	public List<Config_public_char> listxueli();
	//查询教育年限
	@Select("select * from config_public_char WHERE attribute_kind ='教育年限'")
	@ResultMap("Config_public_char")
	public List<Config_public_char> listjiaoyu();
	//查询学历专业
	@Select("select * from config_public_char WHERE attribute_kind ='学历专业'")
	@ResultMap("Config_public_char")
	public List<Config_public_char> listzhuanye();
	//查询特长
	@Select("select * from config_public_char WHERE attribute_kind ='特长'")
	@ResultMap("Config_public_char")
	public List<Config_public_char> listtechang();
	//查询爱好
	@Select("select * from config_public_char WHERE attribute_kind ='爱好'")
	@ResultMap("Config_public_char")
	public List<Config_public_char> listaihao();
	//查询招聘类型
	@Select("select * from config_public_char WHERE attribute_kind ='招聘类型'")
	@ResultMap("Config_public_char")
	public List<Config_public_char> listzhaopin();
	//查询职称
	@Select("select * from config_public_char WHERE attribute_kind ='职称'")
	@ResultMap("Config_public_char")
	public List<Config_public_char> listzhicheng();

}
