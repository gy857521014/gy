package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.Config_major_kind;
import com.zd.entity.e_mail;

public interface IE_mailDao {
	//查询所有
		@Select("select * from e_mail")
		@ResultMap("email")
		public List<e_mail>  selm();
	//删除
		@Delete("delete from e_mail where mid=#{mid}")
		public void deletem(int mid);
	//添加
		@Insert("insert into e_mail values(null,#{mhead},#{mcontent},#{mtype})")
		public void adde(e_mail e_mail);
		
		//查询单条
		@Select("select * from e_mail where mid=#{id}")
		@ResultMap("email")
		public e_mail emailselid(int id);
}
