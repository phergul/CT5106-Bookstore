package com.ct5106.bookstore.web;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/publishers/by-name")
    public Publisher getPublisherByName(@Param("name") String name) {
        return repository.findDistinctByName(name);
    }

    @GetMapping("/publishers/by-address")
    public List<Publisher> getPublishersByAddress(@RequestParam String address) {
        return repository.findByAddress(address);
    }
	
	@GetMapping(value = "/publishers")
	public Iterable<Publisher> getPublishers()
	{
		return repository.findAll();
	}

}