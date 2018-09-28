package com.zd.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zd.entity.Compensation_item;
import com.zd.entity.Config_public_char;
import com.zd.entity.Salary_standard;

public interface ISalary_standardDao {
	
	//��ѯ��������н����Ŀ
	@Select("SELECT * FROM config_public_char WHERE attribute_kind='н������'")
	public List<Config_public_char> selConfig_public_char();
	
	//�Ǽ�н���׼
	@Insert("insert into Salary_standard values(null,#{standard_id},#{standard_name},#{designer},#{register},null,null,#{regist_time},null,null,#{salary_sum},2,0,null,#{remark})")
	public void addSalary_standard(Salary_standard ss);
	//�Ǽ�н���׼н����Ŀ
	@Insert("insert into Compensation_item values(#{standard_id},#{pbc_id},#{money},#{attribute_name})")
	public void addCompensation_item(Map map);
	//н���׼�ǼǸ���ҳ����
	@Select("SELECT COUNT(*) FROM salary_standard")
	public int selSalary_standardli();
	//н���׼�ǼǸ���ҳ���ѯ*****
	public List<Salary_standard> selSalary_standard(int start);
	//������ѯн���׼�Ǽ�
	@Select("select * from salary_standard where standard_id=#{standard_id}")
	@ResultMap("Salary_standardMapper")
	public Salary_standard selOneSalary_standard(String standard_id);
	//����н���Ų�ѯн����Ŀ����
	@Select("select * from compensation_item where standard_id=#{standard_id}")
	public List<Compensation_item> selCompensation_item(String standard_id);
}
