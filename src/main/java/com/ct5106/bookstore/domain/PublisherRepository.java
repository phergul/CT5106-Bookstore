package com.ct5106.bookstore.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PublisherRepository  extends CrudRepository<Publisher, Long>
{
	Publisher findDistinctByName(@Param("name") String name);
	
	@Query("SELECT p FROM Publisher p WHERE p.address = :address")
    List<Publisher> findByAddress(@Param("address") String address);
}
