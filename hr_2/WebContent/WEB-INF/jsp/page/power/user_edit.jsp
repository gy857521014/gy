<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>编辑用户</title>
		<link rel="stylesheet"
			href="../css/table.css" type="text/css"/>
		<script type="text/javascript" src="../javascript/jquery-1.7.2.js"></script>
		<script type="text/javascript"
			src="../javascript/jquery.messager.js"></script>
		<script type="text/javascript" src="../javascript/user_add.js"></script>
	</head>
	<body>
		<form id="powerAction!doModifyUser" name="powerAction!doModifyUser" action="userUpdate?userid=${user.userid }" method="post">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--权限管理--编辑用户</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="submit" id="powerAction!doModifyUser_0" value="&#20445;&#23384;" class="BUTTON_STYLE1"/>

						<input type="button" value="返回" class="BUTTON_STYLE1"
							onclick="history.back()">
						<input type="hidden" value="${start }" name="start" />
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=3 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1">用户名称</td>
					<td class="TD_STYLE2">
						${user.user_name }
						<input type="hidden" name="users.userId" value="1015"/>
					</td>
					<td class="TD_STYLE1">用户密码</td>
					<td class="TD_STYLE2">
						<input type="text" value="${user.user_password }" id="userPassword" name="user_password"/>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">真实姓名</td>
					<td class="TD_STYLE2">
						<input type="text" value="${user.user_true_name }" id="userTrueName" name="user_true_name"/>
					</td>
					
					<td class="TD_STYLE1">用户身份</td>
					<td class="TD_STYLE2">
					
						<select name="uroleid" id="powerAction!doModifyUser_users_sysRole_roleId" multiple="multiple">
						   	<!-- 所有角色 -->
						   	<c:forEach items="${urList }" var="urs">
						   				<option style="width: 80px" <c:if test="${urs.check == 1 }">selected="selected"</c:if> value="${urs.uroleid }">
						   					<c:forEach items="${loginUser.rq }" var="rqs">
												<c:if test="${rqs.q_id==8}">
						   							${urs.urole_name }
						   						</c:if>
											</c:forEach>
						   				</option>
						   	</c:forEach>
						</select>
					</td>
					
					
				</tr>
			</table>
		</form>




	</body>
</html>
