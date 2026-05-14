package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDao;
import com.dao.BookDaoImpl;
import com.entity.Book;


@WebServlet("/reabBook")
public class ReabBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao;
    
    public ReabBookServlet() {
       
    }
    
    @Override
    public void init() throws ServletException {
    	bookDao=new BookDaoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		List<Book> bookList=bookDao.getAllBooks();		
		request.setAttribute("bookList", bookList);
		
		request.getRequestDispatcher("readBook.jsp").forward(request, response);
		
	}

}
