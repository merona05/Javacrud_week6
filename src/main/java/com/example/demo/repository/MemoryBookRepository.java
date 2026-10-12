package com.example.demo.repository;

import com.example.demo.domain.Book;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoryBookRepository implements BookRepository {

    private final Map<Long, Book> store = new HashMap<>();
    private Long nextId = 1L;

    @Override
    public Book save(Book book) {
        book.setId(nextId++);
        store.put(book.getId(), book);
        return book;
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Book> findByid(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public void deleteByid(Long id) {
        store.remove(id);
    }
}
