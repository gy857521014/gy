package com.zd.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.jsp.jstl.core.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_public_char;
import com.zd.service.IHumman_fileService;

/**
 * 人力资源管理Controller
 * @author 周泽旭
 *
 */
@Controller
public class Humman_fileController {
	@Autowired
	private IHumman_fileService humman_fileService;
	//机构三级联动
		//查询一级机构
		@RequestMapping("page/human_register")
		public String human_register(Map<String, Object> map){
			//一级机构所有
			List<Config_file_first_kind> FirstList = humman_fileService.selcffk();
			map.put("FirstList", FirstList);
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
			return "page/humanResources/human_register";
		}
		//根据一级机构编号查询二级机构
		
}
