<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>My JSP 'resume-details.jsp' starting page</title>
		 <link rel="stylesheet"
			href="../css/table.css" type="text/css">
		<link rel="stylesheet"
			href="../css/cwcalendar.css" type="text/css">
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
		<script type="text/javascript">
 			window.onload=check;
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
		  	document.getElementById("nowTime").value=now.getFullYear()+"-"+(now.getMonth()+1)+"-"+now.getDate()+" "+timeString;
			window.setTimeout("tick();", 1000);
		}
		
		//load事件
		function check(){
			//获得系统当前时间的方法
		  	tick();					
		}
 		</script>
 		<script type="text/javascript">
 		function search(){
 		document.getElementById("checkTime").value = document.getElementById("nowTime").value;  
        document.humanfileForm.submit();
 		}
 		</script>
	</head>

	<body>
		<form name="humanfileForm" method="post" action="tuijianre">
			<input type="hidden" name="res_id" value="${resume.res_id}"/>	
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--招聘管理--简历管理--简历筛选--简历筛选编辑
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="submit" value="推荐" class="BUTTON_STYLE1" onclick=search();>
						<input type="button" value="返回" class="BUTTON_STYLE1"
							onclick=history.back();>
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1">
						职位分类
					</td>
					<td class="TD_STYLE2">

						<select name="human_major_kind_id" onchange="fun()" id="majorKindId">
							
							<c:forEach items="${kindlist }" var="list">
								<c:if test="${resume.human_major_kind_id==list.major_kind_id }">
									<option value="${list.major_kind_id }" selected>${list.major_kind_name }</option>
								</c:if>
								<c:if test="${resume.human_major_kind_id!=list.major_kind_id }">
									<option value="${list.major_kind_id }">${list.major_kind_name }</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						职位名称
					</td>
					<td class="TD_STYLE2" width="20%">
						<select name="human_major_id">
						
							<c:forEach items="${majorlist }" var="mlist">
								<c:if test="${resume.human_major_id==mlist.major_id }">
									<option value="${mlist.major_id }" selected>${mlist.major_name }</option>
								</c:if>
								<c:if test="${resume.human_major_id!=mlist.major_id }">
									<option value="${mlist.major_id }">${mlist.major_name }</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
					<td width="11%" class="TD_STYLE1">
						招聘类型
					</td>
					<td class="TD_STYLE2" colspan="2">
						<select name="engage_type" class="SELECT_STYLE1">
							
							<c:forEach items="${zhaoplist }" var="zhlist">
								<c:if test="${zhlist.attribute_name==resume.engage_type }">
									<option value="${zhlist.attribute_name}" selected>${zhlist.attribute_name }</option>
								</c:if>
								<c:if test="${zhlist.attribute_name!=resume.engage_type }">
									<option value="${zhlist.attribute_name}">${zhlist.attribute_name }</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
					<td rowspan="6">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						姓名
					</td>
					<td class="TD_STYLE2">
						<input type="text"
							value="${resume.human_name }"
							name="human_name" class="INPUT_STYLE2" />
					</td>
					<td class="TD_STYLE1">
						性别
					</td>
					<td class="TD_STYLE2">
						<select name="human_sex" class="SELECT_STYLE1">
							<c:if test="${resume.human_sex=='男' }">
								<option value="男" selected>男</option>
								<option value="女">女</option>
							</c:if>
							
							<c:if test="${resume.human_sex=='女' }">
								<option value="男" >男</option>
								<option value="女" selected>女</option>
							</c:if>
						</select>
					</td>
					<td class="TD_STYLE1">
						EMAIL
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="human_email"
							value="${resume.human_postcode }"
							class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						电话
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_telephone"
							value="${resume.human_telephone }"
							class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						家庭电话
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_homephone"
							value="${resume.human_homephone }"
							class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						手机
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="human_mobilephone"
							value="${resume.human_mobilephone }"
							class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						住址
					</td>
					<td colspan="3" class="TD_STYLE2">
						<input type="text" name="human_address"
							value="${resume.human_address }"
							class="INPUT_STYLE2">
					</td>

					<td class="TD_STYLE1">
						邮编
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="human_postcode"
							value="${resume.human_postcode }"
							class="INPUT_STYLE2">
					</td>
				</tr>

				<tr>
					<td class="TD_STYLE1">
						国籍
					</td>
					<td class="TD_STYLE2">
						<select name="human_nationality" class="SELECT_STYLE1">
							<c:forEach items="${guoji }" var="guoji">
								<c:if test="${guoji.attribute_name==resume.human_nationality }">
									<option value="${guoji.attribute_name }" selected>${guoji.attribute_name}</option>
								</c:if>
								<c:if test="${guoji.attribute_name!=resume.human_nationality }">
									<option value="${guoji.attribute_name }">${guoji.attribute_name}</option>
								</c:if>
							</c:forEach>
							
						</select>
					</td>
					<td class="TD_STYLE1">
						出生地
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_birthplace"
							value="${resume.human_birthplace }"
							class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						生日
					</td>
					<td width="13%" colspan="2" class="TD_STYLE2">
						<input type="text" name="human_birthday"
							value="${resume.human_birthday }"
							class="INPUT_STYLE2" id="date_start">
							
							
					</td>

				</tr>
				<tr>
					<td width="11%" class="TD_STYLE1">
						民族
					</td>
					<td class="TD_STYLE2" width="14%">
						<select name="human_race" class="SELECT_STYLE1">
							<c:forEach items="${mingzu }" var="mingzu">
								<c:if test="${mingzu.attribute_name==resume.human_race }">
									<option value="${mingzu.attribute_name }" selected>${mingzu.attribute_name}</option>
								</c:if>
								<c:if test="${mingzu.attribute_name!=resume.human_race }">
									<option value="${mingzu.attribute_name }">${mingzu.attribute_name}</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						宗教信仰
					</td>
					<td class="TD_STYLE2">
						<select name="human_religion" class="SELECT_STYLE1">
							
							<c:forEach items="${zongjiao }" var="zongjiao">
								<c:if test="${zongjiao.attribute_name==resume.human_religion }">
									<option value="${zongjiao.attribute_name }" selected>${zongjiao.attribute_name}</option>
								</c:if>
								<c:if test="${zongjiao.attribute_name!=resume.human_religion }">
									<option value="${zongjiao.attribute_name }">${zongjiao.attribute_name}</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						政治面貌
					</td>
					<td class="TD_STYLE2" colspan="2">
						<select name="human_party" class="SELECT_STYLE1">
							<option value="01">aaa</option>
							<option value="02">bbb</option>
						</select>
					</td>

				</tr>
				<tr>
					<td class="TD_STYLE1">
						身份证号码
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_idcard"
							value="${resume.human_idcard }"
							class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						年龄
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_age"
							value="${resume.human_age }"
							class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						毕业院校
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_college"
							value="${resume.human_college }"
							class="INPUT_STYLE2" />
					</td>

					<td class="TD_STYLE1">
						学历
					</td>
					<td class="TD_STYLE2">
						<select name="human_educated_degree"
							class="SELECT_STYLE1">
							<c:forEach items="${xueli }" var="xueli">
								<c:if test="${xueli.attribute_name==resume.human_educated_degree }">
									<option value="${xueli.attribute_name }" selected>${xueli.attribute_name}</option>
								</c:if>
								<c:if test="${xueli.attribute_name!=resume.human_educated_degree }">
									<option value="${xueli.attribute_name }">${xueli.attribute_name}</option>
								</c:if>
							</c:forEach>
						</select>
					</td>

				</tr>
				<tr>
					<td class="TD_STYLE1">
						教育年限
					</td>
					<td class="TD_STYLE2">
						<select name="human_educated_years"
							class="SELECT_STYLE1">
							<c:forEach items="${jiaoyv }" var="jiaoyv">
								<c:if test="${jiaoyv.attribute_name==resume.human_educated_years }">
									<option value="${jiaoyv.attribute_name }" selected>${jiaoyv.attribute_name}</option>
								</c:if>
								<c:if test="${jiaoyv.attribute_name!=resume.human_educated_years }">
									<option value="${jiaoyv.attribute_name }">${jiaoyv.attribute_name}</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						学历专业
					</td>
					<td class="TD_STYLE2">
						<select name="human_educated_major"
							class="SELECT_STYLE1">
							<c:forEach items="${zhuanye }" var="zhuanye">
								<c:if test="${zhuanye.attribute_name==resume.human_educated_major }">
									<option value="${zhuanye.attribute_name }" selected>${zhuanye.attribute_name}</option>
								</c:if>
								<c:if test="${zhuanye.attribute_name!=resume.human_educated_major }">
									<option value="${zhuanye.attribute_name }">${zhuanye.attribute_name}</option>
								</c:if>
							</c:forEach>
						</select>
					</td>

					<td class="TD_STYLE1">
						薪酬要求
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="demand_salary_standard"
							value="${resume.demand_salary_standard }"
							class="INPUT_STYLE2" />
					</td>
					<td class="TD_STYLE1">
						注册时间
					</td>
					<td class="TD_STYLE2">
					<input type="hidden" value="${resume.regist_time }" name="regist_time">
					 	
					</td>

				</tr>
				<tr>

					<td class="TD_STYLE1">
						特长
					</td>
					<td class="TD_STYLE2">
						<select name="human_specility" class="SELECT_STYLE1">
							<c:forEach items="${techang }" var="techang">
								<c:if test="${techang.attribute_name==resume.human_specility }">
									<option value="${techang.attribute_name }" selected>${techang.attribute_name}</option>
								</c:if>
								<c:if test="${techang.attribute_name!=resume.human_specility }">
									<option value="${techang.attribute_name }">${techang.attribute_name}</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						爱好
					</td>
					<td class="TD_STYLE2">
						<select name="human_hobby" class="SELECT_STYLE1">						
							<c:forEach items="${aihao }" var="aihao">
								<c:if test="${aihao.attribute_name==resume.human_hobby }">
									<option value="${aihao.attribute_name }" selected>${aihao.attribute_name}</option>
								</c:if>
								<c:if test="${aihao.attribute_name!=resume.human_hobby }">
									<option value="${aihao.attribute_name }">${aihao.attribute_name}</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						推荐人
					</td>
					<td class="TD_STYLE2">
						<input type="hidden" name="pass_checker"
							value="${loginUser.user_true_name }"
							class="INPUT_STYLE2" />

					</td>
					<td class="TD_STYLE1">
						推荐时间
					</td>
					<td class="TD_STYLE2">
					<input type="text" name="pass_check_time"
							  id="nowTime" readonly="readonly" value=""
							class="INPUT_STYLE2">
						 
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						个人履历
					</td> 
					<td colspan="7" class="TD_STYLE2">
						<textarea name="human_history_records" rows="4" readonly="readonly"
							 class="TEXTAREA_STYLE1">${resume.human_history_records }
						</textarea>
					</td>
				</tr>

				<tr>
					<td class="TD_STYLE1">
						备注
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="remark" rows="4" readonly="readonly"
							class="TEXTAREA_STYLE1">${resume.remark }
						</textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						推荐意见
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="recomandation" rows="4"
							class="TEXTAREA_STYLE1">
						</textarea>
					</td>
				</tr>
			</table>
		</form>
	</body>
	 
</html>


