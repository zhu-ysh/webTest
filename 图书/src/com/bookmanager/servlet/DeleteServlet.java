package com.bookmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmanager.entity.BookManager;
import com.bookmanager.service.BookManagerService;
import com.bookmanager.service.impl.BookManagerServiceImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class DelectServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
		
		String bookId = request.getParameter("bookId");
		System.out.println(bookId);
		BookManager bookManager = new BookManager(Integer.parseInt(bookId));
		if(bms.delete(bookManager)) {
			JSONObject jsonObj = JSONObject.fromObject(bookManager);
			out.write(jsonObj.toString());
		}else {
			out.write("error");
		}
		out.flush();
	
	}

}
