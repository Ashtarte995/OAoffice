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
	       function addMeeting(){
	    	   location.href='meetinginsert.jsp';
	       }
	       function deleteMeeting(id){
	    	   //alert(id);
	    	   if(confirm("确定要删除吗")){
	    		   location.href='MeetingServlet.do?oper=delete&id='+id;  
	    	   }
	       }
	       function updateMeeting(id){
	    	   location.href='MeetingServlet.do?oper=t_update&id='+id;
	    	   //location.href='meetingupdate.jsp';
	    	   
	       }
	       function searchAjax(){
	    	    var searchKey=$("#searchKey").val();
				$.ajax({
					type:"post",
					data:{"searchKey":searchKey,"oper":"searchAjax"},
					url:"MeetingServlet.do",
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
							cont+=s.meeting_id ;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.meeting_title;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.meeting_date;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.meeting_start;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.meeting_end;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.meeting_status;
							cont+="</td>";
							
							cont+="<td>";
							cont+=s.meetingroom_name;
							cont+="</td>";
							
							cont+="<td>";
							cont+="<button onclick=\"updateMeeting(${s.meeting_id })\"  class=\"layui-btn layui-btn-xs\">修改</button>";
							cont+="<button onclick=\"deleteMeeting(${s.meeting_id })\" class=\"layui-btn layui-btn-danger layui-btn-xs\">删除</button>";
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
			<a onclick="addMeeting()"
				class="layui-btn layui-btn-normal usersAdd_btn">添加会议</a>
		</div>
	</blockquote>
	<div class="layui-form news_list">
		<table class="layui-table">
			<thead>
				<tr>
					<th>会议ID</th>
					<th>会议主题</th>
					<th>创建日期</th>
					<th>开始时间</th>
					<th>结束时间</th>
					<th>会议状态</th>
					<th>会议室</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id=ulist class="users_content">
				<c:forEach items="${ulist }" var="s">
					<tr>
						<td>${s.meeting_id }</td>
						<td>${s.meeting_title }</td>
						<td>${s.meeting_date }</td>
						<td>${s.meeting_start }</td>
						<td>${s.meeting_end }</td>
						<td>${s.meeting_status }</td>
						<td>${s.meetingroom_name }</td>
						<td>
							<button onclick="updateMeeting(${s.meeting_id })"
								class="layui-btn layui-btn-xs">修改</button>
							<button onclick="deleteMeeting(${s.meeting_id })"
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