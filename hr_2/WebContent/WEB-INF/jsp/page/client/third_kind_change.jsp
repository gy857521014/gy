﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
		<link rel="stylesheet" href="../css/table.css" type="text/css"></link>
		<script type="text/javascript" src="../javascript/comm/comm.js"></script>
		<script type="text/javascript" src="../javascript/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="../javascript/jquery.messager.js"></script>
		<script type="text/javascript">
			function check(){
			// 获取机构名称
			var xsbh = $("#xsbh").val();
			//在判断是否为空
			if(document.getElementById("xsbh").value==''){
				$.messager.show("消息提示", "请输入销售责任人编号！", 2000);
				return;
			}else{
				var reg = /^\d{1,5}$/;
				var b = reg.test(xsbh);
				if(!b){
					$.messager.show("消息提示", "请填写小于5位的销售责任人数字编号！", 2000);
					return;
				}
			}
			$("#document").submit();
		}
</script>
</head>
	<body>
		<form action="updatecftk" id="document" method="post">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--III级机构设置--III级机构变更
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
					<td width="19%" class="TD_STYLE1">
						I级机构名称
					</td>
					<td width="81%" class="TD_STYLE2">
						<input type="text" readonly="readonly" class="INPUT_STYLE1" name="first_kind_name" value="${cftks.first_kind_name}"/>
					</td>
				</tr>
				<tr>
					<td width="19%" class="TD_STYLE1">
						II级机构名称
					</td>
					<td width="81%" class="TD_STYLE2">
						<input type="text" readonly="readonly" class="INPUT_STYLE1" name="second_kind_name" value="${cftks.second_kind_name }"/>
					</td>
				</tr>
				<tr>
					<td width="19%" class="TD_STYLE1">
						III级机构编号
					</td>
					<td width="81%" class="TD_STYLE2">
						<input type="text" readonly="readonly" class="INPUT_STYLE1" name="third_kind_id" value="${cftks.third_kind_id }"/>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						III级机构名称
					</td>
					<td class="TD_STYLE2">
						<input type="text" readonly="readonly" class="INPUT_STYLE1" name="third_kind_name" value="${cftks.third_kind_name }"/>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						销售责任人编号
					</td>
					<td class="TD_STYLE2">
						<textarea id="xsbh" rows="4" cols="120" class="TEXTAREA_STYLE1" name="third_kind_sale_id">${cftks.third_kind_sale_id }</textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						是否为零售店（是/否）
					</td>
					<td class="TD_STYLE2">
					<select name="third_kind_is_retail">
						<option value="1">是</option>
						<option value="2">否</option>
					</select>
			 	</td>
				</tr>
			</table>
		</form>
	</body>
</html>

