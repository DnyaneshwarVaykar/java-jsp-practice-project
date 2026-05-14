package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDao;
import com.dao.BookDaoImpl;
import com.entity.Book;

@WebServlet("/updateBook")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao;
   
    public UpdateBookServlet() {
    }
    @Override
    public void init() throws ServletException {
    	bookDao=new BookDaoImpl();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String title=request.getParameter("title");
		String author=request.getParameter("author");
		double price=Double.parseDouble(request.getParameter("price"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		int id=Integer.parseInt(request.getParameter("id"));
		
		Book book=new Book(title, author, price, quantity);
		book.setId(id);
		bookDao.updateBook(book);
		response.sendRedirect(request.getContextPath() + "/reabBook");
		
	}

}
