<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="../css/table.css" type="text/css">
		<script type="text/javascript" src="../javascript/comm/comm.js"></script>
		<script type="text/javascript" src="../javascript/jquery-1.7.2.js"></script>
		<script type="text/javascript">
		function check(){
			// 获取机构名称
			var sxzl = $("#sxzl").val();
			var sxname = $("#sxname").val();
			if (document.getElementById("sxzl").value==""){
				$("#errorSpan").html("<font color='red'>请输入属性种类</font>");
				return;
			}
			if (document.getElementById("sxname").value==""){
				$("#errorSpanname").html("<font color='red'>请输入属性名称</font>");
				return;
			}
			$("#document").submit();
		}	
</script>	
	</head>
	<body>
		<form action="addcpc" method="post" id="document">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--公共属性设置--公共属性添加
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="提交" class="BUTTON_STYLE1" onclick="check()">
						<input type="button" value="返回" class="BUTTON_STYLE1"
							onclick="history.back();">
					</td>
				</tr>
			</table>

			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1" width="19%">
						属性种类
					</td>
					<td class="TD_STYLE2" width="81%">
						<input id="sxzl" type="text" class="INPUT_STYLE1" name="attribute_kind" />
						<span id="errorSpan"></span>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						属性名称
					</td>
					<td class="TD_STYLE2">
						<input id="sxname" type="text" class="INPUT_STYLE1" name="attribute_name" />
						<span id="errorSpanname"></span>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

