package com.course.jpa.springdatajpa;

import com.course.jpa.springdatajpa.domain.Book;
import com.course.jpa.springdatajpa.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class SpringDataJpaApplicationTests {

	@Autowired
	private BookRepository bookRepository;

	@Test
	void contextLoads() {

		Book bookDDD = new Book("Domain Driven Design", "123", "RandomHouse");
		Book savedDDD = bookRepository.save(bookDDD);
		System.out.println(savedDDD);

		Book bookSIA = new Book("Spring In Action", "456", "Oriely");
		Book savedSIA = bookRepository.save(bookSIA);
		System.out.println(savedSIA);

		Assert.isTrue(bookRepository.findAll().size() == 2, "Neka knjiga se nija dodala!");

	}

}
