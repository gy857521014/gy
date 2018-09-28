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
			List<Salary_standard> listxinchou = humman_fileService.xinchoulist();
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
			//���ݶ�����Ų�ѯ��������
				@RequestMapping("/page/selsanji")
				@ResponseBody
				public List<Config_file_third_kind> selsanji(String fsk_id){
					List<Config_file_third_kind> sanjilist = config_file_third_kindService.selsanji(fsk_id);
					return sanjilist;
				}
		//1.1ְλ��������
		@RequestMapping("/page/selectzhiwei")
		@ResponseBody
		public List<Config_major> selectzhiwei(int majorid) {
			List<Config_major> majorlist=majorservice.selzhiwei(majorid);
			return majorlist;
		}
		
		//���
		@RequestMapping("/page/add")
		public String add(Humman_file humman_file,HttpServletRequest request,String first_king_id) {
			// ������ȡ����
			String birthday =  request.getParameter("humanFile.humanBirthday");
			humman_file.setHuman_birthday(birthday);
			//����һ��������Ų�ѯһ����������
			Config_file_first_kind config_file_first_kind = 
					config_file_first_kindService.selcffkid(first_king_id);
			humman_file.setFirst_king_name(config_file_first_kind.getFirst_kind_name());
			humman_fileService.add(humman_file);
			return "forward:human_register";
		}
	//���ݵ�����Ų�ѯ
	
}
