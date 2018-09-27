package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_file_second_kind;

public interface IConfig_file_second_kindDao {
	//��ѯ����
	@Select("select * from Config_file_second_kind")
	@ResultMap("cfsk")
	public List<Config_file_second_kind>  selcfsk();
	//ɾ��
	@Delete("delete from Config_file_second_kind where fsk_id=#{fsk_id}")
	public void deletecfsk(int fsk_id);
	//���
	@Insert("insert into Config_file_second_kind values(null,#{first_kind_id},#{first_kind_name},#{second_kind_id},#{second_kind_name},#{second_salary_id},#{second_sale_id})")
	public void addcfsk(Config_file_second_kind config_file_second_kind);
	//����id��ѯ�û�
	@Select("select * from Config_file_second_kind where fsk_id=#{fsk_id}")
	@ResultMap("cfsk")
	public Config_file_second_kind  selcfskid(int fsk_id);
	//�޸��û�
	@Update("update Config_file_second_kind set second_salary_id=#{second_salary_id},second_sale_id=#{second_sale_id} where fsk_id=#{fsk_id}")
	public void updatecfsk(Config_file_second_kind config_file_second_kind);
}
