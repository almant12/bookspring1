package com.example.bookspring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;


@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "author")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Author {

    @Id
    @Column(name = "author_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    @Column(name = "author_first_name", nullable = false)
    @NotNull
    private String firstName;

    @Column(name = "author_last_name", nullable = false)
    @NotNull
    private String lastName;

    @Column(name = "author_birthday", nullable = false)
    @NotNull
    @Type(type = "date")
    private Date birthday;

    @Column(name = "author_img_link", nullable = false)
    @NotNull
    @Type(type = "text")
    private String imgLink;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "author_book",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> books = new HashSet<>();

}
