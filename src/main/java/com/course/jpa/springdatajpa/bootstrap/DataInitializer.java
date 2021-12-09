package com.course.jpa.springdatajpa.bootstrap;

import com.course.jpa.springdatajpa.domain.Book;
import com.course.jpa.springdatajpa.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Book bookDDD = new Book("Domain Driven Desing", "123", "RandomHouse", null);
        Book savedDDD = bookRepository.save(bookDDD);
        System.out.println(savedDDD);

        Book bookSIA = new Book("Spring In Action", "456", "Oriely", null);
        Book savedSIA = bookRepository.save(bookSIA);
        System.out.println(savedSIA);

        bookRepository.findAll().forEach( book -> {
            System.out.println(book);
        });
    }
}
