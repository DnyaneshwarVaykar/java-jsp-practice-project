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


@WebServlet("/updateMovieFormServLet")
public class UpdateMovieFormServLet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieDao movieDao;
   
    public UpdateMovieFormServLet() {
        
    }
    
    @Override
    public void init() throws ServletException {
    	movieDao = new MovieDaoImpl(); 
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		Movie movie=movieDao.getMovieById(id);
		
		request.setAttribute("movie", movie);
		
		request.getRequestDispatcher("updateMovie.jsp").include(request, response);
		}

}
