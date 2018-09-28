package com.zd.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zd.dao.IConfig_file_first_kindDao;
import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;
import com.zd.entity.Config_major;
import com.zd.entity.Config_major_kind;
import com.zd.entity.Config_public_char;
import com.zd.entity.Engage_major_release;
import com.zd.service.IConfig_file_first_kindService;
import com.zd.service.IConfig_file_second_kindService;
import com.zd.service.IConfig_file_third_kindService;
import com.zd.service.IConfig_majorService;
import com.zd.service.IConfig_major_kindService;
import com.zd.service.IEngage_major_releaseService;
import com.zd.service.IHumman_fileService;

@Controller
public class EngageMajotController {
	
	@Autowired
	private IConfig_major_kindService kindservice;	//职位分类
	
	@Autowired
	private IConfig_majorService majorservice;	//职位
	
	@Autowired
	private IConfig_file_first_kindService firstservice;	//一级机构
	
	
	@Autowired
	private IEngage_major_releaseService releaseservice;	//招聘信息
	
	@Autowired
	private IHumman_fileService fileservice;	//公共信息表
	
	@Autowired
	private IConfig_file_second_kindService secondservice;	//二级机构
	
	@Autowired
	private IConfig_file_third_kindService thirdservice;	//三级机构
	
	
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
	
	//1.1添加招聘
	@RequestMapping("/page/addrelease")
	public String addrelease(Engage_major_release release) {
		//根据一级机构id查名称
		release.setFirst_kind_name(firstservice.selcffkid(release.getFirst_kind_id()).getFirst_kind_name());
		//根据二级机构id查名称
		if(release.getSecond_kind_id()!=null) {
			
			release.setSecond_kind_name(secondservice.selerjiid(release.getSecond_kind_id()).getSecond_kind_name());
		}else {
			release.setSecond_kind_name("");
			release.setSecond_kind_id("");
		}
		//根据三级机构id查名称
		if(release.getThird_kind_id()!=null) {
			
			release.setThird_kind_name(thirdservice.selsanjiid(release.getThird_kind_id()).getThird_kind_name());
		}else {
			release.setThird_kind_name("");
			release.setThird_kind_id("");
		}
		//根据职位分类id查名称
		release.setMajor_kind_name(kindservice.selmajorkindid(release.getMajor_kind_id()).getMajor_kind_name());
		//根据职位id查名称
			release.setMajor_name(majorservice.selzhiweiid(release.getMajor_id()).getMajor_name());
		
			releaseservice.addrelease(release);
		
		return "redirect:/page/selallrelease";
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
	//1.3查询所有
	@RequestMapping("/page/selallrelease2")
	public String selallrelease2(Map map){
		List<Engage_major_release> releaselist=releaseservice.selallrelease();
		map.put("releaselist", releaselist);
		return "page/recruit/position/position_release_search";
	}
	
	//1.3
		@RequestMapping("/page/selidrelease2")
		public String selidrelease2(int mre_id,Map map) {
			Engage_major_release release=releaseservice.selidrelease(mre_id);
			List<Config_public_char> zhaoplist=fileservice.listzhaopin();
			List<Config_file_first_kind> firstlist=firstservice.selcffk();
			List<Config_file_second_kind> erlist=secondservice.selcfsk();
			List<Config_file_third_kind> sanlist=thirdservice.selcftk();
			List<Config_major_kind> kindlist=kindservice.selconfigmajor();
			List<Config_major> majorlist=majorservice.selallzhi();
			map.put("release", release);
			map.put("zhaoplist", zhaoplist);
			map.put("firstlist", firstlist);
			map.put("erlist", erlist);
			map.put("sanlist", sanlist);
			map.put("kindlist", kindlist);
			map.put("majorlist", majorlist);
			return "page/recruit/position/position_release_details";
		}
}
