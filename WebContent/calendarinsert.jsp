<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int user_id = (int) session.getAttribute("loginUser_id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>个人资料--layui后台管理模板</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="layui/css/layui.css" media="all" />
<link rel="stylesheet" href="css/user.css" media="all" />
</head>
<script type="text/javascript">
	function provingId() {
		var name = $("#name").val();
		var start = $("#start").val();
		var end = $("#end").val();
		var remind = $("#remind").val();
		var content = $("#content").val();
		var user_id = $("#user_id").val();
		if(<%=user_id%>!=user_id){
			alert("您的id不正确不可以添加事件");
		} else {
			alert("您的id正确可以添加事件");
			$.ajax({
				type : "get",
				data : {
					"name" : name,
					"start" : start,
					"end" : end,
					"remind" : remind,
					"content" : content,
					"user_id" : user_id,
					"oper" : "add"
				},
				url : "CalendarServlet.do",
				dataType : "json",
				async : true,
				success : function(data) {
					if (data.status == "1") {
						alert("添加成功");
						//进入首页
						location.href = "CalendarServlet.do";
					} else {
						alert("添加失败");
					}
				}
			});
		}

	}
</script>
<body class="childrenBody">
	<form action="CalendarServlet.do" role="form" method="post"
		class="layui-form">
		<input type=hidden name="oper" value="add" />
		<div class="user_left">
			<div class="layui-form-item">
				<label class="layui-form-label">日程标题</label>
				<div class="layui-input-block">
					<input name="name" id="name" type="text" value=""
						placeholder="请输入日程标题" lay-verify="required" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">开始时间</label>
				<div class="layui-input-block">
					<input name="start" id="start" type="text" value=""
						placeholder="请输入日程开始时间" lay-verify="required|date"
						onclick="layui.laydate({elem: this,max: laydate.now()})" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">结束时间</label>
				<div class="layui-input-block">
					<input name="end" id="end" type="text" value="" placeholder="请输入日程结束时间"
						lay-verify="required|date"
						onclick="layui.laydate({elem: this,max: laydate.now()})" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">提醒</label>
				<div class="layui-input-block">
					<input name="remind" id="remind" type="tel" value=""
						placeholder="请输入提醒事项" lay-verify="required|phone"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">内容</label>
				<div class="layui-input-block">
					<input name="content" id="content" type="tel"
						value="${calendar.calendar_content }" placeholder="请输入提醒内容"
						lay-verify="required|phone" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">用户id</label>
				<div class="layui-input-block">
					<input name="user_id" id="user_id" type="text" value="${loginUser_id }" disabled
						placeholder="请输入您的id" lay-verify="required" class="layui-input">
				</div>
			</div>
		</div>

		<div class="layui-form-item" style="margin-left: 5%;">
			<div class="layui-input-block">
			    <button onclick="provingId()" type="button" class="layui-btn">提交</button>
				<!-- <button type="submit" class="layui-btn">提交</button> -->
				<!-- <button class="layui-btn" lay-submit="" lay-filter="changeUser">立即提交</button> -->
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript" src="js/address.js"></script>
	<script type="text/javascript" src="js/user.js"></script>
</body>
</html>