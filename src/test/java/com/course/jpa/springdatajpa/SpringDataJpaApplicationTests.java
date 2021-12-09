package com.course.jpa.springdatajpa;

import com.course.jpa.springdatajpa.domain.Author;
import com.course.jpa.springdatajpa.domain.AuthorUUID;
import com.course.jpa.springdatajpa.domain.Book;
import com.course.jpa.springdatajpa.domain.composite.AuthorComposite;
import com.course.jpa.springdatajpa.domain.composite.AuthorEmbedded;
import com.course.jpa.springdatajpa.domain.composite.NameId;
import com.course.jpa.springdatajpa.repository.*;
import org.hibernate.LazyInitializationException;
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

	@Autowired
	private AuthorCompositeRepository authorCompositeRepository;

	@Autowired
	private AuthorEmbeddedRepository authorEmbeddedRepository;

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

	@Test
	void authorsCompositeTest() {

		NameId nameId = new NameId("Ivan", "Rakonjac");

		AuthorComposite authorComposite1 = new AuthorComposite();
		authorComposite1.setFirstName(nameId.getFirstName());
		authorComposite1.setLastName(nameId.getLastName());
		authorCompositeRepository.save(authorComposite1);

		AuthorComposite fetched = authorCompositeRepository.getById(nameId);

		Assertions.assertNotEquals(null, fetched);

		long countBefore = authorCompositeRepository.count();

		authorCompositeRepository.save(authorComposite1);

		long countAfter = authorCompositeRepository.count();

		Assertions.assertEquals(countAfter, countBefore);

	}

	@Test
	void authorsEmbeddedTest() {

		NameId nameId = new NameId("Dragan", "Markovic");

		AuthorEmbedded authorEmbedded = new AuthorEmbedded();
		authorEmbedded.setNameId(nameId);
		authorEmbeddedRepository.save(authorEmbedded);

		AuthorEmbedded fetched = authorEmbeddedRepository.getById(nameId);

		Assertions.assertNotEquals(null, fetched);

		long countBefore = authorEmbeddedRepository.count();

		authorEmbeddedRepository.save(fetched);

		long countAfter = authorEmbeddedRepository.count();

		Assertions.assertEquals(countAfter, countBefore);

	}


}
