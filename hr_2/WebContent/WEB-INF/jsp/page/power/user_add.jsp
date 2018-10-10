<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>添加用户</title>
		<link rel="stylesheet"
			href="../css/table.css" type="text/css"/>
		<script type="text/javascript" src="../javascript/jquery-1.7.2.js"></script>
		<script type="text/javascript"
			src="../javascript/jquery.messager.js"></script>
		<script type="text/javascript" src="../javascript/user_add.js"></script>
		<script type="text/javascript">
		function byName() {
			//判断手机号
			var userName = $("#userName").val();
			var uroleid = $("#uroleid").val();
			if(uroleid==null){
				$.messager.show("消息提示", "请选择角色!", 2000);
			}
			if(uroleid!=null){
			$.ajax({
				url:"by_name?user_name=" + userName,
				type:'get',
				success:function(data){
					$("#count").val(data);
					if(data!=0){
						$.messager.show("消息提示", "该用户名以存在!", 2000);
					}
					if(data==0){
						$("#bc").submit();
					}
				}
			});
		}
	}
		</script>
	</head>
	<body>
		<form method="post" action="userAdd" id="bc">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--权限管理--添加用户</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="保存" class="BUTTON_STYLE1" onclick="byName()"/>
						<input type="button" value="返回" class="BUTTON_STYLE1"
							onclick="history.back()">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=3 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1">用户名称</td>
					<td class="TD_STYLE2">
						<input type="text" id="userName" name="user_name"/>
					</td>
					<td class="TD_STYLE1">用户密码</td>
					<td class="TD_STYLE2">
						<input type="text" id="userPassword" name="user_password"/>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">真实姓名</td>
					<td class="TD_STYLE2">
						<input type="text" id="userTrueName" name="user_true_name"/>
					</td>
					<td class="TD_STYLE1">用户身份</td>
					<td class="TD_STYLE2">
						<select name="userIds" multiple="multiple" id="uroleid">
							<c:forEach items="${urList }" var="ur">
								<option value="${ur.uroleid }">${ur.urole_name }-${ur.uroleid }</option>
							</c:forEach>	
						</select>
					</td>
				</tr>
			</table>
			<input type="hidden" id="count"  />
		</form>
	</body>
</html>
