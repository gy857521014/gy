﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html public "-//w3c//dtd html 4.01 transitional//en"
"http://www.w3.org/tr/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>hr_middle</title>
		<style type="text/css">
			body {
				background-color:white;
				background-image: url(../images/11041R35400-19.jpg);
				background-repeat:no-repeat;
				background-position:130% 0;
				margin-left: 20px;
				margin-top: 20px;
			}
		</style>
		<script type="text/javascript"
			src="../javascript/jquery-1.7.2.js">
		</script>
		<script type="text/javascript"
			src="../javascript/jquery.messager.js">
		</script>
		<script type="text/javascript">
			$(function() {
				$.messager.show("<font style='font-family:宋体;'>消息提示","欢迎你：<c:forEach items='${loginUser.urole }' var='ur'>${ur.urole_name }</c:forEach>(${loginUser.user_true_name })！</font>",2000);
			});
		</script>
	</head>
	<body>
	</body>
</html>
