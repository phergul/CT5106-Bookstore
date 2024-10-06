package com.ct5106.bookstore.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_isbn")
    private Book book;
	
	public Review()
	{
		super();
	}

	public Review(float rating, String comment, LocalDate reviewDate, Book book) {
		super();
		this.rating = rating;
		this.comment = comment;
		this.reviewDate = reviewDate;
		this.book = book;
	}
	
	public Book getBook(){
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
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
