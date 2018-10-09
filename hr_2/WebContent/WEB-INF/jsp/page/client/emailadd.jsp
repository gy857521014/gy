<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
		<link rel="stylesheet" href="../css/table.css" type="text/css"></link>
		<script type="text/javascript" src="../javascript/comm/comm.js"></script>
		<script type="text/javascript" src="../javascript/jquery-1.7.2.js"></script>
		<script type="text/javascript">
			function checkeServiceName(){
				// 获取机构名称
				var bt = $("#bt").val();
				var zrrbh = $("#zw").val();
				//在判断是否为空
				if(document.getElementById("bt").value==''){
					$("#errorSpan").html("<font color='red'>请输入标题</font>");
					return;
				}else{
					$("#errorSpan").html("");
				}
				if(document.getElementById("zw").value==''){
					$("#errorSpanzw").html("<font color='red'>请输入正文</font>");
					return;
				}else{
					$("#errorSpanzrrbh").html("");
				}
				$("#aa").submit();
			}
	</script>
	</head>
	<body>
		<form id="aa" method="post"
			action="addm">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--邮箱管理设置--邮箱添加设置
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="提交" class="BUTTON_STYLE1" onclick="checkeServiceName()">
						<input type="button" value="返回" class="BUTTON_STYLE1"
							onclick="window.location.href='selm'">
					</td>
				</tr>
			</table>

			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="19%" class="TD_STYLE1">
						标题
					</td>
					<td width="81%" class="TD_STYLE2">
					<input id="bt" type="text" name="mhead" value="" class="INPUT_STYLE1">
					<span id="errorSpan"></span>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						正文
					</td>
					<td class="TD_STYLE2">
						<textarea id="zw" name="mcontent" rows="15"
							class="TEXTAREA_STYLE1"></textarea>
							<span id="errorSpanzw"></span>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						邮件类型
					</td>
					<td class="TD_STYLE2">
					<select name="mtype">
						<option value="1" selected="selected">面试通知类型</option>
						<option value="2">录取通知类型</option>
						<option value="3">其他通知类型</option>
					</select>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
