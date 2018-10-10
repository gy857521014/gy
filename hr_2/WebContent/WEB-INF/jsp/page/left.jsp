<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>无标题文档</title>
		<link rel="stylesheet"
			href="../css/table.css" type="text/css"/>
		<link rel="stylesheet" href="../javascript/easyui/themes/default/easyui.css"/>
		<link rel="stylesheet" href="../javascript/easyui/themes/icon.css"/>
		<script type="text/javascript" src="../javascript/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="../javascript/jquery.easyui.min.js"></script>
	</head>
	<body >
	
		<ul id="tt1" class="easyui-tree" animate="true">
		<c:forEach items="${loginUser.rq }" var="rqs">
		<c:if test="${rqs.q_id==1}">
				<li>
					<span>招聘管理</span>
					<ul>
							<c:if test="${rqs.q_id==101 or rqs.q_id==1}">
								<li state="closed">
									<span>
										职位发布管理
									</span>
									<ul>
											<c:if test="${rqs.q_id==1 or rqs.q_id==101 or rqs.q_id==10101}">
												<li>
													<span>
														<a href="torecruit" target="mainFrame" style="color:black;">职位发布登记</a>
													</span>
												</li>
											</c:if>
											<c:if test="${rqs.q_id==1 or rqs.q_id==101 or rqs.q_id==10102}">
												<li>
													<span>
														<a href="selallrelease" target="mainFrame" style="color:black;">职位发布变更</a>
													</span>
												</li>
											</c:if>	
											<c:if test="${rqs.q_id==1 or rqs.q_id==101 or rqs.q_id==10103}">	
												<li>
													<span>
														<a href="selallrelease2" target="mainFrame" style="color:black;">职位发布查询</a>
													</span>
												</li>
											</c:if>
									</ul>
								</li>
							</c:if>
								
							<c:if test="${rqs.q_id==1 or rqs.q_id==102}">	
								<li state="closed">
									<span>
										简历管理
									</span>
									<ul>
											<c:if test="${rqs.q_id==1 or rqs.q_id==102 or rqs.q_id==10201}">
												<li>
													<span>
														<a href="recruit/resume/register.html" target="mainFrame" style="color:black;">简历登记</a>
													</span>
												</li>
											</c:if>
											<c:if test="${rqs.q_id==1 or rqs.q_id==102 or rqs.q_id==10202}">
												<li>
													<span>
														<a href="recruit/resume/resume-choose.html" target="mainFrame" style="color:black;">简历筛选</a>
													</span>
												</li>
											</c:if>
											<c:if test="${rqs.q_id==1 or rqs.q_id==102 or rqs.q_id==10203}">
												<li>
													<span>
														<a href="recruit/resume/valid-resume.html" target="mainFrame" style="color:black;">有效简历查询</a>
													</span>
												</li>
											</c:if>
									</ul>
								</li>
							</c:if>
								
							<c:if test="${rqs.q_id==1 or rqs.q_id==103}">	
								<li state="closed">
									<span>
										面试管理
									</span>
									<ul>
											<c:if test="${rqs.q_id==1 or rqs.q_id==103 or rqs.q_id==10301}">
												<li>
													<span>
														<a href="recruit/interview/interview-list.html" target="mainFrame" style="color:black;">面试结果登记</a>
													</span>
												</li>
											</c:if>
											<c:if test="${rqs.q_id==1 or rqs.q_id==103 or rqs.q_id==10302}">
												<li>
													<span>
														<a href="recruit/interview/sift-list.html" target="mainFrame" style="color:black;">面试筛选</a>
													</span>
												</li>
											</c:if>
									</ul>
								</li>
							</c:if>
							
							<c:if test="${rqs.q_id==1 or rqs.q_id==106}">
								<li state="closed">
									<span>
										录用管理
									</span>
									<ul>
											<c:if test="${rqs.q_id==1 or rqs.q_id==106 or rqs.q_id==10601}">
												<li>
													<span>
														<a href="recruit/employ/register_list.html" target="mainFrame" style="color:black;">录用申请</a>
													</span>
												</li>
											</c:if>
											<c:if test="${rqs.q_id==1 or rqs.q_id==106 or rqs.q_id==10602}">
												<li>
													<span>
														<a href="recruit/employ/check_list.html" target="mainFrame" style="color:black;">录用审批</a>
													</span>
												</li>
											</c:if>
											<c:if test="${rqs.q_id==1 or rqs.q_id==106 or rqs.q_id==10603}">
												<li>
													<span>
														<a href="recruit/employ/list.html" target="mainFrame" style="color:black;">录用查询</a>
													</span>
												</li>
											</c:if>
									</ul>
								</li>
							</c:if>
					</ul>
				</li>
				</c:if>
			</c:forEach>
			
			
			<c:forEach items="${loginUser.rq }" var="rqs">
			<c:if test="${rqs.q_id==2}">
				<li>
					<span>人力资源档案管理</span>
					<ul>
							<c:if test="${rqs.q_id==2 or rqs.q_id==201 }">
								<li>
									<span>
											<a href="human_register" target="mainFrame" style="color:black;">人力资源档案登记</a>
									</span>
								</li>
							</c:if>
							<c:if test="${rqs.q_id==2 or rqs.q_id==202 }">
								<li>
									<span>
											<a href="check_list" target="mainFrame" style="color:black;">人力资源档案登记复核</a>
									</span>
								</li>
							</c:if>
							<c:if test="${rqs.q_id==2 or rqs.q_id==203 }">
								<li>
									<span>
											<a href="query_locate" target="mainFrame" style="color:black;">人力资源档案查询</a>
									</span>
								</li>
							</c:if>
							<c:if test="${rqs.q_id==2 or rqs.q_id==204 }">
								<li>
									<span>
											<a href="change_locate" target="mainFrame" style="color:black;">人力资源档案变更</a>
									</span>
								</li>
							</c:if>
							<c:if test="${rqs.q_id==2 or rqs.q_id==205 }">
								<li state="closed">
									<span>
										人力资源档案删除管理
									</span>
									<ul>
											<c:if test="${rqs.q_id==2 or rqs.q_id==205 or rqs.q_id==20501 }">
												<li>
													<span>
															<a href="delete_locate" target="mainFrame" style="color:black;">人力资源档案删除</a>
													</span>
												</li>
											</c:if>
											<c:if test="${rqs.q_id==2 or rqs.q_id==205 or rqs.q_id==20502 }">
												<li>
													<span>
															<a href="recovery_locate" target="mainFrame" style="color:black;">档案删除恢复</a>
													</span>
												</li>
											</c:if>
											<c:if test="${rqs.q_id==2 or rqs.q_id==205 or rqs.q_id==20503 }">
												<li>
													<span>
															<a href="delete_forever_list" target="mainFrame" style="color:black;">人力资源档案永久删除</a>
													</span>
												</li>
											</c:if>
									</ul>
								</li>
							</c:if>
					</ul>
				</li>
			</c:if>
		</c:forEach>
		
		<c:forEach items="${loginUser.rq }" var="rqs">
			<c:if test="${rqs.q_id==3}">
				<li>
					<span>薪酬标准管理</span>
					<ul>
							<c:if test="${rqs.q_id==3 or rqs.q_id==301 }">
								<li>
									<span>
										<a href="tosalarystandard_register" target="mainFrame" style="color:black;">薪酬标准登记</a>
									</span>
								</li>
							</c:if>
							<c:if test="${rqs.q_id==3 or rqs.q_id==302 }">
								<li>
									<span>
										<a href="tosalarystandard_check_list?start=0" target="mainFrame" style="color:black;">薪酬标准登记复核</a>
									</span>
								</li>
							</c:if>
							<c:if test="${rqs.q_id==3 or rqs.q_id==303 }">
								<li>
									<span>
										<a href="tosalarystandard_query_locate" target="mainFrame" style="color:black;">薪酬标准查询</a>
									</span>
								</li>
							</c:if>
							<c:if test="${rqs.q_id==3 or rqs.q_id==304 }">
								<li>
									<span>
										<a href="tosalarystandard_change_locate" target="mainFrame" style="color:black;">薪酬标准变更</a>
									</span>
								</li>
							</c:if>
					</ul>
				</li>
			</c:if>
		</c:forEach>
		
		<c:forEach items="${loginUser.rq }" var="rqs">
			<c:if test="${rqs.q_id==4}">
				<li>
					<span>薪酬发放管理</span>
					<ul>
							<c:if test="${rqs.q_id==4 or rqs.q_id==401 }">
								<li>
									<span>
										<a href="tolo" target="mainFrame" style="color:black;">薪酬发放登记</a>
									</span>
								</li>
							</c:if>
							<c:if test="${rqs.q_id==4 or rqs.q_id==402 }">	
								<li>
									<span>
										<a href="salaryGrant/check_list.html" target="mainFrame" style="color:black;">薪酬发放登记复核</a>
									</span>
								</li>
							</c:if>
							<c:if test="${rqs.q_id==4 or rqs.q_id==403 }">	
								<li>
									<span>
										<a href="salaryGrant/query_locate.html" target="mainFrame" style="color:black;">薪酬发放查询</a>
									</span>
								</li>
							</c:if>
					</ul>
				</li>
			</c:if>
		</c:forEach>
		
		<c:forEach items="${loginUser.rq }" var="rqs">
			<c:if test="${rqs.q_id==5}">
				<li>
					<span>调动管理</span>
					<ul>
							<c:if test="${rqs.q_id==5 or rqs.q_id==501 }">
								<li>
									<span>
										<a href="transfer/register_locate.html" target="mainFrame" style="color:black;">调动登记</a>
									</span>
								</li>
							</c:if>	
							<c:if test="${rqs.q_id==5 or rqs.q_id==502 }">
								<li>
									<span>
										<a href="transfer/check_list.html" target="mainFrame" style="color:black;">调动审核</a>
									</span>
								</li>
							</c:if>	
							<c:if test="${rqs.q_id==5 or rqs.q_id==503 }">
								<li>
									<span>
										<a href="transfer/locate.html" target="mainFrame" style="color:black;">调动查询</a>
									</span>
								</li>
							</c:if>
					</ul>
				</li>
			</c:if>
		</c:forEach>
		
		<c:forEach items="${loginUser.rq }" var="rqs">
			<c:if test="${rqs.q_id==6}">
				<li>
					<span>客户化设置</span>
					<ul>
							<c:if test="${rqs.q_id==6 or rqs.q_id==601 }">
								<li state="closed">
									<span>
										人力资源档案管理设置
									</span>
									<ul>
											<c:if test="${rqs.q_id==6 or rqs.q_id==601  or rqs.q_id==60101 }">
												<li>
													<span>
														<a href="selcffk" target="mainFrame" style="color:black;">Ⅰ级机构设置</a>
													</span>
												</li>
											</c:if>
											<c:if test="${rqs.q_id==6 or rqs.q_id==601  or rqs.q_id==60102 }">
												<li>
													<span>
														<a href="selcfsk" target="mainFrame" style="color:black;">Ⅱ级机构设置</a>
													</span>
												</li>
											</c:if>	
											<c:if test="${rqs.q_id==6 or rqs.q_id==601  or rqs.q_id==60103 }">
												<li>
													<span>
														<a href="selcftk" target="mainFrame" style="color:black;">Ⅲ级机构设置</a>
													</span>
												</li>
											</c:if>	
											<c:if test="${rqs.q_id==6 or rqs.q_id==601  or rqs.q_id==60104 }">	
												<li>
													<span>
														<a href="selzc" target="mainFrame" style="color:black;">职称设置</a>
													</span>
												</li>
											</c:if>	
											<c:if test="${rqs.q_id==6 or rqs.q_id==601  or rqs.q_id==60105 }">	
												<li>
													<span>
														<a href="selcmk" target="mainFrame" style="color:black;">职位分类设置</a>
													</span>
												</li>
											</c:if>	
											<c:if test="${rqs.q_id==6 or rqs.q_id==601  or rqs.q_id==60106 }">	
												<li>
													<span>
														<a href="selcm" target="mainFrame" style="color:black;">职位设置</a>
													</span>
												</li>
											</c:if>	
											<c:if test="${rqs.q_id==6 or rqs.q_id==601  or rqs.q_id==60107 }">	
												<li>
													<span>
														<a href="selcpc" target="mainFrame" style="color:black;">公共属性设置</a>
													</span>
												</li>
											</c:if>
									</ul>
								</li>
							</c:if>
							
							<c:if test="${rqs.q_id==6 or rqs.q_id==602 }">
								<li state="closed">
									<span>
										薪酬管理设置
									</span>
									<ul>
											<c:if test="${rqs.q_id==6 or rqs.q_id==602  or rqs.q_id==60201 }">	
												<li>
													<span>
														<a href="selxc" target="mainFrame" style="color:black;">薪酬项目设置</a>
													</span>
												</li>
											</c:if>
									</ul>
								</li>
							</c:if>
							<c:if test="${rqs.q_id==6 or rqs.q_id==604 }">
								<li state="closed">
									<span>
										邮箱管理设置
									</span>
									<ul>
											<c:if test="${rqs.q_id==6 or rqs.q_id==604  or rqs.q_id==60401 }">
												<li>
													<span>
														<a href="selm" target="mainFrame" style="color:black;">邮箱设置</a>
													</span>
												</li>
											</c:if>
									</ul>
								</li>
							</c:if>
					</ul>
				</li>
			</c:if>
		</c:forEach>
		
				
				<li>
						<span>权限管理</span>
						<ul>
								<li>
									<span>
											<a href="queryAll" target="mainFrame" style="color:black;">用户管理</a>
									</span>
								</li>
								
						<c:forEach items="${loginUser.rq }" var="rqs">
							<c:if test="${rqs.q_id==802}">
								<li>
									<span>
											<a href="user_roleAll" target="mainFrame" style="color:black;">角色管理</a>
									</span>
								</li>
							</c:if>
						</c:forEach>
						</ul>
				</li>
		</ul>
		
	</body>
</html>
