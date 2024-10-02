package com.ct5106.bookstore.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Publisher {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long publisherId;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String address;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "publisher")
	private List<Book> publshedBooks;
	
	public Publisher()
	{
		super();
	}

	public Publisher(String name, String address) {
		super();
		this.name = name;
		this.address = address;
		//this.publshedBooks = publshedBooks;
	}

	public Long getPublisherId() {
		return publisherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Book> getPublshedBooks() {
		return publshedBooks;
	}

	public void setPublshedBooks(List<Book> publshedBooks) {
		this.publshedBooks = publshedBooks;
	}
	
	
}
