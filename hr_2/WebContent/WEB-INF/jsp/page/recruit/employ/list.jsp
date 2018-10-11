<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My JSP 'filter_result.jsp' starting page</title>
 	  <link rel="stylesheet"
			href="../css/table.css" type="text/css">
		<link rel="stylesheet"
			href="../css/cwcalendar.css"
			type="text/css">
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
	 
     </head>

	<body>
	<form method="post" name="fm" action="/HR_Fist/recruit/recruitAction!list">
		<input type="hidden" name="utilBean.currPage" id="page"/>
		<table width="100%">
			<tr>
				<td>
					<font color="black">您正在做的业务是：人力资源--招聘管理--录用管理--录用查询  </font>
				</td>
			</tr>
		</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr class="TR_STYLE1">
					<td class="TD_STYLE1">
						姓名
					</td>
					<td class="TD_STYLE1">
						性别
					</td>
					<td class="TD_STYLE1">
						年龄
					</td>
					<td class="TD_STYLE1">
						职位类别
					</td>
					<td class="TD_STYLE1">
						职位名称
					</td>
					<td class="TD_STYLE1">
						毕业院校
					</td>
					<td class="TD_STYLE1">
						学历专业
					</td>
					<td class="TD_STYLE1">
						查询
					</td>
					<td class="TD_STYLE1">
						发送邮件
					</td>
				</tr>
				
				 <c:forEach items="${eil }" var="eil">
				 
				 <c:if test="${eil.engage_resume.pass_passComment!=null }">
									
					<tr class="TR_STYLE1">
						<td class="TD_STYLE2">
							${eil.human_name }
						</td>
						<td class="TD_STYLE2">
							${eil.engage_resume.human_sex }
						</td>
						<td class="TD_STYLE2">
							${eil.engage_resume.human_age }
						</td>
						<td class="TD_STYLE2">
							${eil.human_major_kind_name }
						</td>
						<td class="TD_STYLE2">
							${eil.human_major_name }
						</td>
						<td class="TD_STYLE2">
							${eil.engage_resume.human_college }
						</td>
						<td class="TD_STYLE2">
							${eil.engage_resume.human_educated_major }
						</td>
						    <c:if test="${eil.engage_resume.pass_passComment=='通过,通过' }">
								<td class="TD_STYLE2">
									<a href="details_queryDan?id=${eil.ein_id }">通过&nbsp;&nbsp;查询</a>
								</td>
							</c:if>
							
							<c:if test="${eil.engage_resume.pass_passComment=='不通过,不通过' }">
								<td class="TD_STYLE2">
									<a href="details_queryDan?id=${eil.ein_id }">不通过&nbsp;&nbsp;查询</a>
								</td>
							</c:if>
							<td class="TD_STYLE2">
								<a href="selemail2?id=${eil.engage_resume.res_id }">${eil.engage_resume.human_email }</a>
							</td>
						
					</tr>
				 </c:if>
					</c:forEach>
					 
			</table>
			<p>&nbsp;&nbsp;总数：2 例 &nbsp;&nbsp;&nbsp;当前第1 页 /每页显示 10 条 &nbsp;&nbsp;&nbsp;共 1 页 &nbsp;&nbsp;&nbsp;  
			<a href="javascript:up('0','1')" >上一页</a> &nbsp;&nbsp;&nbsp;
			<a href="javascript:down('2','1')" >下一页</a> &nbsp;&nbsp;&nbsp;跳到第 <input name=page type=text class=input1 id="currPage" size=1> 页&nbsp;&nbsp;<input type=image src="../images/go.bmp" onclick="tj('1')" width=18 height=18 border=0>
		</form>
		<script type="text/javascript">
		function up(currPage,row){  
		if(currPage<=0){
		document.getElementById("page").value = row;
		}else{
		document.getElementById("page").value =currPage; 
		}
		 document.fm.submit();
		}
		function down(currPage,row){ 
		if(currPage>=row){
		document.getElementById("page").value = row;
		}else{
		document.getElementById("page").value =currPage; 
		}
		 document.fm.submit();
		}
		function tj(row){
	     document.getElementById("page").value = document.getElementById("currPage").value;
	     if(document.getElementById("currPage").value>row){
	     alert("最大页数为"+row+",当前为第"+row+"页 ");
	     return false;
	     }
	     document.fm.submit();
	 	}
		</script>
</body>
</html>