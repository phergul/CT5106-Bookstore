package com.ct5106.bookstore.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource
public interface BookRepository extends CrudRepository<Book, String>
{
	Book findDistinctByTitle(@Param("title") String title);
	
	@Query("SELECT b FROM Book b WHERE b.publisher.name = :publisherName")
    List<Book> findBooksByPublisher(@Param("publisherName") String publisherName);
}
