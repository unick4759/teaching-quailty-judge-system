<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 导入资源 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="lib/bootstrap/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="lib/bootstrap/js/bootstrap.min.js"></script>
<link
	href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
	
<title>教学质量评价系统</title>
<style>
body {
	background: url("./img/1.jpg");
	animation-name: myfirst;
	animation-duration: 40s;
	/*变换时间*/
	animation-delay: 5s;
	/*动画开始时间*/
	animation-iteration-count: infinite;
	/*下一周期循环播放*/
	animation-play-state: running;
	/*动画开始运行*/
}

@
keyframes myfirst { 
0% {background: url("./img/1.jpg");}
34%{background:url("./img/2.jpg");}
67%{background:url("./img/3.jpg");}
85%{background:url("./img/4.jpg");}
100%{background:url("./img/1.jpg");}
}
.form {
	background: rgba(255, 255, 255, 0.2);
	width: 400px;
	margin: 120px auto;
}
/*阴影*/
.fa {
	display: inline-block;
	top: 27px;
	left: 6px;
	position: relative;
	color: #ccc;
}

input[type="text"], input[type="password"] {
	padding-left: 26px;
}

.checkbox {
	padding-left: 21px;
}
</style>
<!-- =================================================================== -->
<script type="text/javascript">
	//检验输入,不通过ajax检测则不发送请求。
	//登录按钮的点击事件要执行的函数。
	/**$(document).ready(function(){
	 $("button").click(function(){
	 //要执行的函数
	 if(validateAll()){
	 var username=$("#username").val();
	 var password=$("#password").val();
	 var role=$('input:radio:checked').val();
	 var servletUrl="Error";
	
	 //根据选择的role，赋值url
	 if(role==0){
	 servletUrl="StudentLoginServlet";
	 }else if(role==1){
	 servletUrl="TeacherLoginServlet";
	 }else if(role==2){
	 servletUrl="ManagerLoginServlet";
	 }
	 //打包到json
	 /**$.ajax({
	 url:'LoginServlet',
	 type:'post',
	 data:"role="+role,
	 success:function(result){
	 $("#rolemsg").html(result.msg);
	 alert("success");
	 },
	 error:function(XMLHttpRequest,textStatus,errorThrown){
	 alert("ajax执行失败:"+textStatus);
	 }
	 });
	 }else{
	 //alert("validateAll()=false");
	 validateAll();
	 }**/
	//});
	//});
	//调用检验
	function validateAll() {
		if (validateUsername()) {
			if (validatePwd()) {
				if (validateRole()) {
					return true;
				}
			}
		} else {
			return false;
		}
		return false;
	}
	//判断用户名是否为空，
	function validateUsername() {
		var username = $("#username").val();
		if (username == null || username.trim() == "") {
			$("#namemsg").text("请输入用户名");
			//alert("请输入用户名");
			return false;
		} else {
			$("#namemsg").text("*");
			return true;
		}
		return false;
	}
	//判断密码是否为空，
	function validatePwd() {
		var password = $("#password").val();
		if (password = null || password.trim() == "") {
			$("#pwdmsg").text("请输入密码");
			//alert("请输入密码");
			return false;
		} else {
			$("#pwdmsg").text("*");
			return true;
		}
		return false;
	}
	//判断角色是否为空，

	//根据角色选择发送给对应的servlet
	function validateRole() {
		//取角色单选框的值
		var role = $('input:radio:checked').val();
		if (role == null || role == "") {
			$("#rolemsg").text("请选择角色");
			//alert("请选择角色");
			return false;
		} else {
			$("#rolemsg").text("*");
			return true;
		}
		return false;
		//012表示学生教师管理员
	}

	//登录后退出会清空session，跳到登录页面
</script>
<!-- =============================================================== -->

</head>

<body>
	<form action="LoginServlet" method="post"
		onsubmit="return validateAll()">
		<div class="container">
			<div class="form row">
				<div class="form-horizontal col-md-offset-3" id="login_form">
					<h3 class="form-title">LOGIN</h3>
					<div class="col-md-9">
						<div class="form-group">
							<i class="fa fa-user fa-lg"></i> <input
								class="form-control required" type="text" placeholder="Username"
								id="username" name="username" autofocus="autofocus"
								onblur="validateUsername()" maxlength="20" />
						</div>
						<small id="namemsg" style="display: inline;"
							class="form-horizontal">*</small>
						<div id="namemsg" style="display: inline; color: red;"></div>
						<div class="form-group">
							<i class="fa fa-lock fa-lg"></i> <input
								class="form-control required" type="password"
								placeholder="Password" id="password" name="password"
								maxlength="8" onblur="validatePwd()" /><small id="pwdmsg"
								style="display: inline;" class="form-horizontal">*</small>
							<div id="pwdmsg" style="display: inline; color: red;"></div>
						</div>
						<div class="form-group">
							<label class="checkbox"> <input type="checkbox"
								name="remember" value="1" />记住我
							</label> <label class="radio-inline"><input type="radio"
								name="role" value=0>学生</label> <label class="radio-inline"><input
								type="radio" name="role" value=1>教师</label> <label
								class="radio-inline"><input type="radio" name="role"
								value=2>管理员</label> <small id="rolemsg" style="display: inline;"
								class="form-horizontal">*</small>

						</div>
						<div id="rolemsg" style="display: inline; color: red;"></div>
						<div class="form-group col-md-offset-9">
							<button type="submit"
								class="btn btn-success pull-right btn-block" name="submit"
								onclick="validateAll()" onsubmit="return validateAll()">登录</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>