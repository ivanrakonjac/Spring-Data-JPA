package com.course.jpa.springdatajpa.repository;

import com.course.jpa.springdatajpa.domain.User;
import com.course.jpa.springdatajpa.domain.composite.AuthorComposite;
import com.course.jpa.springdatajpa.domain.composite.NameId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}