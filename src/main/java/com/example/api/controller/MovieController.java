
package com.example.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.api.model.Movie;
import com.example.api.repository.MovieRepository;
import com.example.api.service.CreateMovieService;
import com.example.api.service.MovieService;


@Controller
@RequestMapping("catalog")
public class MovieController {
	
	@Autowired
    private CreateMovieService createmovieService;
	
	@Autowired
    private MovieService movieService;

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/movies")
    public String getMovies(Model model) {
    	
		List<Movie> movies = movieService.getMovies();
    	model.addAttribute("movies", movies);

        return "movies";
    }

    @GetMapping("/movie")
    public String formMovie() {
    	return "movie";
    }
    
    @PostMapping("/movie")
    public String saveMovie(@RequestParam String title, @RequestParam Integer duration, @RequestParam String description) {
        createmovieService.saveMovie(title, duration, description);
        return "redirect:movies";
    }
    @PostMapping("/movieUpdateDB")
    public String updateMovieDB(@RequestParam Long id, @RequestParam String title, @RequestParam Integer duration, @RequestParam String description) {
        movieService.updateMovie(id, description, title, duration);
        return "redirect:movies";
    }
    @PostMapping("/movieDeleteDB")
    public String deleteMovieDB(@RequestParam Long id) {
        movieService.deleteByid(id);
        return "redirect:movies";
    }
	
    @DeleteMapping("/About/{id}")
    public String deleteById(@PathVariable Long id) {
    	movieService.deleteByid(id);

        return "redirect:movies";
    }
}
