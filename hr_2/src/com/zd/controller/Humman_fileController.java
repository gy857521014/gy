package com.zd.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.zd.entity.Config_file_first_kind;
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
	//三级联动
		//查询一级机构
	@RenderMapping("/human_register")
	public String human_register(Map<String, Object> map){
		List<Config_file_first_kind> FirstList = humman_fileService.selcffk();
		map.put("FirstList", FirstList);
		return "/page/humanResources/human_register";
	}
}
