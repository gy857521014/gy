<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手机注册</title>
		<link rel="stylesheet"
			href="../css/table.css" type="text/css"/>
		<script type="text/javascript" src="../javascript/jquery-1.7.2.js"></script>
		<script type="text/javascript"
			src="../javascript/jquery.messager.js"></script>
		<script type="text/javascript" src="../javascript/user_add.js"></script>
		
		
		<script type="text/javascript">
		<!-- 手机号判断 -->
		function checkPhone(i){
			var phone = $("#myPhone").val();
			//正则表达式
			var reg = /^(13|14|15|16|17|18|19)\d{9}$/;
			//通过正则表达式验证字符串
			var b = reg.test(phone);
				if(!phone){
					alert("请输入手机号")
					return;
				}else if(!b){
					alert("你输入的手机号码格式不对")
					return;
				}else if(i==1){
					//发送请求
					$.ajax({
						url:"upSms?user_phone=" + phone,
						type:'get',
						success:function(data){
							// data就是生成的验证码
							$("#smsCode").val(data);
						}
					});
					//禁用发送短信
					$("#smsBtn").attr("disabled",true);
					var num = 60;
					var timer = window.setInterval(function(){
						//修改按键上的内容
						$("#smsBtn").val(num + "秒");
						num -= 1;
						if(num == -1){
							// 1、清除定时器
							window.clearInterval(timer);
							// 2、设置按钮不禁用
							$("#smsBtn").attr("disabled",false);
							// 3、重置按钮上的文字为发送验证码
							$("#smsBtn").val("发送验证码");
						}
					},1000);
				
			}
				
		}
		//提交绑定的手机号
		function upload() {
			//判断手机号
			var phone = $("#myPhone").val();
			var reg = /^(13|14|15|16|17|18|19)\d{9}$/;
			var b = reg.test(phone);
			//文本框验证吗
			var textcode = $("#SBtn").val();
			//正确短信验证码
			var SMScode = $("#smsCode").val();
			//先判断不能为空
				if(!phone){
					alert("请输入手机号")
					return;
				}else if(!b){
					alert("你输入的手机号码格式不对")
					return;
				}else if(textcode != SMScode){
					alert("验证码输入有误")
					return;
				}
				
			$("#myForm").submit();
		}
		
		
		</script>
</head>
<body>

<form method="post" action="phoneUpdate" id="myForm">
<input type="hidden" name="userid" value="${user.userid }"/>
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--权限管理--添加用户--手机注册</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="提交" class="BUTTON_STYLE1" onclick="upload()" />
						<input type="button" value="返回" class="BUTTON_STYLE1"
							onclick="history.back()">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=3 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1">用户名称</td>
					<td class="TD_STYLE2">
						${user.user_name }
					</td>
					<td class="TD_STYLE1">请输入手机号码</td>
					<td class="TD_STYLE2">
						<input value="${user.user_phone }" type="text" id="myPhone" name="user_phone" onblur="checkPhone(this)"/>
						<input id="smsBtn" type="button" value="发送验证码" onclick="checkPhone(1)" />
					</td>
					<td class="TD_STYLE1">请输验证码</td>
					<td class="TD_STYLE2">
						<input type="text" id="SBtn" />
					</td>
				</tr>
			</table>
			<input type="hidden" id="smsCode"  />
		</form>
		
</body>
</html>