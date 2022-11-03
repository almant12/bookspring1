package com.example.bookspring.service;

import com.example.bookspring.entity.Author;

import java.util.List;

public interface AuthorService {

    void addAuthor(Author author);
    List<Author> getallAuthors();
    Author getAuthorById(Long id);
    void deleteAuthorById(Long id);
}
