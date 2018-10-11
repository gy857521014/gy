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
 * ������Դ����Controller
 * @author ������
 *
 */
@Controller
public class Humman_fileController {
	//������Դ�������ֶ�
	@Autowired
	private IHumman_fileService humman_fileService;
	//ְλ����
	@Autowired
	private IConfig_major_kindService config_major_kindService;
	//ְλ����
	@Autowired
	private IConfig_majorService majorservice;
	//����һ��������Ų�ѯһ����������
	@Autowired
	private IConfig_file_first_kindService config_file_first_kindService;
	//����һ��������Ų�ѯ��������
	@Autowired
	private IConfig_file_second_kindService config_file_second_kindService;
	//���ݶ���������Ų�ѯ��������
	@Autowired
	private IConfig_file_third_kindService config_file_third_kindService;
	
	//������Դ�Ǽ�
		//������������
		//��ѯһ������
		@RequestMapping("page/human_register")
		public String human_register(Map<String, Object> map){
			//һ����������
			List<Config_file_first_kind> FirstList = humman_fileService.selcffk();
			map.put("FirstList", FirstList);
			//ְλ�����ѯ
			List<Config_major_kind> fenleilist = config_major_kindService.selconfigmajor();
			map.put("fenleilist", fenleilist);
			//���ɵ������
			long sytime = System.currentTimeMillis();
			map.put("sytime", sytime);
			//��ѯ����
			List<Config_public_char> listguoji = humman_fileService.listguoji();
			map.put("listguoji", listguoji);
			//��ѯ����
			List<Config_public_char> listmingzu = humman_fileService.listmingzu();
			map.put("listmingzu", listmingzu);
			//��ѯ�ڽ�����
			List<Config_public_char> listzongjiao = humman_fileService.listzongjiao();
			map.put("listzongjiao",listzongjiao);
			//��ѯ������ò
			List<Config_public_char> listzhengzhi = humman_fileService.listzhengzhi();
			map.put("listzhengzhi", listzhengzhi);
			//��ѯѧ��
			List<Config_public_char> listxueli = humman_fileService.listxueli();
			map.put("listxueli", listxueli);
			//��ѯ��������
			List<Config_public_char> listjiaoyu = humman_fileService.listjiaoyu();
			map.put("listjiaoyu", listjiaoyu);
			//��ѯѧ��רҵ
			List<Config_public_char> listzhuanye = humman_fileService.listzhuanye();
			map.put("listzhuanye", listzhuanye);
			//��ѯ�س�
			List<Config_public_char> listtechang = humman_fileService.listtechang();
			map.put("listtechang", listtechang);
			//��ѯ����
			List<Config_public_char> listaihao = humman_fileService.listaihao();
			map.put("listaihao", listaihao);
			//��ѯְ��
			List<Config_public_char> listzhicheng = humman_fileService.listzhicheng();
			map.put("listzhicheng", listzhicheng);
			//��ѯн���׼
			List<Salary_standard_details> listxinchou = humman_fileService.xinchoulist();
			map.put("listxinchou", listxinchou);
			return "page/humanResources/human_register";
		}
		//����һ��������Ų�ѯ��������
			@RequestMapping("/page/selerji")
			@ResponseBody
			public List<Config_file_second_kind> selerji(String fsk_id){
				List<Config_file_second_kind> erjilist = 
						config_file_second_kindService.selerji(fsk_id);
				return erjilist;
			}
			//���ݶ���������Ų�ѯ��������
			@RequestMapping("/page/selsanji")
			@ResponseBody
			public List<Config_file_third_kind> sanji(String fsk_id){
				List<Config_file_third_kind> sanjilist = 
						config_file_third_kindService.selsanji(fsk_id);
				return sanjilist;
			}
		//1.1ְλ��������
		@RequestMapping("/page/selectzhiwei")
		@ResponseBody
		public List<Config_major> selectzhiwei(String majorid) {
			List<Config_major> majorlist=majorservice.selzhiwei(majorid);
			return majorlist;
		}
		//���
		@RequestMapping("/page/add")
		public String add(Humman_file humman_file,HttpServletRequest request,
				String first_king_id,String second_kind_id,String third_kind_id,String human_major_kind_id,String human_major_id,
				String salary_standard_id,String human_id,Map map) {
			// ������ȡ����
			String birthday =  request.getParameter("humanFile.humanBirthday");
			humman_file.setHuman_birthday(birthday);
			//����һ��������Ų�ѯһ����������
			Config_file_first_kind config_file_first_kind = 
					config_file_first_kindService.selcffkid(first_king_id);
			humman_file.setFirst_king_name(config_file_first_kind.getFirst_kind_name());
			//���ݶ���������Ų�ѯ������������
			Config_file_second_kind config_file_second_kind =
					config_file_second_kindService.selerjiid(second_kind_id);
			humman_file.setSecond_kind_name(config_file_second_kind.getSecond_kind_name());
			//��������������Ų�ѯ������������
			Config_file_third_kind config_file_third_kind = 
					config_file_third_kindService.selsanjiid(third_kind_id);
			humman_file.setThird_kind_name(config_file_third_kind.getThird_kind_name());
			//���ݷ���id��ѯ����
			Config_major_kind config_major_kind =
					config_major_kindService.selmajorkindid(human_major_kind_id);
			humman_file.setHuman_major_kind_name(config_major_kind.getMajor_kind_name());
			/*//����id��ѯְλ
			Config_major config_major = majorservice.selzhiweiid(human_major_id);
			humman_file.setHunma_major_name(config_major.getMajor_name());*/
			//����н���Ų�ѯн���׼name
			Salary_standard salary_standard = humman_fileService.xinchouid(salary_standard_id);
			//���name����
			humman_file.setSalary_standard_name(salary_standard.getStandard_name());
			//��ӻ���н���ܶ�
			humman_file.setSalary_sum(salary_standard.getSalary_sum());
			//���Ӧ��н���ܶ�
			humman_file.setDemand_salaray_sum(salary_standard.getSalary_sum());
			humman_fileService.add(humman_file);
			//��ȡ�������
			map.put("hf", human_id);
			return "page/humanResources/register_choose_picture";
		}
		//�ϴ�ͼƬ
		@RequestMapping("page/updsuccess")
		public String upload(MultipartFile file1,HttpSession session,String hf){
			// ��ȡ�ϴ��ļ����ļ���
			String fname = file1.getOriginalFilename();
			// ��ȡ��Ҫ�ϴ����ļ���·��
			// 1����ȡupload�ļ�����web��Ŀ�е���ʵ·��
			String dir = "/usr/file_upload";
//				session.getServletContext().getRealPath("/usr/file_upload");
			// 2����ȡ�ϴ����ļ��ĵ�·��
			String fnewname = fname.replace(".", System.currentTimeMillis()+".");
			String fpath = dir +"/" +fnewname;
			System.currentTimeMillis();// 2.jpg ʱ��.
			// ����Ҫ�ϴ������ļ�����
			File file = new File(fpath);
			try {
				// ���ϴ�
				file1.transferTo(file);
				// ���ϴ����ݱ����ڱ���
				Map map = new HashMap<>();
				map.put("human_id", hf);
				map.put("fnewname", fnewname);
				humman_fileService.uploadUpdate(map);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			return "page/humanResources/success";
		}
		//������Դ��������
			//��ѯ������Դ����
			@RequestMapping("page/check_list")
			public String check_list(Map<String, Object> map) {
				List<Humman_file> humman_fileslist = 
							humman_fileService.Humman_fileList();
				map.put("humman_fileslist", humman_fileslist);
				map.put("humman_fileslist_size", humman_fileslist.size());
				return "page/humanResources/check_list";
			}
			//��ѯ����������Դ���ѯ��������
			@RequestMapping("page/human_check")
			public String human_check(String human_id,Map<String, Object> map){
				Humman_file humman_file = 
						humman_fileService.human_check(human_id);
				map.put("humman_file", humman_file);
				//��ѯ����
				List<Config_public_char> listguoji = humman_fileService.listguoji();
				map.put("listguoji", listguoji);
				//��ѯ����
				List<Config_public_char> listmingzu = humman_fileService.listmingzu();
				map.put("listmingzu", listmingzu);
				//��ѯ�ڽ�����
				List<Config_public_char> listzongjiao = humman_fileService.listzongjiao();
				map.put("listzongjiao",listzongjiao);
				//��ѯ������ò
				List<Config_public_char> listzhengzhi = humman_fileService.listzhengzhi();
				map.put("listzhengzhi", listzhengzhi);
				//��ѯѧ��
				List<Config_public_char> listxueli = humman_fileService.listxueli();
				map.put("listxueli", listxueli);
				//��ѯ��������
				List<Config_public_char> listjiaoyu = humman_fileService.listjiaoyu();
				map.put("listjiaoyu", listjiaoyu);
				//��ѯѧ��רҵ
				List<Config_public_char> listzhuanye = humman_fileService.listzhuanye();
				map.put("listzhuanye", listzhuanye);
				//��ѯ�س�
				List<Config_public_char> listtechang = humman_fileService.listtechang();
				map.put("listtechang", listtechang);
				//��ѯ����
				List<Config_public_char> listaihao = humman_fileService.listaihao();
				map.put("listaihao", listaihao);
				//��ѯְ��
				List<Config_public_char> listzhicheng = humman_fileService.listzhicheng();
				map.put("listzhicheng", listzhicheng);
				//��ѯн���׼
				List<Salary_standard_details> listxinchou = humman_fileService.xinchoulist();
				map.put("listxinchou", listxinchou);
				return "page/humanResources/human_check";
			}
			//�޸�
			@RequestMapping("page/humman_chack_update")
			public String humman_chack_update(Humman_file humman_file,String salary_standard_id,HttpServletRequest request) {
				//��ȡ����
				String birthday = request.getParameter("humanFile.humanBirthday");
				humman_file.setHuman_birthday(birthday);
				//����н���Ų�ѯн���׼name
				Salary_standard salary_standard = humman_fileService.xinchouid(salary_standard_id);
				//���name����
				humman_file.setSalary_standard_name(salary_standard.getStandard_name());
				//��ӻ���н���ܶ�
				humman_file.setSalary_sum(salary_standard.getSalary_sum());
				//���Ӧ��н���ܶ�
				humman_file.setDemand_salaray_sum(salary_standard.getSalary_sum());
				humman_fileService.humman_chack_update(humman_file);
				return "redirect:check_list";
			}
		
			
	//������Դ��������
	@RequestMapping("page/query_locate")
	public String query_locate(Map<String, Object> map) {
		//һ����������
		List<Config_file_first_kind> FirstList = humman_fileService.selcffk();
		map.put("FirstList", FirstList);
		//ְλ�����ѯ����
		List<Config_major_kind> fenleilist = config_major_kindService.selconfigmajor();
		map.put("fenleilist", fenleilist);
		return "page/humanResources/query_locate";
	}
	//����һ��������Ų�ѯ��������
	@RequestMapping("/page/selerji1")
	@ResponseBody
	public List<Config_file_second_kind> selerji1(String fsk_id){
		List<Config_file_second_kind> erjilist = 
				config_file_second_kindService.selerji(fsk_id);
		return erjilist;
	}
	//���ݶ���������Ų�ѯ��������
	@RequestMapping("/page/selsanji1")
	@ResponseBody
	public List<Config_file_third_kind> sanji1(String fsk_id){
		List<Config_file_third_kind> sanjilist = 
				config_file_third_kindService.selsanji(fsk_id);
		return sanjilist;
	}
	//����ְλ�����Ų�ѯְλ����
	//1.1ְλ��������
	@RequestMapping("/page/selectzhiwei1")
	@ResponseBody
	public List<Config_major> selectzhiwei1(String majorid) {
		List<Config_major> majorlist=majorservice.selzhiwei(majorid);
		return majorlist;
	}
	//������Դģ����ѯ��תҳ��
	@RequestMapping("/page/query_keywords")
	public String query_keywords() {
		return "page/humanResources/query_keywords";
	}
	//������Դģ����ѯ
	@RequestMapping("/page/query_list_key")
	public String query_list_key(@RequestParam Map map,Map map1) {
		String primarKey = (String)map.get("primarKey");
		map.put("primarKey", primarKey);
		List<Humman_file> query_list = humman_fileService.query_list_key(map);
		map1.put("query_list", query_list);
		return "page/humanResources/query_list";
	}
	//������ѯ
	@RequestMapping("page/query_list")
	public String query_list(@RequestParam Map map,Map map1) throws ParseException {
		//��ȡ��ʼʱ��
		String startDate = (String) map.get("utilBean.startDate");
		//��ȡ����ʱ��
		String endDate = (String) map.get("utilBean.endDate");
		map.put("startDateStr", startDate);
		map.put("endDateStr", endDate);
		
		List<Humman_file> query_list = humman_fileService.query_list(map);
		map1.put("query_list", query_list);
		map1.put("query_list_size", query_list.size());
		return "page/humanResources/query_list";
	}
	
	//���ݵ�����Ų�ѯ����
	@RequestMapping("page/query_list_information")
	public String query_list_information(String human_id,Map<String, Object> map) {
		Humman_file humman_file =  humman_fileService.human_check(human_id);
		map.put("humman_file", humman_file);
		return "page/humanResources/query_list_information";
	}
	//������Դ�������
	@RequestMapping("page/change_locate")
	public String change_locate(Map<String, Object> map) {
		//һ����������
		List<Config_file_first_kind> FirstList = humman_fileService.selcffk();
		map.put("FirstList", FirstList);
		//ְλ�����ѯ����
		List<Config_major_kind> fenleilist = config_major_kindService.selconfigmajor();
		map.put("fenleilist", fenleilist);
		return "page/humanResources/change_locate";
	}
		
	//������ѯ������Դ���
		@RequestMapping("page/change_list")
		public String change_list(@RequestParam Map map,Map map1) throws ParseException {
			//��ȡ��ʼʱ��
			String startDate = (String) map.get("utilBean.startDate");
			//��ȡ����ʱ��
			String endDate = (String) map.get("utilBean.endDate");
			map.put("startDateStr", startDate);
			map.put("endDateStr", endDate);
			
			List<Humman_file> query_list = humman_fileService.query_list(map);
			map1.put("query_list", query_list);
			map1.put("query_list_size", query_list.size());
			return "page/humanResources/change_list";
		}
		//���ݵ�����Ų�ѯ����������Դ���
		@RequestMapping("page/change_list_information")
		public String change_list_information(String human_id,Map<String, Object> map) {
			Humman_file humman_file =  humman_fileService.human_check(human_id);
			map.put("humman_file", humman_file);
			//��ѯ����
			List<Config_public_char> listguoji = humman_fileService.listguoji();
			map.put("listguoji", listguoji);
			//��ѯ����
			List<Config_public_char> listmingzu = humman_fileService.listmingzu();
			map.put("listmingzu", listmingzu);
			//��ѯ�ڽ�����
			List<Config_public_char> listzongjiao = humman_fileService.listzongjiao();
			map.put("listzongjiao",listzongjiao);
			//��ѯ������ò
			List<Config_public_char> listzhengzhi = humman_fileService.listzhengzhi();
			map.put("listzhengzhi", listzhengzhi);
			//��ѯѧ��
			List<Config_public_char> listxueli = humman_fileService.listxueli();
			map.put("listxueli", listxueli);
			//��ѯ��������
			List<Config_public_char> listjiaoyu = humman_fileService.listjiaoyu();
			map.put("listjiaoyu", listjiaoyu);
			//��ѯѧ��רҵ
			List<Config_public_char> listzhuanye = humman_fileService.listzhuanye();
			map.put("listzhuanye", listzhuanye);
			//��ѯ�س�
			List<Config_public_char> listtechang = humman_fileService.listtechang();
			map.put("listtechang", listtechang);
			//��ѯ����
			List<Config_public_char> listaihao = humman_fileService.listaihao();
			map.put("listaihao", listaihao);
			//��ѯְ��
			List<Config_public_char> listzhicheng = humman_fileService.listzhicheng();
			map.put("listzhicheng", listzhicheng);
			//��ѯн���׼
			List<Salary_standard_details> listxinchou = humman_fileService.xinchoulist();
			map.put("listxinchou", listxinchou);
			return "page/humanResources/change_list_information";
		}
		//������Դ����޸�
		@RequestMapping("page/register_choose_picture_update")
		public String register_choose_picture_update(Humman_file humman_file,HttpServletRequest request,String salary_standard_id) {
			//��ȡ����
			String birthday = request.getParameter("humanFile.humanBirthday");
			humman_file.setHuman_birthday(birthday);
			//����н���Ų�ѯн���׼name
			Salary_standard salary_standard = humman_fileService.xinchouid(salary_standard_id);
			//���name����
			humman_file.setSalary_standard_name(salary_standard.getStandard_name());
			//��ӻ���н���ܶ�
			humman_file.setSalary_sum(salary_standard.getSalary_sum());
			//���Ӧ��н���ܶ�
			humman_file.setDemand_salaray_sum(salary_standard.getSalary_sum());
			humman_fileService.register_choose_picture_update(humman_file);
			return "redirect:change_locate";
		}
				//������Դ����ɾ��
				@RequestMapping("page/delete_locate")
				public String delete_locate(Map<String, Object> map) {
					//һ����������
					List<Config_file_first_kind> FirstList = humman_fileService.selcffk();
					map.put("FirstList", FirstList);
					//ְλ�����ѯ����
					List<Config_major_kind> fenleilist = config_major_kindService.selconfigmajor();
					map.put("fenleilist", fenleilist);
					return "page/humanResources/delete_locate";
				}
				//ģ����ѯ������Դɾ������תҳ�棩
				@RequestMapping("page/delete_keywords")
				public String delete_keywords() {
					return "page/humanResources/delete_keywords";
				}
				//ģ����ѯ������Դɾ��
				@RequestMapping("page/delete_list_key")
				public String delete_list_key(@RequestParam Map map,Map map1) {
					String primarKey = (String)map.get("primarKey");
					map.put("primarKey", primarKey);
					List<Humman_file> query_list = humman_fileService.delete_list_key(map);
					map1.put("query_list", query_list);
					return "page/humanResources/delete_list";
				}
				//������ѯ������Դɾ��
				@RequestMapping("page/delete_list")
				public String delete_list(@RequestParam Map map,Map map1) throws ParseException {
					//��ȡ��ʼʱ��
					String startDate = (String) map.get("utilBean.startDate");
					//��ȡ����ʱ��
					String endDate = (String) map.get("utilBean.endDate");
					map.put("startDateStr", startDate);
					map.put("endDateStr", endDate);
					
					List<Humman_file> query_list = humman_fileService.delete_list(map);
					map1.put("query_list", query_list);
					map1.put("query_list_size", query_list.size());
					return "page/humanResources/delete_list";
				}
				
				//���ݵ�����Ų�ѯ����������Դɾ��
				@RequestMapping("page/delete_list_information")
				public String delete_list_information(String human_id,Map<String, Object> map) {
					Humman_file humman_file =  humman_fileService.human_check(human_id);
					map.put("humman_file", humman_file);
					//��ѯ����
					List<Config_public_char> listguoji = humman_fileService.listguoji();
					map.put("listguoji", listguoji);
					//��ѯ����
					List<Config_public_char> listmingzu = humman_fileService.listmingzu();
					map.put("listmingzu", listmingzu);
					//��ѯ�ڽ�����
					List<Config_public_char> listzongjiao = humman_fileService.listzongjiao();
					map.put("listzongjiao",listzongjiao);
					//��ѯ������ò
					List<Config_public_char> listzhengzhi = humman_fileService.listzhengzhi();
					map.put("listzhengzhi", listzhengzhi);
					//��ѯѧ��
					List<Config_public_char> listxueli = humman_fileService.listxueli();
					map.put("listxueli", listxueli);
					//��ѯ��������
					List<Config_public_char> listjiaoyu = humman_fileService.listjiaoyu();
					map.put("listjiaoyu", listjiaoyu);
					//��ѯѧ��רҵ
					List<Config_public_char> listzhuanye = humman_fileService.listzhuanye();
					map.put("listzhuanye", listzhuanye);
					//��ѯ�س�
					List<Config_public_char> listtechang = humman_fileService.listtechang();
					map.put("listtechang", listtechang);
					//��ѯ����
					List<Config_public_char> listaihao = humman_fileService.listaihao();
					map.put("listaihao", listaihao);
					//��ѯְ��
					List<Config_public_char> listzhicheng = humman_fileService.listzhicheng();
					map.put("listzhicheng", listzhicheng);
					//��ѯн���׼
					List<Salary_standard_details> listxinchou = humman_fileService.xinchoulist();
					map.put("listxinchou", listxinchou);
					return "page/humanResources/delete_list_information";
				}
				//������Դɾ���޸�
				@RequestMapping("page/success_update")
				public String success_update(Humman_file humman_file) {
					humman_fileService.success_update(humman_file);
					return "page/humanResources/success";
				}
				
		//������Դ�����ָ�
		@RequestMapping("page/recovery_locate")
		public String recovery_locate(Map<String, Object> map) {
			//һ����������
			List<Config_file_first_kind> FirstList = humman_fileService.selcffk();
			map.put("FirstList", FirstList);
			//ְλ�����ѯ����
			List<Config_major_kind> fenleilist = config_major_kindService.selconfigmajor();
			map.put("fenleilist", fenleilist);
			return "page/humanResources/recovery_locate";
		}
		//������Դ�����ָ�����ҳ�棩
		@RequestMapping("page/recovery_keywords")
		public String recovery_keywords() {
			return "page/humanResources/recovery_keywords";
		}
		//ģ����ѯ������Դ�ָ�
		@RequestMapping("page/recovery_list_key")
		public String recovery_list_key(@RequestParam Map map,Map map1) {
			String primarKey = (String)map.get("primarKey");
			map.put("primarKey", primarKey);
			List<Humman_file> query_list = humman_fileService.recovery_list_key(map);
			map1.put("query_list", query_list);
			return "page/humanResources/recovery_list";
		}
		//������Դ�����ָ�������ѯ
		@RequestMapping("page/recovery_list")
		public String recovery_list(@RequestParam Map map,Map map1) throws ParseException {
			//��ȡ��ʼʱ��
			String startDate = (String) map.get("utilBean.startDate");
			//��ȡ����ʱ��
			String endDate = (String) map.get("utilBean.endDate");
			map.put("startDateStr", startDate);
			map.put("endDateStr", endDate);
			
			List<Humman_file> query_list = humman_fileService.recovery_list(map);
			map1.put("query_list", query_list);
			map1.put("query_list_size", query_list.size());
			return "page/humanResources/recovery_list";
		}
		//������Դ�ָ�
		@RequestMapping("page/recovery_list_information")
		public String recovery_list_information(String human_id,Map<String, Object> map) {
			Humman_file humman_file =  humman_fileService.human_check(human_id);
			map.put("humman_file", humman_file);
			//��ѯ����
			List<Config_public_char> listguoji = humman_fileService.listguoji();
			map.put("listguoji", listguoji);
			//��ѯ����
			List<Config_public_char> listmingzu = humman_fileService.listmingzu();
			map.put("listmingzu", listmingzu);
			//��ѯ�ڽ�����
			List<Config_public_char> listzongjiao = humman_fileService.listzongjiao();
			map.put("listzongjiao",listzongjiao);
			//��ѯ������ò
			List<Config_public_char> listzhengzhi = humman_fileService.listzhengzhi();
			map.put("listzhengzhi", listzhengzhi);
			//��ѯѧ��
			List<Config_public_char> listxueli = humman_fileService.listxueli();
			map.put("listxueli", listxueli);
			//��ѯ��������
			List<Config_public_char> listjiaoyu = humman_fileService.listjiaoyu();
			map.put("listjiaoyu", listjiaoyu);
			//��ѯѧ��רҵ
			List<Config_public_char> listzhuanye = humman_fileService.listzhuanye();
			map.put("listzhuanye", listzhuanye);
			//��ѯ�س�
			List<Config_public_char> listtechang = humman_fileService.listtechang();
			map.put("listtechang", listtechang);
			//��ѯ����
			List<Config_public_char> listaihao = humman_fileService.listaihao();
			map.put("listaihao", listaihao);
			//��ѯְ��
			List<Config_public_char> listzhicheng = humman_fileService.listzhicheng();
			map.put("listzhicheng", listzhicheng);
			//��ѯн���׼
			List<Salary_standard_details> listxinchou = humman_fileService.xinchoulist();
			map.put("listxinchou", listxinchou);
			return "page/humanResources/recovery_list_information";
		}
		//������Դɾ���޸�
		@RequestMapping("page/success_update1")
		public String success_update1(Humman_file humman_file) {
			humman_fileService.success_update1(humman_file);
			return "page/humanResources/success";
		}
		//������Դ����ɾ����ѯ
		@RequestMapping("page/delete_forever_list")
		public String delete_forever_list(Map map) {
			List<Humman_file> humman_fileslist = humman_fileService.Humman_fileList1();
			map.put("humman_fileslist", humman_fileslist);
			map.put("humman_fileslist_size", humman_fileslist.size());
			return "page/humanResources/delete_forever_list";
		}
		//������Դ����ɾ��
		@RequestMapping("page/Delete")
		@ResponseBody
		public int Delete(String human_id) {
			humman_fileService.Delete(human_id);
			return 1;
		}
		
}
