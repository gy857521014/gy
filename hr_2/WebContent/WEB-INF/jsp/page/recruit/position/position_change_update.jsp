<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
  <head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
		function dodelete(id){
			
	    		if(confirm("您确定要删除吗？")){
					$.ajax({
						url:'deleterelease?id='+id,
						type:'get',
						success:function(data){
							if(data=="1"){
								
								$("#"+id).remove();
							}
						
						}

					});

	    		}
	    	}
		</script>
		
		</head>

	<body>
		<form method="post" action="/HR_Fist/recruit/recruitAction!findMajor" name="fm">
		<input type="hidden" name="utilBean.currPage" id="page"/>
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--招聘管理--职位发布管理--职位发布变更 
						</font>
					</td>
				</tr>
			 
			</table>
		
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="15%" class="TD_STYLE1">
						职位名称
					</td>
					<td width="20%" class="TD_STYLE1">
						公司名称
					</td>
					<td width="10%" class="TD_STYLE1">
						招聘人数
					</td>
					<td width="20%" class="TD_STYLE1">
						发布时间
					</td>
					<td width="20%" class="TD_STYLE1">
						截止时间
					</td>
					<td width="8%" class="TD_STYLE1">
						修改
					</td>
					<td width="8%" class="TD_STYLE1">
						删除
					</td>
				</tr>
				
			<c:forEach var="rlist" items="${releaselist}">
				<tr id="${rlist.mre_id}">
						<td class="TD_STYLE2">
							${rlist.major_name }
						</td>
						<td class="TD_STYLE2">
							<c:if test="${not empty rlist.third_kind_name}">
								${rlist.third_kind_name}
							</c:if>
							
							<c:if test="${empty rlist.third_kind_name and not empty rlist.second_kind_name}">
								${rlist.second_kind_name }
							</c:if>
							
							<c:if test="${empty rlist.third_kind_name and empty rlist.second_kind_name}">
								${rlist.first_kind_name}
							</c:if>
						</td>
						<td class="TD_STYLE2">
							${rlist.human_amount }
						</td>
						<td class="TD_STYLE2"> 
							${rlist.regist_time }
						</td >
						<td class="TD_STYLE2"> 
							${rlist.deadline } 
						</td>
					 
			
						<td class="TD_STYLE2">
							<a href="updatechange?mre_id=${rlist.mre_id}">修改</a>
						</td>
						<td class="TD_STYLE2">
							<a href="javascript:dodelete(${rlist.mre_id})">删除</a>
						</td>
					</tr>
					</c:forEach>
				
				
				
			</table>
			</form>
		<script type="text/javascript">
		function up(currPage){  
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
