<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>
<link rel="stylesheet" href="../css/table.css" type="text/css">
<link rel="stylesheet" type="text/css" media="all"
	href="../../javascript/calendar/calendar-win2k-cold-1.css">
<script type="text/javascript" src="../javascript/calendar/cal.js"></script>
<script type="text/javascript" src="../javascript/comm/comm.js"></script>
<script type="text/javascript" src="../javascript/comm/list.js"></script>
<script type="text/javascript" src="../javascript/jquery-1.7.2.js"></script>
<script type="text/javascript" src="../javascript/calendar-ch.js"></script>
<script type="text/javascript" src="../javascript/comm/time.js"></script>
<link rel="stylesheet" href="../css/cwcalendar.css" type="text/css"></link>

</head>

<body>
	<form method="post" action="selsalarystandard_change_list" id="queryForm">
		<input type="hidden" name="page.startPage" value="0">
		<table width="100%">
			<tr>
				<td><font color="black">您正在做的业务是:人力资源管理--薪酬标准管理--薪酬标准变更</font>
				</td>
			</tr>
			<tr>
				<td>
					<div align="right">
						<input type="button" value="查询" class="BUTTON_STYLE1" onclick="time()"/>
						<input type="hidden" name="start" value="0"/>
					</div>
				</td>
			</tr>
		</table>
		<table width="100%" border="1" cellpadding=0 cellspacing=1
			bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
			<tr>
				<td width="20%" class="TD_STYLE1">请输入薪酬标准编号</td>
				<td class="TD_STYLE2"><input type="text"
					name="standard_id" value="" class="INPUT_STYLE1"></td>
			</tr>
			<tr>
				<td class="TD_STYLE1">请输入关键字</td>
				<td class="TD_STYLE2"><input type="text"
					name="Keyword" class="INPUT_STYLE1"></td>
			</tr>
			<tr>
				<td class="TD_STYLE1">请输入建档时间</td>
				<td width="84%" class="TD_STYLE2"><input
					name="startDate" onclick="aa('utilbean.startDate')"
					type="text" class="INPUT_STYLE2" id="date_start" style="width: 24%"
					value="" size="30"> 至 <input type="text"
					name="endDate" onclick="aa('utilbean.endDate')" value=""
					style="width: 24%" class="INPUT_STYLE2" id="date_end">
					（YYYY-MM-DD）</td>
			</tr>
		</table>

	</form>
	
	<script type="text/javascript">
			function time(){
				var myform = document.getElementById("queryForm");
				var startDate = document.getElementById("date_start").value;
				var endDate = document.getElementById("date_end").value;
				if(startDate!=null&&startDate!=""&&endDate!=null&&endDate!=""){
					if(startDate>endDate){
						alert("您的输入日期有误");
						document.getElementById("date_start").value=null;
						document.getElementById("date_end").value=null;
						return;
					}
				}
				myform.submit();
			}
		</script>
</body>
</html>
