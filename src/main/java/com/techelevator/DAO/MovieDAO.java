package com.techelevator.DAO;

import java.util.List;

import com.techelevator.model.Movie;

public interface MovieDAO {
	public List<Movie> getAllMovies();
	public Movie getMovieById(Long id);
	public void checkOut(Movie newMovie);
	public void checkIn(Movie newMovie);
}
