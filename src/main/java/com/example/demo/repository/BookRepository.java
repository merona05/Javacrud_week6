package com.example.demo.repository;
import com.example.demo.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Book save(Book book);
    List<Book> findAll();
    Optional<Book> findByid(Long id);
    void deleteByid(Long id);
}
