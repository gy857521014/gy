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
			<script type="text/javascript" src="../javascript/jquery-1.7.2.js"></script>
		<script type="text/javascript">
			function doDelete(id) {
				if (confirm("确定删除此用户吗？")) {
					location.href = "userDel?userid=" + id;
				}
			}
			
			function dopagebybutton(totalPage) {
				var inputPage = document.getElementById("page").value;
				var myform = document.getElementById("queryForm");
				var reg = /^[0-9]*[1-9][0-9]*$/;
				if (reg.test(document.getElementById("page").value)&&(inputPage<(totalPage+1))&&(inputPage!=0)) {
					document.getElementById("startpage").value = document
							.getElementById("page").value;
					document.getElementById("starty").value = document
					.getElementById("page").value-1;
					
				} else {
					alert("您的输入有误");
					document.getElementById("page").value = document
							.getElementById("startpage").value;
					return;
				}
				myform.submit();

			}
		
			//首页
			function doPagesy(startsize) {
				document.getElementById("starty").value = startsize;
				var myform = document.getElementById("queryForm");
				if(${li}==0){
					alert("当前没有结果");
					return false;
				}else{
					if(startsize==${total}){
						alert("已经是末页");
						return;
					}
					if(startsize<0){
						alert("已经是首页");
						return;
					}
				}
				
				
				
				myform.submit();
				
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
					当前角色总数：${li}例
				</td>
			</tr>
			<tr>
				<td align="right">
				<c:forEach items="${loginUser.rq }" var="rqs">
							<c:if test="${rqs.q_id==8}">
					<input type="button" value="添加用户" class="BUTTON_STYLE1" onclick="location.href='queryUr'">
							</c:if>
				</c:forEach>
					<input type="button" value="绑定手机" class="BUTTON_STYLE1" onclick="location.href='phoneByid?userid='+${loginUser.userid }"></input>
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
					手机号码
				</td>
				<td class="TD_STYLE1">
					操作
				</td>
			</tr>
			
			<c:forEach items="${userList }" var="user">
				<tr class="TR_STYLE2" id="${user.userid }">
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
						${user.user_phone }
					</td>
					<td class="TD_STYLE2">
					
						<c:if test="${user.userid == loginUser.userid }">
							<img src="../images/bt_edit.gif" title="编辑" style="cursor:pointer;" onclick="location.href='userById?userid='+${user.userid }"/>
						</c:if>
					<c:forEach items="${loginUser.rq }" var="rqs">
						<c:if test="${rqs.q_id==8}">
							<c:if test="${user.userid != loginUser.userid }">
								<img src="../images/bt_edit.gif" title="编辑" style="cursor:pointer;" onclick="location.href='userById?userid='+${user.userid }"/>
							</c:if>
						</c:if>
					</c:forEach>
					
					<c:forEach items="${loginUser.rq }" var="rqs">
						<c:if test="${rqs.q_id==8}">	
							<c:if test="${user.userid != loginUser.userid }">
								<img src="../images/bt_del.gif" title="删除" style="cursor:pointer;" onclick="doDelete(${user.userid })"/>
							</c:if>
						</c:if>
					</c:forEach>
					</td>
					
				</tr>
			</c:forEach>

		</table>
		<p style="text-align:center;">
			<div align="center" style="font-size: 18px; color: gray">
		<form id="queryForm" action="queryAll" method="post">
		<input name="start" value="${start}" type="hidden" id="starty"/>
		</form>
			&nbsp;&nbsp;总数： <font style="color: maroon;font-weight: bold;">${li}</font>
			例 &nbsp;&nbsp;&nbsp; 每页显示 <font
				style="color: maroon;font-weight: bold;">4</font> 条
			&nbsp;&nbsp;&nbsp; 当前第 <font style="color: maroon;font-weight: bold;">${starttrue}</font>
			页 &nbsp;&nbsp;&nbsp;共 <font style="color: maroon;font-weight: bold;">${total}</font>
			页 <a style="color: navy; font-weight: bold"
				href="javascript:doPagesy(0)">首页</a> <a
				style="color: navy; font-weight: bold" href="javascript:doPagesy(${start-1})">上一页</a>

			<a style="color: navy; font-weight: bold" href="javascript:doPagesy(${start+1})">下一页</a>

			<a style="color: navy; font-weight: bold" href="javascript:doPagesy(${total-1})">末页</a>
			&nbsp;&nbsp;&nbsp;跳到第 <input id="page" type=text value="${starttrue}" class=input1
				size=1 name="pages" > 页&nbsp;&nbsp; <input type="image"
				onclick="dopagebybutton(${total})" src="../images/go.bmp" width=18 height=18
				border=0 > <input type="hidden" 
					id="startpage" value="${starttrue}">
		</div>
		
	     
		</p>
	</body>
</html>
