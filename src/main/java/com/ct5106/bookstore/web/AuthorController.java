package com.ct5106.bookstore.web;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ct5106.bookstore.domain.Author;
import com.ct5106.bookstore.domain.AuthorRepository;

@RestController
public class AuthorController {
	
	private final AuthorRepository repository;
	
	public AuthorController(AuthorRepository repository)
	{
		this.repository	= repository;
	}
	
	@GetMapping("/findDistinct")
    public List<Author> findDistinctByLastname(@Param("lastName") String lastName) {
        return repository.findDistinctByLastName(lastName);
    }

    @GetMapping("/findByFullname")
    public List<Author> findByFullname(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return repository.findByFullname(firstName, lastName);
    }
	
	@GetMapping(value = "/authors")
	public Iterable<Author> getAuthors()
	{
		return repository.findAll();
	}
}