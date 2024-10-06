package com.ct5106.bookstore.domain;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Book {
	@Id
	private String ISBN;
	
	@Column(nullable=false, length=512)
	private String title;
	
	//@Column(nullable=false)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author")
	private Author author;
	
	//@Column(nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner")
	private Publisher publisher;
	
	@Column(nullable = false)
	private float price;
	
	@Column(nullable = false)
	private int stock;
	
	@Column
	private float rating;
	
	@Column(nullable = false)
	private LocalDate releaseDate;
	
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;

	public Book()
	{
		super();
	}

	public Book(String iSBN, String title, Author author, Publisher publisher, float price, int stock,
			LocalDate releaseDate) {
		super();
		ISBN = iSBN;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.stock = stock;
		this.releaseDate = releaseDate;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
	
}
