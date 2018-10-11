<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="../css/table.css" type="text/css" />
		<title>无标题文档</title>
		<style type="text/css">
		<!--
		.style3 {color: #0000CC}
		td{text-align: center}
		-->
		</style>
	</head>

	<body>
	<form action="/HR_Fist/salaryGrant/salaryGrantAction!toQueryListByPage">
			<table width="100%">
				<tr>
					<td style="text-align:left;">
						<font color="black">您正在做的业务是:人力资源管理--薪酬发放管理--薪酬发放查询</font>
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="20%" class="TD_STYLE1">
						<span>薪酬编号</span>
					</td>
					<td width="15%" class="TD_STYLE1">
						<span>I级机构名称</span>
					</td>
					<td width="15%" class="TD_STYLE1">
						<span>II级机构名称</span>
					</td>
					<td width="15%" class="TD_STYLE1">
						<span>III级机构名称</span>
					</td>
					<td width="10%" class="TD_STYLE1">
						<span>人数</span>
					</td>
					<td width="20%" class="TD_STYLE1">
						基本薪酬总额(元)
					</td>
				
				</tr>
				
				<c:forEach items="${sglist }" var="sg">
					<tr class="TD_STYLE2">
						<td>
							${sg.salary_grant_id }
						</td>
						<td>
							${sg.first_kind_name }
						</td>
						<td>
							<c:if test="${not empty sg.second_kind_name }">
							${sg.second_kind_name }
							</c:if>
						</td>
						<td>
							<c:if test="${not empty sg.third_kind_name }">
							${sg.third_kind_name }
							</c:if>
						</td>
						<td>
							${sg.human_amount }
						</td>
						<td>
							${sg.salary_standard_sum }
						</td>
						 
					</tr>
				 	</c:forEach>		
			</table>
			
			
<html>
  <head>  
  </head>  
  <body>
   
			<script type="text/javascript">
function dopagebybutton() {
	var reg = /^[0-9]*[1-9][0-9]*$/;
	if (reg.test(document.getElementById("page").value)) {
		document.getElementById("startpage").value= document.getElementById("page").value;
	} else {
		alert("您的输入有误");
		document.getElementById("page").value = document.getElementById("startpage").value;
	}
	document.forms[0].submit();
	
}
function doPage(startsize) {
	document.getElementById("startpage").value =startsize;
	document.forms[0].submit();
	 
}
</script>
   
   
  </body>
</html>
 
			
			
			
			</form>
				 

	</body>
</html>

