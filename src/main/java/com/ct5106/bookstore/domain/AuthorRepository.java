package com.ct5106.bookstore.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AuthorRepository  extends CrudRepository<Author, Long>
{
	//Author findDistinctByFirstNameAndLastName(String firstName, String lastName);
}
