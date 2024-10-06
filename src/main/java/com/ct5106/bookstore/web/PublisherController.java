package com.ct5106.bookstore.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ct5106.bookstore.domain.Publisher;
import com.ct5106.bookstore.domain.PublisherRepository;

@RestController
public class PublisherController {
	
	private final PublisherRepository repository;
	
	public PublisherController(PublisherRepository repository)
	{
		this.repository	= repository;
	}
	
	@GetMapping(value = "/publishers")
	public Iterable<Publisher> getPublishers()
	{
		return repository.findAll();
	}
}