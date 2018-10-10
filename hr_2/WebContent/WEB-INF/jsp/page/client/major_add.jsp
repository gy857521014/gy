<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
		<link rel="stylesheet"href="../css/table.css" type="text/css"></link>
		<script type="text/javascript"src="../javascript/comm/comm.js"></script>
		<script type="text/javascript" src="../javascript/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="../javascript/jquery.messager.js"></script>
		<script type="text/javascript">
		function check(){
			if(document.getElementById("mkid").value=='0'){
				$.messager.show("消息提示", "请选择职位分类名称！", 2000);
				return;
			}
			if(document.getElementById("mname").value==''){
				$.messager.show("消息提示", "请输入职位名称！", 2000);
				return;
			}
			$("#document").submit();
		}
	</script>
	</head>
	<body>
		<form action="addcm" method="post" id="document">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--职位设置--职位添加
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="提交" class="BUTTON_STYLE1" onclick="check()">
						<input type="button" value="返回" class="BUTTON_STYLE1"
							onclick="history.back();">
					</td>
				</tr>
			</table>

			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">

				<tr>
					<td width="19%" class="TD_STYLE1">
						职位分类名称
					</td>
					<td width="81%" class="TD_STYLE2">
					<select id="mkid" name="major_kind_id" onchange="change()">
						<option value='0'>请选择职位分类名称...</option>
						<c:forEach items="${cmklist }" var="c">
							<option value="${c.major_kind_id }">${c.major_kind_name }</option>
						</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1" width="19%">
						职位编号
					</td>
					<td class="TD_STYLE2" width="81%">
						<input type="hidden" name="major_id" value="${sytime }" />${sytime }
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1" width="19%">
						职位名称
					</td>
					<td class="TD_STYLE2" width="81%">
						<input id="mname" type="text" class="INPUT_STYLE1"name="major_name" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

