<!DOCTYPE HTML>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 导入资源 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="../../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript"
	src="../../lib/bootstrap/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="../../lib/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<title>教师界面</title>
<script>
	$(document).ready(function() {
		$("#my_course").click(function() {
			ajax_course();
		});
		$("#my_judge").click(function() {
			ajax_judge();
		});
		$("#my_info").click(function() {
			ajax_info();
		});
	});
	function ajax_course() {
		$
				.ajax({
					type : "GET",
					dataType : "json",
					data : {},
					url : "TeacherCourseServlet",
					success : function(data) {
						console.log(data);

						var mytab = $("#content");
						mytab.html("");
						$("#content_info").html("");
						mytab
								.append("<thead><tr><th>序号</th><th>课程名称</th><th>所属专业</th><th>老师ID</th><th>老师名称</th><th>学生ID</th></tr></thead><tbody>");
						for ( var i in data) {
							mytab.append("<tr><td>" + i + "</td><td>"
									+ data[i].courseName + "</td><td>"
									+ data[i].majorName + "</td><td>"
									+ data[i].teacherId + "</td><td>"
									+ data[i].teacherName + "</td><td>"
									+ data[i].studentId + "</td></tr>");
						}
						mytab.append("</tbody>");
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						alert("ajax_run_error:" + textStatus + errorThrown);
					}
				});
	}
	function ajax_judge() {
		$
				.ajax({
					type : "GET",
					dataType : "json",
					data : {},
					url : "TeacherJudgeServlet",
					success : function(data) {
						console.log(data);

						var mytab = $("#content");
						mytab.html("");
						mytab
								.append("<thead><tr><th>序号</th><th>老师ID</th><th>学生ID</th><th>课程名称</th><th>选项值</th><th>总分值</th><th>学习总结</th></tr></thead><tbody>");
						for ( var i in data) {
							mytab.append("<tr><td>" + i + "</td><td>"
									+ data[i].teacherId + "</td><td>"
									+ data[i].studentId + "</td><td>"
									+ data[i].courseName + "</td><td>"
									+ data[i].optionValue + "</td><td>"
									+ data[i].totalScore + "</td><td>"
									+ data[i].studySummary + "</td></tr>");
						}
						mytab.append("</tbody>");
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						alert("ajax_run_error:" + textStatus + errorThrown);
					}
				});
	}
	function ajax_info() {
		$
				.ajax({
					type : "GET",//..
					dataType : "json",
					data : {},
					url : "TeacherInfoServlet",
					success : function(data) {
						console.log(data);
						var mytab = $("#content_info");
						mytab.html("");
						mytab
								.append("<tr><td>我的密码:</td><td><input id='password'></td></tr>"
										+ "<tr><td>我的名称:</td><td><input id='teacherName'></td></tr>"
										+ "<tr><td>其他信息:</td><td><input id='elseInfomation'></td></tr>");
						$("#password").val(data.password);
						$("#teacherName").val(data.teacherName);
						$("#elseInfomation").val(data.elseInfomation);
						mytab
								.append("<tr><td colspan='2'><button class='btn btn-success btn-block' id='btn_updateInfo'>保存</button></td></tr>");
						$("#content").html("");
						$("#btn_updateInfo").click(function() {
							ajax_updateInfo();
						});
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						alert("ajax_run_error:" + textStatus + errorThrown);
					}
				});
	}
	function ajax_updateInfo() {
		//取id,取值，发送json给servlet,servlet取值，存数据库，更新session的user.
		var password = $("#password").val();
		var teacherName = $("#teacherName").val();
		var elseInfomation = $("#elseInfomation").val();
		var sendData = {
			"password" : password,
			"teacherName" : teacherName,
			"elseInfomation" : elseInfomation
		};
		$.ajax({
			type : "POST",
			dataType : "json",
			data : sendData,
			url : "TeacherInfoUpdateServlet",
			success : function(data) {
				alert(data);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("ajax_run_error:" + textStatus + errorThrown);
			}
		});
	}
</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<img src="../../img/index_logo.gif" alt="photo">
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<nav class="navbar navbar-expand-md bg-dark navbar-dark">
					<ul class="nav nav-pills">
						<li class="nav-item active"><a class="navbar-brand" href="#">教学质量评价系统</a>
						</li>
					</ul>
				</nav>
			</div>
		</div>
		<div class="row">
			<h1>
				教师界面<small> <a href="LogoutServlet">退出</a></small>
			</h1>
			<hr>
		</div>
		<div class="row">
			<div class="col-md-2">
				<ul class="nav nav-pills nav-stacked">
					<li id="my_course"><a href="#" style="font-size: 20px;">我的课程</a></li>
					<li id="my_judge"><a href="#" style="font-size: 20px;">我的评价</a></li>
					<li id="my_info"><a href="#" style="font-size: 20px;">我的信息</a></li>
				</ul>
			</div>
			<div class="col-md-10">

				<table id="content_info">
				</table>
				<div id="curd_util"></div>
				<!-- 查找。。。增加。。两行输入框和按钮咯。 -->
				<table id="content" class="table table-dark table-hover">
					<!-- table要加操作列，值为修改|删除超链接，url带着id到servlet再到jsp在返回 -->

				</table>
			</div>
		</div>

	</div>
</body>
</html>