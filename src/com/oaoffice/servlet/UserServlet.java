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
import javax.servlet.http.HttpSession;

import com.oaoffice.service.PowerService;
import com.oaoffice.service.impl.PowerServiceImpl;
import com.google.gson.Gson;
import com.oaoffice.bean.Power;
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
	PowerService powerService = new PowerServiceImpl();

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
				List<User> ulist = userService.list();
				request.setAttribute("ulist", ulist);
				request.getRequestDispatcher("userlist.jsp").forward(request, response);
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
				// String id = request.getParameter("id");
				String uname = request.getParameter("uname");
				String realname = request.getParameter("realname");
				String gender = request.getParameter("gender");
				String phonenumber = request.getParameter("phonenumber");
				Date born = Datetransform.parse(request.getParameter("born"), "yyyy-MM-dd");
				String city = request.getParameter("city");
				String hobby = request.getParameter("hobby");
				String email = request.getParameter("email");
				String selfassessment = request.getParameter("selfassessment");
				System.out.println(selfassessment + "22222");
				String headpic = request.getParameter("headpic");
				User user = userService.loadByNo(uname);
				user.setUser_realname(realname);
				user.setUser_sex(gender);
				user.setPhonenumber(phonenumber);
				user.setUser_born(born);
				user.setUser_address(city);
				user.setUser_hobby(hobby);
				user.setUser_email(email);
				user.setSelfassessment(selfassessment);
				user.setHeadpic(headpic);
				userService.update(user);
				out.println("{\"status\":\"1\"}");
			} else if (oper.equals("t_userinfo")) {
				request.getRequestDispatcher("userInfo.jsp").forward(request, response);
			} else if (oper.equals("searchAjax")) {
				System.out.println("qqqqq");
				String searchkey = request.getParameter("searchKey");
				if (searchkey != null && !searchkey.equals("")) {
					List<User> list = userService.listByName(searchkey);
					Gson gson = new Gson();
					Map<String, Object> map = new HashMap<>();
					map.put("list", list);
					map.put("msg", "success");
					String json = gson.toJson(map);
					out.print(json);
				} else {
					List<User> ulist = userService.list();
					request.setAttribute("ulist", ulist);
					request.getRequestDispatcher("userlist.jsp").forward(request, response);
				}
			} else if (oper.equals("loginAjax")) {
				String logname = request.getParameter("logname");
				String logpass = request.getParameter("logpass");
				User bean = userService.loadByNo(logname);
				// System.out.println(bean.getUser_id() + "qweasdzxc");
				if (bean != null) {
					boolean flag = bean.getUser_name().equals(logname) && bean.getUser_pwd().equals(logpass);
					if (flag) {
						// 把请求域范围扩大到会话范围session
						// 获取session对象
						HttpSession session = request.getSession();
						session.setAttribute("loginUser", bean.getUser_realname());
						session.setAttribute("loginUser_name", bean.getUser_name());
						session.setAttribute("loginUser_id", bean.getUser_id());
						session.setAttribute("loginUser_pwd", bean.getUser_pwd());
						session.setAttribute("loginUser_sex", bean.getUser_sex());
						session.setAttribute("loginPhonenumber", bean.getPhonenumber());
						session.setAttribute("loginUser_born", bean.getUser_born());
						session.setAttribute("loginUser_address", bean.getUser_address());
						session.setAttribute("loginUser_hobby", bean.getUser_hobby());
						session.setAttribute("loginUser_email", bean.getUser_email());
						session.setAttribute("loginSelfassessment", bean.getSelfassessment());
						session.setAttribute("loginHeadpic", bean.getHeadpic());

						System.out.println("loginSelfassessment="+bean.getUser_id());
						System.out.println("loginSelfassessment="+bean.getSelfassessment());

						List<Power> allpowerlist = powerService.list();
						session.setAttribute("allpowerlist", allpowerlist);

						// 获取权限信息
						List<Power> powerlist = powerService.getPower(logname);
						System.out.println("Role_id=" + powerlist.get(0).getRole_id());
						session.setAttribute("role_id", powerlist.get(0).getRole_id());
						session.setAttribute("powerlist", powerlist);
						out.println("{\"status\":\"1\"}");
					} else {
						out.print("{\"status\":\"0\",\"msg\":\"login fail\"}");
					}
				}
			} else if (oper.equals("logout")) {
				HttpSession session = request.getSession();
				session.removeAttribute("loginUser");
				session.removeAttribute("loginUser_name");
				session.removeAttribute("loginUser_id");
				session.removeAttribute("powerlist");
				session.invalidate();
				response.sendRedirect("login.jsp");
			} else if (oper.equals("changePwdAjax")) {
				String id = request.getParameter("id");
				String name = request.getParameter("name");
				System.out.println("bbbb" + id);
				String pwd = request.getParameter("pwd");
				User user = userService.loadByNo(name);
				user.setUser_pwd(pwd);
				userService.update(user);
				out.println("{\"status\":\"1\"}");
			} else if (oper.equals("loginout")) {
				HttpSession session = request.getSession();
				session.removeAttribute("loginUser_name");
				session.removeAttribute("loginUser_pwd");
				session.invalidate();
				response.sendRedirect("login.jsp");
			}
		} else {
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
