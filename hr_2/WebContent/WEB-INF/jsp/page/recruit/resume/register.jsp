<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
  <head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
 		function mysubmit(){  
 		if(document.getElementById("name").value==""){
 		alert("请填写姓名");
 		return false;
 		}
 		if(document.getElementById("phone").value==""){ 
	 		alert("请填写电话");
	 		return false;
 		}else if(isNaN(document.getElementById("phone").value)){
	 		alert("电话号码请填写数字");
	 		return false;
 		}
 		if(document.getElementById("card").value==""){
	 		alert("请填写身份证号码");
	 		return false;
 		} 
 		if(document.getElementById("birthday").value!=""){
	 		var str = document.getElementById("birthday").value; 
	 		var r = str.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/); 
	 		 if(r==null){
	 		 alert("请输入正确的日期格式：yyyy-MM-dd");
	 		return false;
	 		}
 		} 
 		if(document.getElementById("email").value!=""){
	 		var email=document.getElementById("email").value;
	 		if(email.indexOf(".")<=-1 || email.indexOf("@")<=-1){
	 		alert("Email格式不匹配，如：123@.com");
	 		return false;
	 		}  
 		}
 		if(document.getElementById("humanHomephone").value!=""){
	 		if(isNaN(document.getElementById("humanHomephone").value)){
	 		alert("家庭电话请填写数字");
	 		return false;
	 		}
 		}
 		if(document.getElementById("humanMobilephone").value!=""){
	 		if(isNaN(document.getElementById("humanMobilephone").value)){
	 		alert("手机请填写数字");
	 		return false;
	 		}
 		}
 		if(document.getElementById("humanAge").value!=""){
 			if(isNaN(document.getElementById("humanAge").value)){
	 		alert("年龄请填写数字");
	 		return false;
	 		}
 		}
 		if(document.getElementById("demandSalaryStandard").value!=""){
 			if(isNaN(document.getElementById("demandSalaryStandard").value)){
	 		alert("年龄请填写数字");
	 		return false;
	 		}
 		} 
 		document.fm.submit();
 		}
 		</script>
 	<script>
		function fun(){
			var pid =$("#majorKindId").val();
			$.ajax({
				url:'selzhiwei?majorid='+pid,
				type:'get',
				success:function(data){
					var cityselect=$("#majorId");
					cityselect.empty();
					cityselect.append("<option value='0'>--请选择职位名称--</option>");
					for(var i=0;i<data.length;i++){
						var eachCity=data[i];
						var id=eachCity.major_id;
						var name=eachCity.major_name;
						cityselect.append("<option value='"+id+"'>"+name+"</option>");		
						}
					}
				
				});
		
			}
	</script>
	</head>
	<body>
	<form id="recruitAction!saveEngageResume" name="fm" action="addresume" method="post" enctype="multipart/form-data">
			<input type="hidden" name="pass_checkComment" value=""/>
			<input type="hidden" name="pass_passComment" value=""/>
	 		<input type="hidden" name="engageResume.checkStatus" value="false"/>
	 		<input type="hidden" name="register" value="${loginUser.user_true_name }">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--招聘管理--简历管理--简历登记 </font>
					 
					</td>
				</tr>
				<tr>
					<td align="right">
					 
						<input type="button" value="提交" class="BUTTON_STYLE1" onclick="return mysubmit()">
						<input type="reset" value="清除" class="BUTTON_STYLE1">
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
						 <input type="hidden" value="01" id="humanMajorKindId" name="engageResume.humanMajorKindId" />
					<select name="human_major_kind_id" onchange="fun()" class="SELECT_STYLE1" id="majorKindId">
						<option value="">请选择职位分类</option>
						<c:forEach items="${kindlist }" var="list">
							<option value="${list.major_kind_id }">${list.major_kind_name }</option>
						</c:forEach>
					</select>		
					</td>
					<td class="TD_STYLE1">
						职位名称
					</td>
					<td class="TD_STYLE2" width="20%"> 
				  
					 <input type="hidden" value="02" name="engageResume.humanMajorId" />
					<select name="human_major_id" class="SELECT_STYLE1" id="majorId">
						<option value="">请选择职位名称</option>
						
					</select>
					</td>
					<td width="11%" class="TD_STYLE1">
						招聘类型
					</td>
					<td class="TD_STYLE2" colspan="2"> 
					<select name="engage_type" class="SELECT_STYLE1">
						<c:forEach items="${zhaoplist }" var="list">
							<option value="${list.attribute_name }">${list.attribute_name }</option>
						</c:forEach>
					</select>
					</td>
					<td rowspan="6" >
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						姓名
					</td>
					<td class="TD_STYLE2">
						 <input type="text"  name="human_name" id="name" class="INPUT_STYLE2"/>
					</td>
					<td class="TD_STYLE1">
						性别
					</td>
					<td class="TD_STYLE2">
						<select name="human_sex"  class="SELECT_STYLE1"><option value="男">男</option>
							<option value="女">女</option></select>
					</td>
					<td class="TD_STYLE1">
						EMAIL
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="human_email" id="email" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
					电话
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_telephone"  id="phone" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						家庭电话
					</td>
					<td class="TD_STYLE2">
					 <input type="text" name="human_homephone" id="humanHomephone" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						手机
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="human_mobilephone" id="humanMobilephone" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						住址
					</td>
					<td colspan="3" class="TD_STYLE2">
						<input type="text" name="human_address" value="" class="INPUT_STYLE2">
					</td>
					 
					<td class="TD_STYLE1">
						邮编
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="human_postcode" value="" class="INPUT_STYLE2">
					</td>
				</tr>
				 
				<tr>
					<td class="TD_STYLE1">
						国籍
					</td>
					<td class="TD_STYLE2">
					 <select name="human_nationality"   class="SELECT_STYLE1">
							<option value="">--请选择--</option> 
							<c:forEach items="${guoji }" var="glist">
								<option value="${glist.attribute_name }">${glist.attribute_name }</option>
							</c:forEach>
							
					 </select> 
					</td>
					<td class="TD_STYLE1">
						出生地
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_birthplace" value="" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						生日
					</td>
					<td width="13%" colspan="2" class="TD_STYLE2">
						<input type="text" name="human_birthday" id="birthday" class="INPUT_STYLE2"  >
					</td>
					
				</tr>
				<tr>
				<td width="11%" class="TD_STYLE1">
						民族
					</td>
					<td class="TD_STYLE2" width="14%">
				 	 <select name="human_race"   class="SELECT_STYLE1">
							<option value="">--请选择--</option> 
							<c:forEach items="${mingzu }" var="list">
								<option value="${list.attribute_name }">${list.attribute_name }</option>
							</c:forEach> 
							
					 </select>  
					</td>
					<td class="TD_STYLE1">
						宗教信仰
					</td>
					<td class="TD_STYLE2">
					   <select name="human_religion"   class="SELECT_STYLE1"> 
							
							<option value="无">无</option> 
							<c:forEach items="${zongjiao }" var="list">
								<option value="${list.attribute_name }">${list.attribute_name }</option>
							</c:forEach> 
							
					 </select>  
					</td>
					<td class="TD_STYLE1">
						政治面貌
					</td>
					<td class="TD_STYLE2" colspan="2">
					   <select name="human_party"   class="SELECT_STYLE1">
							<option value="">--请选择--</option> 
							
							<c:forEach items="${zhengzhi }" var="list">
								<option value="${list.attribute_name }">${list.attribute_name }</option>
							</c:forEach>
							
					 </select>  	  
					</td>
					
					 
				</tr>
				<tr>
				<td class="TD_STYLE1">
						身份证号码
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_idcard" value="" id="card" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						年龄
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_age" id="humanAge" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						毕业院校
					</td>
					<td class="TD_STYLE2">
						 <input type="text" name="human_college" class="INPUT_STYLE2"/>
					</td>
					
					<td class="TD_STYLE1">
						学历
					</td>
					<td class="TD_STYLE2">
					  <select name="human_educated_degree"   class="SELECT_STYLE1">
							<option value="">--请选择--</option> 
							
							<c:forEach items="${xueli }" var="list">
								<option value="${list.attribute_name }">${list.attribute_name }</option>
							</c:forEach> 
							
					 </select> 
					</td>
					
				</tr>
				<tr>
				<td class="TD_STYLE1">
						教育年限
					</td>
					<td class="TD_STYLE2">
					   <select name="human_educated_years"   class="SELECT_STYLE1">
							<option value="">--请选择--</option> 
							
							<c:forEach items="${jiaoyv }" var="list">
								<option value="${list.attribute_name }">${list.attribute_name }</option>
							</c:forEach>
							
					 </select> 
					</td>
					<td class="TD_STYLE1">
						学历专业
					</td>
					<td class="TD_STYLE2">
					   <select name="human_educated_major"   class="SELECT_STYLE1">
							<option value="">--请选择--</option> 
							
							<c:forEach items="${zhuanye }" var="list">
								<option value="${list.attribute_name }">${list.attribute_name }</option>
							</c:forEach> 
							
					 </select>  
					</td>
					
					<td class="TD_STYLE1">
						薪酬要求
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="demand_salary_standard" id="demandSalaryStandard" class="INPUT_STYLE2" />
					</td>
					<td class="TD_STYLE1">
						注册时间
					</td>
					<td class="TD_STYLE2">
						 <input type="text" name="regist_time"
							  id="nowTime" readonly="readonly"
							class="INPUT_STYLE2">
					</td>
					
				</tr>
				<tr>
					 
					<td class="TD_STYLE1">
						特长
					</td>
					<td class="TD_STYLE2">
					   <select name="human_specility"   class="SELECT_STYLE1">
							<option value="">--请选择--</option> 
							
							<c:forEach items="${techang }" var="list">
								<option value="${list.attribute_name }">${list.attribute_name }</option>
							</c:forEach>
							
					 </select> 
						 
					</td>
					<td class="TD_STYLE1">
						爱好
					</td>
					<td class="TD_STYLE2">
				     <select name="human_hobby"   class="SELECT_STYLE1">
							<option value="">--请选择--</option> 
							
							<c:forEach items="${aihao }" var="list">
								<option value="${list.attribute_name }">${list.attribute_name }</option>
							</c:forEach>
							
					 </select> 
						  
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
						个人履历
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="human_history_records" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
				 
				<tr>
					<td class="TD_STYLE1">
						备注
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="remark" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
			</table>
		 </form>




	</body>
 
</html>

