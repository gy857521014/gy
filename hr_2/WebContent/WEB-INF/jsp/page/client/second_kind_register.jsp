<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="../css/table.css" type="text/css"></link>
		<script type="text/javascript" src="../javascript/comm/comm.js"></script>
		<script type="text/javascript" src="../javascript/jquery-1.7.2.js"></script>
		<script type="text/javascript">
		function check(){
			// 获取机构名称
			var yiji = $("#yiji").val();
			var erjiname = $("#erjiname").val();
			var xcbh = $("#xcbh").val();
			var xsbh = $("#xsbh").val();
			//在判断是否为空
			if(document.getElementById("yiji").value=='0'){
				$("#errorSpan").html("<font color='red'>请选择I级机构</font>");
				return;
			}
			if(document.getElementById("erjiname").value==''){
				$("#errorSpanerji").html("<font color='red'>请输入II级机构名称</font>");
				return;
			}
			if(document.getElementById("xcbh").value==''){
				$("#errorSpanxcbh").html("<font color='red'>请输入薪酬发放责任人编号</font>");
				return;
			}else{
				var reg = /^\d{1,}$/;
				var b = reg.test(xcbh);
				if(!b){
					$("#errorSpanxcbh").html("<font color='red'>请填写数字编号</font>");
					return;
				}
			}
			if(document.getElementById("xsbh").value==''){
				$("#errorSpanxsbh").html("<font color='red'>请输入销售责任人编号</font>");
				return;
			}else{
				var reg = /^\d{1,}$/;
				var b = reg.test(xsbh);
				if(!b){
					$("#errorSpanxsbh").html("<font color='red'>请填写数字编号</font>");
					return;
				}
			}
			$("#document").submit();
		}
		
</script>
</head>
	<body>
		<form action="addcfsk" method="post" id="document">
					<input type="hidden" id="firstKindName" name="cfsk.firstKindName">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--II级机构设置--II级机构添加
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
					<select id="yiji" name="first_kind_id" onchange="change()">
						<option value='0'>请选择I级机构名称...</option>
						<c:forEach items="${cffklist }" var="c">
							<option value="${c.first_kind_id }">${c.first_kind_name }</option>
						</c:forEach>
					</select>
					<span id="errorSpan"></span>
					</td>
				</tr>
				<tr>
					<td width="19%" class="TD_STYLE1">
						II级机构编号
					</td>
					<td width="81%" class="TD_STYLE2">
					<input type="hidden" name="second_kind_id" value="${sytime }" />${sytime }
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						II级机构名称
					</td>
					<td class="TD_STYLE2">
						<input id="erjiname" type="text" class="INPUT_STYLE1" name="second_kind_name" value=""/>
						<span id="errorSpanerji"></span>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						薪酬发放责任人编号
					</td>
					<td class="TD_STYLE2">
						<textarea id="xcbh" rows="4" cols="" class="TEXTAREA_STYLE1" name="second_salary_id"></textarea>
						<span id="errorSpanxcbh"></span>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						销售责任人编号
					</td>
					<td class="TD_STYLE2">
						<textarea id="xsbh" rows="4" cols="" class="TEXTAREA_STYLE1" name="second_sale_id" ></textarea>
						<span id="errorSpanxsbh"></span>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

