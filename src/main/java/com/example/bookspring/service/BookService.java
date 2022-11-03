package com.example.bookspring.service;

import com.example.bookspring.entity.Book;

import java.util.List;

public interface BookService {

    void addBook(Book book);

    List<Book> allBooks();

    void deleteBookById(String ISBN);

    Book getBookById(String ISBN);

    List<Book> getBookByAuthorId(Long id);

}
