package com.example.bookspring.entity;

import com.example.bookspring.enums.BookGenre;
import com.example.bookspring.enums.BookLanguage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "book")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Book {

    @Id
    @Column(name = "book_id")
    private String ISBN;

    @Column(name = "book_title", nullable = false)
    private String bookTitle;

    @Column(name = "book_description", nullable = false)
    private String bookDescription;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "book_genre", nullable = false)
    private BookGenre bookGenre;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "book_language", nullable = false)
    private BookLanguage bookLanguage;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "books")
    private Set<Author> authors = new HashSet<>() ;
}
