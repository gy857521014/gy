<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/table.css" type="text/css" />
<title>无标题文档</title>
</head>

<body>
	<form action="salarystandard_change_success.html" method="post">

		<table width="100%">
			<tr>
				<td><font color="black">您正在做的业务是:人力资源管理--薪酬标准管理--薪酬标准登记变更</font>
				</td>
			</tr>
			<tr>
				<td>
					<div align="right">
						<input type="button" value="重新提交" class="BUTTON_STYLE1"
							onclick="check()"> <input type="button" value="返回"
							onclick="history.back();" class="BUTTON_STYLE1">
					</div>
				</td>
			</tr>
		</table>

		<input type="hidden" name="standard.ssdId" value="1238">
		<table width="100%" border="1" cellpadding=0 cellspacing=1
			bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
			<tr>
				<td width="12%" class="TD_STYLE1">薪酬编号</td>
				<td width="15%" class="TD_STYLE2"><input type="hidden"
					name="standard.standardId" value="1353320112255">
					1353320112255</td>
				<td width="12%" class="TD_STYLE1">薪酬标准名称</td>
				<td width="11%" class="TD_STYLE2"><input type="text"
					name="standard.standardName" id="standardName" value="董事长"
					class="INPUT_STYLE2"></td>
				<td width="11%" class="TD_STYLE1">薪酬总额</td>
				<td width="17%" class="TD_STYLE2"><input type="text"
					name="standard.salarySum" id="sumSalary" value="135827.0"
					class="INPUT_STYLE2" readonly="readonly"></td>
				<td width="12%" class="TD_STYLE1">&nbsp;</td>
				<td width="10%" class="TD_STYLE2">&nbsp;</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">制定人</td>
				<td class="TD_STYLE2"><input type="text"
					name="standard.designer" id="designer" value="杨阳"
					class="INPUT_STYLE2"></td>
				<td class="TD_STYLE1">变更人</td>
				<td class="TD_STYLE2"><input type="text"
					name="standard.changer" value="better_admin" readonly="readonly"
					class="INPUT_STYLE2"></td>
				<td class="TD_STYLE1">变更时间</td>
				<td class="TD_STYLE2"><input type="text"
					name="standard.changeTime" id="Tdate" readonly="readonly"
					class="INPUT_STYLE2"></td>
				<td class="TD_STYLE1">&nbsp;</td>
				<td class="TD_STYLE2">&nbsp;</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">备注</td>
				<td colspan="7" class="TD_STYLE2"><textarea
						name="standard.remark" rows="4" class="TEXTAREA_STYLE1"></textarea>
				</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">序号</td>
				<td colspan="3" class="TD_STYLE1">薪酬项目名称</td>
				<td colspan="4" class="TD_STYLE1">金额</td>
			</tr>

			<tr class="TD_STYLE2">
				<td align="center"><input type="hidden" name="details[0].sdtId"
					value="1239" /> <input type="hidden" name="details[0].itemId"
					value="63" /> 63</td>
				<td colspan="3"><input type="hidden"
					name="details[0].standardId" value="1353320112255" /> <input
					type="hidden" name="details[0].standardName" value="董事长" /> <input
					type="hidden" name="details[0].itemName" value="出差补助" /> 出差补助</td>
				<td><input type="text" id="salary1" value="123.0"
					name="details[0].salary" onkeyup="countMoney('6','salary1')"
					class="INPUT_STYLE2"></td>
				<td colspan="3">&nbsp;</td>
			</tr>

			<tr class="TD_STYLE2">
				<td align="center"><input type="hidden" name="details[1].sdtId"
					value="1240" /> <input type="hidden" name="details[1].itemId"
					value="64" /> 64</td>
				<td colspan="3"><input type="hidden"
					name="details[1].standardId" value="1353320112255" /> <input
					type="hidden" name="details[1].standardName" value="董事长" /> <input
					type="hidden" name="details[1].itemName" value="交通补贴" /> 交通补贴</td>
				<td><input type="text" id="salary2" value="12312.0"
					name="details[1].salary" onkeyup="countMoney('6','salary2')"
					class="INPUT_STYLE2"></td>
				<td colspan="3">&nbsp;</td>
			</tr>

			<tr class="TD_STYLE2">
				<td align="center"><input type="hidden" name="details[2].sdtId"
					value="1241" /> <input type="hidden" name="details[2].itemId"
					value="65" /> 65</td>
				<td colspan="3"><input type="hidden"
					name="details[2].standardId" value="1353320112255" /> <input
					type="hidden" name="details[2].standardName" value="董事长" /> <input
					type="hidden" name="details[2].itemName" value="住房补贴" /> 住房补贴</td>
				<td><input type="text" id="salary3" value="123123.0"
					name="details[2].salary" onkeyup="countMoney('6','salary3')"
					class="INPUT_STYLE2"></td>
				<td colspan="3">&nbsp;</td>
			</tr>

			<tr class="TD_STYLE2">
				<td align="center"><input type="hidden" name="details[3].sdtId"
					value="1242" /> <input type="hidden" name="details[3].itemId"
					value="66" /> 66</td>
				<td colspan="3"><input type="hidden"
					name="details[3].standardId" value="1353320112255" /> <input
					type="hidden" name="details[3].standardName" value="董事长" /> <input
					type="hidden" name="details[3].itemName" value="基本工资" /> 基本工资</td>
				<td><input type="text" id="salary4" value="123.0"
					name="details[3].salary" onkeyup="countMoney('6','salary4')"
					class="INPUT_STYLE2"></td>
				<td colspan="3">&nbsp;</td>
			</tr>

			<tr class="TD_STYLE2">
				<td align="center"><input type="hidden" name="details[4].sdtId"
					value="1243" /> <input type="hidden" name="details[4].itemId"
					value="67" /> 67</td>
				<td colspan="3"><input type="hidden"
					name="details[4].standardId" value="1353320112255" /> <input
					type="hidden" name="details[4].standardName" value="董事长" /> <input
					type="hidden" name="details[4].itemName" value="年终奖" /> 年终奖</td>
				<td><input type="text" id="salary5" value="123.0"
					name="details[4].salary" onkeyup="countMoney('6','salary5')"
					class="INPUT_STYLE2"></td>
				<td colspan="3">&nbsp;</td>
			</tr>

			<tr class="TD_STYLE2">
				<td align="center"><input type="hidden" name="details[5].sdtId"
					value="1244" /> <input type="hidden" name="details[5].itemId"
					value="68" /> 68</td>
				<td colspan="3"><input type="hidden"
					name="details[5].standardId" value="1353320112255" /> <input
					type="hidden" name="details[5].standardName" value="董事长" /> <input
					type="hidden" name="details[5].itemName" value="误餐补助" /> 误餐补助</td>
				<td><input type="text" id="salary6" value="23.0"
					name="details[5].salary" onkeyup="countMoney('6','salary6')"
					class="INPUT_STYLE2"></td>
				<td colspan="3">&nbsp;</td>
			</tr>


		</table>
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
				var salary = document.getElementById("salary" + i);
				if (salary.value == "") {
					salary.value = "0.00";
				}
				sum = Number(sum) + Number(salary.value);

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
