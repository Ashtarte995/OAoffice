<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户总数--layui后台管理模板</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="layui/css/layui.css" media="all" />
<link rel="stylesheet" href="css/font_eolqem241z66flxr.css" media="all" />
<link rel="stylesheet" href="css/user.css" media="all" />
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript">
	       function addUser(){
	    	   location.href='userinsert.jsp';
	       }
	       function deleteUser(id){
	    	   //alert(id);
	    	   if(confirm("确定要删除吗")){
	    		   location.href='UserServlet.do?oper=delete&id='+id;  
	    	   }
	       }
	       function updateUser(id){
	    	   alert(id);
	    	   location.href='UserServlet.do?powercode=user_update&oper=t_update&id='+id;
	    	   //location.href='studentupdate.jsp';
	    	   
	       }
	       function searchAjax(){
	    	    alert(123);
	    	    var searchKey=$("#searchKey").val();
	    	    alert(searchKey);
				$.ajax({
					type:"post",
					data:{"searchKey":searchKey,"oper":"searchAjax"},
					url:"UserServlet.do",
					dataType:"json",
					async:true,
					success:function(data){
						//列表展示
						var ulist=data.list;
						var msg=data.msg;
						//拼接HTML
						var cont="";
						for(var i=0;i<ulist.length;i++){
							var s=ulist[i];
							
							cont+="<tr>";
							cont+="<td>";
							cont+=s.user_id ;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.user_name;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.user_realname;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.user_pwd;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.user_sex;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.phonenumber;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.user_born;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.user_address;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.user_email;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.headpic;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.dept_id;
							cont+="</td>";
							
							cont+="<td>";
							cont+="<button onclick=\"updateUser(${s.user_id })\"  class=\"layui-btn layui-btn-xs\">修改</button>";
							cont+="<button onclick=\"deleteUser(${s.user_id })\" class=\"layui-btn layui-btn-danger layui-btn-xs\">删除</button>";
							cont+="</td>";
							cont+="</tr>";
						}
						$("#ulist").html(cont);
						
					}
				});
			} 
</script>
</head>
<body class="childrenBody">
	<blockquote class="layui-elem-quote news_search">
		<div class="layui-inline">
			<div class="layui-input-inline">
				<input id="searchKey" name="searchKey"
					class="layui-input search_input" type="text" />
			   <!--  <input type="text" id="searchKey" name="searchKey" value=""
					placeholder="请输入关键字" class="layui-input search_input"> -->
			</div>
			<a onclick="searchAjax()" class="layui-btn search_btn">查询</a>
		</div>
		<div class="layui-inline">
			<a onclick="addUser()"
				class="layui-btn layui-btn-normal usersAdd_btn">添加用户</a>
		</div>
	</blockquote>
	<div class="layui-form news_list">
		<table class="layui-table">
			<thead>
				<tr>
					<th>id</th>
					<th>用户名</th>
					<th>真实姓名</th>
					<th>密码</th>
					<th>性别</th>
					<th>电话号码</th>
					<th>出生日期</th>
					<th>地址</th>
					<th>邮箱</th>
					<th>头像</th>
					<th>部门id</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id=ulist class="users_content">
				<c:forEach items="${ulist }" var="s">
					<tr>
						<td>${s.user_id }</td>
						<td>${s.user_name }</td>
						<td>${s.user_realname }</td>
						<td>${s.user_pwd }</td>
						<td>${s.user_sex }</td>
						<td>${s.phonenumber }</td>
						<td>${s.user_born }</td>
						<td>${s.user_address }</td>
						<td>${s.user_email }</td>
						<td>${s.headpic }</td>
						<td>${s.dept_id }</td>
						<td>
							<button onclick="updateUser(${s.user_id })"
								class="layui-btn layui-btn-xs">修改</button>
							<button onclick="deleteUser(${s.user_id })"
								class="layui-btn layui-btn-danger layui-btn-xs">删除</button>
                         </td>
                     </tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
	<div id="page"></div>
	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript" src="js/allUsers.js"></script>
</body>
</html>