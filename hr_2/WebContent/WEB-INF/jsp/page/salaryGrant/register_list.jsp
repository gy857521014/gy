<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript"
			src="../javascript/jquery-1.7.2.js">
		</script>
		<link rel="stylesheet" href="../css/table.css" type="text/css" />
		<script type="text/javascript" src="../javascript/comm/comm.js"></script>
		<title>无标题文档</title>
		<STYLE type="text/css">
		td{text-align: center}
		</STYLE>
	</head>

	<body>
		 
			<table width="100%">
				<tr>
					<td colspan="2" style="text-align: left">
						<font color="black">您正在做的业务是：人力资源--薪酬标准管理--薪酬发放登记(负责人控制)
						</font>
						 
					</td>
				</tr>
				 
			</table>
					<br> 
					薪酬总数:${hsum }，
					总人数:8，基本薪酬总数:141821.0，实发总额:1998.0
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				
				<tr>
					<td width="10%" class="TD_STYLE1">
						<span>序号</span>
					</td>			
					
					
					<td width="40%"  class="TD_STYLE1">
					
						<span>I级机构名称</span>
					</td>
					<td width="10%" class="TD_STYLE1">
						<span>人数</span>
					</td>
					<td width="10%" class="TD_STYLE1">
						基本薪酬总额(元)
					</td>					
					<td width="10%" class="TD_STYLE1">
						登记
					</td>
				</tr>
						<c:forEach items="${arr }" var="a" varStatus="vs">
					<tr class="TD_STYLE2">
						<td>
							${vs.count }
						</td>
					<td> ${a.first_kind_name }  </td>
						<td>
							${sum } 
						</td>
						<td>
							1332.0 
						</td>
						<td>
							<a href="register_commit.html">登 记</a>
						</td>
					</tr>
						</c:forEach>
				</table>
			<p>
				&nbsp;
			</p>
		 
	</body>
</html>
