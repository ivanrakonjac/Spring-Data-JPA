package com.course.jpa.springdatajpa.controller;

import com.course.jpa.springdatajpa.domain.Author;
import com.course.jpa.springdatajpa.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @Operation(summary = "This method return all authors")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "SUCCESS"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND")
    })
    @GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Author>> getAllAuthors(){
        return ResponseEntity.ok(authorService.findAll());
    }

    @Operation(summary = "This method fetch all authors with specified firstName and lastName")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "SUCCESS"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND")
    })
    @GetMapping(value = "/findByName/{firstName}/{lastName}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Author>> findByFirstNameAndAndLastName(
            @Parameter(required = true, name = "firstName") @PathVariable(value = "firstName") String firstName,
            @Parameter(required = true, name = "lastName") @PathVariable(value = "lastName") String lastName){
        return ResponseEntity.ok(authorService.findByFirstNameAndAndLastName(firstName, lastName));
    }

    @PostMapping(value = "/findByName", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Author>> findByFirstNameAndAndLastName(@RequestBody @Valid Author author){
        return ResponseEntity.ok(authorService.findByFirstNameAndAndLastName(author.getFirstName(), author.getLastName()));
    }

}
