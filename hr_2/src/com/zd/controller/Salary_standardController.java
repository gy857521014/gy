package com.zd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zd.entity.Compensation_item;
import com.zd.entity.Config_public_char;
import com.zd.entity.Salary_standard;
import com.zd.entity.Salary_standard_details;
import com.zd.service.ISalary_standardService;

@Controller
public class Salary_standardController {

	@Autowired
	private ISalary_standardService Salary_standardService;

	// 薪酬标准登记页面获取时间搓和项目名称
	@RequestMapping("page/tosalarystandard_register")
	public String tosalarystandard_register(Map map, HttpSession session) {
		long sytime = System.currentTimeMillis();
		map.put("sytime", sytime);
		List<Config_public_char> xm = Salary_standardService.selConfig_public_char();
		map.put("xm", xm);
		map.put("xmsize", xm.size());
		return "page/salaryCriterion/salarystandard_register";
	}

	// 薪酬标准登记页面登记
	@RequestMapping("page/addSalary_standard")
	public String addSalary_standard(Salary_standard ss, @RequestParam Map map) {
		Logger logger = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			Salary_standardService.addSalary_standard(ss);
			Map moneyMap = new HashMap<>();
			String Standard_id = ss.getStandard_id();
			Set<String> keySet = map.keySet();
			for (String key : keySet) {
				if (key.startsWith("x_")) {
					String attribute_name = key.split("_")[2];
					int pbc_id = Integer.parseInt(key.split("_")[1]);
					double money = Double.parseDouble((String) map.get(key));
					moneyMap.put("pbc_id", pbc_id);
					moneyMap.put("money", money);
					moneyMap.put("standard_id", Standard_id);
					moneyMap.put("attribute_name", attribute_name);
					Salary_standardService.addCompensation_item(moneyMap);
				}

			}
		} catch (Exception e) {
			logger.error("薪资标准登记错误", e);
		}
		return "/page/salaryCriterion/salarystandard_register_success";
	}

	// 薪酬标准登记复核首页
	@RequestMapping("page/tosalarystandard_check_list")
	public String tosalarystandard_check_list(Map map, int start) {
		Logger logger = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			int total = 0;
			int li = Salary_standardService.selSalary_standardli();
			map.put("li", li);
			if (li % 10 == 0) {
				total = li / 10;
				// 总条数 / 每页显示的条数
				map.put("total", total);
			} else {
				total = li / 10 + 1;
				// 总条数 / 每页显示的条数+1
				map.put("total", total);
			}
			if (li == 0) {
				map.put("starttrue", 0);
			} else {
				map.put("starttrue", start + 1);
				map.put("start", start);
				List<Salary_standard> ss = Salary_standardService.selSalary_standard(start * 10);
				map.put("ss", ss);
			}
		} catch (Exception e) {
			logger.error("薪酬标准登记复核首页错误", e);
		}

		return "/page/salaryCriterion/salarystandard_check_list";
	}

	// 跳转至复核页面
	@RequestMapping("page/tosalarystandard_check")
	public String tosalarystandard_check(Map map, String standard_id) {
		Logger logger = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			Salary_standard ssd = Salary_standardService.selOneSalary_standard(standard_id);
			map.put("ssd", ssd);
			List<Compensation_item> ci = Salary_standardService.selCompensation_item(standard_id);
			map.put("ci", ci);
			map.put("cisize", ci.size());
		} catch (Exception e) {
			logger.error("跳转至复核页面错误", e);
		}

		return "page/salaryCriterion/salarystandard_check";
	}

	// 修改并添加薪酬标准到薪酬标准单详细信息
	@RequestMapping("page/tosalarystandard_check_success")
	public String tosalarystandard_check_success(Salary_standard ss, @RequestParam Map map) {
		Logger logger = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			Salary_standardService.updSalary_standard(ss);
			Map moneyMap = new HashMap<>();
			Map ssdMap = new HashMap<>();
			String Standard_id = ss.getStandard_id();
			String standard_name = ss.getStandard_name();
			Set<String> keySet = map.keySet();
			for (String key : keySet) {
				if (key.startsWith("x_")) {
					String attribute_name = key.split("_")[2];
					int pbc_id = Integer.parseInt(key.split("_")[1]);
					double money = Double.parseDouble((String) map.get(key));
					moneyMap.put("pbc_id", pbc_id);
					moneyMap.put("money", money);
					moneyMap.put("standard_id", Standard_id);
					moneyMap.put("item_name", attribute_name);
					Salary_standardService.updcompensation_item(moneyMap);
					ssdMap.put("standard_id", Standard_id);
					ssdMap.put("standard_name", standard_name);
					ssdMap.put("item_id", pbc_id);
					ssdMap.put("item_name", attribute_name);
					ssdMap.put("salary", money);
					// 判断详情表里是否有该编号的数据
					if (Salary_standardService.sonedelSalary_standard_details(ssdMap) != null) {
						// 有数据对数据进行修改
						Salary_standardService.updSalary_standard_details(ssdMap);
					} else {
						// 没有数据对数据进行添加
						Salary_standardService.addSalary_standard_details(ssdMap);
					}

				}
			}
		} catch (Exception e) {
			logger.error("修改并添加薪酬标准到薪酬标准单详细信息错误", e);
		}

		return "page/salaryCriterion/salarystandard_check_success";
	}

	// 跳转到薪酬标准查询界面
	@RequestMapping("page/tosalarystandard_query_locate")
	public String tosalarystandard_query_locate() {
		return "page/salaryCriterion/salarystandard_query_locate";

	}

	// 薪酬标准模糊查询（分页）
	@RequestMapping("page/selLikeSalary_standardsy")
	public String selLikeSalary_standardsy(@RequestParam Map map, Map smp, Map startmap) {
		Logger logger = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			int total = 0;
			smp.put("startDate", map.get("startDate"));
			smp.put("endDate", map.get("endDate"));
			smp.put("standard_id", map.get("standard_id"));
			smp.put("Keyword", map.get("Keyword"));
			smp.put("start", map.get("start"));
			String startStr = (String) map.get("start");
			int startInt = Integer.parseInt(startStr);// 参与查询页数
			map.put("start", startInt * 10);
			int li = Salary_standardService.selLikeSalary_standardli(map);
			if (li % 10 == 0) {
				total = li / 10;
				// 总条数 / 每页显示的条数
				smp.put("total", total);
			} else {
				total = li / 10 + 1;
				// 总条数 / 每页显示的条数+1
				smp.put("total", total);
			}
			smp.put("li", li);
			if (li == 0) {
				map.put("starttrue", 0);
			} else {
				startmap.put("starttrue", startInt + 1);// 实际页数
				List<Salary_standard> ss = Salary_standardService.selLikeSalary_standard(map);
				smp.put("ss", ss);
			}
		} catch (Exception e) {
			logger.error("薪酬标准模糊查询（分页）错误", e);
		}

		return "page/salaryCriterion/salarystandard_query_list";
	}

	// 单击薪酬标准编号
	@RequestMapping("page/selsalarystandard_query")
	public String selsalarystandard_query(Map map, String standardid, @RequestParam Map fmap) {
		Logger logger = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			if (standardid != null && standardid.endsWith(",")) {
				standardid = standardid.substring(0, standardid.indexOf(","));
			}
			if (standardid != null && standardid.contains(",") && !standardid.endsWith(",")) {
				standardid = standardid.substring(0, standardid.indexOf(","));
			}
			Salary_standard ssd = Salary_standardService.selOneSalary_standard(standardid);
			map.put("ssd", ssd);
			List<Compensation_item> ci = Salary_standardService.selCompensation_item(standardid);
			map.put("ci", ci);
			map.put("cisize", ci.size());
			map.put("Keyword", fmap.get("Keyword"));
			map.put("startDate", fmap.get("startDate"));
			map.put("endDate", fmap.get("endDate"));
			map.put("standard_id", fmap.get("standard_id"));
			map.put("start", fmap.get("start"));
		} catch (Exception e) {
			logger.error("单击薪酬标准编号错误", e);
		}

		return "page/salaryCriterion/salarystandard_query";
	}

	// 薪酬标准变更(查询界面)
	@RequestMapping("page/tosalarystandard_change_locate")
	public String tosalarystandard_change_locate() {
		return "page/salaryCriterion/salarystandard_change_locate";
	}

	// 薪酬标准变更查询(模糊查询)
	@RequestMapping("page/selsalarystandard_change_list")
	public String selsalarystandard_change_list(@RequestParam Map map, Map smp, Map startmap) {
		Logger logger = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			int total = 0;
			smp.put("startDate", map.get("startDate"));
			smp.put("endDate", map.get("endDate"));
			smp.put("standard_id", map.get("standard_id"));
			smp.put("Keyword", map.get("Keyword"));
			smp.put("start", map.get("start"));
			String startStr = (String) map.get("start");
			int startInt = Integer.parseInt(startStr);// 参与查询页数
			map.put("start", startInt * 10);
			int li = Salary_standardService.selLikeSalary_standardli(map);
			if (li % 10 == 0) {
				total = li / 10;
				// 总条数 / 每页显示的条数
				smp.put("total", total);
			} else {
				total = li / 10 + 1;
				// 总条数 / 每页显示的条数+1
				smp.put("total", total);
			}
			smp.put("li", li);
			if (li == 0) {
				map.put("starttrue", 0);
			} else {
				startmap.put("starttrue", startInt + 1);// 实际页数
				List<Salary_standard> ss = Salary_standardService.selLikeSalary_standard(map);
				smp.put("ss", ss);
			}
		} catch (Exception e) {
			logger.error("薪酬标准变更查询(模糊查询)错误", e);
		}

		return "page/salaryCriterion/salarystandard_change_list";
	}

	// 变更按钮
	@RequestMapping("page/selsalarystandard_change")
	public String selsalarystandard_change(Map map, String standardid, @RequestParam Map fmap) {
		Logger logger = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			if (standardid != null && standardid.endsWith(",")) {
				standardid = standardid.substring(0, standardid.indexOf(","));
			}
			if (standardid != null && standardid.contains(",") && !standardid.endsWith(",")) {
				standardid = standardid.substring(0, standardid.indexOf(","));
			}
			Salary_standard ssd = Salary_standardService.selOneSalary_standard(standardid);
			map.put("ssd", ssd);
			List<Compensation_item> ci = Salary_standardService.selCompensation_item(standardid);
			map.put("ci", ci);
			map.put("cisize", ci.size());
			map.put("Keyword", fmap.get("Keyword"));
			map.put("startDate", fmap.get("startDate"));
			map.put("endDate", fmap.get("endDate"));
			map.put("standard_id", fmap.get("standard_id"));
			map.put("start", fmap.get("start"));
		} catch (Exception e) {
			logger.error("变更按钮错误", e);
		}

		return "page/salaryCriterion/salarystandard_change";
	}

	// 变更修改
	@RequestMapping("page/updsalarystandard_change_success")
	public String updsalarystandard_change_success(Salary_standard ss, @RequestParam Map map, Map fmap) {
		Logger logger = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			fmap.put("Keyword", map.get("Keyword"));
			fmap.put("startDate", map.get("startDate"));
			fmap.put("endDate", map.get("endDate"));
			fmap.put("standard_id", map.get("standardid"));
			fmap.put("start", map.get("start"));

			Salary_standardService.updSalary_standardbg(ss);
			Map moneyMap = new HashMap<>();
			Map ssdMap = new HashMap<>();
			String Standard_id = ss.getStandard_id();
			String standard_name = ss.getStandard_name();
			Set<String> keySet = map.keySet();
			for (String key : keySet) {
				if (key.startsWith("x_")) {
					String attribute_name = key.split("_")[2];
					int pbc_id = Integer.parseInt(key.split("_")[1]);
					double money = Double.parseDouble((String) map.get(key));
					moneyMap.put("pbc_id", pbc_id);
					moneyMap.put("money", money);
					moneyMap.put("standard_id", Standard_id);
					// moneyMap.put("item_name", attribute_name);
					Salary_standardService.updcompensation_itembg(moneyMap);
					/*
					 * ssdMap.put("standard_id", Standard_id);
					 * ssdMap.put("standard_name",standard_name); ssdMap.put("item_id", pbc_id);
					 * //ssdMap.put("item_name", attribute_name); ssdMap.put("salary", money);
					 * Salary_standardService.updSalary_standard_details(ssdMap);
					 */
				}
			}
		} catch (Exception e) {
			logger.error("变更修改错误", e);
		}

		return "page/salaryCriterion/salarystandard_change_success";

	}
}
