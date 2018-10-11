<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>My JSP 'valid-resume.jsp' starting page</title>
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
<script type="text/javascript">
function search(){ 
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
		<form id="recruitAction!findEngageResume?a=valid" name="humanfileForm" action="selresume2" method="post">
			<input type="hidden" name="engageResume.humanMajorKindName"
				id="majorKindName" />
			<input type="hidden" name="engageResume.humanMajorName"
				id="majorName" /> 
			<input type="hidden" name="engageResume.checkStatus"
				  value="true" /> 
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--招聘管理--简历查询--有效简历查询</font>
					</td>
				</tr>
				<tr>
					<td align="right">

						<input type="button" value="开始" class="BUTTON_STYLE1"
							onclick= search();  >
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">

				<tr>
					<td class="TD_STYLE1" width="30%">
						请选择职位分类
					</td>
					<td class="TD_STYLE2" width="30%">
					<select name="majorkind" onchange="fun()" id="majorKindId" multiple="multiple" style="width: 290;height: 100"
							 id="majorKindId"  class="SELECT_STYLE2"> 
						<option value="">--请选择--</option>
					
						<c:forEach items="${kindlist }" var="list">
							<option value="${list.major_kind_id}">${list.major_kind_name }</option>
						</c:forEach>
					 </select>
						<select name="major" id="majorId" multiple="multiple"  style="width: 290;height: 100"
							 id="majorId" size="5"
							class="SELECT_STYLE2">
							<option>
								--请选择--
							</option>
						</select>
 
					</td>
				</tr>

				<tr>
					<td class="TD_STYLE1" width="30%">
						请输入关键字
					</td>
					<td width="84%">
						<input type="text" name="primarKey" value=""
							class="INPUT_STYLE2" />
					</td>
				</tr>

				<tr>
					<td class="TD_STYLE1" width="30%">
						请输入登记时间
					</td>
					<td width="84%" class="TD_STYLE2">
					<input type="hidden" name="datePropertyName" value="registTime"/>
						 
						<input type="text" name="startDate"   onclick="aa('startDate')" 
							style="width: 14%" class="INPUT_STYLE2">
						至
						<input type="text" name="endDate" 
							style="width: 14%" class="INPUT_STYLE2" onclick="aa('endDate')">
						（YYYY-MM-DD）
					</td>
				</tr>
			</table>
		</form>




	</body>
	 
</html>