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
		</script>
		<script type="text/javascript"
			src="../javascript/comm/time.js">
		</script>
		<script type="text/javascript"
			src="../javascript/jquery.messager.js">
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
 	   
 		 if(document.getElementById("firstKindId").value.trim()<1||document.getElementById("firstKindId").value.trim().length>20)	
 		  {
 			$.messager.show("消息提示", "请选择一级机构!", 1000);
 	       		return false;
 	       }
 		 
 		 if(document.getElementById("engageType").value.trim()<1||document.getElementById("engageType").value.trim().length>20)
 		  {
 			$.messager.show("消息提示", "请选择招聘类型!", 1000);

 	       return false;
 	       } 
 		 
 		 if(document.getElementById("majorKindId").value.trim()<1||document.getElementById("majorKindId").value.trim().length>20)
 		 {
 			$.messager.show("消息提示", "请选择职位分类!", 1000);
 	       return false;
 	       }  
 		 
 		  if(document.getElementById("majorId").value.trim()<1||document.getElementById("majorId").value.trim().length>20)
 		  {
 			 $.messager.show("消息提示", "请选择职位名称!", 1000);

 	       	 return false;
 	       }  
 		  
 		 if(document.getElementById("humanAmount").value<1||document.getElementById("humanAmount").value>1000)
 		  {		 
 				$.messager.show("消息提示", "请输入招聘人数!", 1000);
 	       		return false; 
 	  		}    
 		 
 		var re = /^[0-9]+.?[0-9]*$/;
		if (!re.test(document.getElementById("humanAmount").value)) {
			$.messager.show("消息提示", "请输入正确的招聘人数!", 1000);
			document.getElementById("humanAmount").focus();
			return false;
		}
 		 
			
			
 		 if(document.getElementById("date_start").value.trim()<1||document.getElementById("date_start").value.trim().length>20)	
 		  {
 			$.messager.show("消息提示", "请输入截止日期!", 1000);

 	       return false; 
 	 	 }   
 		 
 		var riqi = /^([1][7-9][0-9][0-9]|[2][0][0-9][0-9])(\-)([0][1-9]|[1][0-2])(\-)([0-2][1-9]|[3][0-1])$/g;
		if (!riqi.test(document.getElementById("date_start").value)) {
			$.messager.show("消息提示", "请输入正确的日期格式!yyyy-MM-dd", 1000);
			document.getElementById("date_start").focus();
			return false;
		}
		// 输入的时间
			var c =document.getElementById("date_start").value;
			var inpDate = new Date(c);
			// 获取当前时间
			var now = new Date();
			if(inpDate.getTime() < now.getTime()){
				$.messager.show("消息提示", "请输入正确的截止日期!(今天以后)", 1000);
				return false;
			}
 		 
 	  if(document.getElementById("zhiwei").value.trim()<1||document.getElementById("zhiwei").value.trim().length>20)
		{
 		 $.messager.show("消息提示", "请输入职位描述!", 1000);
 			document.getElementById("zhiwei").focus();
			return false;    				
		}
 	  
	  if(document.getElementById("zhp").value.trim()<1||document.getElementById("zhp").value.trim().length>20)
		{
		  $.messager.show("消息提示", "请输入招聘要求!", 1000);
		  document.getElementById("zhp").focus();
			return false;    				
			
		}
		  	document.humanfileForm.submit();
		  	return true;
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
			cityselect.append("<option value=''>--请选择职位名称--</option>");
			for(var i=0;i<data.length;i++){
				var eachCity=data[i];
				var id=eachCity.major_id;
				var name=eachCity.major_name;
				cityselect.append("<option value='"+id+"'>"+name+"</option>");		
				}
			}
		
		});

	}
	
function fun1(){
	var id =$("#firstKindId").val();
	$.ajax({
		url:'selerji?fsk_id='+id,
		type:'get',
		success:function(data){
			var cityselect=$("#secondKindId");
			cityselect.empty();
			cityselect.append("<option value=''>--请选择二级机构--</option>");
			for(var i=0;i<data.length;i++){
				var eachCity=data[i];
				var id=eachCity.second_kind_id;
				var name=eachCity.second_kind_name;
				cityselect.append("<option value='"+id+"'>"+name+"</option>");		
				}
			}
		
		});

	}

function fun2(){
	var id =$("#secondKindId").val();
	$.ajax({
		url:'selsanji?fsk_id='+id,
		type:'get',
		success:function(data){
			var cityselect=$("#thirdKindId");
			cityselect.empty();
			cityselect.append("<option value=''>--请选择三级机构--</option>");
			for(var i=0;i<data.length;i++){
				var eachCity=data[i];
				var id=eachCity.third_kind_id;
				var name=eachCity.third_kind_name;
				cityselect.append("<option value='"+id+"'>"+name+"</option>");		
				}
			}
		
		});

	}
</script>
 	</head>
	<body>
		<form name="humanfileForm" method="post" action="addrelease" >
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--招聘管理--职位发布管理--职位发布登记 </font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="提交" class="BUTTON_STYLE1" 
						  onclick="return mysubmit()">
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
						
						<select name="first_kind_id" onchange="fun1()" id="firstKindId"  class="SELECT_STYLE1"> 
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
						<select name="second_kind_id" onchange="fun2()" id="secondKindId" class="SELECT_STYLE1"> 
						<option value="">--请选择--</option>
						</select>
					</td>
					<td width="11%" class="TD_STYLE1">
						III级机构
					</td>
					<td class="TD_STYLE2"  >
						<select name="third_kind_id" id="thirdKindId" class="SELECT_STYLE1">
							<option value="">--请选择--</option>
						</select>
					</td>
					<td width="11%" class="TD_STYLE1">
						招聘类型
					</td>
					<td class="TD_STYLE2" colspan="2">
					<select name="engage_type" id="engageType" class="SELECT_STYLE1"> 
							<option value="">--请选择--</option> 
							
							<c:forEach var="zhlist" items="${zhaoplist}">
								<option value="${zhlist.attribute_name}">${zhlist.attribute_name}</option>  
							</c:forEach>
							
								 </select>
						 
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						职位分类
					</td>
					<td class="TD_STYLE2">
						<select name="major_kind_id" id="majorKindId" onchange="fun()" class="SELECT_STYLE1">
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
						<select name="major_id" id="majorId" class="SELECT_STYLE1"> 
							<option value="">--请选择--</option>
							
						</select>
					</td>
					<td class="TD_STYLE1">
						招聘人数
					</td>
					<td   class="TD_STYLE2">
						 <input type="text" name="human_amount" id="humanAmount"  class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						截止日期
					</td>
					<td   class="TD_STYLE2">
							  <input type="text" name="deadline"
							  class="INPUT_STYLE2" onclick="aa('deadline')" id="date_start">
					</td>
				</tr>
				<tr>
				<td class="TD_STYLE1">
						登记人
					</td>
					<td  class="TD_STYLE2">
						 <input type="text" name="register" value="${loginUser.user_true_name }" class="INPUT_STYLE2" readonly>
					</td>
					<td class="TD_STYLE1">
						登记时间
					</td>
					<td   class="TD_STYLE2">
					
							<input type="text" name="regist_time"
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
						<textarea name="major_describe" id="zhiwei" rows="4" cols="80" class="TEXTAREA_STYLE1"></textarea>
					</td>
					 
				</tr>
					<tr>
					<td class="TD_STYLE1">
						招聘要求
					</td>
					<td class="TD_STYLE2" colspan="8">
						<textarea name="engage_required" id="zhp" rows="4"  cols="80" class="TEXTAREA_STYLE1"></textarea>
					</td>
					 
				</tr>
				<tr>
					<td colspan="9" align="center">
						<span style="color:red;display:none" id="name">请完善资料</span>
						<span style="color:red;display:none" id="name2">请输入正确的人数</span>
					</td>
				</tr>
			</table>
		</form>
	</body>
 
</html>


