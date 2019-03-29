<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript">
	function updateAjaxTwo() {
		var id = $("#id").val();
		var time = $("#time").val();
		var reason = $("#reason").val();
		var user_id = $("#user_id").val();
		/* var approver = $("#approver").val();
		var state = $("#state").val(); */
		var twoapprover = $("#twoapprover").val();
		var twostate = $('input[type=radio][id=twostate]:checked').val();
		//采用Ajax方式进行访问服务器
		$.ajax({
			type : "get",
			data : {
				"id" : id,
				"time" : time,
				"reason" : reason,
				"user_id" : user_id,
				/* "approver" : approver,
				"state" : state,  */
				"twoapprover" : twoapprover,
				"twostate" : twostate,
				"oper" : "updateAjaxTwo"
			},
			url : "MeetingapplyServlet.do",
			dataType : "json",
			async : true,
			success : function(data) {
				if (data.status == "1") {
					alert("修改成功");
					//进入首页
					location.href = "MeetingapplyServlet.do";
				} else {
					alert("修改失败");
				}
			}
		});
	}
</script>
</head>
<body class="childrenBody">
	<form action="MeetingapplyServlet.do" role="form" method="post"
		class="layui-form">
		<input type=hidden name="oper" value="add" /> <input name="id"
			id="id" type=hidden value="${meetingapply.meetingapply_id }">
		<%-- <input name="approver"
			id="approver" type=hidden value="${meetingapply.apporver }">
			<input name="state"
			id="state" type=hidden value="${meetingapply.state }"> --%>
		<div class="user_left">
			<div class="layui-form-item">
				<label class="layui-form-label">会议申请时间</label>
				<div class="layui-input-block">
					<input name="time" id="time" type="text"
						value="${meetingapply.meetingapply_time }" disabled
						placeholder="请输入请假时间" lay-verify="required" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">会议申请原因</label>
				<div class="layui-input-block">
					<input name="reason" id="reason" type="text"
						value="${meetingapply.meetingapply_reason }" disabled
						placeholder="请输入请假原因" lay-verify="required" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">申请人id</label>
				<div class="layui-input-block">
					<input name="user_id" id="user_id" type="text"
						value="${meetingapply.user_id }" disabled placeholder="请输入id"
						lay-verify="required" class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">审批人(二级)</label>
				<div class="layui-input-block">
					<input name="twoapprover" id="twoapprover" type="tel"
						value="${loginUser }" placeholder="" lay-verify="required|phone"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">审批结果(二级)</label>
				<div class="layui-input-block">
					<input type="radio" name="twostate" id="twostate" value="不同意"
						title="不同意" checked> <input type="radio" name="twostate"
						id="twostate" value="同意" title="同意">

				</div>
			</div>
		</div>

		<div class="layui-form-item" style="margin-left: 5%;">
			<div class="layui-input-block">
				<button onclick="updateAjaxTwo()" type="button" class="layui-btn">提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript" src="js/address.js"></script>
	<script type="text/javascript" src="js/user.js"></script>
</body>
</html>