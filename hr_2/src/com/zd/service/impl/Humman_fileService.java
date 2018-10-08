package com.zd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IConfig_file_first_kindDao;
import com.zd.dao.IConfig_public_charDao;
import com.zd.dao.IHumman_fileDao;
import com.zd.dao.ISalary_grantDao;
import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_public_char;
import com.zd.entity.Humman_file;
import com.zd.entity.Salary_standard;
import com.zd.service.IHumman_fileService;

/**
 * 人力资源管理的Servie
 * @author 周泽旭
 *
 */
@Service
public class Humman_fileService implements IHumman_fileService {
	@Autowired
	private ISalary_grantDao gdao;
	
	@Autowired
	private IHumman_fileDao humman_fileDao;

	@Autowired
	private IConfig_file_first_kindDao config_file_first_kindDao;
	@Autowired
	private IConfig_public_charDao config_public_charDao; 
	
	//三级联动
		//一级机构查询
		public List<Config_file_first_kind> selcffk() {
			return config_file_first_kindDao.selcffk();
		}
	
	//查询国籍
	public List<Config_public_char> listguoji() {
		return config_public_charDao.listguoji();
	}
	//查询民族
	public List<Config_public_char> listmingzu() {
		return config_public_charDao.listmingzu();
	}
	//查询宗教信仰
	public List<Config_public_char> listzongjiao() {
		return config_public_charDao.listzongjiao();
	}
	//查询政治面貌
	public List<Config_public_char> listzhengzhi() {
		return config_public_charDao.listzhengzhi();
	}
	//查询学历
	public List<Config_public_char> listxueli() {
		return config_public_charDao.listxueli();
	}
	//查询教育年限
	public List<Config_public_char> listjiaoyu() {
		return config_public_charDao.listjiaoyu();
	}
	//查询学历专业
	public List<Config_public_char> listzhuanye() {
		return config_public_charDao.listzhuanye();
	}
	//查询特长
	public List<Config_public_char> listtechang() {
		return config_public_charDao.listtechang();
	}
	//查询爱好
	public List<Config_public_char> listaihao() {
		return config_public_charDao.listaihao();
	}

	public List<Config_public_char> listzhaopin(){
		
		return config_public_charDao.listzhaopin();
	}
	//查询职称
	public List<Config_public_char> listzhicheng() {
		return config_public_charDao.listzhicheng();
	}
	//查询薪酬标准
	public List<Salary_standard> xinchoulist() {
		return humman_fileDao.xinchoulist();
	}
	//根据薪酬标注编号查询薪酬标准name
	public Salary_standard xinchouid(String id) {
		return humman_fileDao.xinchouid(id);
	}
	//添加
	public void add(Humman_file humman_file) {
		humman_fileDao.add(humman_file);
	}
	//修改上传图片路径
	public void uploadUpdate(Map map) {
		humman_fileDao.uploadUpdate(map);
	}
	//查询人力资源档案表
	public List<Humman_file> Humman_fileList() {
		return humman_fileDao.Humman_fileList();
	}
	//查询根据人力资源表查询单条数据
	public Humman_file human_check(String human_id) {
		return humman_fileDao.human_check(human_id);
	}
	//修改人力资源档案
	public void humman_chack_update(Humman_file humman_file) {
		humman_fileDao.humman_chack_update(humman_file);
	}
	//条件查询
	public List<Humman_file> query_list(Map map) {
		return humman_fileDao.query_list(map);
	}
	//人力资源变更修改
	public void register_choose_picture_update(Humman_file humman_file) {
		humman_fileDao.register_choose_picture_update(humman_file);
	}
	//多条件查询人力资源删除
	public List<Humman_file> delete_list(Map map) {
		return humman_fileDao.delete_list(map);
	}
	//人力资源删除修改
	public void success_update(Humman_file humman_file) {
		humman_fileDao.success_update(humman_file);
	}
	//人力资源恢复条件查询
	public List<Humman_file> recovery_list(Map map) {
		return humman_fileDao.recovery_list(map);
	}
	//人力资源恢复修改
	public void success_update1(Humman_file humman_file) {
		humman_fileDao.success_update1(humman_file);
	}
	//人力资源删除查询
	public List<Humman_file> Humman_fileList1() {
		return humman_fileDao.Humman_fileList1();
	}
	//人力资源删除
	public void Delete(String human_id) {
		humman_fileDao.Delete(human_id);
	}
	public int selnumz() {
		return gdao.selnumz();
	}
	public int shifa() {
		return gdao.shifa();
	}
	public int zong() {
		return gdao.zong();
	}













}
