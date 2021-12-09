package com.course.jpa.springdatajpa;

import com.course.jpa.springdatajpa.domain.Author;
import com.course.jpa.springdatajpa.domain.Book;
import com.course.jpa.springdatajpa.repository.AuthorRepository;
import com.course.jpa.springdatajpa.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.util.Assert;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringDataJpaApplicationTests {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorRepository authorRepository;

//	@Commit
	@Test
	void booksTest() {

		Book bookDDD = new Book("Domain Driven Design", "123", "RandomHouse", 1L);
		Book savedDDD = bookRepository.save(bookDDD);
		System.out.println(savedDDD);

		Book bookSIA = new Book("Spring In Action", "456", "Oriely", 2L);
		Book savedSIA = bookRepository.save(bookSIA);
		System.out.println(savedSIA);

		assertThat(bookRepository.count() == 2);

	}

	@Test
	void authorsTest() {

		Author author1 = new Author("Carls", "Bukovski");
		Author savedAuthor1 = authorRepository.save(author1);
		System.out.println(author1);

		Author author2 = new Author("Ivo", "Andric");
		Author savedAuthor2 = authorRepository.save(author2);
		System.out.println(author2);

		assertThat(authorRepository.count() == 2);

	}
}
