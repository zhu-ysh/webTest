package com.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet2
 */
@WebServlet("/LoginServlet3")
public class LoginServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取所有参数名的枚举器
		Enumeration<String> names = request.getParameterNames();
		
		while(names.hasMoreElements()){
			String parameterName = names.nextElement();
			if("hobby".equals(parameterName)){
				String hobby[] = request.getParameterValues(parameterName);
				for (String string : hobby) {
					System.out.println(string);
				}
			}else if("myCar".equals(parameterName)){
				String myCar[] = request.getParameterValues(parameterName);
				for (String string : myCar) {
					System.out.println(string);
				}
			}else {
				System.out.println(request.getParameter(parameterName));
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
