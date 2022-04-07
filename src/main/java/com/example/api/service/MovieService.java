package com.example.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.api.model.Movie;
import com.example.api.repository.MovieRepository;


@Service
public class MovieService {
	
	
	@Autowired
	private MovieRepository movieRepository;
	
	public List<Movie> getMovies() {
		return movieRepository.findAll();
	}
	public void updateMovie(Long id, String description, String title, Integer duration) {
		
		Movie movieDB = new Movie();
		movieDB = movieRepository.getById(id);
		movieDB.setTitle(title);
		movieDB.setDuration(duration);
		movieDB.setDescription(description);
		movieRepository.save(movieDB);
		
		
	}
	
	public void deleteByid(long id) {
		movieRepository.deleteById(id);
	}

}
