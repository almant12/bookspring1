package com.example.bookspring.repository;

import com.example.bookspring.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,String> {

    @Query(value = "FROM book as b WHERE b.book_id in (SELECT ab.book_id FROM author_book as ab WHERE ab.author_id = :author_id )", nativeQuery = true)
    List<Book> getBooksByAuthorId(@Param("author_id") Long id);
}
