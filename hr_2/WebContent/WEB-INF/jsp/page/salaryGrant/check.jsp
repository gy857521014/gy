<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-trasitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="../css/table.css" type="text/css" />
		<title>无标题文档</title>
		<style type="text/css">
		<!--
		.style3 {color: #0000CC}
		td{text-align: center;}
		-->
		</style>

	</head>

	<body>
		<form method="post" action="check_success.html">
			<table width="100%">
				<tr>
					<td style="text-align:left;">
						<font color="black">您正在做的业务是:人力资源管理--薪酬发放管理--薪酬发放复核</font>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: right"  >
						<input type="submit" value="复核通过"   class="BUTTON_STYLE1">	　					
						<input type="button" value="返 回" onclick="location.href='check_list.html'" class="BUTTON_STYLE1">
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: left" >
					薪酬单编号：${sg.salary_grant_id }
					<input type="hidden" name="salaryGrant.salaryGrantId" value="${sg.salary_grant_id }">
					</td>					
				</tr>
				<tr>
					<td colspan="2" style="text-align: left">
					机构：
				
					
					
					${sg.first_kind_name } 
				
					</td>					
				</tr>
				<tr>
					<td style="text-align: left">
					本机构总人数:${sg.human_amount }
					<input type="hidden" name="" value="${sg.human_amount }">
					，基本薪酬总数:${sg.salary_standard_sum }<input type="hidden" name="" value="${sg.salary_standard_sum }"/>
					，实发总额:<span id="salarySum_sum">${sg.salary_paid_sum }</span>
					<input type="hidden" id="salaryPaidSum" name="" value="${sg.salary_paid_sum }"/>
					</td>
					<td   style="text-align: right">
					 
						复核人:<input type="text" name="" value="${u.user_true_name }" size="8" readonly="readonly">
						复核时间：<span id="Tdate"></span>
						<input type="hidden" name="" id="Tdate2" >
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1">
						<span>序号</span>
					</td>
					<td class="TD_STYLE1">
						<span>档案编号</span>
					</td>
					<td class="TD_STYLE1">
						<span>姓名</span>
					</td>
					<c:forEach items="${plist }" var="p">
						<td class="TD_STYLE1">
							${p.attribute_name }
						</td>		
					</c:forEach>	
					<td class="TD_STYLE1" width="7%">
						奖励金额
					</td>
					<td class="TD_STYLE1" width="7%">
						销售绩效总额
					</td>
					<td class="TD_STYLE1" width="7%">
						应扣金额
					</td>
					<td class="TD_STYLE1" width="7%">
						实发金额
					</td>
					
				</tr>	
					<input type="hidden" name="grantDetails[0].salaryGrantId" value="HS1353753198460">
				 	<input type="hidden" id="salaryStandardSum1" name="grantDetails[0].salaryStandardSum" value="1332.0"/>
					<tr class="TD_STYLE2">
					
						<td>
							1
						</td>
						<td>
							bt201211190619440428
								<input type="hidden" name="grantDetails[0].humanId"  value="bt201211190619440428"/>							
						</td>
						<td>
							&#26472;&#38451;	
							<input type="hidden" name="grantDetails[0].humanName"  value="&#26472;&#38451;"/>
						</td>
							 
							 
											
						<td> 							
							222.0
						</td>
											
						<td> 							
							222.0
						</td>
											
						<td> 							
							222.0
						</td>
											
						<td> 							
							222.0
						</td>
											
											
						<td> 							
							222.0
						</td>
						 		
						
										
						<td>
							<input type="text" name="grantDetails[0].bounsSum" id="bounsSum1" value=""  onkeyup="onKeyPress('1')"  class="INPUT_STYLE2" />
						</td>
						<td>
							<input type="text" name="grantDetails[0].saleSum" id="saleSum1"  value=""  onkeyup="onKeyPress('1')" class="INPUT_STYLE2"/>
						</td>
						<td>
							<input type="text" name="grantDetails[0].deductSum" id="deductSum1" value=""  onkeyup="onKeyPress('1')" class="INPUT_STYLE2"/>
						</td>
						<td>
							<input type="text" name="grantDetails[0].salaryPaidSum" readonly="readonly" value="1332.0"   id="salaryPaidSum1"   class="INPUT_STYLE2"/>
						</td>
						
					</tr>	
					
					<input type="hidden" name="grantDetails[1].salaryGrantId" value="HS1353753198460">
				 	<input type="hidden" id="salaryStandardSum2" name="grantDetails[1].salaryStandardSum" value="666.0"/>
					<tr class="TD_STYLE2">
					
						<td>
							2
						</td>
						<td>
							bt201211190644520428
								<input type="hidden" name="grantDetails[1].humanId"  value="bt201211190644520428"/>							
						</td>
						<td>
							&#21608;&#65311;	
							<input type="hidden" name="grantDetails[1].humanName"  value="&#21608;&#65311;"/>
						</td>
							 
							 
											
											
						<td> 							
							111.0
						</td>
											
						<td> 							
							111.0
						</td>
											
						<td> 							
							111.0
						</td>
											
						<td> 							
							111.0
						</td>
											
						<td> 							
							111.0
						</td>
						 		
						
										
						<td>
							<input type="text" name="grantDetails[1].bounsSum" id="bounsSum2" value=""  onkeyup="onKeyPress('2')"  class="INPUT_STYLE2" />
						</td>
						<td>
							<input type="text" name="grantDetails[1].saleSum" id="saleSum2"  value=""  onkeyup="onKeyPress('2')" class="INPUT_STYLE2"/>
						</td>
						<td>
							<input type="text" name="grantDetails[1].deductSum" id="deductSum2" value=""  onkeyup="onKeyPress('2')" class="INPUT_STYLE2"/>
						</td>
						<td>
							<input type="text" name="grantDetails[1].salaryPaidSum" readonly="readonly" value="666.0"   id="salaryPaidSum2"   class="INPUT_STYLE2"/>
						</td>
						
					</tr>	
					
					<input type="hidden" name="grantDetails[2].salaryGrantId" value="HS1353753198460">
				 	<input type="hidden" id="salaryStandardSum3" name="grantDetails[2].salaryStandardSum" value="666.0"/>
					<tr class="TD_STYLE2">
					
						<td>
							3
						</td>
						<td>
							bt201211190644030990
								<input type="hidden" name="grantDetails[2].humanId"  value="bt201211190644030990"/>							
						</td>
						<td>
							&#21016;&#24698;&#23041;	
							<input type="hidden" name="grantDetails[2].humanName"  value="&#21016;&#24698;&#23041;"/>
						</td>
							 
							 
											
											
						<td> 							
							111.0
						</td>
											
						<td> 							
							111.0
						</td>
											
						<td> 							
							111.0
						</td>
											
						<td> 							
							111.0
						</td>
											
						<td> 							
							111.0
						</td>
						 		
						
										
						<td>
							<input type="text" name="grantDetails[2].bounsSum" id="bounsSum3" value=""  onkeyup="onKeyPress('3')"  class="INPUT_STYLE2" />
						</td>
						<td>
							<input type="text" name="grantDetails[2].saleSum" id="saleSum3"  value=""  onkeyup="onKeyPress('3')" class="INPUT_STYLE2"/>
						</td>
						<td>
							<input type="text" name="grantDetails[2].deductSum" id="deductSum3" value=""  onkeyup="onKeyPress('3')" class="INPUT_STYLE2"/>
						</td>
						<td>
							<input type="text" name="grantDetails[2].salaryPaidSum" readonly="readonly" value="666.0"   id="salaryPaidSum3"   class="INPUT_STYLE2"/>
						</td>
						
					</tr>	
					
					<input type="hidden" name="grantDetails[3].salaryGrantId" value="HS1353753198460">
				 	<input type="hidden" id="salaryStandardSum4" name="grantDetails[3].salaryStandardSum" value="135827.0"/>
					<tr class="TD_STYLE2">
					
						<td>
							4
						</td>
						<td>
							bt201211190644250035
								<input type="hidden" name="grantDetails[3].humanId"  value="bt201211190644250035"/>							
						</td>
						<td>
							&#26472;&#24130;	
							<input type="hidden" name="grantDetails[3].humanName"  value="&#26472;&#24130;"/>
						</td>
							 
							 
											
											
						<td> 							
							12312.0
						</td>
											
						<td> 							
							123123.0
						</td>
											
						<td> 							
							123.0
						</td>
											
						<td> 							
							123.0
						</td>
											
						<td> 							
							23.0
						</td>
						 		
						
										
						<td>
							<input type="text" name="grantDetails[3].bounsSum" id="bounsSum4" value=""  onkeyup="onKeyPress('4')"  class="INPUT_STYLE2" />
						</td>
						<td>
							<input type="text" name="grantDetails[3].saleSum" id="saleSum4"  value=""  onkeyup="onKeyPress('4')" class="INPUT_STYLE2"/>
						</td>
						<td>
							<input type="text" name="grantDetails[3].deductSum" id="deductSum4" value=""  onkeyup="onKeyPress('4')" class="INPUT_STYLE2"/>
						</td>
						<td>
							<input type="text" name="grantDetails[3].salaryPaidSum" readonly="readonly" value="135827.0"   id="salaryPaidSum4"   class="INPUT_STYLE2"/>
						</td>
						
					</tr>	
					
					<input type="hidden" name="grantDetails[4].salaryGrantId" value="HS1353753198460">
				 	<input type="hidden" id="salaryStandardSum5" name="grantDetails[4].salaryStandardSum" value="1332.0"/>
					<tr class="TD_STYLE2">
					
						<td>
							5
						</td>
						<td>
							bt201211190644390870
								<input type="hidden" name="grantDetails[4].humanId"  value="bt201211190644390870"/>							
						</td>
						<td>
							&#21608;&#23567;&#22362;	
							<input type="hidden" name="grantDetails[4].humanName"  value="&#21608;&#23567;&#22362;"/>
						</td>
							 
							 
											
											
						<td> 							
							222.0
						</td>
											
						<td> 							
							222.0
						</td>
											
						<td> 							
							222.0
						</td>
											
						<td> 							
							222.0
						</td>
											
						<td> 							
							222.0
						</td>
						 		
						
										
						<td>
							<input type="text" name="grantDetails[4].bounsSum" id="bounsSum5" value=""  onkeyup="onKeyPress('5')"  class="INPUT_STYLE2" />
						</td>
						<td>
							<input type="text" name="grantDetails[4].saleSum" id="saleSum5"  value=""  onkeyup="onKeyPress('5')" class="INPUT_STYLE2"/>
						</td>
						<td>
							<input type="text" name="grantDetails[4].deductSum" id="deductSum5" value=""  onkeyup="onKeyPress('5')" class="INPUT_STYLE2"/>
						</td>
						<td>
							<input type="text" name="grantDetails[4].salaryPaidSum" readonly="readonly" value="1332.0"   id="salaryPaidSum5"   class="INPUT_STYLE2"/>
						</td>
						
					</tr>	
					 
					 
			</table>							
		</form>
		<SCRIPT type="text/javascript">
		 
		function onKeyPress(i){
		
		var size=5;
		var bounsSum=document.getElementById("bounsSum"+i);
		var saleSum =document.getElementById("saleSum"+i);
		var deductSum=document.getElementById("deductSum"+i);
		var salaryPaidSum=document.getElementById("salaryPaidSum"+i);
		if (isNaN(bounsSum.value) || bounsSum.value < 0) {
		alert("金额填写错误!");
		bounsSum.value="0.00";
		return;
	} 
		if (isNaN(saleSum.value) || saleSum.value < 0) {
		alert("金额填写错误!");
		saleSum.value="0.00";
		return;
	} 
		if (isNaN(deductSum.value) || deductSum.value < 0) {
		alert("金额填写错误!");
		deductSum.value="0.00";
		return;
	} 
		salaryPaidSum.value=Number(bounsSum.value)+Number(saleSum.value)-Number(deductSum.value)+Number(document.getElementById("salaryStandardSum"+i).value);
		
		var sum=0;
		for(var j=1;j<=size;j++){
			sum=Number(sum)+Number(document.getElementById("salaryPaidSum"+j).value);
		}
	 		 document.getElementById("salarySum_sum").innerHTML=sum;
	 		  document.getElementById("salaryPaidSum").value=sum;	 
		
		}



		function time(){
 					var tdate=document.getElementById("Tdate");					 
 					var d=new Date();
 					var y=d.getFullYear();
 					var moth=d.getMonth()+1;
 					var date=d.getDate();
 					var h=d.getHours();
 					var m=d.getMinutes();
 					var s=d.getSeconds();
					var hh=20-1-h;
					var mm=60-1-m;
					var ss=60-s;
					if(hh>0){
							mm=mm+60*hh;
					}
 					if(moth<10){
 							moth="0"+moth;
 					}
 					if(date<10){
 							date="0"+date;
 					}
 					if(h<10){
 							h="0"+h;
 					}
 					if(m<10){
 							m="0"+m;
 					}
 					if(s<10){
 							s="0"+s;
 					}
 					if(mm<10){
 							mm="0"+mm;
 					}
 					if(ss<10){
 							ss="0"+ss;
 					}	
 					 
 					tdate.innerHTML=y+"-"+moth+"-"+date+" "+h+":"+m+":"+s;
					 document.getElementById("Tdate2").value=tdate.innerHTML;
 				}
 				window.onload=time;
 				var out=window.setInterval(time, 1000);
		</SCRIPT>
	</body>
</html>



