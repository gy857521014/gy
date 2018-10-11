package com.zd.controller;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;
import com.zd.entity.Config_major;
import com.zd.entity.Config_major_kind;
import com.zd.entity.Config_public_char;
import com.zd.entity.Humman_file;
import com.zd.entity.Salary_standard;
import com.zd.entity.Salary_standard_details;
import com.zd.service.IConfig_file_first_kindService;
import com.zd.service.IConfig_file_second_kindService;
import com.zd.service.IConfig_file_third_kindService;
import com.zd.service.IConfig_majorService;
import com.zd.service.IConfig_major_kindService;
import com.zd.service.IHumman_fileService;

/**
 * 人力资源管理Controller
 * @author 周泽旭
 *
 */
@Controller
public class Humman_fileController {
	//人力资源管理公共字段
	@Autowired
	private IHumman_fileService humman_fileService;
	//职位分类
	@Autowired
	private IConfig_major_kindService config_major_kindService;
	//职位设置
	@Autowired
	private IConfig_majorService majorservice;
	//根据一级机构编号查询一级机构名字
	@Autowired
	private IConfig_file_first_kindService config_file_first_kindService;
	//根据一级机构编号查询二级机构
	@Autowired
	private IConfig_file_second_kindService config_file_second_kindService;
	//根据二级机构编号查询三级机构
	@Autowired
	private IConfig_file_third_kindService config_file_third_kindService;
	
	//人力资源登记
		//机构三级联动
		//查询一级机构
		@RequestMapping("page/human_register")
		public String human_register(Map<String, Object> map){
			//一级机构所有
			List<Config_file_first_kind> FirstList = humman_fileService.selcffk();
			map.put("FirstList", FirstList);
			//职位分类查询
			List<Config_major_kind> fenleilist = config_major_kindService.selconfigmajor();
			map.put("fenleilist", fenleilist);
			//生成档案编号
			long sytime = System.currentTimeMillis();
			map.put("sytime", sytime);
			//查询国籍
			List<Config_public_char> listguoji = humman_fileService.listguoji();
			map.put("listguoji", listguoji);
			//查询民族
			List<Config_public_char> listmingzu = humman_fileService.listmingzu();
			map.put("listmingzu", listmingzu);
			//查询宗教信仰
			List<Config_public_char> listzongjiao = humman_fileService.listzongjiao();
			map.put("listzongjiao",listzongjiao);
			//查询政治面貌
			List<Config_public_char> listzhengzhi = humman_fileService.listzhengzhi();
			map.put("listzhengzhi", listzhengzhi);
			//查询学历
			List<Config_public_char> listxueli = humman_fileService.listxueli();
			map.put("listxueli", listxueli);
			//查询教育年限
			List<Config_public_char> listjiaoyu = humman_fileService.listjiaoyu();
			map.put("listjiaoyu", listjiaoyu);
			//查询学历专业
			List<Config_public_char> listzhuanye = humman_fileService.listzhuanye();
			map.put("listzhuanye", listzhuanye);
			//查询特长
			List<Config_public_char> listtechang = humman_fileService.listtechang();
			map.put("listtechang", listtechang);
			//查询爱好
			List<Config_public_char> listaihao = humman_fileService.listaihao();
			map.put("listaihao", listaihao);
			//查询职称
			List<Config_public_char> listzhicheng = humman_fileService.listzhicheng();
			map.put("listzhicheng", listzhicheng);
			//查询薪酬标准
			List<Salary_standard_details> listxinchou = humman_fileService.xinchoulist();
			map.put("listxinchou", listxinchou);
			return "page/humanResources/human_register";
		}
		//根据一级机构编号查询二级机构
			@RequestMapping("/page/selerji")
			@ResponseBody
			public List<Config_file_second_kind> selerji(String fsk_id){
				List<Config_file_second_kind> erjilist = 
						config_file_second_kindService.selerji(fsk_id);
				return erjilist;
			}
			//根据二级机构编号查询三级机构
			@RequestMapping("/page/selsanji")
			@ResponseBody
			public List<Config_file_third_kind> sanji(String fsk_id){
				List<Config_file_third_kind> sanjilist = 
						config_file_third_kindService.selsanji(fsk_id);
				return sanjilist;
			}
		//1.1职位设置联动
		@RequestMapping("/page/selectzhiwei")
		@ResponseBody
		public List<Config_major> selectzhiwei(String majorid) {
			List<Config_major> majorlist=majorservice.selzhiwei(majorid);
			return majorlist;
		}
		//添加
		@RequestMapping("/page/add")
		public String add(Humman_file humman_file,HttpServletRequest request,
				String first_king_id,String second_kind_id,String third_kind_id,String human_major_kind_id,String human_major_id,
				String salary_standard_id,String human_id,Map map) {
			// 单独获取生日
			String birthday =  request.getParameter("humanFile.humanBirthday");
			humman_file.setHuman_birthday(birthday);
			//根据一级机构编号查询一级机构名字
			Config_file_first_kind config_file_first_kind = 
					config_file_first_kindService.selcffkid(first_king_id);
			humman_file.setFirst_king_name(config_file_first_kind.getFirst_kind_name());
			//根据二级机构编号查询二级机构名字
			Config_file_second_kind config_file_second_kind =
					config_file_second_kindService.selerjiid(second_kind_id);
			humman_file.setSecond_kind_name(config_file_second_kind.getSecond_kind_name());
			//根据三级机构编号查询三级机构名字
			Config_file_third_kind config_file_third_kind = 
					config_file_third_kindService.selsanjiid(third_kind_id);
			humman_file.setThird_kind_name(config_file_third_kind.getThird_kind_name());
			//根据分类id查询名称
			Config_major_kind config_major_kind =
					config_major_kindService.selmajorkindid(human_major_kind_id);
			humman_file.setHuman_major_kind_name(config_major_kind.getMajor_kind_name());
			/*//根据id查询职位
			Config_major config_major = majorservice.selzhiweiid(human_major_id);
			humman_file.setHunma_major_name(config_major.getMajor_name());*/
			//根据薪酬编号查询薪酬标准name
			Salary_standard salary_standard = humman_fileService.xinchouid(salary_standard_id);
			//添加name属性
			humman_file.setSalary_standard_name(salary_standard.getStandard_name());
			//添加基本薪酬总额
			humman_file.setSalary_sum(salary_standard.getSalary_sum());
			//添加应发薪酬总额
			humman_file.setDemand_salaray_sum(salary_standard.getSalary_sum());
			humman_fileService.add(humman_file);
			//获取档案编号
			map.put("hf", human_id);
			return "page/humanResources/register_choose_picture";
		}
		//上传图片
		@RequestMapping("page/updsuccess")
		public String upload(MultipartFile file1,HttpSession session,String hf){
			// 获取上传文件的文件名
			String fname = file1.getOriginalFilename();
			// 获取到要上传到文件的路径
			// 1、获取upload文件夹在web项目中的真实路径
			String dir = "/usr/file_upload";
//				session.getServletContext().getRealPath("/usr/file_upload");
			// 2、获取上传到文件的的路径
			String fnewname = fname.replace(".", System.currentTimeMillis()+".");
			String fpath = dir +"/" +fnewname;
			System.currentTimeMillis();// 2.jpg 时间.
			// 创建要上传到的文件对象
			File file = new File(fpath);
			try {
				// 做上传
				file1.transferTo(file);
				// 将上传数据保存在表中
				Map map = new HashMap<>();
				map.put("human_id", hf);
				map.put("fnewname", fnewname);
				humman_fileService.uploadUpdate(map);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			return "page/humanResources/success";
		}
		//人力资源档案复核
			//查询人力资源档案
			@RequestMapping("page/check_list")
			public String check_list(Map<String, Object> map) {
				List<Humman_file> humman_fileslist = 
							humman_fileService.Humman_fileList();
				map.put("humman_fileslist", humman_fileslist);
				map.put("humman_fileslist_size", humman_fileslist.size());
				return "page/humanResources/check_list";
			}
			//查询根据人力资源表查询单条数据
			@RequestMapping("page/human_check")
			public String human_check(String human_id,Map<String, Object> map){
				Humman_file humman_file = 
						humman_fileService.human_check(human_id);
				map.put("humman_file", humman_file);
				//查询国籍
				List<Config_public_char> listguoji = humman_fileService.listguoji();
				map.put("listguoji", listguoji);
				//查询民族
				List<Config_public_char> listmingzu = humman_fileService.listmingzu();
				map.put("listmingzu", listmingzu);
				//查询宗教信仰
				List<Config_public_char> listzongjiao = humman_fileService.listzongjiao();
				map.put("listzongjiao",listzongjiao);
				//查询政治面貌
				List<Config_public_char> listzhengzhi = humman_fileService.listzhengzhi();
				map.put("listzhengzhi", listzhengzhi);
				//查询学历
				List<Config_public_char> listxueli = humman_fileService.listxueli();
				map.put("listxueli", listxueli);
				//查询教育年限
				List<Config_public_char> listjiaoyu = humman_fileService.listjiaoyu();
				map.put("listjiaoyu", listjiaoyu);
				//查询学历专业
				List<Config_public_char> listzhuanye = humman_fileService.listzhuanye();
				map.put("listzhuanye", listzhuanye);
				//查询特长
				List<Config_public_char> listtechang = humman_fileService.listtechang();
				map.put("listtechang", listtechang);
				//查询爱好
				List<Config_public_char> listaihao = humman_fileService.listaihao();
				map.put("listaihao", listaihao);
				//查询职称
				List<Config_public_char> listzhicheng = humman_fileService.listzhicheng();
				map.put("listzhicheng", listzhicheng);
				//查询薪酬标准
				List<Salary_standard_details> listxinchou = humman_fileService.xinchoulist();
				map.put("listxinchou", listxinchou);
				return "page/humanResources/human_check";
			}
			//修改
			@RequestMapping("page/humman_chack_update")
			public String humman_chack_update(Humman_file humman_file,String salary_standard_id,HttpServletRequest request) {
				//获取生日
				String birthday = request.getParameter("humanFile.humanBirthday");
				humman_file.setHuman_birthday(birthday);
				//根据薪酬编号查询薪酬标准name
				Salary_standard salary_standard = humman_fileService.xinchouid(salary_standard_id);
				//添加name属性
				humman_file.setSalary_standard_name(salary_standard.getStandard_name());
				//添加基本薪酬总额
				humman_file.setSalary_sum(salary_standard.getSalary_sum());
				//添加应发薪酬总额
				humman_file.setDemand_salaray_sum(salary_standard.getSalary_sum());
				humman_fileService.humman_chack_update(humman_file);
				return "redirect:check_list";
			}
		
			
	//人力资源档案管理
	@RequestMapping("page/query_locate")
	public String query_locate(Map<String, Object> map) {
		//一级机构所有
		List<Config_file_first_kind> FirstList = humman_fileService.selcffk();
		map.put("FirstList", FirstList);
		//职位分类查询所有
		List<Config_major_kind> fenleilist = config_major_kindService.selconfigmajor();
		map.put("fenleilist", fenleilist);
		return "page/humanResources/query_locate";
	}
	//根据一级机构编号查询二级机构
	@RequestMapping("/page/selerji1")
	@ResponseBody
	public List<Config_file_second_kind> selerji1(String fsk_id){
		List<Config_file_second_kind> erjilist = 
				config_file_second_kindService.selerji(fsk_id);
		return erjilist;
	}
	//根据二级机构编号查询三级机构
	@RequestMapping("/page/selsanji1")
	@ResponseBody
	public List<Config_file_third_kind> sanji1(String fsk_id){
		List<Config_file_third_kind> sanjilist = 
				config_file_third_kindService.selsanji(fsk_id);
		return sanjilist;
	}
	//根据职位分类编号查询职位名称
	//1.1职位设置联动
	@RequestMapping("/page/selectzhiwei1")
	@ResponseBody
	public List<Config_major> selectzhiwei1(String majorid) {
		List<Config_major> majorlist=majorservice.selzhiwei(majorid);
		return majorlist;
	}
	//人力资源模糊查询跳转页面
	@RequestMapping("/page/query_keywords")
	public String query_keywords() {
		return "page/humanResources/query_keywords";
	}
	//人力资源模糊查询
	@RequestMapping("/page/query_list_key")
	public String query_list_key(@RequestParam Map map,Map map1) {
		String primarKey = (String)map.get("primarKey");
		map.put("primarKey", primarKey);
		List<Humman_file> query_list = humman_fileService.query_list_key(map);
		map1.put("query_list", query_list);
		return "page/humanResources/query_list";
	}
	//条件查询
	@RequestMapping("page/query_list")
	public String query_list(@RequestParam Map map,Map map1) throws ParseException {
		//获取起始时间
		String startDate = (String) map.get("utilBean.startDate");
		//获取结束时间
		String endDate = (String) map.get("utilBean.endDate");
		map.put("startDateStr", startDate);
		map.put("endDateStr", endDate);
		
		List<Humman_file> query_list = humman_fileService.query_list(map);
		map1.put("query_list", query_list);
		map1.put("query_list_size", query_list.size());
		return "page/humanResources/query_list";
	}
	
	//根据档案编号查询单条
	@RequestMapping("page/query_list_information")
	public String query_list_information(String human_id,Map<String, Object> map) {
		Humman_file humman_file =  humman_fileService.human_check(human_id);
		map.put("humman_file", humman_file);
		return "page/humanResources/query_list_information";
	}
	//人力资源档案变更
	@RequestMapping("page/change_locate")
	public String change_locate(Map<String, Object> map) {
		//一级机构所有
		List<Config_file_first_kind> FirstList = humman_fileService.selcffk();
		map.put("FirstList", FirstList);
		//职位分类查询所有
		List<Config_major_kind> fenleilist = config_major_kindService.selconfigmajor();
		map.put("fenleilist", fenleilist);
		return "page/humanResources/change_locate";
	}
		
	//条件查询人力资源变更
		@RequestMapping("page/change_list")
		public String change_list(@RequestParam Map map,Map map1) throws ParseException {
			//获取起始时间
			String startDate = (String) map.get("utilBean.startDate");
			//获取结束时间
			String endDate = (String) map.get("utilBean.endDate");
			map.put("startDateStr", startDate);
			map.put("endDateStr", endDate);
			
			List<Humman_file> query_list = humman_fileService.query_list(map);
			map1.put("query_list", query_list);
			map1.put("query_list_size", query_list.size());
			return "page/humanResources/change_list";
		}
		//根据档案编号查询单条人力资源变更
		@RequestMapping("page/change_list_information")
		public String change_list_information(String human_id,Map<String, Object> map) {
			Humman_file humman_file =  humman_fileService.human_check(human_id);
			map.put("humman_file", humman_file);
			//查询国籍
			List<Config_public_char> listguoji = humman_fileService.listguoji();
			map.put("listguoji", listguoji);
			//查询民族
			List<Config_public_char> listmingzu = humman_fileService.listmingzu();
			map.put("listmingzu", listmingzu);
			//查询宗教信仰
			List<Config_public_char> listzongjiao = humman_fileService.listzongjiao();
			map.put("listzongjiao",listzongjiao);
			//查询政治面貌
			List<Config_public_char> listzhengzhi = humman_fileService.listzhengzhi();
			map.put("listzhengzhi", listzhengzhi);
			//查询学历
			List<Config_public_char> listxueli = humman_fileService.listxueli();
			map.put("listxueli", listxueli);
			//查询教育年限
			List<Config_public_char> listjiaoyu = humman_fileService.listjiaoyu();
			map.put("listjiaoyu", listjiaoyu);
			//查询学历专业
			List<Config_public_char> listzhuanye = humman_fileService.listzhuanye();
			map.put("listzhuanye", listzhuanye);
			//查询特长
			List<Config_public_char> listtechang = humman_fileService.listtechang();
			map.put("listtechang", listtechang);
			//查询爱好
			List<Config_public_char> listaihao = humman_fileService.listaihao();
			map.put("listaihao", listaihao);
			//查询职称
			List<Config_public_char> listzhicheng = humman_fileService.listzhicheng();
			map.put("listzhicheng", listzhicheng);
			//查询薪酬标准
			List<Salary_standard_details> listxinchou = humman_fileService.xinchoulist();
			map.put("listxinchou", listxinchou);
			return "page/humanResources/change_list_information";
		}
		//人力资源变更修改
		@RequestMapping("page/register_choose_picture_update")
		public String register_choose_picture_update(Humman_file humman_file,HttpServletRequest request,String salary_standard_id) {
			//获取生日
			String birthday = request.getParameter("humanFile.humanBirthday");
			humman_file.setHuman_birthday(birthday);
			//根据薪酬编号查询薪酬标准name
			Salary_standard salary_standard = humman_fileService.xinchouid(salary_standard_id);
			//添加name属性
			humman_file.setSalary_standard_name(salary_standard.getStandard_name());
			//添加基本薪酬总额
			humman_file.setSalary_sum(salary_standard.getSalary_sum());
			//添加应发薪酬总额
			humman_file.setDemand_salaray_sum(salary_standard.getSalary_sum());
			humman_fileService.register_choose_picture_update(humman_file);
			return "redirect:change_locate";
		}
				//人力资源档案删除
				@RequestMapping("page/delete_locate")
				public String delete_locate(Map<String, Object> map) {
					//一级机构所有
					List<Config_file_first_kind> FirstList = humman_fileService.selcffk();
					map.put("FirstList", FirstList);
					//职位分类查询所有
					List<Config_major_kind> fenleilist = config_major_kindService.selconfigmajor();
					map.put("fenleilist", fenleilist);
					return "page/humanResources/delete_locate";
				}
				//模糊查询人力资源删除（跳转页面）
				@RequestMapping("page/delete_keywords")
				public String delete_keywords() {
					return "page/humanResources/delete_keywords";
				}
				//模糊查询人力资源删除
				@RequestMapping("page/delete_list_key")
				public String delete_list_key(@RequestParam Map map,Map map1) {
					String primarKey = (String)map.get("primarKey");
					map.put("primarKey", primarKey);
					List<Humman_file> query_list = humman_fileService.delete_list_key(map);
					map1.put("query_list", query_list);
					return "page/humanResources/delete_list";
				}
				//条件查询人力资源删除
				@RequestMapping("page/delete_list")
				public String delete_list(@RequestParam Map map,Map map1) throws ParseException {
					//获取起始时间
					String startDate = (String) map.get("utilBean.startDate");
					//获取结束时间
					String endDate = (String) map.get("utilBean.endDate");
					map.put("startDateStr", startDate);
					map.put("endDateStr", endDate);
					
					List<Humman_file> query_list = humman_fileService.delete_list(map);
					map1.put("query_list", query_list);
					map1.put("query_list_size", query_list.size());
					return "page/humanResources/delete_list";
				}
				
				//根据档案编号查询单条人力资源删除
				@RequestMapping("page/delete_list_information")
				public String delete_list_information(String human_id,Map<String, Object> map) {
					Humman_file humman_file =  humman_fileService.human_check(human_id);
					map.put("humman_file", humman_file);
					//查询国籍
					List<Config_public_char> listguoji = humman_fileService.listguoji();
					map.put("listguoji", listguoji);
					//查询民族
					List<Config_public_char> listmingzu = humman_fileService.listmingzu();
					map.put("listmingzu", listmingzu);
					//查询宗教信仰
					List<Config_public_char> listzongjiao = humman_fileService.listzongjiao();
					map.put("listzongjiao",listzongjiao);
					//查询政治面貌
					List<Config_public_char> listzhengzhi = humman_fileService.listzhengzhi();
					map.put("listzhengzhi", listzhengzhi);
					//查询学历
					List<Config_public_char> listxueli = humman_fileService.listxueli();
					map.put("listxueli", listxueli);
					//查询教育年限
					List<Config_public_char> listjiaoyu = humman_fileService.listjiaoyu();
					map.put("listjiaoyu", listjiaoyu);
					//查询学历专业
					List<Config_public_char> listzhuanye = humman_fileService.listzhuanye();
					map.put("listzhuanye", listzhuanye);
					//查询特长
					List<Config_public_char> listtechang = humman_fileService.listtechang();
					map.put("listtechang", listtechang);
					//查询爱好
					List<Config_public_char> listaihao = humman_fileService.listaihao();
					map.put("listaihao", listaihao);
					//查询职称
					List<Config_public_char> listzhicheng = humman_fileService.listzhicheng();
					map.put("listzhicheng", listzhicheng);
					//查询薪酬标准
					List<Salary_standard_details> listxinchou = humman_fileService.xinchoulist();
					map.put("listxinchou", listxinchou);
					return "page/humanResources/delete_list_information";
				}
				//人力资源删除修改
				@RequestMapping("page/success_update")
				public String success_update(Humman_file humman_file) {
					humman_fileService.success_update(humman_file);
					return "page/humanResources/success";
				}
				
		//人力资源档案恢复
		@RequestMapping("page/recovery_locate")
		public String recovery_locate(Map<String, Object> map) {
			//一级机构所有
			List<Config_file_first_kind> FirstList = humman_fileService.selcffk();
			map.put("FirstList", FirstList);
			//职位分类查询所有
			List<Config_major_kind> fenleilist = config_major_kindService.selconfigmajor();
			map.put("fenleilist", fenleilist);
			return "page/humanResources/recovery_locate";
		}
		//人力资源档案恢复（跳页面）
		@RequestMapping("page/recovery_keywords")
		public String recovery_keywords() {
			return "page/humanResources/recovery_keywords";
		}
		//模糊查询人力资源恢复
		@RequestMapping("page/recovery_list_key")
		public String recovery_list_key(@RequestParam Map map,Map map1) {
			String primarKey = (String)map.get("primarKey");
			map.put("primarKey", primarKey);
			List<Humman_file> query_list = humman_fileService.recovery_list_key(map);
			map1.put("query_list", query_list);
			return "page/humanResources/recovery_list";
		}
		//人力资源档案恢复条件查询
		@RequestMapping("page/recovery_list")
		public String recovery_list(@RequestParam Map map,Map map1) throws ParseException {
			//获取起始时间
			String startDate = (String) map.get("utilBean.startDate");
			//获取结束时间
			String endDate = (String) map.get("utilBean.endDate");
			map.put("startDateStr", startDate);
			map.put("endDateStr", endDate);
			
			List<Humman_file> query_list = humman_fileService.recovery_list(map);
			map1.put("query_list", query_list);
			map1.put("query_list_size", query_list.size());
			return "page/humanResources/recovery_list";
		}
		//人力资源恢复
		@RequestMapping("page/recovery_list_information")
		public String recovery_list_information(String human_id,Map<String, Object> map) {
			Humman_file humman_file =  humman_fileService.human_check(human_id);
			map.put("humman_file", humman_file);
			//查询国籍
			List<Config_public_char> listguoji = humman_fileService.listguoji();
			map.put("listguoji", listguoji);
			//查询民族
			List<Config_public_char> listmingzu = humman_fileService.listmingzu();
			map.put("listmingzu", listmingzu);
			//查询宗教信仰
			List<Config_public_char> listzongjiao = humman_fileService.listzongjiao();
			map.put("listzongjiao",listzongjiao);
			//查询政治面貌
			List<Config_public_char> listzhengzhi = humman_fileService.listzhengzhi();
			map.put("listzhengzhi", listzhengzhi);
			//查询学历
			List<Config_public_char> listxueli = humman_fileService.listxueli();
			map.put("listxueli", listxueli);
			//查询教育年限
			List<Config_public_char> listjiaoyu = humman_fileService.listjiaoyu();
			map.put("listjiaoyu", listjiaoyu);
			//查询学历专业
			List<Config_public_char> listzhuanye = humman_fileService.listzhuanye();
			map.put("listzhuanye", listzhuanye);
			//查询特长
			List<Config_public_char> listtechang = humman_fileService.listtechang();
			map.put("listtechang", listtechang);
			//查询爱好
			List<Config_public_char> listaihao = humman_fileService.listaihao();
			map.put("listaihao", listaihao);
			//查询职称
			List<Config_public_char> listzhicheng = humman_fileService.listzhicheng();
			map.put("listzhicheng", listzhicheng);
			//查询薪酬标准
			List<Salary_standard_details> listxinchou = humman_fileService.xinchoulist();
			map.put("listxinchou", listxinchou);
			return "page/humanResources/recovery_list_information";
		}
		//人力资源删除修改
		@RequestMapping("page/success_update1")
		public String success_update1(Humman_file humman_file) {
			humman_fileService.success_update1(humman_file);
			return "page/humanResources/success";
		}
		//人力资源永久删除查询
		@RequestMapping("page/delete_forever_list")
		public String delete_forever_list(Map map) {
			List<Humman_file> humman_fileslist = humman_fileService.Humman_fileList1();
			map.put("humman_fileslist", humman_fileslist);
			map.put("humman_fileslist_size", humman_fileslist.size());
			return "page/humanResources/delete_forever_list";
		}
		//人力资源永久删除
		@RequestMapping("page/Delete")
		@ResponseBody
		public int Delete(String human_id) {
			humman_fileService.Delete(human_id);
			return 1;
		}
		
}
