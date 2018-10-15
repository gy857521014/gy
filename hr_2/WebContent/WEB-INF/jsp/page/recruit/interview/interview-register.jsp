<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My JSP 'interview-register.jsp' starting page</title>
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
			src="../javascript/select.js">
	
</script>
			<script type="text/javascript"
			src="../javascript/comm/time.js">
			</script>
			<script type="text/javascript"
			src="../javascript/jquery.messager.js">
			</script>

 	   <script type="text/javascript">
        function myfunction()
		{
    		
			if(document.getElementById("mshren").value.trim()<1||document.getElementById("mshren").value.trim().length>10)
			{
				$.messager.show("消息提示", "请输入面试人!", 1000);
				document.getElementById("mshren").focus();
				return false;    				
			}
			if(document.getElementById("shijian").value.trim()<1||document.getElementById("shijian").value.trim().length>10)
			{
				$.messager.show("消息提示", "请输入面试时间!", 1000);
				document.getElementById("shijian").focus();
				return false;    				
			}
			var riqi = /^([1][7-9][0-9][0-9]|[2][0][0-9][0-9])(\-)([0][1-9]|[1][0-2])(\-)([0-2][1-9]|[3][0-1])$/g;
			if (!riqi.test(document.getElementById("shijian").value)) {
				$.messager.show("消息提示", "请输入正确的日期格式!yyyy-MM-dd", 1000);
				document.getElementById("shijian").focus();
				return false;
			}
			// 输入的时间
				var c =document.getElementById("shijian").value;
				var inpDate = new Date(c);
				// 获取当前时间
				var now = new Date();
				if(inpDate.getTime() > now.getTime()){
					$.messager.show("消息提示", "请输入正确的面试日期(不能是今天以后)!", 1000);
					document.getElementById("shijian").focus();
					return false;
				}
			if(document.getElementById("pjia").value.trim()<1||document.getElementById("pjia").value.trim().length>50)
			{
				$.messager.show("消息提示", "请输入面试评价!", 1000);
				document.getElementById("pjia").focus();
				return false;    				
			}
			
			return true;
		}


            	
    </script>
	</head>

	<body >
		<form id="recruitAction!toList" name="interviewForm" action="interviewadd" method="post">
		<input type="hidden" name="operate" value="doAdopt">
	<!--	<input type="hidden" name="engageInterview.checkStatus" value=""/>
		<input type="hidden" name="engageInterview.checkComment" value=""/>
		  -->
		  <input type="hidden" name="engageInterview.einId" value=""/>
		<input type="hidden" name="engageInterview.result" value="完成"/>
		<input type="hidden" name="engageInterview.resumeId" value="542"/>
	    <input type="hidden" name="engageResume.resId" value="542"/>
	    <input type="hidden" name="resume_id" value="${resume.res_id }"/>
		<input type="hidden" name="engageInterview.interviewStatus" value="true"/>
			<table width="100%">
				<tr>
					<td>
						
						<font color="black">您正在做的业务是：人力资源--招聘管理--面试管理--面试结果登记  </font>
					</td>
				</tr>
				<tr>
					<td align="right">
						 <span style="color:red;display:none" id="name1">请输入面试人</span>
						 <span style="color:red;display:none" id="name2">请输入面试时间</span>
						 <span style="color:red;display:none" id="name3">请输入面试评价</span>
						<input type="submit" value="面试登记" class="BUTTON_STYLE1"
							onclick="return myfunction()">
						<input type="button" value="返回" class="BUTTON_STYLE1" 
							onclick="history.back();">
							
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1" width="10%">
						职位分类
					</td>
					<td width="10%" class="TD_STYLE2">
					<input type="hidden" name="human_major_kind_id" value="${resume.human_major_kind_id }"/>
					<input type="text" name="human_major_kind_name" value="${resume.human_major_kind_name }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td width="10%" class="TD_STYLE1">
						职位名称
					</td>
					<td width="15%" class="TD_STYLE2">
						<input type="hidden" name="human_major_id" value="${resume.human_major_id }"/>
						<input type="text" name="human_major_name" value="${resume.human_major_name }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td width="10%" class="TD_STYLE1">
						招聘类型
					</td>
					<td width="20%" class="TD_STYLE2" colspan="2">
						<input type="text" name="engage_type" value="${resume.human_major_name }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					
					<td width="10%" rowspan="6" align="center">
						 
					</td>
					
				</tr>
				
				<tr>
					<td class="TD_STYLE1">
						姓名
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_name" value="${resume.human_name }" readonly="readonly" class="INPUT_STYLE2">
						
					</td>
					<td class="TD_STYLE1">
						性别
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_sex" value="${resume.human_sex }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						EMAIL
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="human_email" value="${resume.human_email }"  readonly="readonly" class="INPUT_STYLE2">
					</td>
				</tr>

				<tr>
					<td class="TD_STYLE1">
						电话号码
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_telephone" value="${resume.human_telephone }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						家庭电话
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_homephone" value="${resume.human_homephone }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						手机
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="human_mobilephone" value="${resume.human_mobilephone }" readonly="readonly" class="INPUT_STYLE2">
					</td>
				</tr>

				<tr>
					<td class="TD_STYLE1">
						住址
					</td>
					<td colspan="3" class="TD_STYLE2">
						<input type="text" name="human_address" value="${resume.human_address }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						邮编
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="human_postcode" value="${resume.human_postcode }" readonly="readonly" class="INPUT_STYLE2">
					</td>
				</tr>

				<tr>
					<td class="TD_STYLE1">
						国籍
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_nationality" value="${resume.human_nationality }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						出生地
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_birthplace" value="${resume.human_birthplace }"  readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						生日
					</td>
					<td class="TD_STYLE2" colspan="2"> 
						<input type="text" name="human_birthday" value="${resume.human_birthday }" readonly="readonly" class="INPUT_STYLE2">
					</td>
				</tr>
				
				<tr>
					<td width="11%" class="TD_STYLE1">
						民族
					</td>
					<td class="TD_STYLE2" width="14%">
						<input type="text" name="human_race" value="${resume.human_race }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						宗教信仰
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_religion" value="${resume.human_religion }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						政治面貌
					</td>
					<td class="TD_STYLE2" colspan="2">
						<input type="text" name="human_party" value="${resume.human_party }" readonly="readonly" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>

					<td class="TD_STYLE1">
						身份证号码
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_idcard" value="${resume.human_idcard }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						年龄
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_age" value="${resume.human_age }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						毕业学校
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_college" value="${resume.human_college }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1" width="10%">
						学历
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_educated_degree" value="${resume.human_educated_degree }" readonly="readonly" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						教育年限
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_educated_years"  value="${resume.human_educated_years }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						学历专业
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_educated_major" value="${resume.human_educated_major }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						薪酬要求
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="demand_salary_standard" value="${resume.demand_salary_standard }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						注册时间
					</td>
					<td class="TD_STYLE2"> 
						<input type="text" name="regist_time" value="${resume.regist_time }" readonly="readonly" class="INPUT_STYLE2">
					
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						特长
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_specility" value="${resume.human_specility }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						爱好
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_hobby" value="${resume.human_hobby }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1"><span style="font-size: 10.5pt; font-family: 宋体;"></span> 
						推荐人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="pass_checker" value="${resume.pass_checker }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1"><span style="font-size: 10.5pt; font-family: 宋体;"></span> 
						推荐时间
					</td>
					<td class="TD_STYLE2"> 
						<input type="text" name="pass_check_time" value="${resume.pass_check_time }" readonly="readonly" class="INPUT_STYLE2">
						 
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						个人履历
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="human_history_records" rows="4"  
						class="TEXTAREA_STYLE1" readonly="readonly"> ${resume.human_history_records }
						</textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						备注
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="remark" rows="4"   class="TEXTAREA_STYLE1"  readonly="readonly"> ${resume.remark }
						</textarea>
					</td>
				</tr>
				
				<tr>
					<td class="TD_STYLE1">
						推荐意见
					</td>
					<td class="TD_STYLE2" colspan="7">
						<textarea name=recomandation rows="4"   class="TEXTAREA_STYLE1" readonly="readonly">${resume.recomandation }						</textarea>
					</td>
				</tr>
				
				
				<tr>
					<td class="TD_STYLE1">
						面试次数
					</td>
					<td class="TD_STYLE2">
					<input type="hidden" value="1" name="Engage_interview"/>
						<input type="text"   value="第1次面试" class="INPUT_STYLE2" readonly="readonly"/>
					</td>
					<td class="TD_STYLE1">
						形象评价
					</td>
					<td class="TD_STYLE2">
						<select name="image_degree" class="SELECT_STYLE1">
							<option value="80">A</option>
							<option value="60">B</option>
							<option value="50">C</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						口才评价
					</td>
					<td class="TD_STYLE2">
						<select name="native_language_degree" class="SELECT_STYLE1">
							<option value="85">A</option>
							<option value="65">B</option>
							<option value="50">C</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						外语口语能力
					</td>
					<td class="TD_STYLE1">
						<select name="foreign_language_degree" class="SELECT_STYLE1">
							<option value="85">A</option>
							<option value="65">B</option>
							<option value="50">C</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						应变能力
					</td>
					<td class="TD_STYLE2">
						<select name="response_speed_degree" class="SELECT_STYLE1">
							<option value="85">A</option>
							<option value="65">B</option>
							<option value="50">C</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						EQ
					</td>
					<td class="TD_STYLE2">
						<select name="EQ_degree" class="SELECT_STYLE1">
							<option value="90">90</option>
							<option value="80">80</option>
							<option value="70">70</option>
							<option value="60">60</option>
							<option value="50">50</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						IQ
					</td>
					<td class="TD_STYLE2">
						<select name="IQ_degree" class="SELECT_STYLE1">
							<option value="90">90</option>
							<option value="80">80</option>
							<option value="70">70</option>
							<option value="60">60</option>
							<option value="50">50</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						综合素质
					</td>
					<td class="TD_STYLE1">
						<select name="multi_quality_degree" class="SELECT_STYLE1">
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C">C</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						面试人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="register" id="mshren" value="" class="INPUT_STYLE2"/>
					</td>
					<td class="TD_STYLE1">
						面试时间
					</td>
					<td class="TD_STYLE2"> 
						<input type="text" name="registe_time" id="shijian"  onclick="aa('registe_time')"
							  class="INPUT_STYLE2"  id="date" >
						 
						
					</td>
					<td class="TD_STYLE1">
						&nbsp;
					</td>
					<td class="TD_STYLE2">
						&nbsp;
					</td>
					<td class="TD_STYLE1">
						&nbsp;
					</td>
					<td class="TD_STYLE2">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						面试评价
					</td>
					<td class="TD_STYLE2" colspan="7">
						<textarea
							name="interview_comment" class="TEXTAREA_STYLE1" id="pjia"
							rows="4"></textarea>
					</td>
				</tr>
			</table>
		</form>
</body>
</html>