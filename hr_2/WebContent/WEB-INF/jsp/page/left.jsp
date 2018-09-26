﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<li>
					<span>招聘管理</span>
					<ul>
								<li state="closed">
									<span>
										职位发布管理
									</span>
									<ul>
												<li>
													<span>
														<a href="torecruit" target="mainFrame" style="color:black;">职位发布登记</a>
													</span>
												</li>
												<li>
													<span>
														<a href="recruit/position/position_change_update.html" target="mainFrame" style="color:black;">职位发布变更</a>
													</span>
												</li>
												<li>
													<span>
														<a href="recruit/position/position_release_search.html" target="mainFrame" style="color:black;">职位发布查询</a>
													</span>
												</li>
									</ul>
								</li>
								<li state="closed">
									<span>
										简历管理
									</span>
									<ul>
												<li>
													<span>
														<a href="recruit/resume/register.html" target="mainFrame" style="color:black;">简历登记</a>
													</span>
												</li>
												<li>
													<span>
														<a href="recruit/resume/resume-choose.html" target="mainFrame" style="color:black;">简历筛选</a>
													</span>
												</li>
												<li>
													<span>
														<a href="recruit/resume/valid-resume.html" target="mainFrame" style="color:black;">有效简历查询</a>
													</span>
												</li>
									</ul>
								</li>
								<li state="closed">
									<span>
										面试管理
									</span>
									<ul>
												<li>
													<span>
														<a href="recruit/interview/interview-list.html" target="mainFrame" style="color:black;">面试结果登记</a>
													</span>
												</li>
												<li>
													<span>
														<a href="recruit/interview/sift-list.html" target="mainFrame" style="color:black;">面试筛选</a>
													</span>
												</li>
									</ul>
								</li>
								<li state="closed">
									<span>
										录用管理
									</span>
									<ul>
												<li>
													<span>
														<a href="recruit/employ/register_list.html" target="mainFrame" style="color:black;">录用申请</a>
													</span>
												</li>
												<li>
													<span>
														<a href="recruit/employ/check_list.html" target="mainFrame" style="color:black;">录用审批</a>
													</span>
												</li>
												<li>
													<span>
														<a href="recruit/employ/list.html" target="mainFrame" style="color:black;">录用查询</a>
													</span>
												</li>
									</ul>
								</li>
					</ul>
				</li>
				<li>
					<span>人力资源档案管理</span>
					<ul>
								<li>
									<span>
											<a href="humanResources/human_register.html" target="mainFrame" style="color:black;">人力资源档案登记</a>
									</span>
								</li>
								<li>
									<span>
											<a href="humanResources/check_list.html" target="mainFrame" style="color:black;">人力资源档案登记复核</a>
									</span>
								</li>
								<li>
									<span>
											<a href="humanResources/query_locate.html" target="mainFrame" style="color:black;">人力资源档案查询</a>
									</span>
								</li>
								<li>
									<span>
											<a href="humanResources/change_locate.html" target="mainFrame" style="color:black;">人力资源档案变更</a>
									</span>
								</li>
								<li state="closed">
									<span>
										人力资源档案删除管理
									</span>
									<ul>
												<li>
													<span>
															<a href="humanResources/delete_locate.html" target="mainFrame" style="color:black;">人力资源档案删除</a>
													</span>
												</li>
												<li>
													<span>
															<a href="humanResources/recovery_locate.html" target="mainFrame" style="color:black;">档案删除恢复</a>
													</span>
												</li>
												<li>
													<span>
															<a href="humanResources/delete_forever_list.html" target="mainFrame" style="color:black;">人力资源档案永久删除</a>
													</span>
												</li>
									</ul>
								</li>
					</ul>
				</li>
				<li>
					<span>薪酬标准管理</span>
					<ul>
								<li>
									<span>
										<a href="tosalarystandard_register" target="mainFrame" style="color:black;">薪酬标准登记</a>
									</span>
								</li>
								<li>
									<span>
										<a href="salaryCriterion/salarystandard_check_list.html" target="mainFrame" style="color:black;">薪酬标准登记复核</a>
									</span>
								</li>
								<li>
									<span>
										<a href="salaryCriterion/salarystandard_query_locate.html" target="mainFrame" style="color:black;">薪酬标准查询</a>
									</span>
								</li>
								<li>
									<span>
										<a href="salaryCriterion/salarystandard_change_locate.html" target="mainFrame" style="color:black;">薪酬标准变更</a>
									</span>
								</li>
					</ul>
				</li>
				<li>
					<span>薪酬发放管理</span>
					<ul>
								<li>
									<span>
										<a href="salaryGrant/register_locate.html" target="mainFrame" style="color:black;">薪酬发放登记</a>
									</span>
								</li>
								<li>
									<span>
										<a href="salaryGrant/check_list.html" target="mainFrame" style="color:black;">薪酬发放登记复核</a>
									</span>
								</li>
								<li>
									<span>
										<a href="salaryGrant/query_locate.html" target="mainFrame" style="color:black;">薪酬发放查询</a>
									</span>
								</li>
					</ul>
				</li>
				<li>
					<span>调动管理</span>
					<ul>
								<li>
									<span>
										<a href="transfer/register_locate.html" target="mainFrame" style="color:black;">调动登记</a>
									</span>
								</li>
								<li>
									<span>
										<a href="transfer/check_list.html" target="mainFrame" style="color:black;">调动审核</a>
									</span>
								</li>
								<li>
									<span>
										<a href="transfer/locate.html" target="mainFrame" style="color:black;">调动查询</a>
									</span>
								</li>
					</ul>
				</li>
				<li>
					<span>客户化设置</span>
					<ul>
								<li state="closed">
									<span>
										人力资源档案管理设置
									</span>
									<ul>
												<li>
													<span>
														<a href="selcffk" target="mainFrame" style="color:black;">Ⅰ级机构设置</a>
													</span>
												</li>
												<li>
													<span>
														<a href="client/second_kind.html" target="mainFrame" style="color:black;">Ⅱ级机构设置</a>
													</span>
												</li>
												<li>
													<span>
														<a href="client/third_kind.html" target="mainFrame" style="color:black;">Ⅲ级机构设置</a>
													</span>
												</li>
												<li>
													<span>
														<a href="client/profession_design.html" target="mainFrame" style="color:black;">职称设置</a>
													</span>
												</li>
												<li>
													<span>
														<a href="client/major_kind.html" target="mainFrame" style="color:black;">职位分类设置</a>
													</span>
												</li>
												<li>
													<span>
														<a href="client/major.html" target="mainFrame" style="color:black;">职位设置</a>
													</span>
												</li>
												<li>
													<span>
														<a href="client/public_char.html" target="mainFrame" style="color:black;">公共属性设置</a>
													</span>
												</li>
									</ul>
								</li>
								<li state="closed">
									<span>
										薪酬管理设置
									</span>
									<ul>
												<li>
													<span>
														<a href="client/salary_item.html" target="mainFrame" style="color:black;">薪酬项目设置</a>
													</span>
												</li>
												<li>
													<span>
														<a href="client/salary_grant_mode.html" target="mainFrame" style="color:black;">薪酬发放方式设置</a>
													</span>
												</li>
									</ul>
								</li>
								<li state="closed">
									<span>
										其他设置
									</span>
									<ul>
												<li>
													<span>
														<a href="client/primary_key.html" target="mainFrame" style="color:black;">关键字查询设置</a>
													</span>
												</li>
									</ul>
								</li>
					</ul>
				</li>
				<li>
					<span>标准数据报表</span>
					<ul>
								<li>
									<span>
											<a href="criterionData/excel_locate.html" target="mainFrame" style="color:black;">Excel标准数据报表</a>
									</span>
								</li>
								<li>
									<span>
											<a href="criterionData/pdf_locate.html" target="mainFrame" style="color:black;">Pdf标准数据报表</a>
									</span>
								</li>
								<li>
									<span>
											<a href="criterionData/xml_locate.html" target="mainFrame" style="color:black;">Xml标准数据报表</a>
									</span>
								</li>
						</ul>
				</li>
				<li>
						<span>权限管理</span>
						<ul>
								<li>
									<span>
											<a href="power/user_list.html" target="mainFrame" style="color:black;">用户管理</a>
									</span>
								</li>
								<li>
									<span>
											<a href="power/right_list.html" target="mainFrame" style="color:black;">角色管理</a>
									</span>
								</li>
						</ul>
				</li>
		</ul>
	</body>
</html>
