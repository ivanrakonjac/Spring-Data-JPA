package com.course.jpa.springdatajpa;

import com.course.jpa.springdatajpa.domain.Book;
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
    BookRepository bookRepository;

    @Commit
    @Order(1)
    @Test
    void testJpaTestSplice() {

        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(0);

        bookRepository.save( new Book("My new Book", "123","Laguna"));

        long countAfter = bookRepository.count();

        assertThat(countBefore).isLessThan(countAfter);

    }

    @Order(2)
    @Test
    void testJpaTestSpliceTransaction() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(1);
    }

}

/*
Fora je sto je svaka test metoda zasebna transakcija nad bazom i ona se rollbackuje nakon zavrsetka testa.
Takodje, kada se koristi @DataJpaTest, ne dovlaci se ceo kontekst aplikacije, kao kod normalnih testova,
nego samo komponenti koje su injectovane.

@Commit radi Rollback=false
 */