<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<link rel="stylesheet"
			href="../css/table.css" type="text/css"/>
		<link rel="stylesheet"
			href="../css/cwcalendar.css" type="text/css"/>
		<script type="text/javascript"
			src="../javascript/comm/comm.js">
		</script>
		<script language="javascript"
			src="../javascript/winopen/winopenm.js">
		</script>
		<script type="text/javascript"
			src="../javascript/calendar-ch.js">
		</script>
		<script type="text/javascript"
			src="../javascript/jquery-1.7.2.js">
		</script>
		<script type="text/javascript"
			src="../javascript/jquery.messager.js">
		</script>
		<script src="../javascript/time.js"></script>
		<script type="text/javascript"
			src="../javascript/human_check.js">
		</script>
		<script type="text/javascript"
			src="../javascript/human_input_check.js">
		</script>
<script type="text/javascript">
function pd(){
						//职称
						if($("#majorinName").val() != 0){
							//姓名
							if($("#humanName1").val() != null && $("#humanName1").val().trim() != ""){
								//email
								if($("#humanEmail").val() != null && $("#humanEmail").val().trim() != ""){
									//电话
									if($("#humanTelephone").val() != null && $("#humanTelephone").val().trim() != ""){
										//QQ
										if($("#humanQq").val() != null && $("#humanQq").val().trim() != ""){
											//手机
											if($("#humanMobilephone").val() != null && $("#humanMobilephone").val().trim() != ""){
												//住址
												if($("#humanaddress").val() != null && $("#humanaddress").val().trim() != ""){
													//邮编
													if($("#humanpostcode").val() != null && $("#humanpostcode").val().trim() != ""){
														//出生地
														if($("#humanbirthplace").val() != null && $("#humanbirthplace").val().trim() != ""){
															//生日
															if($("#birthday").val() != null && $("#birthday").val().trim() != ""){
																//社会保障号码
																if($("#humansocietysecurityid").val() != null && $("#humansocietysecurityid").val().trim() != ""){
																	//年龄
																	if($("#humanAge").val() != null && $("#humanAge").val().trim() != ""){
																		//开户行
																		if($("#humanbank").val() != null && $("#humanbank").val().trim() != ""){
																			//银行账户
																			if($("#humanaccount").val() != null && $("#humanaccount").val().trim() != ""){
																				$("#tijiao").submit();
																			}else
																				$.messager.show("消息提示", "请填写你的银行账户", 2000);
																		}else
																			$.messager.show("消息提示", "请填写你的开户行", 2000);
																	}else
																		$.messager.show("消息提示", "请填写你的年龄", 2000);
																}else
																	$.messager.show("消息提示", "请填写你的社会保障号码", 2000);
															}else
																$.messager.show("消息提示", "请填写你的生日", 2000);
														}else
															$.messager.show("消息提示", "请填写你的出生地", 2000);
													}else
														$.messager.show("消息提示", "请填写你的邮编", 2000);
												}else
													$.messager.show("消息提示", "请填写你的住址", 2000);
											}else
												$.messager.show("消息提示", "请填写你的手机", 2000);
										}else
											$.messager.show("消息提示", "请填写你的QQ", 2000);
									}else
										$.messager.show("消息提示", "请填写你的电话，如：123-12345678", 2000);
								}else
									$.messager.show("消息提示", "请填写你的电子邮件", 2000);
							}else
								$.messager.show("消息提示", "请填写你的姓名", 2000);
						}else
							$.messager.show("消息提示", "请选择你的职称", 2000);
}
</script>
	</head>
	<body>

		<form action="register_choose_picture_update" id="tijiao" method="post" enctype="multipart/form-data">
			<input type="hidden" name="human_id" value="${humman_file.human_id }"/>
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--人力资源档案管理--人力资源档案变更 </font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="确认变更" onclick="pd()" class="BUTTON_STYLE1"/>
						<input type="reset" value="清除" class="BUTTON_STYLE1"/>
						<input type="button" value="返回" class="BUTTON_STYLE1"
							onclick="history.back()"/>
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=3 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1" width="10%">
						档案编号
					</td>
					<td colspan="6" class="TD_STYLE2">
						${humman_file.human_id }
					</td>
					<td rowspan="6" width="13%" style="text-align: center;">
						<img src="../upload/${humman_file.human_picture }"  style="width:120px;height:150px;"/>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1" width="10%">
						I级机构
					</td>
					<td width="13%" class="TD_STYLE2">
						${humman_file.first_king_name }
					</td>
					<td width="10%" class="TD_STYLE1">
						II级机构
					</td>
					<td width="13%" class="TD_STYLE2">
						${humman_file.second_kind_name }
					</td>
					<td width="10%" class="TD_STYLE1">
						III级机构
					</td>
					<td class="TD_STYLE2" colspan="2" width="2%">
						${humman_file.third_kind_name }
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						职位分类
					</td>
					<td class="TD_STYLE2">
						${humman_file.human_major_kind_name }
					</td>
					<td class="TD_STYLE1">
						职位名称
					</td>
					<td class="TD_STYLE2">
						${humman_file.hunma_major_name }
					</td>
					<td class="TD_STYLE1">
						职称
					</td>
					<td colspan="2" class="TD_STYLE2">
						<select class="SELECT_STYLE1"  name="human_pro_designation">
							<c:forEach var="listzhicheng" items="${listzhicheng }" >
						<c:if test="${listzhicheng.attribute_name==humman_file.human_pro_designation }">
							<option value="${listzhicheng.attribute_name }" selected>${listzhicheng.attribute_name }</option>
						</c:if>
						
						<c:if test="${listzhicheng.attribute_name!=humman_file.human_pro_designation }">
							<option value="${listzhicheng.attribute_name }">${listzhicheng.attribute_name }</option>
						</c:if>
						</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						姓名
					</td>
					<td class="TD_STYLE2">
						<input type="text" id="humanName1" name="human_name" value="${humman_file.human_name }"
							class="INPUT_STYLE2"/>
					</td>
					<td class="TD_STYLE1">
						性别
					</td>
					<td class="TD_STYLE2">
						<select class="SELECT_STYLE1" name="human_sex">
							<c:if test="${humman_file.human_sex == '男' }">
							<option value="男">男</option>
							<option value="女">女</option>
							</c:if>
							<c:if test="${humman_file.human_sex == '女' }">
							<option value="女">女</option>
							<option value="男">男</option>
							</c:if>
						</select>
					</td>
					<td class="TD_STYLE1">
						EMAIL
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="human_email" value="${humman_file.human_email }"
							class="INPUT_STYLE2" id="humanEmail"/>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						电话
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_telephone" value="${humman_file.human_telephone }"
							class="INPUT_STYLE2" id="humanTelephone"/>
					</td>
					<td class="TD_STYLE1">
						QQ
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_qq" value="${humman_file.human_qq }"
							class="INPUT_STYLE2" id="humanQq"/>
					</td>
					<td class="TD_STYLE1">
						手机
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="human_mobilephone" id="humanMobilephone"
							value="${humman_file.human_mobilephone }" class="INPUT_STYLE2"/>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						住址
					</td>
					<td colspan="3" class="TD_STYLE2">
						<input type="text" name="human_address" value="${humman_file.human_address }"
							class="INPUT_STYLE2" id="humanaddress"/>
					</td>
					<td class="TD_STYLE1">
						邮编
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="human_postcode" value="${humman_file.human_postcode }"
							class="INPUT_STYLE2" id="humanpostcode"/>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						国籍
					</td>
					<td class="TD_STYLE2">
						<select name="human_nationality" class="SELECT_STYLE1">
							<c:forEach var="listguoji" items="${listguoji }">
							<c:if test="${listguoji.attribute_name==humman_file.human_nationality }">
								<option value="${listguoji.attribute_name }" selected>${listguoji.attribute_name }</option>
							</c:if>
							<c:if test="${listguoji.attribute_name!=humman_file.human_nationality }">
								<option value="${listguoji.attribute_name }">${listguoji.attribute_name }</option>
							</c:if>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						出生地
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_birthplace" value="${humman_file.human_birthplace }"
							class="INPUT_STYLE2" id="humanbirthplace"/>
					</td>
					<td class="TD_STYLE1">
						生日
					</td>
					<td width="13%" class="TD_STYLE2">
						<input type="text" name="humanFile.humanBirthday" readonly="readonly"
							value="${humman_file.human_birthday }" class="INPUT_STYLE2" id="birthday"/>
					</td>
					<td width="10%" class="TD_STYLE1">
						民族
					</td>
					<td class="TD_STYLE2">
						<select name="human_race" class="SELECT_STYLE1">
							<c:forEach var="listmingzu" items="${listmingzu }">
							<c:if test="${listmingzu.attribute_name==humman_file.human_race }">
								<option value="${listmingzu.attribute_name }" selected>${listmingzu.attribute_name }</option>
							</c:if>
							<c:if test="${listmingzu.attribute_name!=humman_file.human_race }">
								<option value="${listmingzu.attribute_name }">${listmingzu.attribute_name }</option>
							</c:if>
						</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						宗教信仰
					</td>
					<td class="TD_STYLE2">
						<select name="human_religion" class="SELECT_STYLE1">
							<c:forEach items="${listzongjiao }" var="listzongjiao">
							<c:if test="${listzongjiao.attribute_name==humman_file.human_religion }">
								<option value="${listzongjiao.attribute_name }" selected>${listzongjiao.attribute_name }</option>
							</c:if>
							<c:if test="${listzongjiao.attribute_name!=humman_file.human_religion }">
								<option value="${listzongjiao.attribute_name }">${listzongjiao.attribute_name }</option>
							</c:if>
						</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						政治面貌
					</td>
					<td class="TD_STYLE2">
						<select name="human_party" class="SELECT_STYLE1">
							<c:forEach var="listzhengzhi" items="${listzhengzhi }">
							<c:if test="${listzhengzhi.attribute_name==humman_file.human_party }">
								<option value="${listzhengzhi.attribute_name }" selected>${listzhengzhi.attribute_name }</option>
							</c:if>
							<c:if test="${listzhengzhi.attribute_name!=humman_file.human_party }">
								<option value="${listzhengzhi.attribute_name }">${listzhengzhi.attribute_name }</option>
							</c:if>
						</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						身份证号码
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_id_card" id="humanIdCard"
							value="${humman_file.human_id_card }" class="INPUT_STYLE2"/>
					</td>
					<td class="TD_STYLE1">
						社会保障号码
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_society_security_id" value="${humman_file.human_society_security_id }"
							class="INPUT_STYLE2" id="humansocietysecurityid"/>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						年龄
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_age" value="${humman_file.human_age }"
							class="INPUT_STYLE2" id="humanAge"/>
					</td>
					<td class="TD_STYLE1">
						学历
					</td>
					<td class="TD_STYLE2">
						<select name="human_educated_degree" class="SELECT_STYLE1">
							<c:forEach var="listxueli" items="${listxueli }">
							<c:if test="${listxueli.attribute_name==humman_file.human_educated_degree }">
								<option value="${listxueli.attribute_name }" selected>${listxueli.attribute_name }</option>
							</c:if>
							<c:if test="${listxueli.attribute_name!=humman_file.human_educated_degree }">
								<option value="${listxueli.attribute_name }">${listxueli.attribute_name }</option>
							</c:if>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						教育年限
					</td>
					<td class="TD_STYLE2">
						<select name="human_educated_years" class="SELECT_STYLE1">
							<c:forEach items="${listjiaoyu }" var="listjiaoyu">
						<c:if test="${listjiaoyu.attribute_name==humman_file.human_educated_years }">
							<option value="${listjiaoyu.attribute_name }" selected>${listjiaoyu.attribute_name }</option>
						</c:if>
						<c:if test="${listjiaoyu.attribute_name!=humman_file.human_educated_years }">
							<option value="${listjiaoyu.attribute_name }">${listjiaoyu.attribute_name }</option>
						</c:if>
						</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						学历专业
					</td>
					<td class="TD_STYLE2">
						<select name="human_educated_major" class="SELECT_STYLE1">
							<c:forEach var="listzhuanye" items="${listzhuanye }">
							<c:if test="${listzhuanye.attribute_name==humman_file.human_educated_major }">
								<option value="${listzhuanye.attribute_name }" selected>${listzhuanye.attribute_name }</option>
							</c:if>
							<c:if test="${listzhuanye.attribute_name!=humman_file.human_educated_major }">
								<option value="${listzhuanye.attribute_name }">${listzhuanye.attribute_name }</option>
							</c:if>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						薪酬标准
					</td>
					<td class="TD_STYLE2">
						<select name="salary_standard_id" class="SELECT_STYLE1">
							<c:forEach items="${listxinchou }" var="listxinchou">
						<c:if test="${listxinchou.standard_id==humman_file.salary_standard_id }">
							<option value="${listxinchou.standard_id }" selected>${listxinchou.standard_name }</option>
						</c:if>
						<c:if test="${listxinchou.standard_id!=humman_file.salary_standard_id }">
							<option value="${listxinchou.standard_id }">${listxinchou.standard_name }</option>
						</c:if>
						</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						开户行
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_bank" value="${humman_file.human_bank }"
							class="INPUT_STYLE2" id="humanbank"/>
					</td>
					<td class="TD_STYLE1">
						银行帐号
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_account"
							value="${humman_file.human_account }" class="INPUT_STYLE2" id="humanaccount"/>
					</td>
					<td class="TD_STYLE1">
						变更人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="changer" value="${loginUser.user_true_name }"
							readonly="readonly" class="INPUT_STYLE2"/>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						变更时间
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="change_time"
							id="create_time" readonly="readonly"
							class="INPUT_STYLE2"/>
					</td>
					<td class="TD_STYLE1">
						特长
					</td>
					<td class="TD_STYLE2">
						<select name="human_speciality" class="SELECT_STYLE1">
							<c:forEach var="listtechang" items="${listtechang }">
							<c:if test="${listtechang.attribute_name==humman_file.human_speciality }">
								<option value="${listtechang.attribute_name }" selected>${listtechang.attribute_name }</option>
							</c:if>
							<c:if test="${listtechang.attribute_name!=humman_file.human_speciality }">
								<option value="${listtechang.attribute_name }">${listtechang.attribute_name }</option>
							</c:if>
						</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						爱好
					</td>
					<td class="TD_STYLE2">
						<select name="human_hobby" class="SELECT_STYLE1">
							<c:forEach items="${listaihao }" var="listaihao">
							<c:if test="${listaihao.attribute_name==humman_file.human_hobby }">
								<option value="${listaihao.attribute_name }" selected>${listaihao.attribute_name }</option>
							</c:if>
							<c:if test="${listaihao.attribute_name!=humman_file.human_hobby }">
								<option value="${listaihao.attribute_name }">${listaihao.attribute_name }</option>
							</c:if>
						</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						&nbsp;
					</td>
					<td class="TD_STYLE2">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						个人履历
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="human_histroy_records" rows="4"
							class="TEXTAREA_STYLE1">${humman_file.human_histroy_records }</textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						家庭关系信息
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="human_family_membership" rows="4"
							class="TEXTAREA_STYLE1">${humman_file.human_family_membership }</textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						备注
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="remark" rows="4" class="TEXTAREA_STYLE1">${humman_file.remark }</textarea>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
