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


@WebServlet("/addMovie")
public class AddMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieDao movieDao;
    
    public AddMovieServlet() {
        }
    @Override
    public void init() throws ServletException {
    	movieDao=new MovieDaoImpl();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String name=request.getParameter("name");
		String genre=request.getParameter("genre");
		double budget=Double.parseDouble(request.getParameter("budget"));
		double earning=Double.parseDouble(request.getParameter("earning"));
		
		Movie movie=new Movie(name,genre,budget,earning);
		movieDao.addMovie(movie);
		
		request.getRequestDispatcher("/readMovie").include(request, response);


		}

}
