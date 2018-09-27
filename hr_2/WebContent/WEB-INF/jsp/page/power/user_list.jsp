<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户管理</title>
		<link rel="stylesheet"
			href="../css/table.css" type="text/css"/>
		<script type="text/javascript">
			function doDelete(id) {
				if (confirm("确定删除此用户吗？")) {
					location.href = "success.html?users.userId=" + id;
				}
			}
		</script>
	</head>
	<body>
		<table width="100%">
			<tr>
				<td>
					<font color="black">您正在做的业务是：人力资源--权限管理--用户管理 </font>
				</td>
			</tr>
			<tr>
				<td>
					当前角色总数：6例
				</td>
			</tr>
			<tr>
				<td align="right">
					<input type="button" value="添加用户" class="BUTTON_STYLE1" onclick="location.href='queryUr'">
				</td>
			</tr>
		</table>
		<table width="100%" border="1" cellpadding=5 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
			<tr class="TR_STYLE1">
				<td class="TD_STYLE1">
					用户编号
				</td>
				<td class="TD_STYLE1">
					用户名称
				</td>
				<td class="TD_STYLE1">
					真实姓名
				</td>
				<td class="TD_STYLE1">
					用户密码
				</td>
				<td class="TD_STYLE1">
					用户身份
				</td>
				<td class="TD_STYLE1">
					操作
				</td>
			</tr>
			
			<c:forEach items="${userList }" var="user">
				<tr class="TR_STYLE2">
					<td class="TD_STYLE2">
						${user.userid }
					</td>
					<td class="TD_STYLE2">
						${user.user_name }
					</td>
					<td class="TD_STYLE2">
						${user.user_true_name }
					</td>
					<td class="TD_STYLE2">
						${user.user_password }
					</td>
					<td class="TD_STYLE2">
						<c:forEach items="${user.urole }" var="ur">
						${ur.urole_name }
						</c:forEach>
					</td>
					<td class="TD_STYLE2">
						<img src="../images/bt_edit.gif" title="编辑" style="cursor:pointer;" onclick="location.href='user_edit.html'"/>
						<img src="../images/bt_del.gif" title="删除" style="cursor:pointer;" onclick="doDelete(9)"/>
					</td>
				</tr>
			</c:forEach>

		</table>
		<p style="text-align:center;">
			
				<a href="user_list.html" style="color:black;">首页</a>
				
				
					 
						 
						    <font color="red">1</font> 
						 
						 
					 
				
				 
	     		<a href="user_list.html" style="color:black;">尾页</a> 
	     	
		</p>
	</body>
</html>
