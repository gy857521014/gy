package com.zd.dao;
/**
 * �����ֶ�dao
 * @author ������
 *
 */

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.Config_public_char;

public interface IConfig_public_charDao {

	//��ѯ����
	@Select("select * from config_public_char WHERE attribute_kind ='����'")
	@ResultMap("Config_public_char")
	public List<Config_public_char> listguoji();
	//��ѯ����
	@Select("select * from config_public_char WHERE attribute_kind ='����'")
	@ResultMap("Config_public_char")
	public List<Config_public_char> listmingzu();
	//��ѯ�ڽ�����
	@Select("select * from config_public_char WHERE attribute_kind ='�ڽ�����'")
	@ResultMap("Config_public_char")
	public List<Config_public_char> listzongjiao();
	//��ѯ������ò
	@Select("select * from config_public_char WHERE attribute_kind ='������ò'")
	@ResultMap("Config_public_char")
	public List<Config_public_char> listzhengzhi();
	//��ѯѧ��
	@Select("select * from config_public_char WHERE attribute_kind ='ѧ��'")
	@ResultMap("Config_public_char")
	public List<Config_public_char> listxueli();
	//��ѯ��������
	@Select("select * from config_public_char WHERE attribute_kind ='��������'")
	@ResultMap("Config_public_char")
	public List<Config_public_char> listjiaoyu();
	//��ѯѧ��רҵ
	@Select("select * from config_public_char WHERE attribute_kind ='ѧ��רҵ'")
	@ResultMap("Config_public_char")
	public List<Config_public_char> listzhuanye();
	//��ѯ�س�
	@Select("select * from config_public_char WHERE attribute_kind ='�س�'")
	@ResultMap("Config_public_char")
	public List<Config_public_char> listtechang();
	//��ѯ����
	@Select("select * from config_public_char WHERE attribute_kind ='����'")
	@ResultMap("Config_public_char")
	public List<Config_public_char> listaihao();
	//��ѯ��Ƹ����
	@Select("select * from config_public_char WHERE attribute_kind ='��Ƹ����'")
	@ResultMap("Config_public_char")
	public List<Config_public_char> listzhaopin();
	//��ѯְ��
	@Select("select * from config_public_char WHERE attribute_kind ='ְ��'")
	@ResultMap("Config_public_char")
	public List<Config_public_char> listzhicheng();

}
