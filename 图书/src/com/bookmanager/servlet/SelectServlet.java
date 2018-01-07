package com.bookmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmanager.entity.BookManager;
import com.bookmanager.service.BookManagerService;
import com.bookmanager.service.impl.BookManagerServiceImpl;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class SelectServlet
 */
@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		BookManagerService bms = new BookManagerServiceImpl();
		
		String page = request.getParameter("page");
		String per = request.getParameter("per");
			
		ArrayList<BookManager> arraybm = 
				bms.selectAll(Integer.parseInt(per),Integer.parseInt(page));
		if(null != arraybm && arraybm.size()>0) {
			JSONArray jarray = JSONArray.fromObject(arraybm);
			out.write(jarray.toString());
		}else {
			out.write("error");
		}
		out.flush();
	}

}
