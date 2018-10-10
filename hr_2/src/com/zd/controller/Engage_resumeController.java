package com.zd.controller;

import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zd.entity.Config_major;
import com.zd.entity.Config_major_kind;
import com.zd.entity.Config_public_char;
import com.zd.entity.Engage_resume;
import com.zd.entity.e_mail;
import com.zd.entity.sendemail;
import com.zd.service.IConfig_majorService;
import com.zd.service.IConfig_major_kindService;
import com.zd.service.IEmailService;
import com.zd.service.IEngage_resumeService;
import com.zd.service.IHumman_fileService;

@Controller
public class Engage_resumeController {
	
	@Autowired
	private IConfig_major_kindService kindservice;	//职位分类
	
	@Autowired
	private IConfig_majorService majorservice;	//职位
	
	@Autowired
	private IHumman_fileService fileservice;	//公共信息表
	
	@Autowired
	private IEngage_resumeService resumeservice;
	
	@Autowired
	private IEmailService emailservice;
	
	@Autowired
	private JavaMailSender mailSender;

	
	@RequestMapping("/page/seltype")
	public String seltype(Map map) {
		//职位分类
		List<Config_major_kind> kindlist=kindservice.selconfigmajor();
		
		//招聘类型
		List<Config_public_char> zhaoplist=fileservice.listzhaopin();
		//国籍
		List<Config_public_char> guoji=fileservice.listguoji();
		//民族
		List<Config_public_char> mingzu=fileservice.listmingzu();
		//宗教
		List<Config_public_char> zongjiao=fileservice.listzongjiao();
		//政治面貌
		List<Config_public_char> zhengzhi=fileservice.listzhengzhi();
		//学历
		List<Config_public_char> xueli=fileservice.listxueli();
		//教育年限
		List<Config_public_char> jiaoyv=fileservice.listjiaoyu();
		//学历专业
		List<Config_public_char> zhuanye=fileservice.listzhuanye();
		//特长
		List<Config_public_char> techang=fileservice.listtechang();
		//爱好
		List<Config_public_char> aihao=fileservice.listaihao();
		
		map.put("kindlist",kindlist );
		map.put("zhaoplist",zhaoplist );
		map.put("guoji",guoji );
		map.put("mingzu", mingzu);
		map.put("zongjiao",zongjiao );
		map.put("zhengzhi",zhengzhi );
		map.put("xueli",xueli );
		map.put("jiaoyv",jiaoyv );
		map.put("zhuanye",zhuanye );
		map.put("techang",techang );
		map.put("aihao", aihao);
		return "page/recruit/resume/register";
	}
	
	@RequestMapping("/page/addresume")
	public String addresume(Engage_resume resume,Map map) {
		//根据职位分类id查名称
		resume.setHuman_major_kind_name(kindservice.selmajorkindid(resume.getHuman_major_kind_id()).getMajor_kind_name());
				//根据职位id查名称
		resume.setHuman_major_name(majorservice.selzhiweiid(resume.getHuman_major_id()).getMajor_name());
				
		resumeservice.addresume(resume);
		return "redirect:/page/shaixuan";
	}
	
	@RequestMapping("/page/shaixuan")
	public String shaixuan(Map map) {
		List<Config_major_kind> kindlist=kindservice.selconfigmajor();
		map.put("kindlist", kindlist);
		return "page/recruit/resume/resume_choose";
	}
	
	//模糊查询筛选
	@RequestMapping("/page/selresume")
	public String selresume(@RequestParam Map map,Map map1,HttpSession session) {
		if(map==null||map.size()<1) {
			Map map2=(Map) session.getAttribute("map");
			List<Engage_resume> relist=resumeservice.selresume(map2);
			map1.put("relist", relist);
		}else {
			session.removeAttribute("map");
			List<Engage_resume> relist=resumeservice.selresume(map);
			session.setAttribute("map",map);
			map1.put("relist", relist);
		}

		return "page/recruit/resume/resume_list";
	}
	
	@RequestMapping("/page/fuhe")
	public String fuhe(int res_id,Map map) {
		Engage_resume resume=resumeservice.selresumeid(res_id);
				//职位分类
				List<Config_major_kind> kindlist=kindservice.selconfigmajor();
				//职位
				List<Config_major> majorlist=majorservice.selzhiwei(resume.getHuman_major_kind_id());
				//招聘类型
				List<Config_public_char> zhaoplist=fileservice.listzhaopin();
				//国籍
				List<Config_public_char> guoji=fileservice.listguoji();
				//民族
				List<Config_public_char> mingzu=fileservice.listmingzu();
				//宗教
				List<Config_public_char> zongjiao=fileservice.listzongjiao();
				//政治面貌
				List<Config_public_char> zhengzhi=fileservice.listzhengzhi();
				//学历
				List<Config_public_char> xueli=fileservice.listxueli();
				//教育年限
				List<Config_public_char> jiaoyv=fileservice.listjiaoyu();
				//学历专业
				List<Config_public_char> zhuanye=fileservice.listzhuanye();
				//特长
				List<Config_public_char> techang=fileservice.listtechang();
				//爱好
				List<Config_public_char> aihao=fileservice.listaihao();
				
				map.put("kindlist",kindlist );
				map.put("majorlist", majorlist);
				map.put("zhaoplist",zhaoplist );
				map.put("guoji",guoji );
				map.put("mingzu", mingzu);
				map.put("zongjiao",zongjiao );
				map.put("zhengzhi",zhengzhi );
				map.put("xueli",xueli );
				map.put("jiaoyv",jiaoyv );
				map.put("zhuanye",zhuanye );
				map.put("techang",techang );
				map.put("aihao", aihao);
				map.put("resume", resume);
		return "page/recruit/resume/resume_details";
	}
	
	//推荐修改
	@RequestMapping("/page/tuijianre")
	public String tuijian(Engage_resume resume,Map map) {
		//根据职位分类id查名称
		resume.setHuman_major_kind_name(kindservice.selmajorkindid(resume.getHuman_major_kind_id()).getMajor_kind_name());
		//根据职位id查名称
		resume.setHuman_major_name(majorservice.selzhiweiid(resume.getHuman_major_id()).getMajor_name());
		resumeservice.updateresume(resume);
		return "redirect:/page/selresume";
	}
	
	//forward
	@RequestMapping("/page/shaixuan2")
	public String shaixuan2(Map map) {
		List<Config_major_kind> kindlist=kindservice.selconfigmajor();
		map.put("kindlist", kindlist);
		return "page/recruit/resume/valid_resume";
	}
	
	//模糊查询筛选
	@RequestMapping("/page/selresume2")
	public String selresume2(@RequestParam Map map,Map map1) {
		List<Engage_resume> relist=resumeservice.selresume(map);
		map1.put("relist", relist);
		return "page/recruit/resume/valid_list";
	}
	
	@RequestMapping("/page/selresumeid")
	public String selresumeid(int res_id,Map map) {
		Engage_resume resume=resumeservice.selresumeid(res_id);
		map.put("resume", resume);
		return "page/recruit/resume/resume_select";
	}
	
	//发送邮箱，查询邮件模板
	@RequestMapping("/page/selemail")
	private String selemail(Map map,int id){
		List<e_mail> elist = emailservice.selm();
		Engage_resume resume = resumeservice.selresumeid(id);
		map.put("elist", elist);
		map.put("resume", resume);
		return "/page/recruit/resume/resume_email";
	}
	
	@RequestMapping("/page/selemail2")
	private String selemail2(Map map,int id){
		List<e_mail> elist = emailservice.selm();
		Engage_resume resume = resumeservice.selresumeid(id);
		map.put("elist", elist);
		map.put("resume", resume);
		return "/page/recruit/employ/register_email";
	}
	
	//发送邮件
	@RequestMapping("/page/sendEmailMa")
	public String sendEmailMa(sendemail mai,int emailTitle) throws Exception {
			e_mail email = emailservice.emailselid(emailTitle);
			// 1、通过发送者创建电子邮件对象-MimeMessage
			MimeMessage mm = mailSender.createMimeMessage();
			// 2、创建发送电子邮件的帮助者对象-MimeMessageHelper
			MimeMessageHelper helper = new MimeMessageHelper(mm, "UTF-8");
			// 3、设置发送电子邮件的相关信息
			// 3-1 指定发件人
			helper.setFrom(mai.getSenderEmail());
			// 3-2 指定收件人
			helper.setTo(mai.getHuman_email());
			// 3-3 指定邮件主题
			helper.setSubject(email.getMhead());
			// 3-4 指定邮件内容,上了true表示支持html
			helper.setText(mai.getEidaa(), true);
			// 4、通过邮件发送者发送电子邮件
			mailSender.send(mm);
			
			return "redirect:/page/selresume"; 
	}
	
	@RequestMapping("/page/sendEmailMa2")
	public String sendEmailMa2(sendemail mai,int emailTitle) throws Exception {
			e_mail email = emailservice.emailselid(emailTitle);
			// 1、通过发送者创建电子邮件对象-MimeMessage
			MimeMessage mm = mailSender.createMimeMessage();
			// 2、创建发送电子邮件的帮助者对象-MimeMessageHelper
			MimeMessageHelper helper = new MimeMessageHelper(mm, "UTF-8");
			// 3、设置发送电子邮件的相关信息
			// 3-1 指定发件人
			helper.setFrom(mai.getSenderEmail());
			// 3-2 指定收件人
			helper.setTo(mai.getHuman_email());
			// 3-3 指定邮件主题
			helper.setSubject(email.getMhead());
			// 3-4 指定邮件内容,上了true表示支持html
			helper.setText(mai.getEidaa(), true);
			// 4、通过邮件发送者发送电子邮件
			mailSender.send(mm);
			return "redirect:/page/selresume2"; 
	}
}
