<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
			src="../javascript/jquery.messager.js">
		</script>
			<script type="text/javascript">
 			window.onload=check;
		function tick() {
			var now = new Date();
			var hours, minutes, seconds, noon;
			var intHours, intMinutes, intSeconds;
			intHours = now.getHours();
			intMinutes = now.getMinutes();
			intSeconds = now.getSeconds();
			if (intHours < 24) {
				hours = intHours+":";
				noon = "A.M.";
			} else {
				intHours = intHours - 24;
				hours = intHours + ":";
				noon = "P.M.";
			}
			if (intMinutes < 10) {
				minutes = "0"+intMinutes+":";
			} else {
				minutes = intMinutes+":";
			}
			if (intSeconds < 10) {
				seconds = "0"+intSeconds+" ";
			} else {
				seconds = intSeconds+" ";
			}
			timeString = hours+minutes+seconds;
			var now = new Date();
		  	document.getElementById("nowTime").value=now.getFullYear()+"-"+(now.getMonth()+1)+"-"+now.getDate()+" "+timeString;
			window.setTimeout("tick();", 1000);
		}
		
		//load事件
		function check(){
			//获得系统当前时间的方法
		  	tick();					
		}
 		</script>

 		<script type="text/javascript">
 	   function mysubmit(){  
 		 
 		 if(document.getElementById("majorKindId").value.trim()<1||document.getElementById("majorKindId").value.trim().length>20)
 		 {
 			$.messager.show("消息提示", "请选择职位分类!", 1000);
 	       return false;
 	       }  
 		 
 		  if(document.getElementById("majorId").value.trim()<1||document.getElementById("majorId").value.trim().length>20)
 		  {
 			 $.messager.show("消息提示", "请选择职位名称!",1000);

 	       	 return false;
 	       }
 		  
 		 if(document.getElementById("name").value.trim()<1||document.getElementById("name").value.trim().length>20)	
 		  {
 			$.messager.show("消息提示", "请选择姓名！", 1000);
 			document.getElementById("name").focus();
 	       		return false;
 	       }
 		 if(document.getElementById("email").value.trim()<1||document.getElementById("email").value.trim().length>20)
  		{
  		  $.messager.show("消息提示", "请输入邮箱!", 1000);
  		  document.getElementById("email").focus();
  			return false;    				
  		}
 		 
 		 		var temp = document.getElementById("email");
 		        //对电子邮件的验证
 		        var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
 		        if(!myreg.test(temp.value))
 		        {
 		        	$.messager.show("消息提示", "请输入正确的邮箱(xxx@xxx.com)!", 1000);
	 		         myreg.focus();
	 		        return false;
 		        }
 		 
 		 if(document.getElementById("phone").value.trim()<1||document.getElementById("phone").value.trim().length>20)
 		  {
 			$.messager.show("消息提示", "请选择电话号码!", 1000);

 	       return false;
 	       } 
	 		var re =  /^1[3578]\d{9}$/;
			if (!re.test(document.getElementById("phone").value)) {
				$.messager.show("消息提示", "请输入正确手机号码：13、15、17、18开头,满足11位!", 1000);
				document.getElementById("xxx@xxx.com").focus();
				return false;
			}

 		 if(document.getElementById("humanHomephone").value.trim()<1||document.getElementById("humanHomephone").value.trim().length>20)
  		{
  		  $.messager.show("消息提示", "请输入家庭电话!", 2000);
  		  document.getElementById("humanHomephone").focus();
  			return false;    				
  		}
 		var re = /0\d{3,4}-\d{7,8}/;
		if (!re.test(document.getElementById("humanHomephone").value)) {
			$.messager.show("消息提示", "请输入正确家庭电话号码：以数字0开始，并跟随3-4个数字,中间-连接,满足7-8位!", 2000);
			document.getElementById("humanHomephone").focus();
			return false;
		}

 		 if(document.getElementById("humanMobilephone").value.trim()<1||document.getElementById("humanMobilephone").value.trim().length>20)
  		{
  		  $.messager.show("消息提示", "请输入手机!", 2000);
  		  document.getElementById("humanMobilephone").focus();
  			return false;    				
  		}
 		var re =  /^1[3578]\d{9}$/;
		if (!re.test(document.getElementById("humanMobilephone").value)) {
			$.messager.show("消息提示", "请输入正确手机号码：13、15、17、18开头,满足11位!", 2000);
			document.getElementById("humanMobilephone").focus();
			return false;
		}

 		 if(document.getElementById("zhuzhi").value.trim()<1||document.getElementById("zhuzhi").value.trim().length>20)
   		{
   		  $.messager.show("消息提示", "请输入住址!", 2000);
   		  document.getElementById("zhuzhi").focus();
   			return false;    				
   		}
  		 if(document.getElementById("youbian").value.trim()<1||document.getElementById("youbian").value.trim().length>20)
   		{
   		  $.messager.show("消息提示", "请输入邮编!", 2000);
   		  document.getElementById("youbian").focus();
   			return false;    				
   		}
  		 	var yb= /^[1-9][0-9]{5}$/
  			if (!yb.test(document.getElementById("youbian").value)) {
  				$.messager.show("消息提示", "请输入正确的邮编,不以0开头的六位数字!", 2000);
  				document.getElementById("youbian").focus();
  				return false;
  			}
  		if(document.getElementById("chusheng").value.trim()<1||document.getElementById("chusheng").value.trim().length>20)
		 {
			$.messager.show("消息提示", "请输入出生地!", 2000);
			document.getElementById("chusheng").focus();
	       return false;
	       }  
		 if(document.getElementById("birthday").value.trim()<1||document.getElementById("birthday").value.trim().length>20)
		{
		  $.messager.show("消息提示", "请输入生日!", 2000);
		  document.getElementById("birthday").focus();
			return false;    				
		}
		 var riqi = /^([1][7-9][0-9][0-9]|[2][0][0-9][0-9])(\-)([0][1-9]|[1][0-2])(\-)([0-2][1-9]|[3][0-1])$/g;
			if (!riqi.test(document.getElementById("birthday").value)) {
				$.messager.show("消息提示", "请输入正确的日期格式!yyyy-MM-dd", 1000);
				document.getElementById("birthday").focus();
				return false;
			}
			// 输入的时间
				var c =document.getElementById("birthday").value;
				var inpDate = new Date(c);
				// 获取当前时间
				var now = new Date();
				if(inpDate.getTime() > now.getTime()){
					$.messager.show("消息提示", "请输入正确的截止日期!(今天以前)", 1000);
					document.getElementById("birthday").focus();
					return false;
				}
		 if(document.getElementById("card").value.trim()<1||document.getElementById("card").value.trim().length>20)
			{
			  $.messager.show("消息提示", "请输入身份证号码!", 2000);
			  document.getElementById("card").focus();
				return false;    				
			}
		 	// 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X  
		   var sfz = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;  
		   if (!sfz.test(document.getElementById("card").value)) {
				$.messager.show("消息提示", "请输入正确的身份证号码！15位或者18位，18位时最后一位可为x或X", 1000);
				document.getElementById("card").focus();
				return false;
			}
		   
		 if(document.getElementById("humanAge").value.trim()<1||document.getElementById("humanAge").value.trim().length>20)
			{
			  $.messager.show("消息提示", "请输入年龄(1~99)!", 2000);
			  document.getElementById("humanAge").focus();
				return false;    				
			}
		 	var regNum = /^[0-9]{1,2}$/;
			if (!regNum.test(document.getElementById("humanAge").value)) {
				$.messager.show("消息提示", "请输入正确年龄(1~99)!", 1000);
				document.getElementById("humanAge").focus();
				return false;
			}
		 if(document.getElementById("biye").value.trim()<1||document.getElementById("biye").value.trim().length>20)
			{
			  $.messager.show("消息提示", "请输入毕业院校!", 2000);
			  document.getElementById("biye").focus();
				return false;    				
			}
		 if(document.getElementById("xueli").value.trim()<1||document.getElementById("xueli").value.trim().length>20)
			{
			  $.messager.show("消息提示", "请选择学历!", 2000);
				return false;    				
			}
		 if(document.getElementById("nianxian").value.trim()<1||document.getElementById("nianxian").value.trim().length>20)
			{
			  $.messager.show("消息提示", "请选择教育年限!", 2000);
				return false;    				
			}
		 if(document.getElementById("zhye").value.trim()<1||document.getElementById("zhye").value.trim().length>20)
			{
			  $.messager.show("消息提示", "请选择学历专业!", 2000);
			  document.getElementById("zhye").focus();
				return false;    				
			}
		 if(document.getElementById("gongzi").value.trim()<1||document.getElementById("gongzi").value.trim().length>20)
			{
			  $.messager.show("消息提示", "请输入薪酬要求!", 2000);
			  document.getElementById("gongzi").focus();
				return false;    				
			}
		 	var gz = /^[1-9]+[0-9]{1,6}$/;
		 	if (!gz.test(document.getElementById("gongzi").value)) {
				$.messager.show("消息提示", "请输入正确的薪资要求(数字)!", 1000);
				document.getElementById("gongzi").focus();
				return false;
			}
		 if(document.getElementById("nvli").value.trim()<1||document.getElementById("nvli").value.trim().length>20)
			{
			  $.messager.show("消息提示", "请输入个人履历!", 2000);
			  document.getElementById("nvli").focus();
				return false;    				
			}
		 if(document.getElementById("beizhu").value.trim()<1||document.getElementById("beizhu").value.trim().length>20)
			{
			  $.messager.show("消息提示", "请输入备注!", 2000);
			  document.getElementById("beizhu").focus();
				return false;    				
			}
 		  	document.fm.submit();
 		  	return true;
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
					cityselect.append("<option value=''>--请选择职位名称--</option>");
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
	</head>
	<body>
	<form id="recruitAction!saveEngageResume" name="fm" action="addresume" method="post" enctype="multipart/form-data">
			<input type="hidden" name="pass_checkComment" value=""/>
			<input type="hidden" name="pass_passComment" value=""/>
	 		<input type="hidden" name="engageResume.checkStatus" value="false"/>
	 		<input type="hidden" name="register" value="${loginUser.user_true_name }">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--招聘管理--简历管理--简历登记 </font>
					 
					</td>
				</tr>
				<tr>
					<td align="right">
					 
						<input type="button" value="提交" class="BUTTON_STYLE1" onclick="return mysubmit()">
						<input type="reset" value="清除" class="BUTTON_STYLE1">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
						<td class="TD_STYLE1">
						职位分类
					</td>
					<td class="TD_STYLE2">  
						 <input type="hidden" value="01" id="majorKindIdc" name="engageResume.humanMajorKindId" />
					<select name="human_major_kind_id" onchange="fun()" class="SELECT_STYLE1" id="majorKindId">
						<option value="">请选择职位分类</option>
						<c:forEach items="${kindlist }" var="list">
							<option value="${list.major_kind_id }">${list.major_kind_name }</option>
						</c:forEach>
					</select>		
					</td>
					<td class="TD_STYLE1">
						职位名称
					</td>
					<td class="TD_STYLE2" width="20%"> 
				  
					 <input type="hidden" value="02" name="engageResume.humanMajorId" />
					<select name="human_major_id" class="SELECT_STYLE1" id="majorId">
						<option value="">请选择职位名称</option>
						
					</select>
					</td>
					<td width="11%" class="TD_STYLE1">
						招聘类型
					</td>
					<td class="TD_STYLE2" colspan="2"> 
					<select name="engage_type" id="engageType" class="SELECT_STYLE1">
						<c:forEach items="${zhaoplist }" var="list">
							<option value="${list.attribute_name }">${list.attribute_name }</option>
						</c:forEach>
					</select>
					</td>
					<td rowspan="6" >
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						姓名
					</td>
					<td class="TD_STYLE2">
						 <input type="text"  name="human_name" id="name" class="INPUT_STYLE2"/>
					</td>
					<td class="TD_STYLE1">
						性别
					</td>
					<td class="TD_STYLE2">
						<select name="human_sex"  class="SELECT_STYLE1"><option value="男">男</option>
							<option value="女">女</option></select>
					</td>
					<td class="TD_STYLE1">
						EMAIL
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="human_email" id="email" class="INPUT_STYLE2" placeholder="格式xxx@xxx.com">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
					电话
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_telephone"  id="phone" class="INPUT_STYLE2" placeholder="">
					</td>
					<td class="TD_STYLE1">
						家庭电话
					</td>
					<td class="TD_STYLE2">
					 <input type="text" name="human_homephone" id="humanHomephone" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						手机
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="human_mobilephone" id="humanMobilephone" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						住址
					</td>
					<td colspan="3" class="TD_STYLE2">
						<input type="text" id="zhuzhi" name="human_address" value="" class="INPUT_STYLE2">
					</td>
					 
					<td class="TD_STYLE1">
						邮编
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" id="youbian" name="human_postcode" value="" class="INPUT_STYLE2">
					</td>
				</tr>
				 
				<tr>
					<td class="TD_STYLE1">
						国籍
					</td>
					<td class="TD_STYLE2">
					 <select name="human_nationality" id="guoji"  class="SELECT_STYLE1">
							<c:forEach items="${guoji }" var="glist">
							<c:if test="${glist.attribute_name=='中国' }">
								<option value="${glist.attribute_name }" selected>${glist.attribute_name }</option>
							</c:if>
							<c:if test="${glist.attribute_name!='中国' }">
								<option value="${glist.attribute_name }">${glist.attribute_name }</option>
							</c:if>
								
							</c:forEach>
							
					 </select> 
					</td>
					<td class="TD_STYLE1">
						出生地
					</td>
					<td class="TD_STYLE2">
						<input type="text" id="chusheng" name="human_birthplace" value="" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						生日
					</td>
					<td width="13%" colspan="2" class="TD_STYLE2">
						<input type="text" name="human_birthday" id="birthday" class="INPUT_STYLE2"  >
					</td>
					
				</tr>
				<tr>
				<td width="11%" class="TD_STYLE1">
						民族
					</td>
					<td class="TD_STYLE2" width="14%">
				 	 <select name="human_race" id="mingzu"  class="SELECT_STYLE1">
							<c:forEach items="${mingzu }" var="list">
								<c:if test="${list.attribute_name=='汉族' }">
									<option value="${list.attribute_name }" selected>${list.attribute_name }</option>
								</c:if>
								<c:if test="${list.attribute_name!='汉族' }">
									<option value="${list.attribute_name }">${list.attribute_name }</option>
								</c:if>
								
							</c:forEach> 
							
					 </select>  
					</td>
					<td class="TD_STYLE1">
						宗教信仰
					</td>
					<td class="TD_STYLE2">
					   <select name="human_religion"   class="SELECT_STYLE1"> 
							<option value="无">无</option> 
							<c:forEach items="${zongjiao }" var="list">
								<option value="${list.attribute_name }">${list.attribute_name }</option>
							</c:forEach> 
							
					 </select>  
					</td>
					<td class="TD_STYLE1">
						政治面貌
					</td>
					<td class="TD_STYLE2" colspan="2">
					   <select name="human_party"   class="SELECT_STYLE1"> 					
							<c:forEach items="${zhengzhi }" var="list">
								<option value="${list.attribute_name }">${list.attribute_name }</option>
							</c:forEach>
							
					 </select>  	  
					</td>
					
					 
				</tr>
				<tr>
				<td class="TD_STYLE1">
						身份证号码
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_idcard" value="" id="card" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						年龄
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="human_age" id="humanAge" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						毕业院校
					</td>
					<td class="TD_STYLE2">
						 <input type="text" id="biye" name="human_college" class="INPUT_STYLE2"/>
					</td>
					
					<td class="TD_STYLE1">
						学历
					</td>
					<td class="TD_STYLE2">
					  <select name="human_educated_degree" id="xueli"   class="SELECT_STYLE1">
							<option value="">--请选择--</option> 
							
							<c:forEach items="${xueli }" var="list">
								<option value="${list.attribute_name }">${list.attribute_name }</option>
							</c:forEach> 
							
					 </select> 
					</td>
					
				</tr>
				<tr>
				<td class="TD_STYLE1">
						教育年限
					</td>
					<td class="TD_STYLE2">
					   <select name="human_educated_years" id="nianxian"  class="SELECT_STYLE1">
							<option value="">--请选择--</option> 
							
							<c:forEach items="${jiaoyv }" var="list">
								<option value="${list.attribute_name }">${list.attribute_name }</option>
							</c:forEach>
							
					 </select> 
					</td>
					<td class="TD_STYLE1">
						学历专业
					</td>
					<td class="TD_STYLE2">
					   <select name="human_educated_major" id="zhye"   class="SELECT_STYLE1">
							<option value="">--请选择--</option> 
							
							<c:forEach items="${zhuanye }" var="list">
								<option value="${list.attribute_name }">${list.attribute_name }</option>
							</c:forEach> 
							
					 </select>  
					</td>
					
					<td class="TD_STYLE1">
						薪酬要求
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="demand_salary_standard" id="gongzi" class="INPUT_STYLE2" />
					</td>
					<td class="TD_STYLE1">
						注册时间
					</td>
					<td class="TD_STYLE2">
						 <input type="text" name="regist_time"
							  id="nowTime" readonly="readonly"
							class="INPUT_STYLE2">
					</td>
					
				</tr>
				<tr>
					 
					<td class="TD_STYLE1">
						特长
					</td>
					<td class="TD_STYLE2">
					   <select name="human_specility" id="techang"  class="SELECT_STYLE1">
							<option value="">--无--</option> 
							
							<c:forEach items="${techang }" var="list">
								<option value="${list.attribute_name }">${list.attribute_name }</option>
							</c:forEach>
							
					 </select> 
						 
					</td>
					<td class="TD_STYLE1">
						爱好
					</td>
					<td class="TD_STYLE2">
				     <select name="human_hobby"  class="SELECT_STYLE1">
							<option value="">--无--</option> 
							
							<c:forEach items="${aihao }" var="list">
								<option value="${list.attribute_name }">${list.attribute_name }</option>
							</c:forEach>
							
					 </select> 
						  
					</td>
					<td class="TD_STYLE1">
						&nbsp;
					</td>
					<td class="TD_STYLE2">
						&nbsp;
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
						<textarea name="human_history_records" id="nvli" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
				 
				<tr>
					<td class="TD_STYLE1">
						备注
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="remark" id="beizhu" rows="4" class="TEXTAREA_STYLE1">无</textarea>
					</td>
				</tr>
			</table>
		 </form>




	</body>
 
</html>

