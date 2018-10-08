<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<link rel="stylesheet"
			href="../css/table.css" type="text/css" />
		<link rel="stylesheet"
			href="../css/cwcalendar.css" type="text/css"/>
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
<!-- 职位二级联动 -->
<script type="text/javascript">
function fun(){
	var pid =$("#majorKind").val();
	$.ajax({
		url:'selectzhiwei1?majorid='+pid,
		type:'get',
		success:function(data){
			var cityselect=$("#majorName");
			cityselect.empty();
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
		url:'selerji1?fsk_id='+pid,
		type:'get',
		success:function(data){
			var cityselect=$("#secondKind");
			cityselect.empty();
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
<!-- 机构的三级联动 -->
<script type="text/javascript">
function queryThird(){
	var pid =$("#secondKind").val();
	$.ajax({
		url:'selsanji1?fsk_id='+pid,
		type:'get',
		success:function(data){
			var cityselect=$("#thirdKind");
			cityselect.empty();
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
		<form method="post" action="query_list">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--人力资源档案管理--人力资源档案查询 </font>
					</td>
				</tr>
				<tr>
					<td align="right"> 
						<input type="submit" value="查询" class="BUTTON_STYLE1"/>
						<input type="button" value="搜索" class="BUTTON_STYLE1"
							onclick="location.href='query_keywords.html'">
						<input type="hidden" name="result" value="toQueryList"/>
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr class="TR_STYLE1">
					<td width="16%" class="TD_STYLE1">
						请选择员工所在I级机构
					</td>
					<td width="84%" class="TD_STYLE2">
						<select name="first_king_id" size="5" id="firstKind" onchange="querySecond()" 
						class="SELECT_STYLE2">
							<option value="0" selected="selected">全部</option>
							<c:forEach var="firstList" items="${FirstList }">
								<option value="${firstList.first_kind_id }">${firstList.first_kind_name }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						请选择员工所在II级机构
					</td>
					<td width="84%" class="TD_STYLE2">
						<select name="second_kind_id" size="5" id="secondKind" onchange="queryThird()"
							class="SELECT_STYLE2">
							<option value="0" selected="selected">
							全部
							</option>
						</select>
					</td>
				</tr>
				<tr class="TR_STYLE1">
					<td width="16%" class="TD_STYLE1">
						请选择员工所在III级机构
					</td>
					<td width="84%" class="TD_STYLE2">
						<select name="third_kind_id" class="SELECT_STYLE2" size="5" id="thirdKind">
							<option value="0" selected="selected">
							全部
							</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						请选择职位分类
					</td>
					<td width="84%" class="TD_STYLE2">
						<select name="human_major_kind_id" size="5" id="majorKind" onchange="fun()" 
							class="SELECT_STYLE2">
							<option value="0" selected="selected">
								全部
							</option>
							<c:forEach var="fenleilist" items="${fenleilist }">
								<option value="${fenleilist.major_kind_id }">${fenleilist.major_kind_name }</option>
							</c:forEach>
							
						</select>
					</td>
				</tr>
				<tr class="TR_STYLE1">
					<td width="16%" class="TD_STYLE1">
						请选择职位名称
					</td>
					<td width="84%" class="TD_STYLE2">
						<select name="human_major_id" size="5" class="SELECT_STYLE2" id="majorName">
							<option value="0" selected="selected">
								全部
							</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						请输入建档时间
					</td>
					<td width="84%" class="TD_STYLE2">
						<input type="text" name="utilBean.startDate" readonly
							style="width: 14%" class="INPUT_STYLE2" id="date_start">
						至
						<input type="text" name="utilBean.endDate" readonly="readonly"
							style="width: 14%" class="INPUT_STYLE2" id="date_end">
						<input type="hidden" name="utilBean.datePropertyName" value="registTime"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
