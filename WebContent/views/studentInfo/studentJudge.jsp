<!DOCTYPE HTML >
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript"
	src="../../lib/bootstrap/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="../../lib/bootstrap/js/bootstrap.min.js"></script>
<title>评价页面</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-push-4">
				<form action="StudentJudgeUpdateServlet" method="post">
					<table border="1">
						<!-- el表达式取request中值 -->
						<!-- 传回servlet用update,... -->
						<tr>
							<td>教师ID:</td>
							<td><input name="teacherId" value="${judge.teacherId}"
								readonly="readonly"></td>
						</tr>
						<tr>
							<td>学生ID:</td>
							<td><input name="studentId" value="${judge.studentId}"
								readonly="readonly"></td>
						</tr>
						<tr>
							<td>课程名称:</td>
							<td><input name="courseName" value="${judge.courseName}"
								readonly="readonly"></td>
						</tr>
						<tr>
							<td>选项值:</td>
							<td><input name="optionValue" value="${judge.optionValue}"></td>
						</tr>
						<tr>
							<td>总分值:</td>
							<td><input name="totalScore" value="${judge.totalScore}"></td>
						</tr>
						<tr>
							<td>学习总结:</td>
							<td><textarea name="studySummary">${judge.studySummary}</textarea></td>
						</tr>
						<tr>
							<td colspan="2"><button>提交</button></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>