﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
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
																<input id="userName" name="user_name" style="width: 130px"/>
															</td>
														</tr>
														<tr>
															<td style="height: 28px">
																登录密码：
															</td>
															<td style="height: 28px">
																<input id="userPassword" name="user_password" style="width: 130px" type="password"/>
															</td>
														</tr>

														<tr>
															<td style="height: 18px"></td>
															<td style="height: 18px"></td>
															<td style="height: 18px"></td>
														</tr>
														<tr>

															<td>
																<input type="button" value="登录" style="cursor: pointer;" />
															</td>
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
		</form>
	</body>
</html>
