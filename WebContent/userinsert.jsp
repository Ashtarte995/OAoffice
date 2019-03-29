<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script type="text/javascript">
   function checkUname(){
	    var uname = $("#uname").val();
		//采用Ajax方式进行访问服务器
		$.ajax({
			type : "get",
			data : {
				"uname" : uname,
				"oper" : "checkAjax"
			},
			url : "UserServlet.do",
			dataType:"json",
			async : true,
			success : function(data) {
				var flag=data.isCheck;
				if (flag=="1") {
				    $("#msg").html("用户已经存在,不能添加");
				} else {
					$("#msg").html("用户不存在,可以添加");
				}
			}
		});
   }

</script>
</head>
<body class="childrenBody">
	<form action="UserServlet.do" role="form" method="post"
		class="layui-form">
		<input type=hidden name="oper" value="add" />
		<div class="user_left">
			<div class="layui-form-item">
				<label class="layui-form-label">用户名</label>
				<div class="layui-input-block">
					<input onblur="checkUname()" name="uname" id="uname" type="text" value=""
						placeholder="请输入用户名" lay-verify="required" class="layui-input">
				<div id=msg></div>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">真实姓名</label>
				<div class="layui-input-block">
					<input name="realname" id="realname" type="text" value=""
						placeholder="请输入真实姓名" lay-verify="required" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">密码</label>
				<div class="layui-input-block">
					<input name="pwd" id="pwd" type="text" value="" placeholder="请输入密码"
						lay-verify="required" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item" pane="">
				<label class="layui-form-label">性别</label>
				<div class="layui-input-block">
					<input name="gender" id="gender" type="radio" name="sex" value="男"
						title="男" checked=""> <input name="gender" id="gender"
						type="radio" name="sex" value="女" title="女">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">手机号码</label>
				<div class="layui-input-block">
					<input name="phonenumber" id="phonenumber" type="tel" value=""
						placeholder="请输入手机号码" lay-verify="required|phone"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">出生年月</label>
				<div class="layui-input-block">
					<input name="born" id="born" type="text" value=""
						placeholder="请输入出生年月" lay-verify="required|date"
						onclick="layui.laydate({elem: this,max: laydate.now()})"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">家庭住址</label>
				<div class="layui-input-inline">
					<select name="province" lay-filter="province">
						<option name="city" id="city" value="">请选择省</option>
					</select>
				</div>
				<div class="layui-input-inline">
					<select name="city" id="city" lay-filter="city" disabled>
						<option value="">请选择市</option>
					</select>
				</div>
				<div class="layui-input-inline">
					<select name="area" id="area" lay-filter="area" disabled>
						<option value="">请选择县/区</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">邮箱</label>
				<div class="layui-input-block">
					<input name="email" id="email" type="text" value=""
						placeholder="请输入邮箱" lay-verify="required|email"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">部门id</label>
				<div class="layui-input-block">
					<input name="dept_id" id="dept_id" type="text" value=""
						placeholder="请输入部门id" lay-verify="required" class="layui-input">
				</div>
			</div>
		</div>
		<!-- <div class="user_right">
			<input name="headpic" id="headpic" type="file" name="dddd"
				class="layui-upload-file" lay-title="换个头像"> <img src=""
				class="layui-circle" id="userFace">
		</div> -->

		<div class="layui-form-item" style="margin-left: 5%;">
			<div class="layui-input-block">
				<button type="submit" class="layui-btn">提交</button>
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