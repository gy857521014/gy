<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My JSP 'index.jsp' starting page</title>
	 
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
 	   function mysubmit(){  
 	   	document.getElementById('deadline').value = document
				.getElementById('date_start').value;
				
 	    if(document.getElementById("firstKindId").value==""){
 	       alert("请选择一级机构");
 	       return ;
 	       }
 	  if(document.getElementById("engageType").value==""){
 	       alert("请选择招聘类型");
 	       return ;
 	       } 
 	  if(document.getElementById("majorKindId").value==""){
 	       alert("请选择职位分类");
 	       return ;
 	       }    
 	   if(document.getElementById("majorId").value==""){
 	       alert("请选择职位名称");
 	       return ;
 	       }    
 	  if(document.getElementById("humanAmount").value==""){
 	   alert("请填写招聘人数");
 	       return ; 
 	  }    
 	  if(document.getElementById("date_start").value==""){
 	   alert("请选择截止日期");
 	       return ; 
 	  }   
  
		  	document.humanfileForm.submit();
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
			cityselect.append("<option>--请选择职位名称--</option>");
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
		<form name="humanfileForm" method="post" action="position_change_update.html" >
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--招聘管理--职位发布管理--职位发布登记 </font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="提交" class="BUTTON_STYLE1" 
						  onclick="mysubmit();">
						<input type="reset" value="清除" class="BUTTON_STYLE1">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1" width="11%">
						I级机构
					</td>
					<td width="14%" class="TD_STYLE2">
						
						<select name="emajorRelease.firstKindId" id="firstKindId"  class="SELECT_STYLE1"> 
						<option value="">--请选择--</option>
					
					<c:forEach var="flist" items="${firstlist}">					
						<option value="${flist.first_kind_id}">${flist.first_kind_name}</option>
					</c:forEach>
					 
					 </select>
					</td>
					<td width="11%" class="TD_STYLE1">
						II级机构
					</td>
					<td width="14%" class="TD_STYLE2">
						<select name="emajorRelease.secondKindId" id="secondKindId" class="SELECT_STYLE1"> 
						<option value="">--请选择--</option>
						</select>
					</td>
					<td width="11%" class="TD_STYLE1">
						III级机构
					</td>
					<td class="TD_STYLE2"  >
						<select name="emajorRelease.thirdKindId" id="thirdKindId" class="SELECT_STYLE1">
							<option value="">--请选择--</option>
						</select>
					</td>
					<td width="11%" class="TD_STYLE1">
						招聘类型
					</td>
					<td class="TD_STYLE2" colspan="2">
					<select name="emajorRelease.engageType" id="engageType" class="SELECT_STYLE1"> 
							<option value="">--请选择--</option> 
							
							<c:forEach var="zhlist" items="${zhaoplist}">
								<option value="${zhlist.pbc_id}" selected>${zhlist.attribute_name}</option>  
							</c:forEach>
							
								 </select>
						 
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						职位分类
					</td>
					<td class="TD_STYLE2">
						<select name="emajorRelease.majorKindId" id="majorKindId" onchange="fun()" class="SELECT_STYLE1">
							<option value="">--请选择--</option> 
							
							<c:forEach var="list" items="${kindlist}">
								<option value="${list.major_kind_id }">${list.major_kind_name }</option> 
							</c:forEach>
								 </select>
					</td>
					<td class="TD_STYLE1">
						职位名称
					</td>
					<td class="TD_STYLE2">
						<select name="emajorRelease.majorId" id="majorId" class="SELECT_STYLE1"> 
							<option value="">--请选择--</option>
							<option value="11">区域经理</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						招聘人数
					</td>
					<td   class="TD_STYLE2">
						 <input type="text" name="emajorRelease.humanAmount" id="humanAmount"  class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						截止日期
					</td>
					<td   class="TD_STYLE2">
							  <input type="text" name="item.str_startTime" readonly
							  class="INPUT_STYLE2" id="date_start">
					</td>
				</tr>
				<tr>
				<td class="TD_STYLE1">
						登记人
					</td>
					<td  class="TD_STYLE2">
						 <input type="text" name="emajorRelease.register" value="admin" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						登记时间
					</td>
					<td   class="TD_STYLE2">
					
							<input type="text" name="emajorRelease.registTime"
							  id="nowTime" readonly="readonly"
							class="INPUT_STYLE2">
					</td>
					
					<td>&nbsp; </td>
					<td>&nbsp; </td>
					<td>&nbsp; </td>
					<td>&nbsp; </td>
					
				</tr>
				<tr>
					<td class="TD_STYLE1">
						职位描述
					</td>
					<td class="TD_STYLE2" colspan="8">
						<textarea name="emajorRelease.majorDescribe" rows="4" cols="80" class="TEXTAREA_STYLE1"></textarea>
					</td>
					 
				</tr>
					<tr>
					<td class="TD_STYLE1">
						招聘要求
					</td>
					<td class="TD_STYLE2" colspan="8">
						<textarea name="emajorRelease.engageRequired" rows="4"  cols="80" class="TEXTAREA_STYLE1"></textarea>
					</td>
					 
				</tr>
			</table>
		</form>
	</body>
 
</html>


