package com.course.jpa.springdatajpa.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="Author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "born")
    private int born;

    @Column(name = "died")
    private int died;

    public Author() {
    }

    public Author(String firstName, String lastName, int born, int died) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.born = born;
        this.died = died;
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

    public int getBorn() {
        return born;
    }

    public void setBorn(int born) {
        this.born = born;
    }

    public int getDied() {
        return died;
    }

    public void setDied(int died) {
        this.died = died;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (born != author.born) return false;
        if (died != author.died) return false;
        if (!Objects.equals(id, author.id)) return false;
        if (!Objects.equals(firstName, author.firstName)) return false;
        return Objects.equals(lastName, author.lastName);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + born;
        result = 31 * result + died;
        return result;
    }
}
