package com.zd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zd.entity.Compensation_item;
import com.zd.entity.Config_public_char;
import com.zd.entity.Salary_standard;
import com.zd.service.ISalary_standardService;

@Controller
public class Salary_standardController {
	
	@Autowired
	private ISalary_standardService Salary_standardService;
	
	//薪酬标准登记页面获取时间搓和项目名称
	@RequestMapping("page/tosalarystandard_register")
	public String tosalarystandard_register(Map map) {
		long sytime = System.currentTimeMillis();
		map.put("sytime", sytime);
		List<Config_public_char> xm = Salary_standardService.selConfig_public_char();
		map.put("xm", xm);
		return "page/salaryCriterion/salarystandard_register";
	}
	
	//薪酬标准登记页面登记
	@RequestMapping("page/addSalary_standard")
	public String addSalary_standard(Salary_standard ss,@RequestParam Map map) {
		Salary_standardService.addSalary_standard(ss);
		Map moneyMap = new HashMap<>();
		String  Standard_id = ss.getStandard_id();
		Set<String> keySet = map.keySet();
		for(String key:keySet) {
			if(key.startsWith("x_")) {
				int pbc_id = Integer.parseInt(key.split("_")[1]);
				double money = Double.parseDouble((String) map.get(key));
				moneyMap.put("pbc_id", pbc_id);
				moneyMap.put("money", money);
				moneyMap.put("standard_id",Standard_id);
				Salary_standardService.addCompensation_item(moneyMap);
			}
			
		}
		
		return "/page/salaryCriterion/salarystandard_register_success";
	}
	
	
	
	
}
