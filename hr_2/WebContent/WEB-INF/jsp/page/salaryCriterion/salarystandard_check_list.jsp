<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="../css/table.css" type="text/css" />
	<script type="text/javascript" src="../javascript/jquery-1.7.2.js"></script>
	<title>无标题文档</title>
	<style type="text/css">
<!--
.style3 {
	color: #0000CC
}
-->
</style>
</head>
<body>
	<form method="post"
		action="tosalarystandard_check_listtz">
		<table width="100%">
			<tr>
				<td><font color="black">您正在做的业务是:人力资源管理--薪酬标准管理--薪酬标准登记复核</font>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>当前等待复核的薪酬标准总数: ${li} 例</td>
			</tr>
		</table>
		<table width="100%" border="1" cellpadding=0 cellspacing=1
			bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
			<tr>
				<td width="18%" class="TD_STYLE1"><span>薪酬标准编号</span></td>
				<td width="19%" class="TD_STYLE1"><span>薪酬标准名称</span></td>
				<td width="16%" class="TD_STYLE1"><span>制定人</span></td>
				<td width="30%" class="TD_STYLE1"><span>登记时间</span></td>
				<td width="13%" class="TD_STYLE1">薪酬总额</td>
				<td width="4%" class="TD_STYLE1">复核</td>
			</tr>

			<c:forEach items="${ss }" var="ss">
				<tr class="TD_STYLE2">
					<td>${ss.standard_id}</td>
					<td>${ss.standard_name}</td>
					<td>${ss.designer}</td>
					<td>${ss.regist_time}</td>
					<td>&nbsp; ${ss.salary_sum}</td>
					<td><a href="tosalarystandard_check?standard_id=${ss.standard_id}">复 核</a></td>
				</tr>
			</c:forEach>




		</table>


		<html>
<head>
</head>
<body>
	<p>
		<div align="center" style="font-size: 18px; color: gray">
			&nbsp;&nbsp;总数： <font style="color: maroon;font-weight: bold;">${li}</font>
			例 &nbsp;&nbsp;&nbsp; 每页显示 <font
				style="color: maroon;font-weight: bold;">10</font> 条
			&nbsp;&nbsp;&nbsp; 当前第 <font style="color: maroon;font-weight: bold;">${start}</font>
			页 &nbsp;&nbsp;&nbsp;共 <font style="color: maroon;font-weight: bold;">${total}</font>
			页 <a style="color: navy; font-weight: bold"
				href="tosalarystandard_check_list">首页</a> <a
				style="color: navy; font-weight: bold" href="javascript:doPageup(${start})">上一页</a>

			<a style="color: navy; font-weight: bold" href="javascript:doPagedown(${start})">下一页</a>

			<a style="color: navy; font-weight: bold" href="tosalarystandard_check_listwy">末页</a>
			&nbsp;&nbsp;&nbsp;跳到第 <input id="page" type=text value="${start}" class=input1
				size=1 name="pages" > 页&nbsp;&nbsp; <input type="image"
				onclick="dopagebybutton(${total})" src="../images/go.bmp" width=18 height=18
				border=0 > <input type="hidden" 
					id="startpage" value="1">
		</div>
		<script type="text/javascript">
			function dopagebybutton(totalPage) {
				var inputPage = document.getElementById("page").value;
				var reg = /^[0-9]*[1-9][0-9]*$/;
				if (reg.test(document.getElementById("page").value)&&(inputPage<(totalPage+1))&&(inputPage!=0)) {
					document.getElementById("startpage").value = document
							.getElementById("page").value;
				} else {
					alert("您的输入有误");
					document.getElementById("page").value = document
							.getElementById("startpage").value;
				}
				document.forms[0].submit();

			}
			function doPageup(startsize) {
				document.getElementById("startpage").value = startsize;
				document.forms[0].submit();
				if(${start!=1}){
					location.href="tosalarystandard_check_listup?start="+${start}
				}else{
					alert("已经是首页");
					location.href="tosalarystandard_check_list";
				}
			}
			
			function doPagedown(startsize) {
				document.getElementById("startpage").value = startsize;
				document.forms[0].submit();
				if(${start}!=${total}){
					location.href="tosalarystandard_check_listdown?start="+${start}
				}else{
					alert("已经是末页");
					location.href="tosalarystandard_check_listwy";
				}
			}
			
			
		</script>
</body>
		</html>


	</form>

</body>
</html>

