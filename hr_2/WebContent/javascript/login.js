$(function() {
	$(":button").click(function() {
		doLogin();
	});
	$("html").die().live("keydown", function(event) {
		if (event.keyCode == 13) {
			checkLogin();
		}
	});
//	$(window).keydown(function(event){
//		if (event.keyCode == 13) {
//			checkLogin();
//		}
//	});
});

function checkLogin() {
	
	var login = $("#login1");
	var userName = $("#userName");
	var userPassword = $("#userPassword");
	var reg = /^\S{6,}$/;
	
	var reg2 =  /^(13|14|15|16|17|18|19)\d{9}$/;
	var textcode = $("#SBtn").val();
	var SMScode = $("#smsCode").val();
	//alert(textcode);
	//alert(SMScode);
	//不是手机号
	if(!reg2.test(userName.val())){
		if (!reg.test(userName.val())) {
			userName[0].select();
			$.messager.show("消息提示", "登录名格式不正确！长度必须大于6位且不能有空格！", 2000);
			return false;
		}
		if (!reg.test(userPassword.val())) {
			userPassword[0].select();
			$.messager.show("消息提示", "登录密码格式不正确！长度必须大于6位且不能有空格！", 2000);
			return false;
		}
		
	}
	//是手机号
	if(reg2.test(userName.val())){
		if (!textcode){
			$.messager.show("消息提示", "请输入验证码！", 2000);
			return false;
		}
		if (textcode != SMScode){
			$.messager.show("消息提示", "验证码输入有误，请重新输入！", 2000);
			return false;
		}
	}
	login.submit();
}

