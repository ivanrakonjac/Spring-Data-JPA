package com.course.jpa.springdatajpa.repository;

import com.course.jpa.springdatajpa.domain.composite.AuthorEmbedded;
import com.course.jpa.springdatajpa.domain.composite.NameId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorEmbeddedRepository extends JpaRepository<AuthorEmbedded, NameId> {
}