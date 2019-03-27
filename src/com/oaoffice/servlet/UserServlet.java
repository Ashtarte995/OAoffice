package com.oaoffice.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.oaoffice.bean.User;
import com.oaoffice.service.UserService;
import com.oaoffice.service.impl.UserServiceImpl;
import com.oaoffice.util.Datetransform;

public class UserServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// *******防止乱码
		// 输入数据乱码解决方案：使用request对象获取浏览器提交数据前，先设置字符集
		response.setCharacterEncoding("utf-8");

		// 输出数据乱码解决方案：使用request输出数据前，先设置字符集和内容类型
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		// response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		String oper = request.getParameter("oper");
		PrintWriter out = response.getWriter();
        System.out.println("aaaa");
		if (oper != null) {
			if (oper.equals("add")) {
				// 获取表单数据
				String uname = request.getParameter("uname");
				String realname = request.getParameter("realname");
				String pwd = request.getParameter("pwd");
				String gender = request.getParameter("gender");
				String phonenumber = request.getParameter("phonenumber");
				Date born = Datetransform.parse(request.getParameter("born"), "yyyy-MM-dd");
				String city = request.getParameter("city");
				String email = request.getParameter("email");
				String headpic = request.getParameter("headpic");
				int dept_id = Integer.parseInt(request.getParameter("dept_id"));
				User user = new User(uname, realname, pwd, gender, phonenumber, born, city, email, headpic, dept_id);
				userService.insert(user);
			} else if (oper.equals("delete")) {
				String id = request.getParameter("id");
				System.out.println(id);
				userService.delete(Integer.parseInt(id));
			} else if (oper.equals("t_update")) {
				String id = request.getParameter("id");
				System.out.println(id);
				User user = userService.load(Integer.parseInt(id));
				request.setAttribute("user", user);
				request.getRequestDispatcher("userupdate.jsp").forward(request, response);

			} else if (oper.equals("updateAjax")) {
				String id = request.getParameter("id");
				String uname = request.getParameter("uname");
				String realname = request.getParameter("realname");
				String pwd = request.getParameter("pwd");
				String gender = request.getParameter("gender");
				String phonenumber = request.getParameter("phonenumber");
				Date born = Datetransform.parse(request.getParameter("born"), "yyyy-MM-dd");
				String city = request.getParameter("city");
				String email = request.getParameter("email");
				String headpic = request.getParameter("headpic");
				int dept_id = Integer.parseInt(request.getParameter("dept_id"));
				User user = new User(uname, realname, pwd, gender, phonenumber, born, city, email, headpic, dept_id);
				user.setUser_id(Integer.parseInt(id));
				userService.update(user);
				out.println("{\"status\":\"1\"}");
			} else if (oper.equals("userinfo")) {
				String id = request.getParameter("id");
				String uname = request.getParameter("uname");
				String realname = request.getParameter("realname");
				String gender = request.getParameter("gender");
				String phonenumber = request.getParameter("phonenumber");
				Date born = Datetransform.parse(request.getParameter("born"), "yyyy-MM-dd");
				String city = request.getParameter("city");
				String hobby = request.getParameter("hobby");
				String email = request.getParameter("email");
				String selfassessment = request.getParameter("selfassessment");		
				String headpic = request.getParameter("headpic");
				User user = new User(uname, realname, gender, phonenumber, born, city,hobby ,email,selfassessment ,headpic);
				user.setUser_id(Integer.parseInt(id));
				userService.update(user);
				out.println("{\"status\":\"1\"}");
			}else if (oper.equals("searchAjax")) {
				 System.out.println("qqqqq");
				String searchkey = request.getParameter("searchKey");
				if (searchkey != null && !searchkey.equals("")) {
					List<User> list = userService.listByName(searchkey);
					Gson gson = new Gson();
					Map<String, Object> map = new HashMap<>();
					map.put("list", list);
					map.put("msg", "success");
					String json = gson.toJson(map);
					//System.out.println(json);
					out.print(json);
				}else {
					List<User> ulist = userService.list();
					request.setAttribute("ulist", ulist);
					request.getRequestDispatcher("userlist.jsp").forward(request, response);
				}
			} 
		}else {
			List<User> ulist = userService.list();
			request.setAttribute("ulist", ulist);
			request.getRequestDispatcher("userlist.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
