package com.zd.service;

import java.util.List;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_public_char;
import com.zd.entity.Humman_file;

/**
 * 人力资源管理Service
 * @author 周泽旭
 *
 */
public interface IHumman_fileService {

	//三级联动
		//一级机构查询
		public List<Config_file_first_kind> selcffk();
	
	public int selnumz();
	//查询国籍
	public List<Config_public_char> listguoji();
	//查询民族
	public List<Config_public_char> listmingzu();
	//查询宗教信仰
	public List<Config_public_char> listzongjiao();
	//查询政治面貌
	public List<Config_public_char> listzhengzhi();
	//查询学历
	public List<Config_public_char> listxueli();
	//查询教育年限
	public List<Config_public_char> listjiaoyu();
	//查询学历专业
	public List<Config_public_char> listzhuanye();
	//查询特长
	public List<Config_public_char> listtechang();
	//查询爱好
	public List<Config_public_char> listaihao();
	
	public int shifa();
	
	public int zong();
}
