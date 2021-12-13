package com.course.jpa.springdatajpa.repository;

import com.course.jpa.springdatajpa.domain.Author;
import com.course.jpa.springdatajpa.domain.composite.AuthorComposite;
import com.course.jpa.springdatajpa.domain.composite.NameId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorCompositeRepository extends JpaRepository<AuthorComposite, NameId>{
}
