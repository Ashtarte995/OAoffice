<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改密码--layui后台管理模板</title>
<style type="text/css">
#card{
	height: 685px;
	width: 1110px;
	overflow: hidden;
	background: url(images/businesscard.jpg);
}
#realname{
	 font-size: 67px;
	 margin-left:560px;
	 margin-top:100px;
	 color: #EBBB6E;
}
#email{
	 font-size: 27px;
	 margin-left:560px;
	 margin-top:300px;
	 color: #EBBB6E;
}
#phone{
	 font-size: 27px;
	 margin-left:560px;
	 margin-top:1px;
	 color: #EBBB6E;
}
</style>
</head>

<body>
	<div>
		<!--  <img alt="" src="images/businesscard.jpg" style="margin: 0 auto">-->
	</div>
	<div id="card">
	<div id="realname">${loginUser}</div>
	<div id="email">${loginUser_email}</div>
	<div id="phone">${loginPhonenumber}</div>
	</div>

</body>
</html>