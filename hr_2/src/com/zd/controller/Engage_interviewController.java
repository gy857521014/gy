package com.zd.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zd.entity.Config_major_kind;
import com.zd.entity.Engage_interview;
import com.zd.entity.Engage_resume;
import com.zd.service.IConfig_major_kindService;
import com.zd.service.IEngage_interviewService;
import com.zd.service.IEngage_resumeService;

@Controller
public class Engage_interviewController {

	@Autowired
	private IEngage_resumeService resumeservice;
	@Autowired
	private IEngage_interviewService interviewservice;
	@Autowired
	private IConfig_major_kindService majorservice;
	
		//3.1���ԵǼ��б��ѯ
		@RequestMapping("/page/selmianshi")
		private String selmianshi(@RequestParam Map map,Map map1) {
			List<Engage_resume> relist =resumeservice.selresume(map);
			map1.put("relist", relist);
			return "/page/recruit/interview/interview-list";
		}
		//3.1���ԵǼǽ��
		@RequestMapping("/page/dengji")
		private String dengji(int id,Map map) {
			Engage_resume resume = resumeservice.selresumeid(id);
			map.put("resume", resume);
			return "/page/recruit/interview/interview-register";
		}
	
		//3.1��Ч�����б�Ǽ�
		@RequestMapping("/page/interviewadd")
		private String interviewadd(Engage_interview interview) {
			interviewservice.interviewadd(interview);
			resumeservice.resumeupdate(interview.getResume_id());
			return "redirect:/page/selmianshi";
		}
		
		//3.2����ɸѡְҵ�����ѯ
		@RequestMapping("/page/mshisel")
		public String mshisel(Map map) {
			List<Config_major_kind> major =majorservice.selconfigmajor();
			map.put("major", major);
			return "/page/recruit/interview/interview-resume";
		}
		
		//3.2����ɸѡ�б�
		@RequestMapping("/page/selinterview")
		private String selinterview(@RequestParam Map map,Map map1,HttpSession session) {
			if(map==null||map.size()<1) {
				Map map2=(Map) session.getAttribute("map2");
				List<Engage_interview> inlist = interviewservice.selresume(map2);
				map1.put("inlist", inlist);
			}else {
				session.removeAttribute("map2");
				List<Engage_interview> inlist = interviewservice.selresume(map);
				session.setAttribute("map2",map);
				map1.put("inlist", inlist);
			}

			return "/page/recruit/interview/sift-list";
		}
		
		//3.2����ɸѡ��ѯ
		@RequestMapping("/page/Engage_interview_queryDan")
		private String Engage_interview_queryDan(Engage_interview interview,int id,Map map) {
			Engage_interview ei = interviewservice.Engage_interview_queryDan(id);
			Engage_resume er =resumeservice.selresumeid(ei.getResume_id());
			map.put("ei", ei);
			map.put("er", er);
			return "/page/recruit/interview/interview-sift";
		}
		
		//3.2����ɸѡ����¼ȡ���
		@RequestMapping("/page/Engage_interview_upd")
		private String Engage_interview_upd(Engage_interview engage_interview) {
			interviewservice.Engage_interview_upd(engage_interview);
			return "redirect:/page/selinterview";
		}
		
		//4.1¼�������ѯ
		@RequestMapping("/page/Engage_interview_query")
		private String Engage_interview_query(Map map) {
			List<Engage_interview> inlist = interviewservice.Engage_interview_query();
			map.put("inlist", inlist);
			return "/page/recruit/employ/register_list";
		}
		
		//4.1¼�������ѯ����ҳ��
		@RequestMapping("/page/register_sift_queryDan")
		private String register_sift_queryDan(Engage_interview engage_interview,int id,Map map) {
			Engage_interview ei = interviewservice.Engage_interview_queryDan(id);
			Engage_resume er = resumeservice.selresumeid(ei.getResume_id());
			map.put("ei", ei);
			map.put("er", er);
			return "/page/recruit/employ/register";
		}
		
		//4.1¼ȡ����ͨ����ͨ��
		@RequestMapping("/page/register_sift_update")
		private String register_sift_update(Engage_resume engage_resume) {
			interviewservice.register_sift_update(engage_resume);
			return "redirect:/page/Engage_interview_query";
		}
		
		//4.2¼����˲�ѯ
		@RequestMapping("/page/check_list_query")
		private String check_list_query(Map map) {
			List<Engage_interview> eil = interviewservice.Engage_interview_query();
			map.put("eil", eil);
			return "/page/recruit/employ/check_list";
		}
		
		//4.2¼����˲�ѯ����ҳ��
		@RequestMapping("/page/check_list_queryDan")
		private String check_list_queryDan(Engage_interview engage_interview,int id,Map map) {
			Engage_interview ei = interviewservice.Engage_interview_queryDan(id);
			Engage_resume er = resumeservice.selresumeid(ei.getResume_id());
			map.put("ei", ei);
			map.put("er", er);
			return "/page/recruit/employ/check";
		}
		
		//4.2¼ȡ���ͨ����ͨ��
		@RequestMapping("/page/check_list_update")
		private String check_list_update(Engage_resume engage_resume) {
			interviewservice.check_list_update(engage_resume);
			return "redirect:check_list_query";
		}
		
		//4.3¼�ò�ѯ
		@RequestMapping("/page/list_query")
		private String list_query(Map map) {
			List<Engage_interview> eil = interviewservice.Engage_interview_query();
			map.put("eil", eil);
			return "/page/recruit/employ/list";
		}
		
		//4.3¼�ò�ѯ����ҳ��
		@RequestMapping("/page/details_queryDan")
		private String details_queryDan(Engage_interview engage_interview,int id,Map map) {
			Engage_interview ei = interviewservice.Engage_interview_queryDan(id);
			Engage_resume er =resumeservice.selresumeid(ei.getResume_id());
			map.put("ei", ei);
			map.put("er", er);
			return "/page/recruit/employ/details";
		}
}
