package com.ct5106.bookstore.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestResource
public interface AuthorRepository  extends CrudRepository<Author, Long>
{
	List<Author> findDistinctByLastName(@Param("lastName") String lastName);
	
	@Query("SELECT a FROM Author a WHERE a.firstName = :firstname AND a.lastName = :lastname")
    List<Author> findByFullname(@Param("firstname") String firstname, @Param("lastname") String lastname);
}
