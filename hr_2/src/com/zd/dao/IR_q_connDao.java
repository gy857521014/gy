package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.R_q_conn;

public interface IR_q_connDao {

	//���ݽ�ɫid��ѯȨ�޹�ϵ�����Ȩ��ֵ
	@Select("select * from r_q_conn where r_id=#{uroleid}")
	@ResultMap("r_q_connMapper")
	public List<R_q_conn> rqconnAll(int uroleid);
	
	//��ѯ��ɫȨ��
	public List<R_q_conn> queryByUid(int userid);
	
	/*@Select("")
	@ResultMap("r_q_connMapper")
	public List<R_q_conn> qByUid(int userid);*/
}
