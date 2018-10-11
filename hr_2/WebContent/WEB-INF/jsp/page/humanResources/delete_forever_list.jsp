<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet"
			href="../css/table.css" type="text/css">
			<script type="text/javascript"
			src="../javascript/jquery-1.7.2.js">
		</script>
		<script type="text/javascript"
			src="../javascript/jquery.messager.js">
		</script>
		<script type="text/javascript">
			function doDelete(id) {
				var ajaxdel = $("#ajaxdel");
				if (confirm("确定删除此档案吗？")) {
					$.ajax({
						url:'Delete?human_id='+id,
						type:'get',
						success:function(data){
							if(data == 1){
								ajaxdel.remove();
								$.messager.show("删除提示", "删除成功", 2000);
							}
						}
					});
				}
			}
		</script>

	</head>

	<body>
		<form action="" method="post">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--人力资源档案管理--人力资源档案永久删除 </font>
					</td>
				</tr>
				<tr>
					<td>
						符合条件的人力资源档案总数：${humman_fileslist_size }例
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=5 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr class="TR_STYLE1">
					<td width="14%" height="13" class="TD_STYLE1">
						档案编号
					</td>
					<td width="11%" class="TD_STYLE1">
						姓名
					</td>
					<td width="6%" class="TD_STYLE1">
						性别
					</td>
					<td width="13%" class="TD_STYLE1">
						I级机构
					</td>
					<td width="12%" class="TD_STYLE1">
						II级机构
					</td>
					<td width="13%" class="TD_STYLE1">
						III级机构
					</td>
					<td width="11%" class="TD_STYLE1">
						职位分类
					</td>
					<td width="13%" class="TD_STYLE1">
						职位名称
					</td>
					<td width="7%" class="TD_STYLE1">
						永久删除
					</td>
				</tr>
				<c:forEach items="${humman_fileslist }" var="humman_fileslist">
					<tr class="TR_STYLE2" id ="ajaxdel">
						<td width="14%" height="13" class="TD_STYLE2">
							${humman_fileslist.human_id }
						</td>
						<td width="11%" class="TD_STYLE2">
							${humman_fileslist.human_name }
						</td>
						<td width="6%" class="TD_STYLE2">
							${humman_fileslist.human_sex }
						</td>
						<td width="13%" class="TD_STYLE2">
							${humman_fileslist.first_king_name }
						</td>
						<td width="12%" class="TD_STYLE2">
							${humman_fileslist.second_kind_name }
						</td>
						<td width="13%" class="TD_STYLE2">
							${humman_fileslist.third_kind_name }
						</td>
						<td width="11%" class="TD_STYLE2">
							${humman_fileslist.human_major_kind_name }
						</td>
						<td width="13%" class="TD_STYLE2">
							${humman_fileslist.hunma_major_name }
						</td>
						<td width="7%" class="TD_STYLE2">
							<img src="../images/bt_del.gif" title="删除" style="cursor:pointer;" onclick="doDelete(${humman_fileslist.human_id })"/>
						</td>
					</tr>
				</c:forEach>
				
			</table>
		</form>
	</body>
</html>
    