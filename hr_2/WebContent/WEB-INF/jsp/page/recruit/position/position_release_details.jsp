<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
  <head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My JSP 'position-release_details.jsp' starting page</title>
    
	  <link rel="stylesheet"
			href="../css/table.css" type="text/css">
		<link rel="stylesheet"
			href="../css/cwcalendar.css" type="text/css">
		<script type="text/javascript"
			src="../javascript/comm/comm.js">
		</script>
		<script type="text/javascript"
			src="../javascript/comm/list.js">
		</script>
		<script type="text/javascript"
			src="../javascript/calendar-ch.js">
		</script>
		<script type="text/javascript"
			src="../javascript/jquery-1.7.2.js">
		</script>
		<script type="text/javascript"
			src="../javascript/locate.js">
		</script>
	 <script type="text/javascript"
			src="../javascript/select.js">
		</script>
		
		<script type="text/javascript">
		function search(id){ 
		 // document.fm.submit();		
 		window.location.href="/HR_Fist/recruit/recruitAction!register?id="+id;
		}
		</script>
   <script>
function fun(){
	var pid =$("#majorKindId").val();
	$.ajax({
		url:'selzhiwei?majorid='+pid,
		type:'get',
		success:function(data){
			var cityselect=$("#majorId");
			cityselect.empty();
			cityselect.append("<option value='0'>--请选择职位名称--</option>");
			for(var i=0;i<data.length;i++){
				var eachCity=data[i];
				var id=eachCity.major_id;
				var name=eachCity.major_name;
				cityselect.append("<option value='"+id+"'>"+name+"</option>");		
				}
			}
		
		});

	}
	
function fun1(){
	var id =$("#firstKindId").val();
	$.ajax({
		url:'selerji?fsk_id='+id,
		type:'get',
		success:function(data){
			var cityselect=$("#secondKindId");
			cityselect.empty();
			cityselect.append("<option value=''>--请选择二级机构--</option>");
			var cityselect2=$("#thirdKindId");
			cityselect2.empty();
			cityselect2.append("<option value=''>--请选择三级机构--</option>");
			for(var i=0;i<data.length;i++){
				var eachCity=data[i];
				var id=eachCity.second_kind_id;
				var name=eachCity.second_kind_name;
				cityselect.append("<option value='"+id+"'>"+name+"</option>");		
				}
			}
		
		});

	}

function fun2(){
	var id =$("#secondKindId").val();
	$.ajax({
		url:'selsanji?fsk_id='+id,
		type:'get',
		success:function(data){
			var cityselect=$("#thirdKindId");
			cityselect.empty();
			cityselect.append("<option value=''>--请选择三级机构--</option>");
			for(var i=0;i<data.length;i++){
				var eachCity=data[i];
				var id=eachCity.third_kind_id;
				var name=eachCity.third_kind_name;
				cityselect.append("<option value='"+id+"'>"+name+"</option>");		
				}
			}
		
		});

	}
</script>
 		
 	</head>
	<body>
		<form id="recruitAction!toRegister" name="fm" action="/HR_Fist/recruit/recruitAction!toRegister" method="post" enctype="multipart/form-data">
			<input type="hidden" name="emajorRelease.mreId" value="531" />
			<table width="100%"> 
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--招聘管理--职位发布管理--职位发布查询--详细  </font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="确认申请" onclick="search('531')" class="BUTTON_STYLE1" />
						<input type="button" value="返回" class="BUTTON_STYLE1" onclick="history.back();">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1" width="11%">
						I级机构
					</td>
					<td width="14%" class="TD_STYLE2">
					<select name="emajorRelease.firstKindName" id="firstKindId" onchange="fun1()">
					<c:forEach items="${firstlist}" var="flist">
						<c:if test="${release.first_kind_id==flist.first_kind_id }">
							<option value="${flist.first_kind_id}" selected>${flist.first_kind_name }</option>
						</c:if>
						<c:if test="${release.first_kind_id!=flist.first_kind_id }">
							<option value="${flist.first_kind_id}">${flist.first_kind_name }</option>
						</c:if>
					</c:forEach>
						</select>
					</td>
					<td width="11%" class="TD_STYLE1">
						II级机构
					</td>
					<td width="14%" class="TD_STYLE2">
					<select name="emajorRelease.secondKindName" onchange="fun2()" id="secondKindId">
					<c:forEach items="${erlist}" var="erlist">
						<c:if test="${release.first_kind_id==erlist.first_kind_id }">
							<c:if test="${release.second_kind_id==erlist.second_kind_id }">
								<option value="${erlist.second_kind_id }" selected>${erlist.second_kind_name}</option>
							</c:if>
							<c:if test="${release.second_kind_id!=erlist.second_kind_id }">
								<option value="${erlist.second_kind_id }">${erlist.second_kind_name}</option>
							</c:if>
						</c:if>
					</c:forEach>
						</select>
					</td>
					<td width="11%" class="TD_STYLE1">
						III级机构
					</td>
					<td class="TD_STYLE2"  >
						<select name="emajorRelease.thirdKindId" id="thirdKindId">
					<c:forEach items="${sanlist}" var="slist">
						<c:if test="${release.second_kind_id==slist.second_kind_id }">
							<c:if test="${release.third_kind_id==slist.third_kind_id }">
								<option value="${slist.third_kind_id }" selected> ${slist.third_kind_name }</option>
							</c:if>
							<c:if test="${release.third_kind_id!=slist.third_kind_id }">
								<option value="${slist.third_kind_id }">${slist.third_kind_name }</option>
							</c:if>
						</c:if>
					</c:forEach>
						</select>
					</td>
					<td width="11%" class="TD_STYLE1">
						招聘类型
					</td>
					<td class="TD_STYLE2" colspan="2">
						<select name="emajorRelease.engageType"  class="SELECT_STYLE1">
						<c:forEach items="${zhaoplist}" var="zhlist">
							<c:if test="${release.engage_type==zhlist.attribute_name }">
								<option value="${zhlist.attribute_name }" selected>${zhlist.attribute_name }</option>
							</c:if>
							<c:if test="${release.engage_type!=zhlist.attribute_name }">
								<option value="${zhlist.attribute_name }">${zhlist.attribute_name }</option>
							</c:if>
						</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						职位分类
					</td>
					<td class="TD_STYLE2">
						<select name="emajorRelease.majorKindName" id="majorKindId" onchange="fun()">
					<c:forEach items="${kindlist }" var="klist">
				
							<c:if test="${release.major_kind_id==klist.major_kind_id }">
								<option value="${klist.major_kind_id }" selected>${klist.major_kind_name }</option>
							</c:if>
							<c:if test="${release.major_kind_id!=klist.major_kind_id }">
								<option value="${klist.major_kind_id }">${klist.major_kind_name }</option>
							</c:if>
					
					</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						职位名称
					</td>
					<td class="TD_STYLE2">
						<select name="emajorRelease.majorName" id="majorId">
					<c:forEach items="${majorlist }" var="mlist">
						<c:if test="${release.major_kind_id==mlist.major_kind_id }">
							<c:if test="${release.major_name==mlist.major_name }">
								<option value="${mlist.major_id }" selected>${mlist.major_name }</option>
							</c:if>
							<c:if test="${release.major_name!=mlist.major_name }">
								<option value="${mlist.major_id }">${mlist.major_name }</option>
							</c:if>
						</c:if>
					</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						招聘人数
					</td>
					<td   class="TD_STYLE2">
						 <input type="text" name="emajorRelease.humanAmount" value="2 " class="INPUT_STYLE2">
				
						</td>
					<td class="TD_STYLE1">
						截止日期
					</td>
					<td   class="TD_STYLE2"> 
							  <input type="text" name="emajorRelease.deadline" readonly
							class="INPUT_STYLE2" value="2012-11-15 12:00:00">
					</td>
				</tr>
				<tr>
				<td class="TD_STYLE1">
						登记人
					</td>
					<td  class="TD_STYLE2">
						 <input type="text" name="emajorRelease.register" value="&#26446;&#22235;" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						登记时间
					</td>
					<td   class="TD_STYLE2">
					<input type="text" name="emajorRelease.registTime"
							value="2012-08-02 12:00:00" readonly="readonly"
							class="INPUT_STYLE2">
					  
						</td>
					
					<td>&nbsp; </td>
					<td>&nbsp; </td>
					<td>&nbsp; </td>
					<td>&nbsp; </td>
					
				</tr>
				<tr>
					<td class="TD_STYLE1">
						职位描述
					</td>
					<td class="TD_STYLE2" colspan="8">
						<textarea name="emajorRelease.majorDescribe" rows="4" cols="100%" class="TEXTAREA_STYLE1" readonly="readonly" >&#19982;&#26102;&#20465;&#36827;</textarea>
					</td>
					 
				</tr>
					<tr>
					<td class="TD_STYLE1">
						招聘要求
					</td>
					<td class="TD_STYLE2" colspan="8">
						<textarea name="emajorRelease.engageRequired" rows="4"  cols="100%" class="TEXTAREA_STYLE1"  readonly="readonly" >&#20570;&#20107;&#32454;&#24515;</textarea>
					</td>
					 
				</tr>
			</table>
		</form>




	</body>
 
</html>

