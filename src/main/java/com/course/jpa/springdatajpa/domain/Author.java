package com.course.jpa.springdatajpa.domain;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.*;

import javax.persistence.*;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="author")
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

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY, cascade = {
//            CascadeType.DETACH,
//            CascadeType.MERGE,
//            CascadeType.REFRESH,
            CascadeType.ALL
    })
    @Singular
    private final Set<Book> books = new HashSet<>();

}
