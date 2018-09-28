package com.zd.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;
import com.zd.entity.Config_major;
import com.zd.entity.Config_major_kind;
import com.zd.entity.Config_public_char;
import com.zd.entity.Humman_file;
import com.zd.entity.Salary_standard;
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
			List<Salary_standard> listxinchou = humman_fileService.xinchoulist();
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
		public List<Config_major> selectzhiwei(int majorid) {
			List<Config_major> majorlist=majorservice.selzhiwei(majorid);
			return majorlist;
		}
		//添加
		@RequestMapping("/page/add")
		public String add(Humman_file humman_file,HttpServletRequest request,
				String first_king_id,String second_kind_id,String third_kind_id,int human_major_kind_id,int human_major_id,
				String salary_standard_id) {
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
			return "redirect:check_list";
		}
		
		//人力资源档案复核
			//查询人力资源档案
			@RequestMapping("page/check_list")
			public String check_list(Map<String, Object> map) {
				List<Humman_file> humman_fileslist = 
						humman_fileService.Humman_fileList();
				map.put("humman_fileslist", humman_fileslist);
				return "page/humanResources/check_list";
			}
			////查询根据人力资源表查询单条数据
			@RequestMapping("page/human_check")
			public String human_check(String human_id,Map<String, Object> map){
				Humman_file humman_file = 
						humman_fileService.human_check(human_id);
				map.put("humman_file", humman_file);
				return "page/humanResources/human_check";
			}
	
}
