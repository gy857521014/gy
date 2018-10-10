<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/table.css" type="text/css">
<script type="text/javascript" src="../javascript/comm/comm.js"></script>
</head>
<body>
	<form action="selsalarystandard_change_list" method="post" id="cform">
	<input type="hidden" name="Keyword" value="${Keyword}">
	<input name="startDate" value="${startDate}" type="hidden"/>
	<input name="endDate" value="${endDate}" type="hidden"/>
	<input name="standard_id" value="${standard_id}" type="hidden"/>
	<input name="start" value="${start}" type="hidden" id="starty"/>
	<table width="100%">

		<tr>

			<td colspan="2"><font color="black">您正在做的业务是:人力资源管理--薪酬标准管理--薪酬标准登记变更
			</font></td>

		</tr>

		<td width="49%">提交成功，需要复核！</td>
		<td width="51%" align="right"><input type="button"
			class="BUTTON_STYLE1"
			onclick="javascript:cform()"
			value="返回" /></td>




	</table>



	</form>
	<script type="text/javascript">
	function cform(){
		var myform = document.getElementById("cform");
		myform.submit();
	 }
	</script>
</body>

</html>
