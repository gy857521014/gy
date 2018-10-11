<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet"
			href="../css/table.css" type="text/css">
	</head>

	<body>
		<form action="" method="post">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--人力资源档案管理--人力资源档案恢复 </font>
					</td>
				</tr>
				<tr>
					<td>
						符合条件的人力资源档案总数：${query_list_size }例
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=5 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr class="TR_STYLE1">
					<td width="16%" class="TD_STYLE1">
						档案编号
					</td>
					<td width="13%" class="TD_STYLE1">
						姓名
					</td>
					<td width="8%" class="TD_STYLE1">
						性别
					</td>
					<td width="14%" class="TD_STYLE1">
						I级机构
					</td>
					<td width="14%" class="TD_STYLE1">
						II级机构
					</td>
					<td width="14%" class="TD_STYLE1">
						III级机构
					</td>
					<td width="14%" class="TD_STYLE1">
						职位分类
					</td>
					<td width="7%" class="TD_STYLE1">
						职位名称
					</td>
				</tr>
				<c:forEach var="query_list" items="${query_list }">
					<tr class="TR_STYLE2">
							<td width="16%" class="TD_STYLE2">
								<a href="recovery_list_information?human_id=${query_list.human_id }">${query_list.human_id }</a>
							</td>
							<td width="13%" class="TD_STYLE2">
								${query_list.human_name }
							</td>
							<td width="8%" class="TD_STYLE2">
								${query_list.human_sex }
							</td>
							<td width="14%" class="TD_STYLE2">
								${query_list.first_king_name }
							</td>
							<td width="14%" class="TD_STYLE2">
								${query_list.second_kind_name }
							</td>
							<td width="14%" class="TD_STYLE2">
								${query_list.third_kind_name }
							</td>
							<td width="14%" class="TD_STYLE2">
								${query_list.human_major_kind_name }
							</td>
							<td width="7%" class="TD_STYLE2">
								${query_list.hunma_major_name }
							</td>
					</tr>
						</c:forEach>
			</table>
		</form>
	</body>
</html>
