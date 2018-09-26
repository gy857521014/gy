<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/table.css" type="text/css" />
<title>无标题文档</title>
<style type="text/css">
#d {
	background-color: #FFFFBB;
	width: 100%;
	height: 100%;
	position: absolute;
	top: 0;
	left: 0;
	z-index: 1;
	filter: alpha(opacity : 20);
	opacity: 0.2;
	position: fixed;
	display: none;
}

#parent {
	border: 1px solid #FFDB6F;
	width: 400px;
	height: 200px;
	position: absolute;
	z-index: 2;
	top: 20%;
	left: 25%;
	position: fixed;
	display: none;
}

#child {
	width: 100%;
	height: 100%;
	color: #C66C35;
	font-size: 15px;
	text-align: center;
	line-height: 25px;
	font-weight: bold;
}

.button {
	height: 30px;
	width: 90px;
	border-color: #D4DEE7;
	background-color: #D4DEE7;
	font-weight: bold;
	font-size: 15px;
	color: #481858;
	cursor: pointer;
	BORDER-BOTTOM: #D4DEE7 1px solid;
	FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0,
		StartColorStr=#ffffff, EndColorStr=#C3DAF5);
}
</style>
</head>
<script type="text/javascript" src="../../javascript/jquery-1.7.2.js">
	
</script>
<SCRIPT type="text/javascript">
	$(function() {
		$("#button1").click(function() {
			$("#table1").hide(800);
			$("#table2").hide(800);

			$("#d").show(1800);
			$("#parent").fadeIn(2200);
		});
		$("#close").click(function() {
			$("#d").hide(800);
			$("#parent").hide(600);

			$("#table1").show(1000);
			$("#table2").show(1000);

		});
		$("#sure").click(function() {

			$("#d").hide(800);
			$("#parent").fadeOut(600);

			$("#table1").show(1000);
			$("#table2").show(1000);
			$("form:first").submit();
		});
	});
</SCRIPT>

<body>
	<form
		action="/HR_Fist/salaryCriterion/salaryCriterionAction!printsalarystandard.action"
		method="post">
		<input type="hidden" name="standard.standardId" value="1353320112255">

		<div id="d"></div>
		<div id="parent">
			<div id="child">
				<br>
				<br> zhangsan,您确认打印此页面的信息吗？<br>
				<br>
				<br> <input type="button" class="button" value="确 定" id="sure" />
				<input type="button" class="button" value="取 消" id="close" />
			</div>
		</div>


		<table width="100%" id="table1">
			<tr>
				<td><font color="black">您正在做的业务是:人力资源管理--薪酬标准管理--薪酬标准登记查询</font>
				</td>
			</tr>
			<tr>
				<td>
					<div align="right">
						<input type="button" value="打印" id="button1" class="BUTTON_STYLE1">
						<input type="button" value="返回"
							onclick="javascript:windows.location='/HR_Fist/salaryCriterion/salaryCriterionAction!querysalarystandardByPage?page.startPage=1'"
							class="BUTTON_STYLE1">
					</div>
				</td>
			</tr>
		</table>
		<table width="100%" border="1" cellpadding=0 cellspacing=1
			bordercolorlight=#848284 bordercolordark=#eeeeee id="table2"
			class="TABLE_STYLE1">
			<tr>
				<td width="12%" class="TD_STYLE1">薪酬编号</td>
				<td width="15%" class="TD_STYLE2">1353320112255</td>
				<td width="12%" class="TD_STYLE1">薪酬标准名称</td>
				<td width="11%" class="TD_STYLE2">董事长</td>
				<td width="11%" class="TD_STYLE1">薪酬总额</td>
				<td width="17%" class="TD_STYLE2">135827.0</td>
				<td class="TD_STYLE1" width="12%">&nbsp;</td>
				<td class="TD_STYLE2" width="10%">&nbsp;</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">制定人</td>
				<td class="TD_STYLE2">杨阳</td>
				<td class="TD_STYLE1">复核人</td>
				<td class="TD_STYLE2">manager</td>
				<td class="TD_STYLE1">复核时间</td>
				<td class="TD_STYLE2">2012年11月19日</td>
				<td class="TD_STYLE1">&nbsp;</td>
				<td class="TD_STYLE2">&nbsp;</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">备注</td>
				<td colspan="7" class="TD_STYLE2" height="68"></td>
			</tr>
			<tr>
				<td class="TD_STYLE1">序号</td>
				<td colspan="3" class="TD_STYLE1">薪酬项目名称</td>
				<td colspan="4" class="TD_STYLE1">金额</td>
			</tr>

			<tr class="TD_STYLE2">
				<td align="center">63</td>
				<td colspan="3">出差补助</td>
				<td>123.0</td>
				<td colspan="3">&nbsp;</td>
			</tr>

			<tr class="TD_STYLE2">
				<td align="center">64</td>
				<td colspan="3">交通补贴</td>
				<td>12312.0</td>
				<td colspan="3">&nbsp;</td>
			</tr>

			<tr class="TD_STYLE2">
				<td align="center">65</td>
				<td colspan="3">住房补贴</td>
				<td>123123.0</td>
				<td colspan="3">&nbsp;</td>
			</tr>

			<tr class="TD_STYLE2">
				<td align="center">66</td>
				<td colspan="3">基本工资</td>
				<td>123.0</td>
				<td colspan="3">&nbsp;</td>
			</tr>

			<tr class="TD_STYLE2">
				<td align="center">67</td>
				<td colspan="3">年终奖</td>
				<td>123.0</td>
				<td colspan="3">&nbsp;</td>
			</tr>

			<tr class="TD_STYLE2">
				<td align="center">68</td>
				<td colspan="3">误餐补助</td>
				<td>23.0</td>
				<td colspan="3">&nbsp;</td>
			</tr>



		</table>
	</form>
</body>
</html>
