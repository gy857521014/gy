<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/table.css" type="text/css" />
<script type="text/javascript" src="../javascript/comm/comm.js"></script>
<script type="text/javascript" src="../javascript/jquery-1.7.2.js"></script>
</head>
<body>
	<form method="post" action="addSalary_standard">
		<table width="100%">
			<tr>
				<td><font color="black">您正在做的业务是：人力资源--薪酬标准管理--薪酬标准登记 </font></td>
			</tr>
			<tr>
				<td align="right"><input type="submit" value="提 交"
					onclick="check()" class="BUTTON_STYLE1"> <input
					type="reset" value="返 回" class="BUTTON_STYLE1"></td>
			</tr>
		</table>
		<table id="stable" width="100%" border="1" cellpadding=0 cellspacing=1
			bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
			<tr>
				<td width="74" class="TD_STYLE1">薪酬标准编号</td>
				<td width="168" class="TD_STYLE2"><input type="text"
					name="standard_id" value="${sytime }"
					readonly="readonly" class="INPUT_STYLE2"></td>
				<td width="83" class="TD_STYLE1">薪酬标准名称</td>
				<td width="171" class="TD_STYLE2"><input type="text"
					name="standard_name" id="standardName" class="INPUT_STYLE2">
				</td>
				<td width="170" class="TD_STYLE1">薪酬总额</td>
				<td width="138" class="TD_STYLE2"><input type="text"
					name="salary_sum" id="sumSalary" value="0.0" readonly
					class="INPUT_STYLE2" /></td>
				<td width="103" class="TD_STYLE1">&nbsp;</td>
				<td width="95" height="26" class="TD_STYLE2">&nbsp;</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">制定人</td>
				<td class="TD_STYLE2"><input type="text" id="designer"
					name="designer" class="INPUT_STYLE2"></td>
				<td class="TD_STYLE1">登记人</td>
				<td class="TD_STYLE2"><input type="text"
					name="register" value="${loginUser.user_true_name}" readonly="readonly"
					class="INPUT_STYLE2"></td>
				<td class="TD_STYLE1">登记时间</td>
				<td class="TD_STYLE2"><input type="text" id="Tdate"
					name="regist_time" readonly="readonly" class="INPUT_STYLE2">
				</td>
				<td class="TD_STYLE1">&nbsp;</td>
				<td class="TD_STYLE2">&nbsp;</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">备注</td>
				<td colspan="7" class="TD_STYLE2"><textarea
						name="remark" rows="4" class="TEXTAREA_STYLE1"></textarea>
				</td>
			</tr>
			<tr class="TD_STYLE1">
				<td align="center">序号</td>
				<td colspan="3">薪酬项目名称</td>
				<td>金额</td>
				<td colspan="3">&nbsp;</td>
			</tr>
			<tbody>
			
				<c:forEach items="${xm }" var="xm">
					<tr class="TD_STYLE2">
					<td align="center">${xm.pbc_id } <input type="hidden"
						name="${xm.pbc_id }" value="${xm.pbc_id }">
					</td>
					<td colspan="3">${xm.attribute_name }<input type="hidden" id="details6"
						name="${xm.attribute_name }" value="${xm.attribute_name }">
					</td>
					<td>
						<input type="text" id="salary${xm.pbc_id }" value="0.00" name="x_${xm.pbc_id }" 
						onkeyup="countMoney('6','salary${xm.pbc_id }')" class="INPUT_STYLE2">
					</td>
					<td colspan="3">&nbsp;</td>
				</tr>
				</c:forEach>
				

			</tbody>
		</table>
		<p>&nbsp;</p>
	</form>
	<script type="text/javascript">
		function check() {

			var designer = document.getElementById("designer");
			var standardName = document.getElementById("standardName");
			if (designer.value.length <= 0) {
				alert("制定人不可为空!!!");
				return;
			}
			if (standardName.value.length <= 0) {
				alert("薪酬标准名称不可为空!!!");
				return;
			}

			document.forms[0].submit();
		}
		function countMoney(obj, o) {

			if (isNaN(document.getElementById(o).value)
					|| document.getElementById(o).value < 0) {
				alert("金额填写错误!");
				document.getElementById(o).value = "0.00";
				return;
			}
			var sum = 0;
			for (var i = 1; i <= obj; i++) {
				var salary = document.getElementById("salary" + i).value;
				if (salary == "") {
					salary = "0.00";
				}
				sum = Number(sum) + Number(salary);

			}
			document.getElementById("sumSalary").value = sum;

		}
		function time() {
			var tdate = document.getElementById("Tdate");
			var d = new Date();
			var y = d.getFullYear();
			var moth = d.getMonth() + 1;
			var date = d.getDate();
			var h = d.getHours();
			var m = d.getMinutes();
			var s = d.getSeconds();
			var hh = 20 - 1 - h;
			var mm = 60 - 1 - m;
			var ss = 60 - s;
			if (hh > 0) {
				mm = mm + 60 * hh;
			}
			if (moth < 10) {
				moth = "0" + moth;
			}
			if (date < 10) {
				date = "0" + date;
			}
			if (h < 10) {
				h = "0" + h;
			}
			if (m < 10) {
				m = "0" + m;
			}
			if (s < 10) {
				s = "0" + s;
			}
			if (mm < 10) {
				mm = "0" + mm;
			}
			if (ss < 10) {
				ss = "0" + ss;
			}

			tdate.value = y + "-" + moth + "-" + date + " " + h + ":" + m + ":"
					+ s;

		}
		window.onload = time;
		var out = window.setInterval(time, 1000);
	</script>
</body>
</html>