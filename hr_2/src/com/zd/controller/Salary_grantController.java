package com.zd.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;
import com.zd.entity.Config_public_char;
import com.zd.entity.Humman_file;
import com.zd.entity.Salary_grant;
import com.zd.entity.Salary_grant_details;
import com.zd.entity.Salary_standard_details;
import com.zd.entity.User;
import com.zd.service.IConfig_file_first_kindService;
import com.zd.service.IConfig_file_second_kindService;
import com.zd.service.IHumman_fileService;
import com.zd.service.ISalary_grantService;


@Controller
public class Salary_grantController {
	@Autowired
	private ISalary_grantService isg;
	@Autowired
	private IConfig_file_second_kindService fsk;
	@Autowired
	private IConfig_file_first_kindService icffkservice;
	@Autowired
	private IHumman_fileService hf;
	
	@RequestMapping("page/tolo")
	public String tolo() {
		return "page/salaryGrant/register_locate";
	}
	
	@RequestMapping("page/selnum")
	public String selnum(Map map,int num) {
		Logger log = LoggerFactory.getLogger(Salary_grantController.class);
		try {
			if(num==1) {
				List<Config_file_first_kind> arr = icffkservice.selcffk();
				map.put("arr", arr);
				//总人数
				int numz = hf.selnumz();
				//总机构
				int hsum = icffkservice.selhumnum();
				//实发工资
				int shifa = hf.shifa();
				//总薪资
				int zong = hf.zong();
				map.put("numz", numz);
				map.put("hsum", hsum);
				map.put("shifa", shifa);
				map.put("zong", zong);
				List<Map> mapList = icffkservice.tongjiByFname();
				map.put("mapList", mapList);
				return "page/salaryGrant/register_list";
			}
			if(num==2) {
				int numzz = isg.selnumzz();
				int hsumm = isg.selhumnumm();
				int shifaa = isg.shifaa();
				int zongg = isg.zongg();
				map.put("shifaa", shifaa);
				map.put("zongg", zongg);
				map.put("hsumm", hsumm);
				map.put("numzz", numzz);
				List<Map> maplist =  fsk.tongjiByFname();
				map.put("maplist", maplist);
				return "page/salaryGrant/register_list2";
			}
			if(num==3) {
				int numzzz = isg.selnumzzz();
				int hsummm = isg.selhumnummm();
				int shifaaa = isg.shifaaa();
				int zonggg = isg.zonggg();
				map.put("numzzz", numzzz);
				map.put("hsummm", hsummm);
				map.put("shifaaa", shifaaa);
				map.put("zonggg", zonggg);
				List<Map> maplist = isg.tongjiByFname();
				map.put("maplist", maplist);
				return "page/salaryGrant/register_list3";
			}
			
		} catch (Exception e) {
			log.error("错误",e);
		}
		return null;
	}
	@RequestMapping("page/toregister_commit")
	public String toregister_commit(Map map,String fname,HttpSession session) {
		User u = (User)session.getAttribute("loginUser");
		map.put("u", u);
		List<Humman_file> mmlist = isg.selhuman(fname);
		for (Humman_file humman_file : mmlist) {
			String ssid = humman_file.getSalary_standard_id();
			// 查询每个人的薪酬项目--List
			List<Salary_standard_details> list1= isg.selBySSD(ssid);
			humman_file.setSsdList(list1);
		}
		map.put("mmlist", mmlist);
		int sum = isg.selsum(fname);
		map.put("sum", sum);
		int hum = isg.selhum(fname);
		map.put("hum", hum);
		List<Config_public_char> plist = isg.selpubulic();
		map.put("plist", plist);
		Config_file_first_kind selfname = isg.selall(fname);
		map.put("fname", selfname);
		long timer = System.currentTimeMillis();
		map.put("timer", timer);
		return "page/salaryGrant/register_commit";
	}
	@RequestMapping("page/toregister_success")
	public String toregister_success(@RequestParam double salarystandardsum,@RequestParam double salarypaidsum,Salary_grant sg, @RequestParam List<String> salary_grant_id,@RequestParam List<String> human_name,@RequestParam List<String> human_id,@RequestParam List<Double> bouns_sum,@RequestParam List<Double> sale_sum,@RequestParam List<Double> deduct_sum,@RequestParam List<Double> salary_standard_sum,@RequestParam List<Double> salary_paid_sum,@RequestParam List<String> salary_standard_id) {
		Salary_grant_details sgd = new Salary_grant_details();
		//Salary_grant sg = new Salary_grant();
		for(int index = 0; index < human_name.size(); index++) {
			sgd.setSalary_grant_id(salary_grant_id.get(0));//id
			sgd.setHuman_name(human_name.get(index));// name
			sgd.setHuman_id(human_id.get(index));
			sgd.setBouns_sum(bouns_sum.get(index));
			sgd.setSale_sum(sale_sum.get(index));
			sgd.setDeduct_sum(deduct_sum.get(index));
			sgd.setSalary_standard_sum(salary_standard_sum.get(index));
			sgd.setSalary_paid_sum(salary_paid_sum.get(index));
			isg.add(sgd);
			
			sg.setSalary_grant_id(salary_grant_id.get(0));//id
			sg.setSalary_standard_id(salary_standard_id.get(index));
			sg.setSalary_standard_sum(salarystandardsum);
			sg.setSalary_paid_sum(salarypaidsum);
		}
		isg.addsg(sg);
		return "page/salaryGrant/register_success";
	}
	@RequestMapping("page/tocheck_list")
	public String tocheck_list(Map map) {
		List<Salary_grant> sglist = isg.selallsg();
		map.put("sglist", sglist);
		return "page/salaryGrant/check_list";
	}
	@RequestMapping("page/toregister_commit2")
	public String toregister_commit2(Map map,String fname,HttpSession session) {
		User u = (User)session.getAttribute("loginUser");
		map.put("u", u);
		List<Humman_file> mmlist = isg.selhuman2(fname);
		for (Humman_file humman_file : mmlist) {
			String ssid = humman_file.getSalary_standard_id();
			// 查询每个人的薪酬项目--List
			List<Salary_standard_details> list1= isg.selBySSD(ssid);
			humman_file.setSsdList(list1);
		}
		map.put("mmlist", mmlist);
		int sum = isg.selsum2(fname);
		map.put("sum", sum);
		int hum2 = isg.selhum2(fname);
		map.put("hum", hum2);
		List<Config_public_char> plist = isg.selpubulic();
		map.put("plist", plist);
		Config_file_second_kind selfname = isg.selall2(fname);
		map.put("fname", selfname);
		long timer = System.currentTimeMillis();
		map.put("timer", timer);
		return "page/salaryGrant/register_commit2";
	}
	@RequestMapping("page/toregister_commit3")
	public String toregister_commit3(Map map,String fname,HttpSession session) {
		User u = (User)session.getAttribute("loginUser");
		map.put("u", u);
		List<Humman_file> mmlist = isg.selhuman3(fname);
		for (Humman_file humman_file : mmlist) {
			String ssid = humman_file.getSalary_standard_id();
			// 查询每个人的薪酬项目--List
			List<Salary_standard_details> list1= isg.selBySSD(ssid);
			humman_file.setSsdList(list1);
		}
		map.put("mmlist", mmlist);
		int sum = isg.selsum3(fname);
		map.put("sum", sum);
		int hum2 = isg.selhum3(fname);
		map.put("hum", hum2);
		List<Config_public_char> plist = isg.selpubulic();
		map.put("plist", plist);
		Config_file_third_kind selfname = isg.selall3(fname);
		map.put("fname", selfname);
		long timer = System.currentTimeMillis();
		map.put("timer", timer);
		return "page/salaryGrant/register_commit3";
	}
	@RequestMapping("page/tocheck")
	public String tocheck(Map map,HttpSession session,String salary_grant_id) {
		User u = (User)session.getAttribute("loginUser");
		map.put("u", u);
		
		Salary_grant sg = isg.selone(salary_grant_id);
		map.put("sg", sg);
		
		/*List<Salary_grant_details> sgdlist = isg.selsgdall();
		for (Salary_grant_details salary_grant_details : sgdlist) {
			String ssid = humman_file.getSalary_standard_id();
			 查询每个人的薪酬项目--List
			List<Salary_standard_details> list1= isg.selBySSD(ssid);
			humman_file.setSsdList(list1);
		}
		map.put("sgdlist", sgdlist);*/
		
		List<Config_public_char> plist = isg.selpubulic();
		map.put("plist", plist);
		return "page/salaryGrant/check";
	}
	
}
