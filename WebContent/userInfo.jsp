<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>个人资料</title>
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
	$(function(){
		var hobby2 = document.getElementsByName("like1");
		var hobby3 = [];
			<%
			String[] str=(String[])session.getAttribute("loginUser_hobby");
			for(String key :str){
			%>
			hobby3.push("<%=key%>");
			<%
			}
		    %>
		alert(hobby3.length);
		for(var i = 0;i<hobby3.length;i++){
			for(var j = 0 ;j<hobby2.length;j++){
				if(hobby2[j].value==hobby3[i]){
					hobby[j].checked=true;
				}
			}
		}
		
	});
	function userinfo() {
		var id = $("#id").val();
		var uname = $("#uname").val();
		var realname = $("#realname").val();
		var gender = $('input[type=radio][id=gender]:checked').val();
		var phonenumber = $("#phonenumber").val();
		var born = $("#born").val();
		var city = $("#city").val();
		var hobby = $("input[name='like1']:checked").val();
		alert(hobby);
		var hobby2 = document.getElementsByName("like1");
		var hobby3 = [];
		for(k in hobby2){
			if (hobby2[k].checked){
				hobby3.push(hobby2[k].value);
			}
		}
		alert(hobby3);
		var email = $("#email").val();
		var selfassessment = $("#selfassessment").val();
		var headpic = $("#headpic").val()
		alert(headpic);
		//采用Ajax方式进行访问服务器
		$.ajax({
			type : "get",
			data : {
				"id" : id,
				"uname" : uname,
				"realname" : realname,
				"gender" : gender,
				"phonenumber" : phonenumber,
				"born" : born,
				"city" : city,
				"hobby" : hobby3,
				"email" : email,
				"selfassessment" : selfassessment,
				"headpic" : headpic,
				"oper" : "userinfo"
			},
			url : "UserServlet.do?powercode=user_update",
			dataType : "json",
			traditional: true,
			async : true,
			success : function(data) {
				if (data.status == "1") {
					alert("修改成功");
					
					//location.href = "UserServlet.do?";
				} else {
					alert("修改失败");
				}
			}
		});
	}

	function uploadFunction() {
		var formData = new FormData();
		formData.append('file', $('#file')[0].files[0]);
		$.ajax({
			url : 'UploadServlet.do',
			type : 'POST',
			cache : false,
			data : formData,
			dataType : "json",
			processData : false,
			contentType : false
		}).done(function(res) {
			console.log(res);
			if (res.status == "1") {
				$("#headpic").attr("value",res.fpath);
				$("#pic").attr("src", "images/" + res.fpath);
			}
		});
	}
</script>
</head>
<body class="childrenBody">
	<form action="UserServlet.do" role="form" method="post"
		class="layui-form">
		<input name="id" id="id" type=hidden value="${loginUser_id }">
		<div class="user_left">
			<div class="layui-form-item">
				<label class="layui-form-label">用户名</label>
				<div class="layui-input-block">
					<input name="uname" id="uname" type="text"
						value="${loginUser_name }" disabled
						class="layui-input layui-disabled">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">真实姓名</label>
				<div class="layui-input-block">
					<input name="realname" id="realname" type="text"
						value="${loginUser }" placeholder="请输入真实姓名" lay-verify="required"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item" pane="">
				<label class="layui-form-label">性别</label>
				<div class="layui-input-block">
					<input name="gender" id="gender" type="radio" name="sex" value="男"
						title="男" <c:if test="${loginUser_sex eq '男' }">checked</c:if>>
					<input name="gender" id="gender" type="radio" name="sex" value="女"
						title="女" <c:if test="${loginUser_sex eq '女' }">checked</c:if>>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">手机号码</label>
				<div class="layui-input-block">
					<input name="phonenumber" id="phonenumber" type="tel"
						value="${loginPhonenumber }" placeholder="请输入手机号码"
						lay-verify="required|phone" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">出生年月</label>
				<div class="layui-input-block">
					<input name="born" id="born" type="text" value="${loginUser_born }"
						placeholder="请输入出生年月" lay-verify="required|date"
						onclick="layui.laydate({elem: this,max: laydate.now()})"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">家庭住址</label>
				<div class="layui-input-inline">
					<select name="province" lay-filter="province">
						<option name="city" id="city" value="${loginUser_address }">请选择市</option>
					</select>
				</div>
				<div class="layui-input-inline">
					<select name="area" id="area" lay-filter="city">
						<option value="area">请选择县</option>
					</select>
				</div>
				<!-- <div class="layui-input-inline">
					<select name="area" id="area" lay-filter="area" disabled>
						<option value="">请选择县/区</option>
					</select>
				</div> -->
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">兴趣爱好</label>
				<div class="layui-input-block">
					<input id="hobby" type="checkbox" name="like1" title="运动"
						value="运动" >
					<input id="hobby" type="checkbox" name="like1" title="旅游"
						value="旅游" >
					<input id="hobby" type="checkbox" name="like1" title="阅读"
						value="阅读" >
					<input id="hobby" type="checkbox" name="like1" title="玩游戏"
						value="玩游戏" >			
					<input id="hobby" type="checkbox" name="like1" title="听音乐"
						value="听音乐" >
					<input id="hobby" type="checkbox" name="like1" title="饮食"
						value="饮食" >
					<input id="hobby" type="checkbox" name="like1" title="影视"
						value="影视" >
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">邮箱</label>
				<div class="layui-input-block">
					<input name="email" id="email" type="text"
						value="${loginUser_email }" placeholder="请输入邮箱"
						lay-verify="required|email" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">自我评价</label>
				<div class="layui-input-block">
					<textarea name="selfassessment" id="selfassessment"
						value="${loginSelfassessment }" placeholder="请输入内容"
						class="layui-textarea">${loginSelfassessment }</textarea>
				</div>
			</div>
		</div>

		<div class="user_right">
			<input type="file" id="file" name="file" >
			<button type="button" onclick="uploadFunction()">上传</button>
			<img id="pic" src="images/${loginHeadpic }" width="100" height="100">
			<input name="headpic" id="headpic" type=hidden value="${loginHeadpic }">
		</div>

		<div class="layui-form-item" style="margin-left: 5%;">
			<div class="layui-input-block">
				<button onclick="userinfo()" type="button" class="layui-btn">提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript" src="js/address.js"></script>
	<script type="text/javascript" src="js/user.js"></script>
</body>
</html>