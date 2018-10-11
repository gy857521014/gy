<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My JSP 'interview-sift.jsp' starting page</title>
    	<link rel="stylesheet"
			href="../css/table.css" type="text/css">
		<link rel="stylesheet"
			href="../css/cwcalendar.css"
			type="text/css">
		<script type="text/javascript"
			src="../javascript/comm/comm.js">
	
</script>
		<script type="text/javascript"
			src="../javascript/comm/list.js">
	
</script>
		<script type="text/javascript"
			src="../javascript/calendar-ch.js">
	
</script>
		<script type="text/javascript"
			src="../javascript/jquery-1.7.2.js">
	
</script>
		<script type="text/javascript"
			src="../javascript/locate.js">
	
</script>
		<script type="text/javascript"
			src="../javascript/jquery.messager.js">
		</script>
	 
<script type="text/javascript">
 

	function toPhoto(data){
		var a = data.substring(data.indexOf(".")+1)
		if(a!="jpg" && a!="gif" && a!="bmp"){
			alert("您上传的不是图片路径");
		}
	}
	
	function toPhotofile(da){
		var a = da.substring(da.indexOf(".")+1)
		if(a!="doc"){
			alert("您上传的不是文件路径");
		}
	}

		var validateMsg = "";
	function checkNotEmpty(ctlName,label)
	{
		var oCtl = document.forms[0].elements[ctlName];
		if (oCtl.value=="")
		{
			if (label)
			{
				validateMsg += label;
			}
			validateMsg += "不能为空！\n";
			oCtl.focus();
		}
	}
	
	function checkValidateMsg()
	{
		if (validateMsg!="")
		{
			alert(validateMsg);
			return false;
		}
		return true;
	}
			
		function tosubmit(){
			validateMsg = "";
			checkNotEmpty("ei.checker","筛选人");
			checkNotEmpty("ei.checkComment","录用申请审核意见");
			if (!checkValidateMsg())
			{
				return;
			}
			document.forms[0].elements["operate"].value = "doAdopt"; 
			document.forms[0].submit();
		}
		
		
		function tozwfenlei(id){
			$("er.humanMajorKindName").value=$("er.humanMajorKindId").options[$("er.humanMajorKindId").selectedIndex].outerText;
			engageResume.SelectConfig_major(id,callbackkind)
		}
		
		function callbackkind(data){
			$("er.humanMajorId").options.length=0;
			var o = new Option("--请选择--",0);
			$("er.humanMajorId").add(o);
			DWRUtil.addOptions("er.humanMajorId",data,"majorId","majorName");
		}
		function zwmingchen(){
			$("er.humanMajorName").value=$("er.humanMajorId").options[$("er.humanMajorId").selectedIndex].outerText;
		}
		
		
		function tick() {
			var now = new Date();
			var hours, minutes, seconds, noon;
			var intHours, intMinutes, intSeconds;
			intHours = now.getHours();
			intMinutes = now.getMinutes();
			intSeconds = now.getSeconds();
			if (intHours < 24) {
				hours = intHours+":";
				noon = "A.M.";
			} else {
				intHours = intHours - 24;
				hours = intHours + ":";
				noon = "P.M.";
			}
			if (intMinutes < 10) {
				minutes = "0"+intMinutes+":";
			} else {
				minutes = intMinutes+":";
			}
			if (intSeconds < 10) {
				seconds = "0"+intSeconds+" ";
			} else {
				seconds = intSeconds+" ";
			}
			timeString = hours+minutes+seconds;
			var now = new Date();
			
		  	document.getElementById("nowTime").value = now.getFullYear()+"-"+(now.getMonth()+1)+"-"+now.getDate()+" "+timeString;
			window.setTimeout("tick();", 100);
		}
		
		//load事件
		function check(){
			//获得系统当前时间的方法
		  	tick();					
		}
		
		function mians(){
			document.getElementById("passCheckcomment").value="建议面试";
			
		}
		function bis(){
			document.getElementById("passCheckcomment").value="建议笔试";
		}
		function luy(){
			document.getElementById("passCheckcomment").value="建议录用";
			
		}
		function del(){
			document.getElementById("passCheckcomment").value="删除简历";
			
		}
		
 		</script>
 		<script type="text/javascript">
 		function search(id){   
 			if(document.getElementById("shaixuan").value.trim()<1||document.getElementById("shaixuan").value.trim().length>10)
			{
 				$.messager.show("消息提示", "请输入筛选人!", 1000);
 				document.getElementById("shaixuan").focus();
				return false;    				
			}
	 		if(document.getElementById("passCheckcomment").value=="删除简历"){
			//	window.location.href="/HR_Fist/recruit/recruitAction!deleteResumeById?id="+id;
			 return true;
			}else if(document.getElementById("passCheckcomment").value=="建议录用"){
					document.getElementById("ly").value = true;
					 return true;
			}else if(document.getElementById("passCheckcomment").value=="建议面试"){
					document.getElementById("mianshi").value = false;
					 return true;
			} 
		}
 		</script>
	</head>

	<body onload="check(),luy()">
		<form id="recruitAction!returnSiftList" name="fm" action="Engage_interview_upd" method="post" >
		<input type="hidden" name="ein_id" value="${ei.ein_id }">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--招聘管理--面试管理--面试筛选  </font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<span style="color:red;display:none" id="name1">请输入筛选人</span>
						<!-- <input type="radio" name="check_status"  value="1" onclick="mians()">建议面试 -->
						<input type="radio" name="check_status"   value="3"  checked="checked" onclick="luy()">建议录用
						<input type="radio" name="check_status"  value="4" onclick="del()">删除简历
						<input type="submit" value="确认" class="BUTTON_STYLE1"
							onclick="return search('542')">
						<input type="button" value="返回" class="BUTTON_STYLE1" 
							onclick="history.back();">
							
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1" width="11%">
						职位分类
					</td>
					<td width="14%" class="TD_STYLE2"> 
						<input type="hidden" name="engageInterview.humanMajorKindId" value="${ei.human_major_kind_id }"/>
					   <input type="text" name="engageInterview.humanMajorKindName"
						   value="${ei.human_major_kind_name }" readonly="readonly" class="INPUT_STYLE2">
					
					</td>
					<td width="11%" class="TD_STYLE1">
						职位名称
					</td>
					<td width="14%" class="TD_STYLE2">
					<input type="hidden" name="engageInterview.humanMajorId" value="${ei.human_major_id }"/>
					 <input type="text" name="engageInterview.humanMajorName" value="${ei.human_major_name }" readonly="readonly" class="INPUT_STYLE2">
				    </td>
					<td width="11%" class="TD_STYLE1">
						招聘类型
					</td>
					<td class="TD_STYLE2" >
						<input type="text" name="engageResume.engageType" value="${er.engage_type }" readonly="readonly" class="INPUT_STYLE2">
					
					</td>
					
					<td width="10%" rowspan="6" colspan="2"  align="center">
						 
					</td>
					
				</tr>
				<tr>
				<td class="TD_STYLE1">
						姓名
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="engageInterview.humanName" value="${ei.human_name }" readonly="readonly" class="INPUT_STYLE2">
						
					</td>
					<td class="TD_STYLE1">
						性别
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="engageResume.humanSex" value="${er.human_sex }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						EMAIL
					</td>
					<td   class="TD_STYLE2">
						<input type="text" name="engageResume.humanEmail" value="${er.human_email }"  readonly="readonly" class="INPUT_STYLE2">
					</td>
				</tr>

				<tr>
					<td class="TD_STYLE1">
						电话号码
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="engageResume.humanTelephone" value="${er.human_telephone }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						家庭电话
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="engageResume.humanHomephone" value="${er.human_homephone }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1" >
						手机
					</td>
					<td  class="TD_STYLE2" >
						<input type="text" name="engageResume.humanMobilephone" value="${er.human_mobilephone }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					
				</tr>
				<tr>
					<td class="TD_STYLE1">
						住址
					</td>
					<td colspan="3" class="TD_STYLE2">
						<input type="text" name="engageResume.humanAddress" value="${er.human_address }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						邮编
					</td>
					<td   class="TD_STYLE2">
						<input type="text" name="engageResume.humanPostcode" value="${er.human_postcode }" readonly="readonly" class="INPUT_STYLE2">
					</td>
				</tr>

				<tr>
					<td class="TD_STYLE1">
						国籍
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="engageResume.humanNationality" value="${er.human_nationality }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						出生地
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="engageResume.humanBirthplace" value="${er.human_birthplace }"  readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						生日
					</td>
					<td class="TD_STYLE2"  > 
						<input type="text" name="engageResume.humanBirthday" value="${er.human_birthday }" readonly="readonly" class="INPUT_STYLE2">
					</td>
				</tr>
				
				<tr>
					<td width="11%" class="TD_STYLE1">
						民族
					</td>
					<td class="TD_STYLE2" width="14%">
						<input type="text" name="engageResume.humanRace" value="${er.human_race }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						宗教信仰
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="engageResume.humanReligion" value="${er.human_religion }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						政治面貌
					</td>
					<td class="TD_STYLE2" >
						<input type="text" name="engageResume.humanParty" value="${er.human_party }" readonly="readonly" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>

					<td class="TD_STYLE1">
						身份证号码
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="engageResume.humanIdcard" value="${er.human_idcard }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						年龄
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="engageResume.humanAge" value="${er.human_age }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						毕业学校
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="engageResume.humanCollege" value="${er.human_college }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1" width="10%">
						学历
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="engageResume.humanEducatedDegree" value="${er.human_educated_degree }" readonly="readonly" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						教育年限
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="engageResume.humanEducatedYears"  value="${er.human_educated_years }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						学历专业
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="engageResume.humanEducatedMajor" value="${er.human_educated_major }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						薪酬要求
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="engageResume.demandSalaryStandard" value="${er.demand_salary_standard }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						注册时间
					</td>
					<td class="TD_STYLE2"> 
						<input type="text" name="engageResume.registTime" value="${er.regist_time }" readonly="readonly" class="INPUT_STYLE2">
						
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						特长
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="engageResume.humanSpecility" value="${er.human_specility }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						爱好
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="engageResume.humanHobby" value="${er.human_hobby }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1"><span style="font-size: 10.5pt; font-family: 宋体;"></span> 
						推荐人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="engageResume.passChecker" value="${er.pass_checker }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1"><span style="font-size: 10.5pt; font-family: 宋体;"></span> 
						推荐时间
					</td>
					<td class="TD_STYLE2"> 
						<input type="text" name="engageResume.passCheckTime" value="${er.pass_check_time } " readonly="readonly" class="INPUT_STYLE2">	 
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						档案附件
					</td>
					<td colspan="7" class="TD_STYLE2">
						<input type="text" name="er.checker" readonly="readonly" class="INPUT_STYLE2">
					</td>
				</tr>
			<tr>
					<td class="TD_STYLE1">
						个人履历
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="engageResume.humanHistoryRecords" rows="4"  
						class="TEXTAREA_STYLE1" readonly="readonly"> ${er.human_history_records }
						</textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						备注
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="engageResume.remark" rows="4"   class="TEXTAREA_STYLE1"  readonly="readonly"> ${er.remark }
						</textarea>
					</td>
				</tr>
				
				<tr>
					<td class="TD_STYLE1">
						筛选推荐意见
					</td>
					<td class="TD_STYLE2" colspan="7">
						<textarea name="engageResume.recomandation" rows="4"   class="TEXTAREA_STYLE1" readonly="readonly">${er.recomandation }					</textarea>
					</td>
				</tr>
				
				
				
				<tr>
					<td class="TD_STYLE1">
						面试次数
					</td>
					<td class="TD_STYLE2">
					 	<input type="text"   name="engageInterview.interviewAmount" value="${ei.interview_amount }" class="INPUT_STYLE2" readonly="readonly"/>
					</td>
					<td class="TD_STYLE1">
						形象评价
					</td>
					<td class="TD_STYLE2">
						 
				 <input type="text"  name="engageInterview.imageDegree" value="${ei.image_degree }" class="INPUT_STYLE2" readonly="readonly"/>
				
					</td>
					<td class="TD_STYLE1">
						口才评价
					</td>
					<td class="TD_STYLE2">
					 
						 <input type="text"  name="engageInterview.nativeLanguageDegree" value="${ei.native_language_degree }" class="INPUT_STYLE2" readonly="readonly"/>
				
					</td>
					<td class="TD_STYLE1">
						外语口语能力
					</td>
					<td class="TD_STYLE1">
					 
						 <input type="text"  name="engageInterview.foreignLanguageDegree" value="${ei.foreign_language_degree }" class="INPUT_STYLE2" readonly="readonly"/>
				
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						应变能力
					</td>
					<td class="TD_STYLE2">
					 
						<input type="text"  name="engageInterview.responseSpeedDegree" value="${ei.response_speed_degree }" class="INPUT_STYLE2" readonly="readonly"/>
				
					</td>
					<td class="TD_STYLE1">
						EQ
					</td>
					<td class="TD_STYLE2"> 
						<input type="text"  name="engageInterview.eqDegree" value="${ei.eQ_degree }" class="INPUT_STYLE2" readonly="readonly"/>
				
					</td>
					<td class="TD_STYLE1">
						IQ
					</td>
					<td class="TD_STYLE2"> 
						 <input type="text"  name="engageInterview.iqDegree" value="${ei.iQ_degree }" class="INPUT_STYLE2" readonly="readonly"/>
				
					</td>
					<td class="TD_STYLE1">
						综合素质
					</td>
					<td class="TD_STYLE1">
					 <input type="text"  name="engageInterview.multiQualityDegree" value="${ei.multi_quality_degree }" class="INPUT_STYLE2" readonly="readonly"/>
				
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						面试人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="engageInterview.register" value="${ei.register }" class="INPUT_STYLE2"/>
					</td>
					<td class="TD_STYLE1">
						面试时间
					</td>
					<td class="TD_STYLE2"> 
					<input type="text" name="engageInterview.registeTime" value="${ei.registe_time }" class="INPUT_STYLE2"/>
						  
					</td>
					<td class="TD_STYLE1">
						筛选人
					</td>
					<td class="TD_STYLE2">
					 <input type="text" id="shaixuan" name="checker" value="${loginUser.user_true_name }" class="INPUT_STYLE2" readonly="readonly"/>
				 
					</td>
					<td class="TD_STYLE1">
						筛选时间
					</td>
					<td class="TD_STYLE2"> 
				  	<input type="text" name="check_time"
							  id="nowTime" readonly="readonly"
							class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						录用申请审核意见
					</td>
					<td class="TD_STYLE2" colspan="7">
						<textarea name="engageResume.passCheckcomment" class="TEXTAREA_STYLE1"
							rows="4" readonly="readonly" id="passCheckcomment">${er.pass_checkComment }</textarea>
					</td>
				</tr>
			</table>
		</form>

</body>
</html>