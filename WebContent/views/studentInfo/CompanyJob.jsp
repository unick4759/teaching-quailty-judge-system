<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>本公司发布的职位</title>
<style>
.main {
	width: 700px;
	margin: 20px auto;
}

.tabData {
	margin-top: 30px;
}

#tab {
	border-collapse: collapse;
}

#tab tr th {
	width: 150px;
	font-size: 12px;
	height: 35px;
	line-height: 35px;
}

#pages span {
	padding: 8px;
	margin-right: 10px;
	position: relative;
	top: 30px;
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="main">
		<div id="search">
		<a href="${pageContext.request.contextPath}/index.jsp">☞返回首页</a><br/><br/>
			职位类型:<select id="type">
				<option value="">全部</option>
				<option value="1">后端开发</option>
				<option value="2">移动开发</option>
				<option value="3">前端开发</option>
				<option value="4">人工智能</option>
				<option value="5">测试</option>
				<option value="6">运维</option>
				<option value="7">DBA</option>
			</select>职位名称:<input type="text" name="jobname" id="jobname" /> 
			<input type="button" id="btn" value="搜索" />
		</div>

		<div class="tabData">
			<table id="tab" border="1" cellspacing="0" cellspadding="0">

			</table>

			<div id="pages"></div>
		</div>
	</div>
	<!-- <script type="text/javascript" src="../js/jquery-1.8.3.js"></script> -->
	<script type="text/javascript" src="../js/jquery.js"></script>
	<script type="text/javascript">
	var pSize = 3;
		$(function() {
			loadData(1, pSize, null, null);
		});
		function loadData(curPage, pageSize, type, jobname) {
			$.ajax({
				async : true,
				dataType : "json",
				url : "../CompanyJobListByPageServlet",
				type : "POST",
				data : {
					"curPage" : curPage,
					"pageSize" : pageSize,
					"type" : type,
					"jobname" : jobname
				},
				success : function(data) {
					console.log(data);
					loadDom(data);
				}

			});
		}

		function loadDom(data) {
			//先将标签清空，再去加载
			$("#tab").html("");
			$("#pages").html("");
			$("#tab").append(
					"<tr><th>职位类型</th><th>职位名称</th><th>月薪</th><th>发布时间</th><th>查看详细信息</th></tr>");
			for (var i = 0; i < data.list.length; i++) {
				var stype = data.list[i].jt_id;
				var type = "";
				if (stype == 1) {
					type = "后端开发";
				}
				if (stype == 2) {
					type = "移动开发";
				}
				if (stype == 3) {
					type = "前端开发";
				}
				if (stype == 4) {
					type = "人工智能";
				}
				if (stype == 5) {
					type = "测试";
				}
				if (stype == 6) {
					type = "运维";
				}
				if (stype == 7) {
					type = "DBA";
				}
				$("#tab").append(
						"<tr><th>" + type 
							+ "</th><th>" + data.list[i].j_name
							+ "</th><th>" + data.list[i].j_salary
							+ "</th><th>" + data.list[i].j_time
							+ "</th>" + "<th><a href='../CompanyJobDetailsServlet?id="+ data.list[i].j_id +"'>查看详细信息</a></th>" + "</tr>");
			}
			//拼接span
			$("#pages").append("<span class='pre'>上一页</span>");
			for (var i = 0; i < data.totalPages; i++) {
				if(data.params.curPage == (i+1)){
					$("#pages").append("<span class='page' style='color:red'>" + (i + 1) + "</span>");
				}
				else{
					$("#pages").append("<span class='page'>" + (i + 1) + "</span>");
				}
			}
			$("#pages").append("<span class='next'>下一页</span>");
			//点击 1,2,3具体的页码，需要访问对应页码的数据
			
			$(".page").click(function() {
				// 
				$(this).css("color", "red").siblings().css("color", "black");
				//数据也要换
				
				var snum = $(this).html();
				snum = parseInt(snum);
				var type = $("#type").val();
				var jobname = $("#jobname").val();
				data.params.curPage = snum;
				loadData(snum, pSize, type, jobname);

			});
			
			$(".pre").click(function() {
				var type = $("#type").val();
				var jobname = $("#jobname").val();
				if(data.params.curPage > 0){
					data.params.curPage = data.params.curPage - 1;
					loadData(data.params.curPage, pSize, type, jobname);
				}
			});
			
			$(".next").click(function() {
				var type = $("#type").val();
				var jobname = $("#jobname").val();
				if(data.params.curPage < data.totalPages){
					data.params.curPage = data.params.curPage + 1;
					loadData(data.params.curPage, pSize, type, jobname);
				}
			});

			$("#btn").click(function() {
				var type = $("#type").val();
				var jobname = $("#jobname").val();
				console.log(type);
				console.log(jobname);
				loadData(1, pSize, type, jobname);
			});
		}
	</script>
</body>
</html>