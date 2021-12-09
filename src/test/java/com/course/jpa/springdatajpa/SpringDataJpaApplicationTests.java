package com.course.jpa.springdatajpa;

import com.course.jpa.springdatajpa.domain.Author;
import com.course.jpa.springdatajpa.domain.AuthorUUID;
import com.course.jpa.springdatajpa.domain.Book;
import com.course.jpa.springdatajpa.repository.AuthorRepository;
import com.course.jpa.springdatajpa.repository.AuthorUUIDRepository;
import com.course.jpa.springdatajpa.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.Assert;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringDataJpaApplicationTests {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private AuthorUUIDRepository authorUUIDRepository;


	@Rollback
	@Test
	@Transactional
	void booksTest() {

		Book bookDDD = new Book("Domain Driven Design", "123", "RandomHouse", 1L);
		Book savedDDD = bookRepository.save(bookDDD);
		System.out.println(savedDDD);

		Book bookSIA = new Book("Spring In Action", "456", "Oriely", 2L);
		Book savedSIA = bookRepository.save(bookSIA);
		System.out.println(savedSIA);

		Assertions.assertEquals(2, bookRepository.count());

	}

	@Test
	@Rollback
	@Transactional
	void authorsTest() {

		Author author1 = new Author("Carls", "Bukovski");
		Author savedAuthor1 = authorRepository.save(author1);
		System.out.println(author1);

		Author author2 = new Author("Ivo", "Andric");
		Author savedAuthor2 = authorRepository.save(author2);
		System.out.println(author2);

		Assertions.assertEquals(10, authorRepository.count());

	}

	@Test
	void authorsUUIDTest() {

		AuthorUUID authorUUID1 = new AuthorUUID("Pisac1Ime", "Pisac1Prezime");
		System.out.println(authorUUIDRepository.save(authorUUID1));

		AuthorUUID authorUUID2 = new AuthorUUID("Pisac2Prezime", "Pisac2Prezime");
		System.out.println(authorUUIDRepository.save(authorUUID2));

		Assertions.assertEquals(10, authorUUIDRepository.count());
	}
}
