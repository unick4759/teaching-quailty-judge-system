<!DOCTYPE HTML >
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@page import="com.entity.StudentInfo"%>
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
<title>管理员界面</title>
<script>
	$(document).ready(function() {
		$("#manager_student").click(function() {
			ajax_studentList();
		});
		$("#manager_teacher").click(function() {
			ajax_teacherList();
		});
		$("#manager_major").click(function() {
			ajax_majorList();
		});
		$("#manager_course").click(function() {
			ajax_courseList();
		});
		$("#manager_judge").click(function() {
			ajax_judgeList();
		});
	});
	function ajax_studentList() {
		//$("#form").attr("action","StudentListServlet");
		$
				.ajax({
					async : true,
					type : "GET",
					dataType : "json",
					data : {},
					url : "StudentListServlet",
					success : function(data) {
						console.log(data);

						var mytab = $("#content");
						mytab.html("");
						mytab
								.append("<thead><tr><th>序号</th><th>学生帐号</th><th>学生密码</th><th>学生专业</th><th>操作</th></tr></thead><tbody>");
						for ( var i in data) {
							mytab.append("<tr><td>" + i + "</td><td>"
									+ data[i].username + "</td><td>"
									+ data[i].password + "</td><td>"
									+ data[i].majorName + "<td><a href='#'>修改</a>|<a href='#'>删除</a></td></td></tr>");
						}
						mytab.append("</tbody>");
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						alert("ajax_run_error:" + textStatus + errorThrown);
					}
				});
	}
	function ajax_teacherList() {
		//$("#content").text("teacherList table");
		//$("#form").attr("action", "TeacherListServlet");
		$
				.ajax({
					async : true,
					type : "GET",
					dataType : "json",
					data : {},
					url : "TeacherListServlet",
					success : function(data) {
						console.log(data);

						var mytab = $("#content");
						mytab.html("");
						mytab
								.append("<thead><tr><th>序号</th><th>老师帐号</th><th>老师密码</th><th>老师姓名</th><th>操作</th></tr></thead><tbody>");
						for ( var i in data) {
							mytab.append("<tr><td>" + i + "</td><td>"
									+ data[i].username + "</td><td>"
									+ data[i].password + "</td><td>"
									+ data[i].teacherName + "<td><a href='#'>修改</a>|<a href='#'>删除</a></td></td></tr>");
						}
						mytab.append("</tbody>");
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						alert("ajax_run_error:" + textStatus + errorThrown);
					}
				});
	}
	function ajax_majorList() {
		$
				.ajax({
					type : "GET",
					dataType : "json",
					data : {},
					url : "MajorListServlet",
					success : function(data) {
						console.log(data);

						var mytab = $("#content");
						mytab.html("");
						mytab
								.append("<thead><tr><th>序号</th><th>专业ID</th><th>专业名称</th><th>操作</th></tr></thead><tbody>");
						for ( var i in data) {
							mytab.append("<tr><td>" + i + "</td><td>"
									+ data[i].majorId + "</td><td>"
									+ data[i].majorName + "<td><a href='#'>修改</a>|<a href='#'>删除</a></td></td></tr>");
						}
						mytab.append("</tbody>");
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						alert("ajax_run_error:" + textStatus + errorThrown);
					}
				});
	}
	function ajax_courseList() {
		$
				.ajax({
					type : "GET",
					dataType : "json",
					data : {},
					url : "CourseListServlet",
					success : function(data) {
						console.log(data);

						var mytab = $("#content");
						mytab.html("");
						mytab
								.append("<thead><tr><th>序号</th><th>课程名称</th><th>所属专业</th><th>老师ID</th><th>老师名称</th><th>学生ID</th><th>操作</th></tr></thead><tbody>");
						for ( var i in data) {
							mytab.append("<tr><td>" + i + "</td><td>"
									+ data[i].courseName + "</td><td>"
									+ data[i].majorName + "</td><td>"
									+ data[i].teacherId + "</td><td>"
									+ data[i].teacherName + "</td><td>"
									+ data[i].studentId + "<td><a href='#'>修改</a>|<a href='#'>删除</a></td></td></tr>");
						}
						mytab.append("</tbody>");
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						alert("ajax_run_error:" + textStatus + errorThrown);
					}
				});
	}
	function ajax_judgeList() {
		$
				.ajax({
					type : "GET",
					dataType : "json",
					data : {},
					url : "JudgeListServlet",
					success : function(data) {
						console.log(data);

						var mytab = $("#content");
						mytab.html("");
						mytab
								.append("<thead><tr><th>序号</th><th>老师ID</th><th>学生ID</th><th>课程名称</th><th>选项值</th><th>总分值</th><th>学习总结</th><th>操作</th></tr></thead><tbody>");
						for ( var i in data) {
							mytab.append("<tr><td>" + i + "</td><td>"
									+ data[i].teacherId + "</td><td>"
									+ data[i].studentId + "</td><td>"
									+ data[i].courseName + "</td><td>"
									+ data[i].optionValue + "</td><td>"
									+ data[i].totalScore + "</td><td>"
									+ data[i].studySummary + "<td><a href='#'>修改</a>|<a href='#'>删除</a></td></td></tr>");
						}
						mytab.append("</tbody>");
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
			<div class="col-md-12">
				<h1>
					管理员界面 <small><a href="/LogoutServlet">退出</a></small>
				</h1>
				<hr>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<ul class="nav nav-pills nav-stacked">
					<li class="nav-item" id="manager_student"><a class="nav-link"
						href="#" style="font-size: 20px;">管理学生信息</a></li>
					<li id="manager_teacher"><a href="#" style="font-size: 20px;">管理教师信息</a></li>
					<li id="manager_major"><a href="#" style="font-size: 20px;">管理专业信息</a></li>
					<li id="manager_course"><a href="#" style="font-size: 20px;">管理课程信息</a></li>
					<li id="manager_judge"><a href="#" style="font-size: 20px;">管理评价信息</a></li>
				</ul>
			</div>
			<div class="col-md-10">

				<table id="curd_util"></table>
				<!-- 查找。。。增加。。两行输入框和按钮咯。 -->
				<table id="content" class="table table-dark table-hover">
					<!-- table要加操作列，值为修改|删除超链接，url带着id到servlet再到jsp在返回 -->

				</table>
			</div>
		</div>
	</div>
</body>
</html>