package com.course.jpa.springdatajpa;

import com.course.jpa.springdatajpa.domain.*;
import com.course.jpa.springdatajpa.domain.composite.AuthorComposite;
import com.course.jpa.springdatajpa.domain.composite.AuthorEmbedded;
import com.course.jpa.springdatajpa.domain.composite.NameId;
import com.course.jpa.springdatajpa.repository.*;
import com.course.jpa.springdatajpa.service.AuthorService;
import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

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

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private AuthorService authorService;

	@Autowired
	private UserRepository userRepository;

	@Test
	void authorsTest() {

		Author author1 = Author.builder().firstName("Carls").lastName("Bukovski").born(1920).died(1994).build();
		authorRepository.save(author1);
		System.out.println(author1);

		Author author2 = Author.builder().firstName("Ivo").lastName("Andric").born(1892).died(1975).build();
		authorRepository.save(author2);
		System.out.println(author2);

		Author author3 = Author.builder().firstName("Vladimir").lastName("Majakovski").born(1893).died(1930).build();
		authorRepository.save(author3);
		System.out.println(author3);

		Author author4 = Author.builder().firstName("Danilo").lastName("Kis").born(1935).died(1989).build();
		authorRepository.save(author4);
		System.out.println(author4);

		Author author5 = Author.builder().firstName("Borislav").lastName("Pekic").born(1930).died(1992).build();
		authorRepository.save(author5);
		System.out.println(author5);

		Assertions.assertEquals(5, authorRepository.count());

	}

	@Rollback(value = false)
	@Test
	@Transactional
	void booksTest() {

		List<Author> authorsList = authorRepository.findByFirstNameAndAndLastName("Ivo", "Andric");

		Book bookDDD = Book.builder()
				.title("Domain Driven Design")
				.isbn("456")
				.publisher("Oriley")
				.author(authorsList.get(0))
				.build();

		Book savedDDD = bookRepository.save(bookDDD);
		System.out.println(savedDDD);

		Book bookSIA = Book.builder()
				.title("Spring In Action")
				.isbn("456")
				.publisher("Oriley")
				.author(authorsList.get(0))
				.build();

		Book savedSIA = bookRepository.save(bookSIA);
		System.out.println(savedSIA);

		Assertions.assertEquals(2, bookRepository.count());

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

		NameId nameId = new NameId("Pisac", "Pisac");

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

	@Test
	void authorFindByFirstNameAndLastname() {
		List<Author> authorList = authorRepository.findByFirstNameAndAndLastName("Ivo", "Andric");
		Assertions.assertEquals(1, authorList.size());
	}

	@Test
	@Transactional
	void bookFetchTest() {
		List<Book> bookList = bookRepository.findAll();

		for (Book b: bookList) {
			System.out.println(b);
			for (Author a: b.getAuthors()) {
				System.out.println("\t" + a);
			}
		}

	}

	@Test
	void bookReviewOneToManyTest() {
		Optional<Book> book = bookRepository.findById(1L);

		if(book.isEmpty()) Assertions.assertEquals(true, false);

		Review review = Review.builder().text("Komentar za knjigu where ID==1").book(book.get()).build();

		reviewRepository.save(review);

		Assertions.assertEquals(1, reviewRepository.count());

	}

	@Test
	@Transactional
	void reviewFetchTest() {
		List<Review> reviewList = reviewRepository.findAll();

		for (Review r: reviewList) {
			System.out.println(r.getBook());
		}

	}

	@Test
//	@Transactional
//	@Rollback(value = false)
//	authorService je @Transactional
	void transactionalContextTest() {
		authorService.delete(5L);
	}

	@Test
	@Transactional
	@Rollback(value = false)
	void authorBookDeleteTest() {
		List<Book> bookList = bookRepository.findAll();
		Book book = bookList.get(0);
		bookRepository.delete(book);
	}

	@Test
	@Transactional
	@Rollback(value = false)
	void reviewUserOneToOneTest() {

		User user = User.builder()
				.username("username")
				.firstName("Ivan")
				.lastName("Rakonjac")
				.build();

		userRepository.save(user);

		Optional<Book> book = bookRepository.findById(1L);

		Review review = Review.builder()
								.text("Komentar za knjigu")
								.book(book.get())
								.user(user)
								.build();

		reviewRepository.save(review);

		Assertions.assertEquals(1, reviewRepository.count());

	}
}
