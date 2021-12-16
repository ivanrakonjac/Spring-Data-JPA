package com.course.jpa.springdatajpa.service;

import com.course.jpa.springdatajpa.domain.Author;
import com.course.jpa.springdatajpa.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<Author> findByFirstNameAndAndLastName(String firstName, String lastName){
        return authorRepository.findByFirstNameAndAndLastName(firstName, lastName);
    }

    public List<Author> findAll(){
        return authorRepository.findAll();
    }

    public void delete(Long id){
        authorRepository.deleteById(id);
    }
}
