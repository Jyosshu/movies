package com.techelevator.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.DAO.MovieDAO;
import com.techelevator.model.Movie;
import com.techelevator.model.ShoppingCart;


@Controller
public class MovieController {

	@Autowired
	MovieDAO movieDao;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showHomePage(ModelMap modelHolder) {
		List<Movie> movieList = movieDao.getAllMovies();
		
		modelHolder.put("movies", movieList);
		return "index";
	}
	
	@RequestMapping(path="/movieDetail/{id}", method=RequestMethod.GET)
	public String showMovieDetail(@PathVariable Long id, ModelMap modelHolder) {
		Movie newMovie = movieDao.getMovieById(id);
		modelHolder.put("movie", newMovie);
		return "movieDetail";
	}
	
	@RequestMapping(path="/addMovieToCart", method=RequestMethod.POST)
	public String checkOutMovie(@RequestParam Long id, HttpSession session) {
		
		if(session.getAttribute("ShoppingCart") == null){
			session.setAttribute("ShoppingCart", new ShoppingCart());
		}
		
		ShoppingCart sc = (ShoppingCart) session.getAttribute("ShoppingCart");
		Movie newMovie = movieDao.getMovieById(id);
		sc.addMovieToCart(newMovie);
		
		return "redirect:/view";
	}
	
	@RequestMapping(path="/view", method=RequestMethod.GET)
	public String showShoppingCart(HttpSession session, ModelMap modelHolder) {
		Map<Long, Movie> movieMap = new HashMap<>();
		ShoppingCart sc = (ShoppingCart) session.getAttribute("ShoppingCart");
		if (sc != null) {
			List<Movie> shoppingCartList = sc.getAllMovies();
			for (Movie entry : shoppingCartList) {
				movieMap.put(entry.getId(), entry);
			}
		}
		modelHolder.put("movieList", movieMap);
		return "cartView";
	}
}
