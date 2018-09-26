package com.zd.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zd.entity.Compensation_item;
import com.zd.entity.Salary_standard;
import com.zd.service.ISalary_standardService;

@Controller
public class Salary_standardController {
	
	@Autowired
	private ISalary_standardService Salary_standardService;
	
	//薪酬标准登记页面获取时间搓
	@RequestMapping("page/tosalarystandard_register")
	public String tosalarystandard_register(Map map) {
		long sytime = System.currentTimeMillis();
		map.put("sytime", sytime);
		return "page/salaryCriterion/salarystandard_register";
	}
	
	//薪酬标准登记页面登记
	@RequestMapping("page/addSalary_standard")
	public String addSalary_standard(Salary_standard ss,Compensation_item ci) {
		Salary_standardService.addSalary_standard(ss);
		ci.setStandard_id(ss.getStandard_id());
		Salary_standardService.addCompensation_item(ci);
		return "/page/salaryCriterion/salarystandard_register_success";
	}
	
	
	
	
}
