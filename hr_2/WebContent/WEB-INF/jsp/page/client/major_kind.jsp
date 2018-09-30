<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
		<link rel="stylesheet" href="../css/table.css" type="text/css"></link>
		<script type="text/javascript" src="../javascript/comm/comm.js"></script>
		<script type="text/javascript" src="../javascript/jquery-1.7.2.js"></script>
		<script type="text/javascript">
			function deleteMajor(major_kind_id){
				 if(confirm("删除职位分类会同时删除下所属职位等....是否删除？"))
			     {
			$.ajax({
				url:'deletecmk?major_kind_id='+major_kind_id,
				type:'get',
				success:function(data){
					if(data=="1"){
					$("#"+major_kind_id).remove();
					}
				}
			});
			}else  {
		    	 window.location.href("selcmk");
		     }
			}
		</script>
	</head>
	<body>
		<form method="post" action="tomadd">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--职位分类设置
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="submit" value="添加" class="BUTTON_STYLE1"
							onclick="window.location.href='major_kind_add.html';">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="46%" class="TD_STYLE1">
						职位分类编号
					</td>
					<td width="47%" class="TD_STYLE1">
						职位分类名称
					</td>
					<td width="5%" class="TD_STYLE1">
						删除
					</td>
				</tr>
				<c:forEach items="${cmklist }" var="c">
				<tr id="${c.major_kind_id }">
					<td class="TD_STYLE2">
						${c.major_kind_id }
					</td>
					<td class="TD_STYLE2">
						${c.major_kind_name }
					</td>
					<td class="TD_STYLE2">
						<a href="javascript:deleteMajor(${c.major_kind_id })">删除</a>
					</td>
				</tr>
				</c:forEach>
			</table>
		</form>
	</body>
</html>
