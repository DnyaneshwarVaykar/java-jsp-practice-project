package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MovieDao;
import com.dao.MovieDaoImpl;
import com.entity.Movie;

@WebServlet("/readMovie")
public class ReadMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieDao movieDao;

	public ReadMovieServlet() {
	}

	@Override
	public void init() throws ServletException {
		movieDao = new MovieDaoImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Movie> list = movieDao.getAllMovie();

		request.setAttribute("list", list);

		request.getRequestDispatcher("readMovie.jsp").include(request, response);

	}

}
