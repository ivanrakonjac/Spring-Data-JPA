package com.course.jpa.springdatajpa.domain.composite;

import javax.persistence.*;

@Entity
@Table(name="author_composite")
@IdClass(NameId.class)
public class AuthorComposite {

    @Column(name = "first_name")
    @Id
    private String firstName;

    @Column(name = "last_name")
    @Id
    private String lastName;

    public AuthorComposite() {
    }

    public AuthorComposite(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
