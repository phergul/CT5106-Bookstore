package com.ct5106.bookstore.web;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ct5106.bookstore.domain.Book;
import com.ct5106.bookstore.domain.Review;
import com.ct5106.bookstore.domain.ReviewRepository;

@RestController
public class ReviewController {
	
	private final ReviewRepository repository;
	
	public ReviewController(ReviewRepository repository)
	{
		this.repository	= repository;
	}
	
	@GetMapping("/reviews/by-rating-and-date")
	public List<Review> getReviewByRatingAndDate(@Param("rating")float rating, @Param("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate reviewDate) {
        return repository.findDistinctByRatingAndReviewDate(rating, reviewDate);
    }
	
	@GetMapping("/reviews/by-rating-greater-than")
	public List<Review> getReviewsByRating(@Param("rating") float rating) {
        return repository.findReviewsWithRatingGreaterThan(rating);
    }
	
	@GetMapping(value = "/reviews")
	public Iterable<Review> getReviews()
	{
		return repository.findAll();
	}
}