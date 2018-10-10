<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			src="../javascript/comm/time.js">
			</script>
<script type="text/javascript" src="../js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
 function email(){
	 var eid = $("#eid").val();
	 var human_name=$("#human_name").val();
	 $.ajax({
		url:'emailselid?id='+eid,
		type:'get',
		success:function(data){
				var emailSel=$("#mcontent");		
				var emailName=data;
				var emailId=emailName.mid;
				var name =emailName.mcontent;
				var name1 = name.replace('name',human_name);
				emailSel.val(name1);
		}	
	 });
 }
</script>
 	</head>
	<body>
		<form name="humanfileForm" method="post" action="sendEmailMa2" >
		<input type="hidden" name="human_name" id="human_name" value="${resume.human_name }">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--面试管理--面试结果登记--发送电子邮件 </font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="submit"  value="发送"  class="BUTTON_STYLE1" 
						  >
						<input type="reset" value="清除" class="BUTTON_STYLE1">
					</td>
				</tr>
			</table>
			<table>
			<tr>
				<td width="13%" class="TD_STYLE1">
						发送者电子邮件
					</td>
				<td>
					<input  type="text" name="senderEmail" value="2644736006@qq.com" class="INPUT_STYLE2" >
				</td>
		</tr>
			<tr>
				<td width="11%" class="TD_STYLE1">
						电子邮件
					</td>
				<td>
					<input  type="text" name="human_email" class="INPUT_STYLE2" value="${resume.human_email }">
				</td>
		</tr>
		<tr>
					<td width="13%" class="TD_STYLE1">
						电子邮件题目
					</td>
					<td class="TD_STYLE2" colspan="2">
					<select name="emailTitle" id="eid" onchange="email()" class="SELECT_STYLE1"> 
							<option value="">--请选择--</option> 
							<c:forEach items="${elist }" var="elist">
								<option value="${elist.mid  }">${elist.mhead }</option> 
							</c:forEach>
					</select>
				</tr>
					<tr>
					<td class="TD_STYLE1">
						电子邮箱内容
					</td>
					<td class="TD_STYLE2" colspan="8">
						<textarea name="eidaa" id="mcontent" rows="4"  cols="100" class="TEXTAREA_STYLE1"></textarea>
					</td>
					 
				</tr>
			</table>
		</form>
</body>
</html>