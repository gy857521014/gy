package com.zd.service;

import java.util.List;
import java.util.Map;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_public_char;
import com.zd.entity.Humman_file;
import com.zd.entity.Salary_standard;

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
	//查询招聘类型
	public List<Config_public_char> listzhaopin();
	//查询职称
	public List<Config_public_char> listzhicheng();
	//查询薪酬标准
	public List<Salary_standard> xinchoulist();
	//根据薪酬标注编号查询薪酬标准name
	public Salary_standard xinchouid(String id);
	//添加
	public void add(Humman_file humman_file);
	//修改上传图片
	public void uploadUpdate(Map map);
	//查询人力资源档案表
	public List<Humman_file> Humman_fileList();
	//查询根据人力资源表查询单条数据
	public Humman_file human_check(String human_id);
	//修改人力资源表
	public void humman_chack_update(Humman_file humman_file);
	//条件查询
	public List<Humman_file> query_list(Map map);
	//人力资源变更修改
	public void register_choose_picture_update(Humman_file humman_file);
	//多条件查询人力资源删除
	public List<Humman_file> delete_list(Map map);
	//人力资源删除修改
	public void success_update(Humman_file humman_file);
	//人力资源恢复条件查询
	public List<Humman_file> recovery_list(Map map);
	//人力资源恢复修改
	public void success_update1(Humman_file humman_file);
	//人力资源删除查询
	public List<Humman_file> Humman_fileList1();
	//人力资源删除
	public void Delete(String human_id);
	public int shifa();
	
	public int zong();
}
