package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.Config_file_third_kind;
import com.zd.entity.Config_major_kind;




public interface IConfig_major_kindDao {
	
		//��ѯ����ְλ����
		@Select("select * from Config_major_kind")
		@ResultMap("majorkind")
		public List<Config_major_kind> selconfigmajor();
		//���
		@Insert("insert into Config_major_kind values(null,#{major_kind_id},#{major_kind_name})")
		public void addcmk(Config_major_kind config_major_kind);
		//ɾ��
		@Delete("delete from Config_major_kind where major_kind_id=#{major_kind_id}")
		public void deletecmk(String major_kind_id);
		
	//����ְλ����id��ѯ����major_kind_id
	@Select("select * from Config_major_kind where major_kind_id=#{id}")
	@ResultMap("majorkind")
	public Config_major_kind selmajorkindid(int id);
}
