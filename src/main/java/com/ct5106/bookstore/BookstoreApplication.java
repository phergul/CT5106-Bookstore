package com.ct5106.bookstore;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ct5106.bookstore.domain.Author;
import com.ct5106.bookstore.domain.AuthorRepository;
import com.ct5106.bookstore.domain.Book;
import com.ct5106.bookstore.domain.BookRepository;
import com.ct5106.bookstore.domain.Publisher;
import com.ct5106.bookstore.domain.PublisherRepository;
//import com.ct5106.bookstore.domain.Review;
import com.ct5106.bookstore.domain.ReviewRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	private final BookRepository brepository;
	private final AuthorRepository arepository;
	private final PublisherRepository prepository;
	//private final ReviewRepository rrepository;

	private static final Logger logger = LoggerFactory.getLogger(BookstoreApplication.class);

	public BookstoreApplication(BookRepository brepository, AuthorRepository arepository,
			PublisherRepository prepository, ReviewRepository rrepository) // inject a working instance of the
																			// repository class
	{
		this.brepository = brepository;
		this.arepository = arepository;
		this.prepository = prepository;
		//this.rrepository = rrepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);

		logger.info("Bookstore Application Started");
	}

	@Override
	public void run(String... args) throws Exception {
		Author author1 = new Author("Joanne", "Rowling", LocalDate.of(1965, 7, 31));
		Author author2 = new Author("Roald", "Dahl", LocalDate.of(1916, 9, 13));
		arepository.save(author1);
		arepository.save(author2);

		Publisher pub1 = new Publisher("Bloomsbury", "London, England");
		Publisher pub2 = new Publisher("George Allen & Unwin", "Crows Nest, New South Wales, Australia");
		prepository.save(pub1);
		prepository.save(pub2);

		/*
		 * Review r1 = new Review(4.5f, "Great Book", LocalDate.of(2024, 2, 20));
		 * rrepository.save(r1);
		 */

		brepository.save(new Book("978-0-7475-3269-9", "Harry Potter and the Philosopher's Stone", author1, pub1, 7.99f,
				100, LocalDate.of(1997, 6, 26)));
		brepository.save(new Book("978-0-1424-0108-8", "Charlie and the Chocolate Factory", author2, pub2, 6.99f, 200,
				LocalDate.of(1964, 1, 17)));

		for (Book book : brepository.findAll())
		{
			logger.info("Created book: -name- "+ book.getTitle());
		}
	}
}
