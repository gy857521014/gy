<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
		<link rel="stylesheet" href="../css/table.css" type="text/css"/>
		<link rel="stylesheet" href="../css/cwcalendar.css" type="text/css"/>
		<script type="text/javascript" src="../javascript/jquery-1.7.2.js">
		</script>
		<script type="text/javascript" src="../javascript/jquery.messager.js">
		</script>
		<script type="text/javascript" src="../javascript/comm/comm.js">
		</script>
		<script type="text/javascript" src="../javascript/comm/select.js">
		</script>
		<script type="text/javascript" src="../javascript/calendar-ch.js">
		</script>
		<script type="text/javascript" src="../javascript/time.js">
		</script>
		<script type="text/javascript" src="../javascript/human_register.js">
		</script>
		<script type="text/javascript" src="../javascript/human_input_check.js">
		</script>
<!-- 职位二级联动 -->
<script type="text/javascript">
function fun(){
	var pid =$("#majorKind").val();
	$.ajax({
		url:'selectzhiwei?majorid='+pid,
		type:'get',
		success:function(data){
			var cityselect=$("#majorName");
			cityselect.empty();
			cityselect.append("<option>--请选择职位名称--</option>");
			for(var i=0;i<data.length;i++){
				var eachCity=data[i];
				var id=eachCity.major_id;
				var name=eachCity.major_name;
				cityselect.append("<option value='"+id+"'>"+name+"</option>");		
				}
			}
		});
	}
</script>
<!-- 机构的二级联动 -->
<script type="text/javascript">
function querySecond(){
	var pid =$("#firstKind").val();
	$.ajax({
		url:'selerji?fsk_id='+pid,
		type:'get',
		success:function(data){
			var cityselect=$("#secondKind");
			cityselect.empty();
			cityselect.append("<option>--请选择二级机构名称--</option>");
			for(var i=0;i<data.length;i++){
				var eachCity=data[i];
				var id=eachCity.second_kind_id;
				var name=eachCity.second_kind_name;
				cityselect.append("<option value='"+id+"'>"+name+"</option>");		
				}
			}
		});
	}
</script>
	</head>
	<body>
		<form method="post" action="add">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--人力资源档案管理--人力资源档案登记 </font>
					</td>
				</tr>
				
			<table width="100%" border="1" cellpadding=3 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1">
						档案编号：
					</td>
					<td class="TD_STYLE2">
						<input type="text" id="humanName" name="human_id"
							class="INPUT_STYLE2" value="${sytime }"/>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1" width="11%">
						I级机构
					</td>
					<td width="14%" class="TD_STYLE2">
						<select name="first_kind_id" class="SELECT_STYLE1" id="firstKind" onchange="querySecond()">
							<option value="0">请选择</option>
							<c:forEach var="firstList" items="${FirstList }">
								<option value="${firstList.first_kind_id }">${firstList.first_kind_name }</option>
							</c:forEach>
						</select>
						<input type="hidden" name="first_kind_name"/>
					</td>
					<td width="11%" class="TD_STYLE1">
						II级机构
					</td>
					<td width="14%" class="TD_STYLE2">
						<select name="second_kind_id" class="SELECT_STYLE1" id="secondKind">
							<option value="1">湖南分校</option>
						</select>
						<input type="hidden" name="second_kind_name"/>
					</td>
					<td width="11%" class="TD_STYLE1">
						III级机构
					</td>
					<td class="TD_STYLE2" colspan="2">
						<select name="third_kind_id" class="SELECT_STYLE1" id="thirdKind">
							<option value="1">长沙华瑞</option>
						</select>
						<input type="hidden" name="third_kind_name"/>
					</td>
					<td rowspan="5" style="text-align: center;">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						职位分类
					</td>
					<td class="TD_STYLE2">
						<select name="human_major_kind_id" class="SELECT_STYLE1" id="majorKind" onchange="fun()" >
							<c:forEach var="fenleilist" items="${fenleilist }">
								<option value="${fenleilist.major_kind_id }">${fenleilist.major_kind_name }</option>
							</c:forEach>
						</select>
						<input type="hidden" name="human_major_kind_name"/>
					</td>
					<td class="TD_STYLE1">
						职位名称
					</td>
					<td class="TD_STYLE2">
						<select name="human_major_id" class="SELECT_STYLE1" id="majorName">
							<option value="0">请选择</option>
						</select>
						<input type="hidden" name="hunma_major_name"/>
					</td>
					<td class="TD_STYLE1">
						职称
					</td>
					<td colspan="2" class="TD_STYLE2">
						<select name="human_pro_designation" class="SELECT_STYLE1">
							<option>工程师</option>
							<option>助理</option>
							<option>经理</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						姓名
					</td>
					<td class="TD_STYLE2">
						<input type="text" id="humanName" name="human_name"
							class="INPUT_STYLE2"/>
					</td>
					<td class="TD_STYLE1">
						性别
					</td>
					<td class="TD_STYLE2">
						<select name="human_sex" class="SELECT_STYLE1">
							<option value="男" selected="selected">
								男
							</option>
							<option value="女">
								女
							</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						EMAIL
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="human_email" id="humanEmail"
							class="INPUT_STYLE2"/>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						电话
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_telephone" id="humanTelephone"
							class="INPUT_STYLE2"/>
					</td>
					<td class="TD_STYLE1">
						QQ
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_qq" id="humanQq"
							class="INPUT_STYLE2"/>
					</td>
					<td class="TD_STYLE1">
						手机
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="human_mobilephone" id="humanMobilephone"
							class="INPUT_STYLE2"/>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						住址
					</td>
					<td colspan="3" class="TD_STYLE2">
						<input type="text" name="human_address"
							class="INPUT_STYLE2"/>
					</td>
					<td class="TD_STYLE1">
						邮编
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="human_postcode"
							class="INPUT_STYLE2"/>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						国籍
					</td>
					<td class="TD_STYLE2">
						<select name="human_nationality" class="SELECT_STYLE1">
						<c:forEach var="listguoji" items="${listguoji }">
							<option value="${listguoji.pbc_id }">${listguoji.attribute_name }</option>
						</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						出生地
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_birthplace"
							class="INPUT_STYLE2"/>
					</td>
					<td class="TD_STYLE1">
						生日
					</td>
					<td width="13%" class="TD_STYLE2">
						<input type="text" name="humanFile.humanBirthday" readonly="readonly"
							class="INPUT_STYLE2" id="birthday">
					</td>
					<td width="11%" class="TD_STYLE1">
						民族
					</td>
					<td class="TD_STYLE2" width="14%">
						<select name="human_race" class="SELECT_STYLE1">
						<c:forEach var="listmingzu" items="${listmingzu }">
							<option value="${listmingzu.pbc_id }">${listmingzu.attribute_name }</option>
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
							<option value="${listzongjiao.pbc_id }">${listzongjiao.attribute_name }</option>
						</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						政治面貌
					</td>
					<td class="TD_STYLE2">
						<select name="human_party" class="SELECT_STYLE1">
						<c:forEach var="listzhengzhi" items="${listzhengzhi }">
							<option value="${listzhengzhi.pbc_id }">${listzhengzhi.attribute_name }</option>
						</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						身份证号码
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_id_card" id="humanIdCard"
							class="INPUT_STYLE2"/>
					</td>
					<td class="TD_STYLE1">
						社会保障号码
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_society_security_id"
							class="INPUT_STYLE2"/>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						年龄
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_age" id="humanAge"
							class="INPUT_STYLE2"/>
					</td>
					<td class="TD_STYLE1">
						学历
					</td>
					<td class="TD_STYLE2">
						<select name="human_educated_degree" class="SELECT_STYLE1">
						<c:forEach var="listxueli" items="${listxueli }">
							<option value="${listxueli.pbc_id }">${listxueli.attribute_name }</option>
						</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						教育年限
					</td>
					<td class="TD_STYLE2">
						<select name="human_educated_years" class="SELECT_STYLE1">
						<c:forEach items="${listjiaoyu }" var="listjiaoyu">
							<option value="${listjiaoyu.pbc_id }">${listjiaoyu.attribute_name }</option>
						</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						学历专业
					</td>
					<td class="TD_STYLE2">
						<select name="human_educated_major" class="SELECT_STYLE1">
						<c:forEach var="listzhuanye" items="${listzhuanye }">
							<option value="${listzhuanye.pbc_id }">${listzhuanye.attribute_name }</option>
						</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						薪酬标准
					</td>
					<td class="TD_STYLE2">
						<select name="salary_standard_name" class="SELECT_STYLE1">
							<option>薪酬标准1</option>
							<option>薪酬标准2</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						开户行
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_bank"
							class="INPUT_STYLE2"/>
					</td>
					<td class="TD_STYLE1">
						帐号
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_account"
							class="INPUT_STYLE2"/>
					</td>
					<td class="TD_STYLE1">
						登记人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="register" value="${loginUser.user_true_name }"
							readonly="readonly" class="INPUT_STYLE2"/>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						建档时间
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="regist_time" id="create_time" readonly="readonly"
							class="INPUT_STYLE2"/>
					</td>
					<td class="TD_STYLE1">
						特长
					</td>
					<td class="TD_STYLE2">
						<select name="human_speciality" class="SELECT_STYLE1">
						<c:forEach var="listtechang" items="${listtechang }">
							<option value="${listtechang.pbc_id }">${listtechang.attribute_name }</option>
						</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						爱好
					</td>
					<td class="TD_STYLE2">
						<select name="human_hobby" class="SELECT_STYLE1">
						<c:forEach items="${listaihao }" var="listaihao">
							<option value="${listaihao.pbc_id }">${listaihao.attribute_name }</option>
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
							class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						家庭关系信息
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="human_family_membership" rows="4"
							class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						备注
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="remark" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
			</table>
			<tr>
					<td align="right">
						<input type="submit" value="提交" class="BUTTON_STYLE1"/>
						<input type="reset" value="清除" class="BUTTON_STYLE1"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

