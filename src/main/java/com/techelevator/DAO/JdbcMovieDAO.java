package com.techelevator.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Movie;

@Component
public class JdbcMovieDAO implements MovieDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcMovieDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Movie> getAllMovies() {
		List<Movie> allMovies = new ArrayList<>();
		String sqlSelectAllMovies = "SELECT * FROM movies";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllMovies);
		while(results.next()) {
			allMovies.add(mapRowToMovie(results));
		}
		return allMovies;
	}

	public Movie getMovieById(Long id) {
		Movie newMovie = null;
		String sqlSelectMovieById = "SELECT * FROM movies WHERE id=?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectMovieById, id);
		if(result.next()) {
			newMovie = mapRowToMovie(result);
		}
		
		return newMovie;
	}
	
	@Override
	public void checkOut(Movie newMovie) {
		String sqlUpdateCheckOutMovie = "UPDATE movies SET available_copies=? WHERE id=?";
		jdbcTemplate.update(sqlUpdateCheckOutMovie, (newMovie.getAvailableCopies() - 1), newMovie.getId());
		//this method is not finished.  Decrement availableCopies from id that was passed. 
	}

	@Override
	public void checkIn(Movie newMovie) {
		String sqlUpdateCheckOutMovie = "UPDATE movies SET available_copies=? WHERE id=?";
		jdbcTemplate.update(sqlUpdateCheckOutMovie, (newMovie.getAvailableCopies() + 1), newMovie.getId());
		//this method is not finished.  Decrement availableCopies from id that was passed. 
		
	}
	
	private Movie mapRowToMovie(SqlRowSet row) {
		Movie newMovie = new Movie();
		newMovie.setId(row.getLong("id"));
		newMovie.setTitle(row.getString("title"));
		newMovie.setNumOfCopies(row.getInt("num_of_copies"));
		newMovie.setAvailableCopies(row.getInt("available_copies"));
		newMovie.setReleaseDate(row.getTimestamp("release_date").toLocalDateTime());	
		
		return newMovie;
	}
}
