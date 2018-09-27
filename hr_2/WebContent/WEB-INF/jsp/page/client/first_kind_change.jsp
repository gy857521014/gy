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
			var zrrbh = $("#zrrbh").val();
			var xsbh = $("#xsbh").val();
			//在判断是否为空
			if(document.getElementById("zrrbh").value==''){
				$("#errorSpanzrrbh").html("<font color='red'>不能为空</font>");
				return;
			}else{
				var reg = /^\d{1,}$/;
				var b = reg.test(zrrbh);
				if(!b){
					$("#errorSpanzrrbh").html("<font color='red'>必须填写数字编号</font>");
					return;
				}
			}
			
			if(document.getElementById("xsbh").value==''){
				$("#errorSpanxsbh").html("<font color='red'>不能为空</font>");
				return;
			}else{
				var reg = /^\d{1,}$/;
				var b = reg.test(xsbh);
				if(!b){
					$("#errorSpanxsbh").html("<font color='red'>必须填写数字编号</font>");
					return;
				}
			}
			$("#cc").submit();
		}
</script>
	</head>
	<body>
		<form name="configfilefirstkindForm" method="post"
			action="updatecffk" id="cc">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--I级机构设置--I级机构变更
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="提交" class="BUTTON_STYLE1" onclick="checkeServiceName()" />
						<input type="button" value="返回" class="BUTTON_STYLE1"
							onclick="window.location.href='selcffk'">
					</td>
				</tr>
			</table>

			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<input type="hidden" name="cffk.ffkId" value="755" />
				<tr>
					<td width="19%" class="TD_STYLE1">
						I级机构编号
					</td>
					<td width="81%" class="TD_STYLE2">
						<input type="text" name="first_kind_id" value="${cffks.first_kind_id }"
							readonly="readonly" class="INPUT_STYLE1">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						I级机构名称
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="first_kind_name" value="${cffks.first_kind_name }"
							readonly="readonly" class="INPUT_STYLE1">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						薪酬发放责任人编号
					</td>
					<td class="TD_STYLE2">
						<textarea id="zrrbh" name="first_kind_salary_id"  rows="4"
							class="TEXTAREA_STYLE1">${cffks.first_kind_salary_id }</textarea>
							<span id="errorSpanzrrbh"></span>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						销售责任人编号
					</td>
					<td class="TD_STYLE2">
						<textarea id="xsbh" name="first_kind_sale_id" rows="4"
							class="TEXTAREA_STYLE1">${cffks.first_kind_sale_id }</textarea>
							<span id="errorSpanxsbh"></span>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
