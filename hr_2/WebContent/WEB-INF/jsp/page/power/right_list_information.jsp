<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>编辑角色</title>
		<link rel="stylesheet"
			href="../css/table.css" type="text/css"/>
		<script type="text/javascript" src="../javascript/jquery-1.7.2.js"></script>
		<script type="text/javascript"
			src="../javascript/jquery.messager.js"></script>
		<script type="text/javascript" src="../javascript/right_list_information.js"></script>
		<script type="text/javascript">
		function byName() {
			var uroleExp = $("#uroleExp").val();
			var un = $("un").val;
			if(uroleExp==""){
				$.messager.show("消息提示", "角色说明不能为空!", 2000);
			}
			if(un==""){
				$.messager.show("消息提示", "角色名不能为空!", 2000);
			}
			if(uroleExp!=""){
			
				$("#bc").submit();
			}
		}
		
		</script>
		<style type="text/css">
			.parent {
				margin-left: 50px;
			}
			.children {
				margin-left: 20%;
			}
		</style>
	</head>
	<body>
		<form id="bc" name="powerAction!doModifyRight" action="user_roleUpdate?uroleid=${ur.uroleid }" method="post">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--权限管理--编辑角色</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" id="powerAction!doModifyRight_0" value="&#20445;&#23384;" class="BUTTON_STYLE1" onclick="byName()"/>

						<input type="button" value="返回" class="BUTTON_STYLE1"
							onclick="history.back()">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=3 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1">角色编号</td>
					<td class="TD_STYLE2">${ur.uroleid }</td>
					<td class="TD_STYLE1">角色名称</td>
					<td class="TD_STYLE2">
						<input id="un" type="text" class="INPUT_STYLE2" value="${ur.urole_name }"
							name="urole_name"/>
						<input type="hidden" name="uroleid" value="${ur.uroleid }"/>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">角色说明</td>
					<td class="TD_STYLE2">
						<input id="uroleExp" type="text" class="INPUT_STYLE2" value="${ur.urole_exp }"
							name="urole_exp"/>
					</td>
					<td class="TD_STYLE1">角色是否可用</td>
					<td class="TD_STYLE2">
						<select name="urole_state" id="powerAction!doModifyRight_sysRole_roleFlag">
    						<option <c:if test="${ur.urole_state == 2 }"> selected="selected"</c:if> value="2">否</option>
    						<option <c:if test="${ur.urole_state == 1 }"> selected="selected"</c:if> value="1">是</option>
						</select>
					</td>
				</tr>
				<c:forEach items="${rq }" var="rq">
					<input type="hidden" name="qid" id="q" value="${rq.q_id }"/>
				</c:forEach>
			</table>
			<hr/>
			
				<table class="grandfather">
					<tr>
						<td>
							<input type="checkbox" name="q_id" value="1" id="powerAction!doModifyRight_rightCodes1" class="grandfather_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L01" /> 
							&#25307;&#32856;&#31649;&#29702;
							<table class="parent">
										<tr>
											<td>
												<input type="checkbox" name="q_id" value="101" id="powerAction!doModifyRight_rightCodes101" class="parent_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L0101" /> 
												&#32844;&#20301;&#21457;&#24067;&#31649;&#29702;
												<table class="children">
													<tr>
																<td>
																	<input type="checkbox" name="q_id" value="10101" id="powerAction!doModifyRight_rightCodes10101" class="children_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L010101" /> 
																	&#32844;&#20301;&#21457;&#24067;&#30331;&#35760;
																</td>
																<td>
																	<input type="checkbox" name="q_id" value="10102" id="powerAction!doModifyRight_rightCodes10102" class="children_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L010102" /> 
																	&#32844;&#20301;&#21457;&#24067;&#21464;&#26356;
																</td>
																<td>
																	<input type="checkbox" name="q_id" value="10103" id="powerAction!doModifyRight_rightCodes10103" class="children_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L010103" /> 
																	&#32844;&#20301;&#21457;&#24067;&#26597;&#35810;
																</td>
													</tr>
												</table>
											</td>
										</tr>
									
								
									
										<tr>
											<td>
												<input type="checkbox" name="q_id" value="102" id="powerAction!doModifyRight_rightCodes102" class="parent_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L0102" /> 
												&#31616;&#21382;&#31649;&#29702;
												<table class="children">
													<tr>
																<td>
																	<input type="checkbox" name="q_id" value="10201" id="powerAction!doModifyRight_rightCodes10201" class="children_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L010201" /> 
																	&#31616;&#21382;&#30331;&#35760;
																</td>
																<td>
																	<input type="checkbox" name="q_id" value="10202" id="powerAction!doModifyRight_rightCodes10202" class="children_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L010202" /> 
																	&#31616;&#21382;&#31579;&#36873;
																</td>
																<td>
																	<input type="checkbox" name="q_id" value="10203" id="powerAction!doModifyRight_rightCodes10203" class="children_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L010203" /> 
																	&#26377;&#25928;&#31616;&#21382;&#26597;&#35810;
																</td>
													</tr>
												</table>
											</td>
										</tr>
									
								
									
										<tr>
											<td>
												<input type="checkbox" name="q_id" value="103" id="powerAction!doModifyRight_rightCodes103" class="parent_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L0103" /> 
												&#38754;&#35797;&#31649;&#29702;
												<table class="children">
													<tr>
																<td>
																	<input type="checkbox" name="q_id" value="10301" id="powerAction!doModifyRight_rightCodes10301" class="children_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L010301" /> 
																	&#38754;&#35797;&#32467;&#26524;&#30331;&#35760;
																</td>
																<td>
																	<input type="checkbox" name="q_id" value="10302" id="powerAction!doModifyRight_rightCodes10302" class="children_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L010302" /> 
																	&#38754;&#35797;&#31579;&#36873;
																</td>
													</tr>
												</table>
											</td>
										</tr>
									
										<tr>
											<td>
												<input type="checkbox" name="q_id" value="106" id="powerAction!doModifyRight_rightCodes106" class="parent_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L0106" /> 
												&#24405;&#29992;&#31649;&#29702;
												<table class="children">
													<tr>
																<td>
																	<input type="checkbox" name="q_id" value="10601" id="powerAction!doModifyRight_rightCodes10601" class="children_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L010601" /> 
																	&#24405;&#29992;&#30003;&#35831;
																</td>
																<td>
																	<input type="checkbox" name="q_id" value="10602" id="powerAction!doModifyRight_rightCodes10602" class="children_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L010602" /> 
																	&#24405;&#29992;&#23457;&#25209;
																</td>
																<td>
																	<input type="checkbox" name="q_id" value="10603" id="powerAction!doModifyRight_rightCodes10603" class="children_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L010603" /> 
																	&#24405;&#29992;&#26597;&#35810;
																</td>
													</tr>
												</table>
											</td>
										</tr>
							</table>
						</td>
					</tr>
				</table>
				<hr/>
			
				<table class="grandfather">
					<tr>
						<td>
							<input type="checkbox" name="q_id" value="2" id="powerAction!doModifyRight_rightCodes2" class="grandfather_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L02" /> 
							&#20154;&#21147;&#36164;&#28304;&#26723;&#26696;&#31649;&#29702;
							<table class="parent">
										<tr>
											<td>
												<input type="checkbox" name="q_id" value="201" id="powerAction!doModifyRight_rightCodes201" class="parent_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L0201" /> 
												&#20154;&#21147;&#36164;&#28304;&#26723;&#26696;&#30331;&#35760;
												<table class="children">
													<tr>
													</tr>
												</table>
											</td>
										</tr>
										<tr>
											<td>
												<input type="checkbox" name="q_id" value="202" id="powerAction!doModifyRight_rightCodes202" class="parent_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L0202" /> 
												&#20154;&#21147;&#36164;&#28304;&#26723;&#26696;&#30331;&#35760;&#22797;&#26680;
												<table class="children">
													<tr>
													</tr>
												</table>
											</td>
										</tr>
										<tr>
											<td>
												<input type="checkbox" name="q_id" value="203" id="powerAction!doModifyRight_rightCodes203" class="parent_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L0203" /> 
												&#20154;&#21147;&#36164;&#28304;&#26723;&#26696;&#26597;&#35810;
												<table class="children">
													<tr>
													</tr>
												</table>
											</td>
										</tr>
										<tr>
											<td>
												<input type="checkbox" name="q_id" value="204" id="powerAction!doModifyRight_rightCodes204" class="parent_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L0204" /> 
												&#20154;&#21147;&#36164;&#28304;&#26723;&#26696;&#21464;&#26356;
												<table class="children">
													<tr>

													</tr>
												</table>
											</td>
										</tr>
										
										<tr>
											<td>
												<input type="checkbox" name="q_id" value="205" id="powerAction!doModifyRight_rightCodes205" class="parent_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L0205" /> 
												&#20154;&#21147;&#36164;&#28304;&#26723;&#26696;&#21024;&#38500;&#31649;&#29702;
												<table class="children">
													<tr>
														
																<td>
																	<input type="checkbox" name="q_id" value="20501" id="powerAction!doModifyRight_rightCodes20501" class="children_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L020501" /> 
																	&#20154;&#21147;&#36164;&#28304;&#26723;&#26696;&#21024;&#38500;
																</td>
																<td>
																	<input type="checkbox" name="q_id" value="20502" id="powerAction!doModifyRight_rightCodes20502" class="children_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L020502" /> 
																	&#26723;&#26696;&#21024;&#38500;&#24674;&#22797;
																</td>
																<td>
																	<input type="checkbox" name="q_id" value="20503" id="powerAction!doModifyRight_rightCodes20503" class="children_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L020503" /> 
																	&#20154;&#21147;&#36164;&#28304;&#26723;&#26696;&#27704;&#20037;&#21024;&#38500;
																</td>
													</tr>
												</table>
											</td>
										</tr>
							</table>
						</td>
					</tr>
				</table>
				<hr/>
			
				<table class="grandfather">
					<tr>
						<td>
						
							<input type="checkbox"  name="q_id" value="3" id="powerAction!doModifyRight_rightCodes3" class="grandfather_ck"/>
							
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L03" /> 
							&#34218;&#37228;&#26631;&#20934;&#31649;&#29702;
							<table class="parent">
										<tr>
											<td>
												<input type="checkbox" name="q_id" value="301" id="powerAction!doModifyRight_rightCodes301" class="parent_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L0301" /> 
												&#34218;&#37228;&#26631;&#20934;&#30331;&#35760;
												<table class="children">
													<tr>
													</tr>
												</table>
											</td>
										</tr>
										<tr>
											<td>
												<input type="checkbox" name="q_id" value="302" id="powerAction!doModifyRight_rightCodes302" class="parent_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L0302" /> 
												&#34218;&#37228;&#26631;&#20934;&#30331;&#35760;&#22797;&#26680;
												<table class="children">
													<tr>
													</tr>
												</table>
											</td>
										</tr>
										<tr>
											<td>
												<input type="checkbox" name="q_id" value="303" id="powerAction!doModifyRight_rightCodes303" class="parent_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L0303" /> 
												&#34218;&#37228;&#26631;&#20934;&#26597;&#35810;
												<table class="children">
													<tr>
													</tr>
												</table>
											</td>
										</tr>
										<tr>
											<td>
												<input type="checkbox" name="q_id" value="304" id="powerAction!doModifyRight_rightCodes304" class="parent_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L0304" /> 
												&#34218;&#37228;&#26631;&#20934;&#21464;&#26356;
												<table class="children">
													<tr>
													</tr>
												</table>
											</td>
										</tr>
							</table>
						</td>
					</tr>
				</table>
				<hr/>
			
				<table class="grandfather">
					<tr>
						<td>
							<input type="checkbox" name="q_id" value="4" id="powerAction!doModifyRight_rightCodes4" class="grandfather_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L04" /> 
							&#34218;&#37228;&#21457;&#25918;&#31649;&#29702;
							<table class="parent">
										<tr>
											<td>
												<input type="checkbox" name="q_id" value="401" id="powerAction!doModifyRight_rightCodes401" class="parent_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L0401" /> 
												&#34218;&#37228;&#21457;&#25918;&#30331;&#35760;
												<table class="children">
													<tr>
													</tr>
												</table>
											</td>
										</tr>
										<tr>
											<td>
												<input type="checkbox" name="q_id" value="402" id="powerAction!doModifyRight_rightCodes402" class="parent_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L0402" /> 
												&#34218;&#37228;&#21457;&#25918;&#30331;&#35760;&#22797;&#26680;
												<table class="children">
													<tr>
													</tr>
												</table>
											</td>
										</tr>
										<tr>
											<td>
												<input type="checkbox" name="q_id" value="403" id="powerAction!doModifyRight_rightCodes403" class="parent_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L0403" /> 
												&#34218;&#37228;&#21457;&#25918;&#26597;&#35810;
												<table class="children">
													<tr>
													</tr>
												</table>
											</td>
										</tr>
							</table>
						</td>
					</tr>
				</table>
				<hr/>
			
				<table class="grandfather">
					<tr>
						<td>
							<input type="checkbox" name="q_id" value="5" id="powerAction!doModifyRight_rightCodes5" class="grandfather_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L05" /> 
							&#35843;&#21160;&#31649;&#29702;
							<table class="parent">
										<tr>
											<td>
												<input type="checkbox" name="q_id" value="501" id="powerAction!doModifyRight_rightCodes501" class="parent_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L0501" /> 
												&#35843;&#21160;&#30331;&#35760;
												<table class="children">
													<tr>
													</tr>
												</table>
											</td>
										</tr>
										<tr>
											<td>
												<input type="checkbox" name="q_id" value="502" id="powerAction!doModifyRight_rightCodes502" class="parent_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L0502" /> 
												&#35843;&#21160;&#23457;&#26680;
												<table class="children">
													<tr>
													</tr>
												</table>
											</td>
										</tr>
										<tr>
											<td>
												<input type="checkbox" name="q_id" value="503" id="powerAction!doModifyRight_rightCodes503" class="parent_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L0503" /> 
												&#35843;&#21160;&#26597;&#35810;
												<table class="children">
													<tr>
													</tr>
												</table>
											</td>
										</tr>
							</table>
						</td>
					</tr>
				</table>
				<hr/>
			
				<table class="grandfather">
					<tr>
						<td>
							<input type="checkbox" name="q_id" value="6" id="powerAction!doModifyRight_rightCodes6" class="grandfather_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L06" /> 
							&#23458;&#25143;&#21270;&#35774;&#32622;
							<table class="parent">
										<tr>
											<td>
												<input type="checkbox" name="q_id" value="601" id="powerAction!doModifyRight_rightCodes601" class="parent_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L0601" /> 
												&#20154;&#21147;&#36164;&#28304;&#26723;&#26696;&#31649;&#29702;&#35774;&#32622;
												<table class="children">
													<tr>
																<td>
																	<input type="checkbox" name="q_id" value="60101" id="powerAction!doModifyRight_rightCodes60101" class="children_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L060101" /> 
																	&#8544;&#32423;&#26426;&#26500;&#35774;&#32622;
																</td>
																<td>
																	<input type="checkbox" name="q_id" value="60102" id="powerAction!doModifyRight_rightCodes60102" class="children_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L060102" /> 
																	&#8545;&#32423;&#26426;&#26500;&#35774;&#32622;
																</td>
																<td>
																	<input type="checkbox" name="q_id" value="60103" id="powerAction!doModifyRight_rightCodes60103" class="children_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L060103" /> 
																	&#8546;&#32423;&#26426;&#26500;&#35774;&#32622;
																</td>
																<td>
																	<input type="checkbox" name="q_id" value="60104" id="powerAction!doModifyRight_rightCodes60104" class="children_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L060104" /> 
																	&#32844;&#31216;&#35774;&#32622;
																</td>
																<td>
																	<input type="checkbox" name="q_id" value="60105" id="powerAction!doModifyRight_rightCodes60105" class="children_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L060105" /> 
																	&#32844;&#20301;&#20998;&#31867;&#35774;&#32622;
																</td>
																<td>
																	<input type="checkbox" name="q_id" value="60106" id="powerAction!doModifyRight_rightCodes60106" class="children_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L060106" /> 
																	&#32844;&#20301;&#35774;&#32622;
																</td>
																<td>
																	<input type="checkbox" name="q_id" value="60107" id="powerAction!doModifyRight_rightCodes60107" class="children_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L060107" /> 
																	&#20844;&#20849;&#23646;&#24615;&#35774;&#32622;
																</td>
													</tr>
												</table>
											</td>
										</tr>
										<tr>
											<td>
												<input type="checkbox" name="q_id" value="602" id="powerAction!doModifyRight_rightCodes602" class="parent_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L0602" /> 
												&#34218;&#37228;&#31649;&#29702;&#35774;&#32622;
												<table class="children">
													<tr>
																<td>
																	<input type="checkbox" name="q_id" value="60201" id="powerAction!doModifyRight_rightCodes60201" class="children_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L060201" /> 
																	&#34218;&#37228;&#39033;&#30446;&#35774;&#32622;
																</td>
																
													</tr>
												</table>
											</td>
										</tr>
										<tr>
											
										</tr>
										<tr>
											<td>
												<input type="checkbox" name="q_id" value="604" id="powerAction!doModifyRight_rightCodes604" class="parent_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L0604" /> 
												邮箱管理设置
												<table class="children">
													<tr>
																<td>
																	<input type="checkbox" name="q_id" value="60401" id="powerAction!doModifyRight_rightCodes60401" class="children_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L060401" /> 
																	邮箱设置
																</td>
													</tr>
												</table>
											</td>
										</tr>
							</table>
						</td>
					</tr>
				</table>
				<hr/>
			
				
			
				<table class="grandfather">
					<tr>
						<td>
							<input type="checkbox" name="q_id" value="8" id="powerAction!doModifyRight_rightCodes8" class="grandfather_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L08" /> 
							&#26435;&#38480;&#31649;&#29702;
							<table class="parent">
										<tr>
											<td>
												<input type="checkbox" name="q_id" value="801" id="powerAction!doModifyRight_rightCodes801" class="parent_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L0801" /> 
												&#29992;&#25143;&#31649;&#29702;
												<table class="children">
													<tr>
													</tr>
												</table>
											</td>
										</tr>
										<tr>
											<td>
												<input type="checkbox" name="q_id" value="802" id="powerAction!doModifyRight_rightCodes802" class="parent_ck"/>
<input type="hidden" id="__checkbox_powerAction!doModifyRight_rightCodes" name="__checkbox_rightCodes" value="L0802" /> 
												&#35282;&#33394;&#31649;&#29702;
												<table class="children">
													<tr>
													</tr>
												</table>
												<input type="hidden" checked="checked" name="q_id" value="9"/>
											</td>
										</tr>
							</table>
						</td>
					</tr>
				</table>
				<hr/>
				
		</form>




	</body>
	
	
	
	<script type="text/javascript">
		function byDefault(){
				// 所有权限
				var arr=new Array("1","101","10101","10102","10103",
						              "102","10201","10202","10203",
						              "103","10301","10302",
						              "106","10601","10602","10603",
								  "2","201",
								  	  "202",
								  	  "203",
								  	  "204",
								  	  "205","20501","20502","20503",
								  "3","301",
								  	  "302",
								  	  "303",
								  	  "304",
								  "4","401",
								  	  "402",
								  	  "403",
								  "5","501",
								  	  "502",
								  	  "503",
								  "6","601","60101","60102","60103","60104","60105","60106","60107",
								  	  "602","60201",
								  	  "604","60401",
								  "8","801",
								     "802");
				//这个人的权限
				var arr1 = document.getElementsByName("qid");
				
				for(var i=0;i<arr.length;i++){
					for(var j=0;j<arr1.length;j++){
				 		var zjqx = arr1[j].value;// 每个自己的权限
				 		//alert(zjqx);
				 		//alert(zjqx + "," + arr[i]);
				 		if(zjqx == arr[i]){
				 			//alert("ok");
				 			// 把id=powerAction!doModifyRight_rightCodes302这个复选框选中
				 			//$("#powerAction!doModifyRight_rightCodes"+zjqx).attr("checked",true);
				 			document.getElementById("powerAction!doModifyRight_rightCodes" + zjqx).checked = true;
				 		}
					}
				}
				 		
					
				
			}
	
	window.onload=byDefault;
	</script>
	
	
	
</html>
