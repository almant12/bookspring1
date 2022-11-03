package com.example.bookspring.service.implementation;

import com.example.bookspring.entity.Book;
import com.example.bookspring.repository.BookRepository;
import com.example.bookspring.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteBookById(String ISBN) {
        bookRepository.deleteById(ISBN);
    }

    @Override
    public Book getBookById(String ISBN) {
        return bookRepository.getById(ISBN);
    }

    @Override
    public List<Book> getBookByAuthorId(Long id) {
        return bookRepository.getBooksByAuthorId(id);
    }


}
