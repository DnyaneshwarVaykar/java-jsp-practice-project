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

@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao;
   
    public DeleteBookServlet() {
    }
    @Override
    public void init() throws ServletException {
    	bookDao=new BookDaoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		Book book=new Book();
		book.setId(id);
		bookDao.deleteBook(book);
		response.sendRedirect(request.getContextPath() + "/reabBook");
		
	
		
	}

}
