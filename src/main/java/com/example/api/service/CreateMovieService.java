package com.example.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.model.Movie;
import com.example.api.repository.MovieRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CreateMovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	public Boolean saveMovie(String title, Integer duration, String description) {
		Movie movie = new Movie();
		movie.setDescription(description);
		movie.setTitle(title);
		movie.setDuration(duration);
		try {
			movieRepository.save(movie);
			return true;
		}catch(Exception e){
			log.error(e.getLocalizedMessage());
			return false;
		}
		
	}
}
