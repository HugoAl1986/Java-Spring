package com.example.api.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.api.model.Movie;

@Controller
@RequestMapping("catalog")
public class MovieController {
	
	@GetMapping("/home")
	public String getMovies(Model model) {
		
		Movie movie = new Movie();
		movie.setTitle("Transformers");
		movie.setDuration(120);
		movie.setDescription("Film d'action");
		
		Movie movie2 = new Movie();
		movie2.setTitle("Indiana Jones");
		movie2.setDuration(140);
		movie2.setDescription("Film d'aventure");
		
		Movie movie3 = new Movie();
		movie3.setTitle("Le diner de Con");
		movie3.setDuration(110);
		movie3.setDescription("Comédie");
		
		List<Movie> movies = new ArrayList<>();
		movies.add(movie);
		movies.add(movie2);
		movies.add(movie3);
		model.addAttribute("movieList", movies);
		
		return "home";
	}

}
