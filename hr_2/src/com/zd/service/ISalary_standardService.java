package com.zd.service;

import java.util.List;
import java.util.Map;

import com.zd.entity.Config_public_char;
import com.zd.entity.Salary_standard;

public interface ISalary_standardService {
	
	//��ѯ��������н����Ŀ
	public List< Config_public_char> selConfig_public_char();
	//н���׼�Ǽ�
	public void addSalary_standard(Salary_standard ss);
	//�Ǽ�н���׼н����Ŀ
	public void addCompensation_item(Map map);
	//н���׼�ǼǸ���ҳ����
	public int selSalary_standardli();
	//н���׼�ǼǸ���ҳ���ѯ*****
	public List<Salary_standard> selSalary_standard(int start);
}
