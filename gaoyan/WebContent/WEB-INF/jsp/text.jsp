<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
	function ajaxDelete(sid){
		$.ajax({
			url:'Delstudent?sid='+sid,
			type:'get',
			success:
				$("#"+sid).remove()
			
		});
	}
</script>
</head>
<body>
	<table border="1px" cellspacing="0" align="center" width="300px" style="text-align: center; border: 1px solid red;">
		<tr>
			<td>学号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>年龄</td>
			<td>操作</td>	
		</tr>
		<c:forEach items="${stuList}" var="s">
		<tr id="${s.sid }">
			<td>${s.sid }</td>
			<td>${s.sname }</td>
			<td>${s.ssex }</td>
			<td>${s.sage }</td>
			<td>
				<a href="javascript:ajaxDelete(${s.sid })">删除</a>
				<a href="studentByid?sid=${s.sid }">修改</a>
			</td>
		</tr>
		</c:forEach>
	</table>
		<center>
			<a href="toAdd">添加</a>
		</center>
</body>
</html>