package com.zd.service;

import java.util.List;
import java.util.Map;

import com.zd.entity.Compensation_item;
import com.zd.entity.Config_public_char;
import com.zd.entity.Salary_standard;
import com.zd.entity.Salary_standard_details;

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
	//������ѯн���׼�Ǽ�
	public Salary_standard selOneSalary_standard(String standard_id);
	//����н���Ų�ѯн����Ŀ����
	public List<Compensation_item> selCompensation_item(String standard_id);
	//����н�����޸�н���׼
	public void updSalary_standard(Salary_standard ss);
	//������Ŀid�޸���Ŀ���
	public void updcompensation_item(Map map);
	//���н���׼����ϸ��Ϣ
	public void addSalary_standard_details(Map map);
	//н���׼ģ����ѯ
	public List<Salary_standard> selLikeSalary_standard(Map map);
	//ģ����ѯн���׼��
	public int selLikeSalary_standardli(Map map);
	//����н�����޸�н���׼(���)
	public void updSalary_standardbg(Salary_standard ss);
	//�޸�н���׼����ϸ��Ϣ
	public void updSalary_standard_details(Map map);
	//������Ŀid�޸���Ŀ���(���)
	public void updcompensation_itembg(Map map);
	//������ѯн���׼����ϸ��Ϣ
	public Salary_standard_details sonedelSalary_standard_details(Map map);
	
}
