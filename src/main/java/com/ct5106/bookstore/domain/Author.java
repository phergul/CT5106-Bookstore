package com.ct5106.bookstore.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;

@Entity
public class Author {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long authorId;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column
	private LocalDate dob;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
	private List<Book> authoredBooks;
	
	public Author()
	{
		super();
	}

	public Author(String firstName, String lastName, LocalDate dob) 
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public List<Book> getAuthoredBooks() {
		return authoredBooks;
	}

	public void setAuthoredBooks(List<Book> authoredBooks) {
		this.authoredBooks = authoredBooks;
	}
}
