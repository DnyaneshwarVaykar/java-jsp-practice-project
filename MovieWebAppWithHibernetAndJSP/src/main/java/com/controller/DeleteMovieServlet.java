package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MovieDao;
import com.dao.MovieDaoImpl;
import com.entity.Movie;

@WebServlet("/deleteMovie")
public class DeleteMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieDao movieDao;
   
    public DeleteMovieServlet() {
       
    }
    @Override
    public void init() throws ServletException {
    	movieDao=new MovieDaoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		Movie movie = new Movie();
		movie.setId(id);
		movieDao.deleteMovie(movie);
		
		request.getRequestDispatcher("/readMovie").include(request, response);

		
	}

}
