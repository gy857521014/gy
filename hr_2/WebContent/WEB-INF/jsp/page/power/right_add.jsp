<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>添加角色</title>
		<link rel="stylesheet"
			href="../css/table.css" type="text/css"/>
		<script type="text/javascript" src="../javascript/jquery-1.7.2.js"></script>
		<script type="text/javascript"
			src="../javascript/jquery.messager.js"></script>
		<script type="text/javascript" src="../javascript/right_add.js"></script>
		<script type="text/javascript">
		function byName() {
			//判断手机号
			var roleName = $("#roleName").val();
			var uroleExp = $("#uroleExp").val();
			
			if(uroleExp==""){
				$.messager.show("消息提示", "角色说明不能为空!", 2000);
			}
			if(uroleExp!=""){
				$.ajax({
					url:"byurole_name",
					type:'post',
					data:{'roleName':roleName},
					success:function(data){
						$("#count").val(data);
						if(data!=0){
							$.messager.show("消息提示", "该角色名以存在!", 2000);
						}
						if(data==0){
							$("#bc").submit();
						}
					}
				});
			}
		}
		
		</script>
	</head>
	<body>
		<form method="post" action="user_roleAdd" id="bc">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--权限管理--添加角色</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="保存" class="BUTTON_STYLE1" onclick="byName()"/>
						<input type="button" value="返回" class="BUTTON_STYLE1"
							onclick="history.back()">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=3 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1">角色名称</td>
					<td class="TD_STYLE2">
						<input type="text" id="roleName" name="urole_name"/>
					</td>
					<td class="TD_STYLE1">角色说明</td>
					<td class="TD_STYLE2">
						<input type="text" name="urole_exp" id="uroleExp"/>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">角色是否可用</td>
					<td colspan="3" class="TD_STYLE2">
						<select name="urole_state">
							<option value="1">是</option>
							<option value="2" selected="selected">否</option>
						</select>
					</td>
				</tr>
			</table>
			<input type="hidden" id="count"  />
		</form>
	</body>
</html>
