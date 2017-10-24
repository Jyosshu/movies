package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	private List<Movie> movieList = new ArrayList<>();
	
	public void addMovieToCart(Movie newMovie) {
		movieList.add(newMovie);
		
	}
	
	public void removeMovieFromCart(Movie newMovie) {
		movieList.remove(newMovie);
	}
	
	public void clear(){
		movieList.clear();
	}
	
	public List<Movie> getAllMovies() {
		return new ArrayList<Movie>(movieList);
	}
}
