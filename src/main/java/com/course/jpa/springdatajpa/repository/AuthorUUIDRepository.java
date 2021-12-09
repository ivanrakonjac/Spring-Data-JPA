package com.course.jpa.springdatajpa.repository;

import com.course.jpa.springdatajpa.domain.Author;
import com.course.jpa.springdatajpa.domain.AuthorUUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorUUIDRepository extends JpaRepository<AuthorUUID, UUID> {
}
