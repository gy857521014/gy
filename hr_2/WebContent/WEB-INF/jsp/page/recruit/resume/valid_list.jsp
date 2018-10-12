<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
  <head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My JSP 'valid-list.jsp' starting page</title>
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
     </head>

	<body>
		<form method="post" action="/HR_Fist/recruit/recruitAction!toResumeList?a=valid" name="fm">
		<input type="hidden" name="utilBean.currPage" id="page"/>
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--招聘管理--简历管理--有效简历列表 
						</font>
					</td>
				</tr>
			 <tr>
					<td align="right"> 
						<input type="button" value="返回" class="BUTTON_STYLE1" onclick="history.back();">
					</td>
				</tr>
			</table> 
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="15%" class="TD_STYLE1">
						档案编号
					</td>
					<td width="15%" class="TD_STYLE1">
						姓名
			     	</td>
					<td width="15%" class="TD_STYLE1">
						性别
					</td>
					<td width="15%" class="TD_STYLE1">
						职位分类
					</td>
					<td width="10%" class="TD_STYLE1">
						职位名称
					</td>
					<td width="10%" class="TD_STYLE1">
						电话号码
					</td>
					<td width="10%" class="TD_STYLE1">
						复核状态
					</td>
					<td width="10%" class="TD_STYLE1">
						面试状态
					</td>
					<td width="10%" class="TD_STYLE1">
						发送邮箱
					</td>
				</tr>
				
				<c:forEach items="${relist }" var="list">
					<tr>
						<td class="TD_STYLE2">
							<a href="selresumeid?res_id=${list.res_id }">
								${list.res_id}</a>
						</td>
						<td class="TD_STYLE2">
							${list.human_name}
						</td>
						<td class="TD_STYLE2">
							${list.human_sex}
						</td>
						<td class="TD_STYLE2">
						${list.human_major_kind_name}
						</td>
						<td class="TD_STYLE2">
						${list.human_major_name}
						</td>
						<td class="TD_STYLE2">
						${list.human_telephone}
						</td>
						<td class="TD_STYLE2">
							<c:if test="${list.check_status==1 }">
								未通过
							</c:if>
							<c:if test="${list.check_status==2 }">
								已通过
							</c:if>
						</td>
						
							 <c:if test="${list.interview_status==2 }">
							 	<td class="TD_STYLE2">
									不可以面试
								</td>
								<td class="TD_STYLE2">
									<span>${list.human_email }</span>
								</td>
							</c:if>
							
							
							<c:if test="${list.interview_status==1 }">
								<td class="TD_STYLE2">
									<span style="color:red">可以面试</span>
								</td>
								<td class="TD_STYLE2">
									<c:if test="${list.pass_check_status==1}">
										<a href="selemail?id=${list.res_id }" style="color:red">${list.human_email }</a>
									</c:if>
									<c:if test="${list.pass_check_status==2}">
										<span style="color:red">已发送</span>
									</c:if>
								</td>								
							</c:if>
							
							<c:if test="${list.interview_status==3 }">
								<td class="TD_STYLE2">
									已面试
								</td>
								<td class="TD_STYLE2">
									<c:if test="${list.pass_check_status==2 or list.pass_check_status==3}">
										<span style="color:red">已发送</span>
									</c:if>
								</td>								
							</c:if>
					</tr>
					</c:forEach>
					
					
			</table>
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