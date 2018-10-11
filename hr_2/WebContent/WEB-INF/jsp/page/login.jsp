<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html public "-//w3c//dtd html 4.01 transitional//en"
"http://www.w3.org/tr/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<style type=text/css>
		body {
			font-size: 12px;
			color: #ffffff;
			font-family: 宋体
		}
		
		td {
			font-size: 12px;
			color: #ffffff;
			font-family: 宋体
		}
		</style>
		<script type="text/javascript"
			src="javascript/jquery-1.7.2.js">
		</script>
		<script type="text/javascript"
			src="javascript/jquery.messager.js">
		</script>
		<script type="text/javascript"
			src="javascript/login.js">
		</script>
		<script type="text/javascript">
		function checkNameOrPhone(i) {
			var userName = $("#userName").val();
			var reg2 =  /^(13|14|15|16|17|18|19)\d{9}$/;
			var b = reg2.test(userName);
			if(b){
				// 1、显示发送验证码的按钮
				$("#smsSpan").show();
				// 2、隐藏密码框的span
				$("#pwdSpan").hide();
				// 3、显示验证码的span
				$("#codeSpan").show();
			}else if(!b){
				//隐藏验证码的按钮
				$("#smsSpan").hide();
				//显示密码框
				$("#pwdSpan").show();
				//隐藏验证码框span
				$("#codeSpan").hide();
				//清空验证码值
				$("#SBtn").val("");
			}
			if(i==1){
				$.ajax({
					url:"byuser_phone?user_phone=" + userName,
					type:'get',
					success:function(data){
						$("#count").val(data);
						if(data==0){
							$.messager.show("消息提示", "该手机号未绑定!请重新输入", 2000);
						}
						if(data!=0){
							$.ajax({
								url:"upCode?user_phone=" + userName,
								type:'get',
								success:function(data){
									// data就是生成的验证码
									$("#smsCode").val(data);
								}
							});
							
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
				});
			}
			
			
			
		}
		</script>
		
	</head>
	<body>
		<form action="login" method="post" id="login1">
			<div>
				<table cellspacing=0 cellpadding=0 width=900 align=center border=0>
					<tbody>
						<tr>
							<td style="height: 105px">
								<img src="images/login_11.gif" border=0>
							</td>
						</tr>
						<tr>
							<td background=images/login_22.jpg height=300>
								<table height=300 cellpadding=0 width=900 border=0>
									<tbody>
										<tr>
											<td colspan=2 height=35></td>
										</tr>
										<tr>
											<td width=360></td>
											<td>
												<table cellspacing=0 cellpadding=2 border=0>
													<tbody>
														<tr>
															<td style="height: 28px" width=80>
																登 录 名：
															</td>
															<td style="height: 28px" width=150>
																
																<input id="userName" name="user_phone" style="width: 130px" onkeyup="checkNameOrPhone()" />
																<input type="hidden" id="count"/>
															</td>
															<td></td>
														</tr>
														<tr id="pwdSpan">
																<td style="height: 28px">
																	登录密码：
																</td>
																<td style="height: 28px">
																	<input id="userPassword" name="user_password" style="width: 130px" type="password"/>
																</td>
																<td></td>
														</tr>
														<tr id="codeSpan" style="display: none;">
																<td style="height: 28px">
																	验 证 码：
																</td>
																<td style="height: 28px" width=150>
																	<input id="SBtn" type="text" name="ucode" style="width: 130px">
																</td>
																<td><input id="smsBtn" type="button" value="发送验证码" onclick="checkNameOrPhone(1)"></td>
														</tr>

														<tr>
															<td style="height: 10px"></td>
															<td style="height: 10px"></td>
															<td style="height: 10px"></td>
														</tr>
														<tr>
															<td></td>
															<td>
																<input type="button" value="登录" style="cursor: pointer;" onclick="checkLogin()" />
															</td>
															<td></td>
														</tr>
													</tbody>
												</table>
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<img src="images/login_33.jpg" border=0>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<!-- 查询手机号码 -->
			<input type="hidden" id="count"  />
			<!-- 获取验证码 -->
			<input type="hidden" id="smsCode"  />
		</form>
	</body>
</html>
