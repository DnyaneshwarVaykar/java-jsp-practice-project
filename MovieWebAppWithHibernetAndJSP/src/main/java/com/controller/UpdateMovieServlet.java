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


@WebServlet("/updateMovie")
public class UpdateMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieDao movieDao;
    
    public UpdateMovieServlet() {
      }
    
    @Override
    public void init() throws ServletException {
    	movieDao=new MovieDaoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String genre=request.getParameter("gener");
		double budget=Double.parseDouble(request.getParameter("budget"));
		double earning=Double.parseDouble(request.getParameter("earning"));
		
		
		Movie movie=new Movie(name,genre,budget,earning);
		movie.setId(id);
		
		
		movieDao.updateMovie(movie);
		response.sendRedirect(request.getContextPath()+"/readMovie");

		
	}

}
