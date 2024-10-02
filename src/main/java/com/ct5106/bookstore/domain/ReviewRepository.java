package com.ct5106.bookstore.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ReviewRepository  extends CrudRepository<Review, Long>
{

}
