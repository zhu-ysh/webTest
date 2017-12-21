package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.Io;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String[]> map = request.getParameterMap();
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("username:"+map.get("username")[0]);
		arr.add("password:"+map.get("psd")[0]);
		arr.add("phone:"+map.get("phone")[0]);
		arr.add("email:"+map.get("email")[0]);
		arr.add("idCard:"+map.get("idCard")[0]);
		arr.add("text:"+map.get("text")[0]);
		arr.add("gender:"+map.get("gender")[0]);
		Io io = new Io();
		 if(io.MyWrite(arr)) {
			 System.out.println("写入文件成功");
		 }else {
			 System.out.println("写入文件失败");
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
