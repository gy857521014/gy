<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="../css/table.css" type="text/css">
		<script type="text/javascript" src="../javascript/comm/comm.js"></script>
		<script type="text/javascript" src="../javascript/jquery-1.7.2.js"></script>
		<script type="text/javascript">
		function ajaxDelete(first_kind_id){
				 if(confirm("删除一级机构会同时删除下所属分公司、人员等....是否删除？"))
				     {
				 $.ajax({
				url:'deletecffk?first_kind_id='+first_kind_id,
				type:'get',
				success:function(data){
				if(data=="1"){
				$("#"+first_kind_id).remove();
						}
					}
				});
					 window.location.href("todelete");
				     }
				     else  {
				    	 window.location.href("selcffk");
				     }
				}
		</script>
	</head>
	<body>
		<form method="post" action="toadd">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--I级机构设置
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="submit" value="添加" class="BUTTON_STYLE1"
							onclick="window.location.href='first_kind_register.html'" />
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="20%" class="TD_STYLE1">
						I级机构编号
					</td>
					<td width="20%" class="TD_STYLE1">
						I级机构名称
					</td>
					<td width="25%" class="TD_STYLE1">
						薪酬发放责任人编号
					</td>
					<td width="25%" class="TD_STYLE1">
						销售责任人编号
					</td>
					<td width="5%" class="TD_STYLE1">
						变更
					</td>
					<td width="5%" class="TD_STYLE1">
						删除
					</td>
				</tr>

				<c:forEach items="${cffklist }" var="c">
				<tr id="${c.ffk_id }">
					<td class="TD_STYLE2">
						${c.first_kind_id }
					</td>
					<td class="TD_STYLE2">
						${c.first_kind_name }
					</td>
					<td class="TD_STYLE2">
						${c.first_kind_salary_id }
					</td>
					<td class="TD_STYLE2">
						${c.first_kind_sale_id }
					</td>
					<td class="TD_STYLE2">
						<a href="selcffkid?first_kind_id=${c.first_kind_id }">变更</a>
					</td>
					<td class="TD_STYLE2">
						<a href="javascript:ajaxDelete(${c.first_kind_id })">删除</a>
					</tr>
				</c:forEach>
			</table>
		</form>
	</body>
</html>
