package com.ct5106.bookstore.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ct5106.bookstore.domain.Review;
import com.ct5106.bookstore.domain.ReviewRepository;

@RestController
public class ReviewController {
	
	private final ReviewRepository repository;
	
	public ReviewController(ReviewRepository repository)
	{
		this.repository	= repository;
	}
	
	@GetMapping(value = "/reviews")
	public Iterable<Review> getReviews()
	{
		return repository.findAll();
	}
}