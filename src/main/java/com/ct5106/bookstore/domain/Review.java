package com.ct5106.bookstore.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long reviewId;
	
	@Column(nullable = false)
	private float rating;
	
	@Column
	private String comment;
	
	@Column(nullable = false)
	private LocalDate reviewDate;
	
	public Review()
	{
		super();
	}

	public Review(float rating, String comment, LocalDate reviewDate) {
		super();
		this.rating = rating;
		this.comment = comment;
		this.reviewDate = reviewDate;
	}

	public Long getReviewId() {
		return reviewId;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDate getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(LocalDate reviewDate) {
		this.reviewDate = reviewDate;
	}
	
	
}
