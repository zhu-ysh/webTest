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
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		String bookName = request.getParameter("bookName");
		String bookAuthor = request.getParameter("bookAuthor");
		BookManager bookManager = new BookManager(bookName,bookAuthor);
		BookManagerService bms = new BookManagerServiceImpl();
		PrintWriter out = response.getWriter();
		if(bms.save(bookManager)) {
			JSONObject jsonObj = JSONObject.fromObject(bookManager);
			out.write(jsonObj.toString());
		}else {
			out.write("error");
		}
		out.flush();
	}

}
