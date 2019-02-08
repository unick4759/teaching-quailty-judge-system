<!DOCTYPE HTML >
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
<title>学生界面</title>
<script>
	$(document).ready(function() {
		$("#my_course").click(function() {
			ajax_course();
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
					data : {},//别的地方需要看一下data.
					url : "StudentCourseServlet",
					success : function(data) {
						console.log(data);

						var mytab = $("#content");
						mytab.html("");
						$("#content_info").html("");
						mytab
								.append("<thead><tr><th>序号</th><th>课程名称</th><th>所属专业</th><th>老师ID</th><th>老师名称</th><th>学生ID</th><th>操作</th></tr></thead><tbody>");
						for ( var i in data) {

							mytab
									.append("<tr><td>"
											+ i
											+ "</td><td>"
											+ data[i].courseName
											+ "</td><td>"
											+ data[i].majorName
											+ "</td><td>"
											+ data[i].teacherId
											+ "</td><td>"
											+ data[i].teacherName
											+ "</td><td>"
											+ data[i].studentId
											+ "</td><td><a href='StudentJudgeServlet?studentId="
											+ data[i].studentId + "&teacherId="
											+ data[i].teacherId
											+ "&courseName="
											+ data[i].courseName
											+ "' target='_blank'>评价</a></td></tr>");
							//在这里设置每一个<a>的id属性和值。onclick事件。
							var courseName = data[i].courseName;
							$("#operate")
									.click(
											function() {
												$
														.ajax({
															type : "POST",
															dataType : "json",
															data : {
																"courseName" : courseName,
																"teacherId" : data[i].teacherId,
															},
															url : "StudentJudgeServlet",
															success : function(
																	data) {
																var mytab = $("#content");
																mytab.html("");
																mytab
																		.append("<tr><td>课程名称:</td><td><input id='courseName' readonly='readonly'/></td></tr>"
																				+ "<tr><td>教师ID:</td><td><input id='teacherId' readonly='readonly'/></td></tr>"
																				+ "<tr><td>选项值:</td><td><input id='optionValue'/></td></tr>"
																				+ "<tr><td>总分值:</td><td><input id='totalScore'/></td></tr>"
																				+ "<tr><td>学习总结:</td><td><input id='studySummary'/></td></tr>");
																//按钮要加ajax...与修改个人信息一模一样..
																$("#courseName")
																		.val(
																				data.courseName);
																$("#teacherId")
																		.val(
																				data.teacherId);
																$("#studentId")
																		.val(
																				data.studentId);
																mytab
																		.append("<tr><td colspan='2'><button class='btn btn-success btn-block' id='btn_updateInfo'>保存</button></td></tr>");
																$("#content")
																		.html(
																				"");
																$(
																		"#btn_updateInfo")
																		.click(
																				function() {
																					ajax_updateJudge();
																				});
															},
															error : function(
																	XMLHttpRequest,
																	textStatus,
																	errorThrown) {
																alert("ajax_run_error (点击评价):"
																		+ textStatus
																		+ errorThrown);
															}
														});
											});
							$("#operate").attr({
								id : i
							});
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
					url : "StudentInfoServlet",
					success : function(data) {
						console.log(data);
						var mytab = $("#content_info");
						mytab.html("");
						mytab
								.append("<tr><td>我的密码:</td><td><input id='password'></td></tr>"
										+ "<tr><td>我的专业:</td><td><input id='majorName'></td></tr>"
										+ "<tr><td>其他信息:</td><td><input id='elseInfomation'></td></tr>");
						$("#password").val(data.password);
						$("#majorName").val(data.majorName);
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
		var majorName = $("#majorName").val();
		var elseInfomation = $("#elseInfomation").val();
		var sendData = {
			"password" : password,
			"majorName" : majorName,
			"elseInfomation" : elseInfomation
		};
		$.ajax({
			type : "POST",
			dataType : "json",
			data : sendData,
			url : "StudentInfoUpdateServlet",
			success : function(data) {
				alert(data);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("ajax_run_error:" + textStatus + errorThrown);
			}
		});
	}
	function ajax_updateJudge() {
		var courseName = $("#courseName").val();
		var teacherId = $("#teacherId").val();
		var optionValue = $("#optionValue").val();
		var totalScore = $("#totalScore").val();
		var studySummary = $("#studySummary").val();
		var sendData = {
			"courseName" : courseName,
			"teacherId" : teacherId,
			"optionValue" : optionValue,
			"totalScore" : totalScore,
			"studySummary" : studySummary
		};
		$.ajax({
			type : "POST",
			dataType : "json",
			data : sendData,
			url : "StudentJudgeUpdateServlet",
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
				学生界面 <small><a href="LogoutServlet">退出</a></small>
			</h1>
			<hr>
		</div>
		<div class="row">
			<div class="col-md-2">
				<ul class="nav nav-pills nav-stacked">
					<li id="my_course"><a href="#" style="font-size: 20px;">我的课程</a></li>
					<li id="my_info"><a href="#" style="font-size: 20px;">我的信息</a></li>
				</ul>
			</div>
			<div class="col-md-10">

				<table id="content_info"></table>
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