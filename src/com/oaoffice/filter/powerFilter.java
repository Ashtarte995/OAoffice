package com.oaoffice.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oaoffice.bean.Power;

public class powerFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// 获取想要获取的权限
		String powercode = req.getParameter("powercode");

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		List<Power> list = (List<Power>) request.getSession().getAttribute("powerlist");
		System.out.println("vvvvv" + powercode);
		System.out.println("xxxxx" + list);

		String uri = request.getRequestURI();
		System.out.println("uri=" + uri);
		if (list != null) {
			if (uri.contains("UserServlet.do")) {
				if (!isUser(list)) {
					if (isLogout(powercode, list)) {
						chain.doFilter(req, resp);
						return;
					} else {
						request.setAttribute("message", "对不起你没有权限！");
						request.getRequestDispatcher("/message.jsp").forward(request, response);
						return;
					}
				} else {
					chain.doFilter(req, resp);
				}

			} else if (uri.contains("VacateServlet.do")&&powercode != null) {
				if (!isApproval(powercode, list)) {
					request.setAttribute("message", "对不起你没有权限！");
					request.getRequestDispatcher("/message.jsp").forward(request, response);
					return;

				} else {
					chain.doFilter(req, resp);
				}
			}else if (uri.contains("MeetingapplyServlet.do")&&powercode != null) {
				if (!isApproval(powercode, list)) {
					request.setAttribute("message", "对不起你没有权限！");
					request.getRequestDispatcher("/message.jsp").forward(request, response);
					return;

				} else {
					chain.doFilter(req, resp);
				}
			} else if (uri.contains("BulletinServlet.do")&&powercode != null) {
				if (!isApproval(powercode, list)) {
					request.setAttribute("message", "对不起你没有权限！");
					request.getRequestDispatcher("/message.jsp").forward(request, response);
					return;

				} else {
					chain.doFilter(req, resp);
				}
			}else {

				// if (list != null && powercode != null) {
				// if (!isPower(powercode, list)) {
				// request.setAttribute("message", "对不起你没有权限！");
				// request.getRequestDispatcher("/message.jsp").forward(request, response);
				// return;
				// } else {
				// chain.doFilter(req, resp);
				// }
				// }

				chain.doFilter(req, resp);

			}
		} else {
			chain.doFilter(req, resp);
		}
	}

	public boolean isUser(List<Power> list) {
		boolean flag = false;
		for (Power power : list) {
			if (power.getKey().equals("user")) {
				// 有用户管理权限
				flag = true;
				break;
			}
		}
		return flag;
	}

	public boolean isLogout(String powercode, List<Power> list) {
		boolean flag = false;
		for (Power power : list) {
			if (power.getKey().equals(powercode)) {
				// 有权限
				flag = true;
				break;
			}
		}
		return flag;
	}

	public boolean isApproval(String powercode, List<Power> list) {
		boolean flag = false;
		for (Power power : list) {
			if (power.getKey().equals(powercode)) {
				// 有权限
				flag = true;
				break;
			}
		}
		return flag;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
