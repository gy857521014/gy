package com.zd.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_major;
import com.zd.entity.Config_major_kind;
import com.zd.entity.Config_public_char;
import com.zd.entity.Engage_major_release;
import com.zd.service.IConfig_file_first_kindService;
import com.zd.service.IConfig_majorService;
import com.zd.service.IConfig_major_kindService;
import com.zd.service.IEngage_major_releaseService;
import com.zd.service.IHumman_fileService;

@Controller
public class EngageMajotController {
	
	@Autowired
	private IConfig_major_kindService kindservice;
	
	@Autowired
	private IConfig_majorService majorservice;
	
	@Autowired
	private IConfig_file_first_kindService firstservice;
	
	@Autowired
	private IEngage_major_releaseService releaseservice;
	
	@Autowired
	private IHumman_fileService fileservice;
	
	
	//1.1查询机构联动，职位联动，招聘
	@RequestMapping("/page/torecruit")
	public String tosel(Map map) {
		List<Config_major_kind> kindlist=kindservice.selconfigmajor();
		List<Config_file_first_kind> firstlist=firstservice.selcffk();
		List<Config_public_char> zhaoplist=fileservice.listzhaopin();
		map.put("zhaoplist", zhaoplist);
		map.put("kindlist", kindlist);
		map.put("firstlist", firstlist);
		return "page/recruit/position/position_register";
	}
	//1.1职位联动
	@RequestMapping("/page/selzhiwei")
	@ResponseBody
	public List<Config_major> selzhiwei(int majorid) {
		List<Config_major> majorlist=majorservice.selzhiwei(majorid);
		return majorlist;
	}
	
	//1.2查询所有招聘
	@RequestMapping("/page/selallrelease")
	public String selallrelease(Map map){
		List<Engage_major_release> releaselist=releaseservice.selallrelease();
		map.put("releaselist", releaselist);
		return "page/recruit/position/position_change_update";
	}
	
	//1.2修改前查询
	@RequestMapping("/page/updatechange")
	public String selidrelease(int mre_id,Map map) {
		Engage_major_release release=releaseservice.selidrelease(mre_id);
		List<Config_public_char> zhaoplist=fileservice.listzhaopin();
		map.put("release", release);
		map.put("zhaoplist", zhaoplist);
		return "page/recruit/position/position_release_change";
	}
	
	//1.2修改
	@RequestMapping("/page/updaterelease")
	public String updaterelease(Engage_major_release release) {
		releaseservice.updaterelease(release);
		
		return "redirect:/page/selallrelease";
	}
	
	//删除
	@RequestMapping("/page/deleterelease")
	@ResponseBody
	public String deleterelease(int id) {
		
		releaseservice.deleterelease(id);
		return "1";
	}
}
