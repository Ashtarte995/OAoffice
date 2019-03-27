<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改密码--layui后台管理模板</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="layui/css/layui.css" media="all" />
<link rel="stylesheet" href="css/user.css" media="all" />
<style type="text/css">
#sss {
	background: url("images/bg1.png") no-repeat -104px -75px;
}
</style>
</head>
<body class="childrenBody">
	<form class="layui-form changePwd" id="sss" style="width:380px;background-color:red">
		<div class="layui-form-item">
			<label class="layui-form-label"></label>
			<!-- <div class="layui-input-block">
		    	<input type="text" value="" class="layui-input layui-disabled">
		    </div> -->
		    <div class="layui-input-block">
				<input type="text" value="xxxxxx有限公司"
					style="border: 0px; font-size: 35px; font-weight: bloder;"
					placeholder="请输入" lay-verify="required|oldPwd"
					class="layui-input pwd">
			</div>
			<div class="layui-input-block">
				<input type="text" value="王五       主管"
					style="border: 0px; font-size: 30px; font-weight: bloder;"
					placeholder="请输入" lay-verify="required|oldPwd"
					class="layui-input pwd">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label"
				style="font-size: 20px; font-weight: bloder;">电话:</label>
			<div class="layui-input-block">
				<input type="text" value="" style="border: 0px; font-size: 20px"
					placeholder="13727882722" lay-verify="required|oldPwd"
					class="layui-input pwd">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label" style="font-size: 20px; font-weight: bloder;">邮箱:</label>
			<div class="layui-input-block">
				<input type="text" value="18415153@163.com" style="border: 0px;font-size: 20px"
					placeholder="" lay-verify="required|newPwd" id="oldPwd"
					class="layui-input pwd">
			</div>
		</div>
		<div class="layui-form-item" style="font-size: 20px; font-weight: bloder;">
			<label class="layui-form-label">地址:</label>
			<div class="layui-input-block">
				<input type="text" value="XXXXXXXXX" style="border: 0px;font-size: 20px"
					placeholder="" lay-verify="required|confirmPwd"
					class="layui-input pwd">
			</div>
		</div>
		<!-- <div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="changePwd">立即修改</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div> -->
	</form>
	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript" src="js/address.js"></script>
	<script type="text/javascript" src="js/user.js"></script>
</body>
</html>