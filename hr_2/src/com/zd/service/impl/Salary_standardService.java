package com.zd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.ISalary_standardDao;
import com.zd.entity.Compensation_item;
import com.zd.entity.Config_public_char;
import com.zd.entity.Salary_standard;
import com.zd.service.ISalary_standardService;

@Service
public class Salary_standardService implements ISalary_standardService{
	@Autowired
	private ISalary_standardDao Salary_standardDao;
	
	//��ѯ��������н����Ŀ
	public List<Config_public_char> selConfig_public_char() {
		return Salary_standardDao.selConfig_public_char();
	}
	
	//н���׼�Ǽ�
	public void addSalary_standard(Salary_standard ss) {
		Salary_standardDao.addSalary_standard(ss);
	}
	//�Ǽ�н���׼н����Ŀ
	public void addCompensation_item(Map map) {
		Salary_standardDao.addCompensation_item(map);
		
	}

	//н���׼�ǼǸ���ҳ����
	public int selSalary_standardli() {
		return Salary_standardDao.selSalary_standardli();
	}

	//н���׼�ǼǸ���ҳ���ѯ*****
	public List<Salary_standard> selSalary_standard(int start) {
		return Salary_standardDao.selSalary_standard(start);
	}

	//������ѯн���׼�Ǽ�
	public Salary_standard selOneSalary_standard(String standard_id) {
		return Salary_standardDao.selOneSalary_standard(standard_id);
	}

	//����н���Ų�ѯн����Ŀ����
	public List<Compensation_item> selCompensation_item(String standard_id) {
		return Salary_standardDao.selCompensation_item(standard_id);
	}

	//����н�����޸�н���׼
	public void updSalary_standard(Salary_standard ss) {
		Salary_standardDao.updSalary_standard(ss);
		
	}

	//������Ŀid�޸���Ŀ���
	public void updcompensation_item(Map map) {
		Salary_standardDao.updcompensation_item(map);
		
	}

	//���н���׼����ϸ��Ϣ
	public void addSalary_standard_details(Map map) {
		Salary_standardDao.addSalary_standard_details(map);
		
	}

	//н���׼ģ����ѯ
	public List<Salary_standard> selLikeSalary_standard(Map map) {
		return Salary_standardDao.selLikeSalary_standard(map);
	}

	//ģ����ѯн���׼��
	public int selLikeSalary_standardli(Map map) {
		return Salary_standardDao.selLikeSalary_standardli(map);
	}
	
	
}
