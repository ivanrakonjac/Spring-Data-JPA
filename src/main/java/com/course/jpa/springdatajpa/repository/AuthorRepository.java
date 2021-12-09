package com.course.jpa.springdatajpa.repository;

import com.course.jpa.springdatajpa.domain.Author;
import com.course.jpa.springdatajpa.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
