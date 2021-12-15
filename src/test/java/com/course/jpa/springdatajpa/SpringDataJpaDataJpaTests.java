package com.course.jpa.springdatajpa;

import com.course.jpa.springdatajpa.domain.Author;
import com.course.jpa.springdatajpa.domain.Book;
import com.course.jpa.springdatajpa.repository.AuthorRepository;
import com.course.jpa.springdatajpa.repository.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
public class SpringDataJpaDataJpaTests{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Commit
    @Order(1)
    @Test
    void testJpaTestSplice() {

//        long countBefore = bookRepository.count();
//        assertThat(countBefore).isEqualTo(0);
//
//        bookRepository.save( new Book("My new Book", "123","Laguna", null));
//
//        long countAfter = bookRepository.count();
//
//        assertThat(countBefore).isLessThan(countAfter);

    }

    @Order(2)
    @Test
    void testJpaTestSpliceTransaction() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(1);
    }

    @Test
    @Order(3)
    void authorsTest() {

        Author author1 = Author.builder().firstName("Carls").lastName("Bukovski").born(1920).died(1994).build();
        authorRepository.save(author1);
        System.out.println(author1);

        Author author2 = Author.builder().firstName("Ivo").lastName("Andric").born(1892).died(1975).build();
        authorRepository.save(author2);
        System.out.println(author2);

        assertThat(authorRepository.count() == 2);

    }

}

/*
Fora je sto je svaka test metoda zasebna transakcija nad bazom i ona se rollbackuje nakon zavrsetka testa.
Takodje, kada se koristi @DataJpaTest, ne dovlaci se ceo kontekst aplikacije, kao kod normalnih testova,
nego samo komponenti koje su injectovane.

@Commit radi Rollback=false
 */