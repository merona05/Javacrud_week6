package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.dto.BookRequest;
import com.example.demo.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book findByid(Long id){
        return bookRepository.findByid(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("해당 도서를 찾을 수 없습니다. ID: " + id));
    }
    public Book create(BookRequest request){
        Book book = new Book(
                null,
                request.getTitle(),
                request.getAuthor(),
                request.getPrice(),
                request.getCategory(),
                request.getIsbn()
        );

        return bookRepository.save(book);
    }

    public Book update(Long id, BookRequest request) {
        Book book = findByid(id);

        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setPrice(request.getPrice());
        book.setCategory(request.getCategory());
        book.setIsbn(request.getIsbn());

        return book;
    }

    public void delete(Long id){
        bookRepository.deleteByid(id);
    }
}
