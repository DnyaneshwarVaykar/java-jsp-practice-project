package com.dao;

import java.util.List;

import com.entity.Movie;

public interface MovieDao {

	void addMovie(Movie book);

	void updateMovie(Movie book);

	void deleteMovie(Movie book);

	void deleteMovieById(int id);

	Movie getMovieById(int id);

	List<Movie> getAllMovie();

}