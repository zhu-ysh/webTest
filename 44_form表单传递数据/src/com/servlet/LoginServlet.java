package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取form表单使用name属性的传递来的值
		String username = request.getParameter("username");
//tomcat 7.0		username = new String(username.getBytes("iso-8859-1"), "utf-8");
		String userpsd = request.getParameter("userpsd");
//		userpsd = new String(userpsd.getBytes("iso-8859-1"), "utf-8");
		String gender = request.getParameter("gender");
//		gender = new String(gender.getBytes("iso-8859-1"), "utf-8");

		// 多选项目
		String hobby[] = request.getParameterValues("hobby");
		String myCar[] = request.getParameterValues("myCar");

		System.out.println("username:" + username + ",password:" + userpsd + ",gender:" + gender + ",hobby:");
		for (String string : hobby) {
			System.out.println(string + "\t");
		}
		for (String string : myCar) {
			System.out.println(string + "\t");
		}

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// if("root".equals(username) && "123".equals(userpsd)) {
		out.println(username + " 登录成功");
		// }else {
		// out.println("登录失败");
		// }
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置请求的编码格式
		request.setCharacterEncoding("utf-8");
		
		// 获取form表单使用name属性的传递来的值
		String username = request.getParameter("username");
		String userpsd = request.getParameter("userpsd");
		String gender = request.getParameter("gender");

		// 多选项目
		String hobby[] = request.getParameterValues("hobby");
		String myCar[] = request.getParameterValues("myCar");

		System.out.println("username:" + username + ",password:" + userpsd + ",gender:" + gender + ",hobby:");
		for (String string : hobby) {
			System.out.println(string + "\t");
		}
		for (String string : myCar) {
			System.out.println(string + "\t");
		}

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// if("root".equals(username) && "123".equals(userpsd)) {
		out.println(username + " 登录成功");
		// }else {
		// out.println("登录失败");
		// }
		out.flush();
	}

}
