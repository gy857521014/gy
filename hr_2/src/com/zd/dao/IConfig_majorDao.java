package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.Config_major;
import com.zd.entity.Config_major_kind;

public interface IConfig_majorDao {
	
	//��ѯ����ְҵ����
	@Select("select * from Config_major where major_kind_id=#{majorid}")
	@ResultMap("major")
	public List<Config_major> selzhiwei(int majorid);
	
	//����ְλid��ѯ����
	@Select("select * from Config_major where major_id=#{id}")
	@ResultMap("major")
	public Config_major selzhiweiid(int id);
	@Select("select * from Config_major")
	@ResultMap("major")
	public List<Config_major> selallzhi();
	//���
	@Insert("insert into Config_major values(null,#{major_kind_id},#{major_kind_name},#{major_id},#{major_name})")
	public void addcm(Config_major Config_major);
	//ɾ��
	@Delete("delete from Config_major where major_kind_id=#{major_kind_id}")
	public void deletecm(String major_kind_id);
}
