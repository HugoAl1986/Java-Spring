package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	

	
}
