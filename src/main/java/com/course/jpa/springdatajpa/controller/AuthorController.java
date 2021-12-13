package com.course.jpa.springdatajpa.controller;

import com.course.jpa.springdatajpa.domain.Author;
import com.course.jpa.springdatajpa.service.AuthorService;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Author>> getAllAuthors(){
        return ResponseEntity.ok(authorService.findAll());
    }

    @GetMapping(value = "/findByName/{firstName}/{lastName}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Author>> findByFirstNameAndAndLastName(
            @PathVariable(value = "firstName") String firstName,
            @PathVariable(value = "lastName") String lastName){
        return ResponseEntity.ok(authorService.findByFirstNameAndAndLastName(firstName, lastName));
    }

    @PostMapping(value = "/findByName", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Author>> findByFirstNameAndAndLastName(@RequestBody Author author){
        return ResponseEntity.ok(authorService.findByFirstNameAndAndLastName(author.getFirstName(), author.getLastName()));
    }

}
