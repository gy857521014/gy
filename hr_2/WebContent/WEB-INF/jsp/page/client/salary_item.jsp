<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
		<link rel="stylesheet" href="../css/table.css" type="text/css"></link>
		<script type="text/javascript" src="../javascript/comm/comm.js"></script>
		<script type="text/javascript" src="../javascript/jquery-1.7.2.js"></script>
		<script type="text/javascript">
		function ajaxDelete(pbc_id){
			$.ajax({
				url:'deletecpc?pbc_id='+pbc_id,
				type:'get',
				success:
					$("#"+pbc_id).remove()
			});
		}
		</script>
</head>
	<body>
		<form action="toxcadd" method="post">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--客户化设置--薪酬管理设置--薪酬项目设置
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="submit" value="添加" class="BUTTON_STYLE1"
							onclick="window.location.href='salary_item_register.html'">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr height="20">
					<td width="80%" class="TD_STYLE1" align="center">
						薪酬项目名称
					</td>
					<td width="20%" class="TD_STYLE1" align="center">
						删除
					</td>
				</tr>
				<c:forEach items="${xclist }" var="c">
					<tr id="${c.pbc_id }" height="20">
						<td class="TD_STYLE2">
						${c.attribute_name }
						</td>
						<td  align="center" class="TD_STYLE2">
							<a href="javascript:ajaxDelete(${c.pbc_id })">删除</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<br>
			<br>
			<th colspan="7" class="pager">
				
			</th>
		</form>
	</body>
</html>
