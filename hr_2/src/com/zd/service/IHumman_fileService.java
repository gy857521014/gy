package com.zd.service;

import java.util.List;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Humman_file;

/**
 * ������Դ����Service
 * @author ������
 *
 */
public interface IHumman_fileService {

	//��������
		//һ��������ѯ
	public List<Config_file_first_kind> selcffk();
	
	public int selnumz();
	
	public int shifa();
	
	public int zong();
}
