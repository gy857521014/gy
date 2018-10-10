<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
		<link rel="stylesheet" href="../css/table.css" type="text/css"></link>
		<script type="text/javascript" src="../javascript/comm/comm.js"></script>
		<script type="text/javascript" src="../javascript/jquery-1.7.2.js"></script>
		<script type="text/javascript">
			function deletem(mid){
			$.ajax({
				url:'deletem?mid='+mid,
				type:'get',
				success:
					$("#"+mid).remove()
			});
			}
		</script>
	</head>
	<body>
		<form method="post" action="madd">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--邮箱管理设置
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="submit" value="添加" class="BUTTON_STYLE1"
							onclick="window.location.href='emailadd.jsp'" />
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="30%" class="TD_STYLE1">
						标题
					</td>
					<td width="30%" class="TD_STYLE1">
						正文
					</td>
					<td width="30%" class="TD_STYLE1">
						类别
					</td>
					<td width="5%" class="TD_STYLE1">
						删除
					</td>
				</tr>

				<c:forEach items="${mlist }" var="c">
				<tr id="${c.mid }">
					<td class="TD_STYLE2">
						${c.mhead }
					</td>
					<td class="TD_STYLE2" title="${c.mcontent }">
						${c.newmcontent }
					</td>
					<td class="TD_STYLE2">
						<c:if test="${c.mtype==1 }">
						面试通知类型
						</c:if>
						<c:if test="${c.mtype==2 }">
						录取通知类型
						</c:if>
						<c:if test="${c.mtype==3 }">
						其他通知类型
						</c:if>
					</td>
					<td class="TD_STYLE2">
						<a href="javascript:deletem(${c.mid })">删除</a>
					</td>
				</tr>
			</c:forEach>
			</table>
		</form>
	</body>
</html>
