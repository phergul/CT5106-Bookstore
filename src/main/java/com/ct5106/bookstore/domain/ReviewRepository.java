package com.ct5106.bookstore.domain;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ReviewRepository  extends CrudRepository<Review, Long>
{
	 // Query method using keywords and property names
    List<Review> findDistinctByRatingAndReviewDate(float rating, LocalDate reviewDate);

    // Query method using JPQL and @Query annotation
    @Query("SELECT r FROM Review r WHERE r.rating > :rating")
    List<Review> findReviewsWithRatingGreaterThan(@Param("rating") float rating);
}
