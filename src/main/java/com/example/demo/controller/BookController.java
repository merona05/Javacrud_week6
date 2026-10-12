package com.example.demo.controller;

import com.example.demo.domain.Book;
import com.example.demo.dto.BookRequest;
import com.example.demo.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String list(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books/list";
    }

    @GetMapping("/books/new")
    public String form(Model model){
        model.addAttribute("bookRequest", new BookRequest());
        return "books/form";
    }

    @GetMapping("/books/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Book book = bookService.findByid(id);

        BookRequest request = new BookRequest();
        request.setTitle(book.getTitle());
        request.setAuthor(book.getAuthor());
        request.setPrice(book.getPrice());
        request.setCategory(book.getCategory());
        request.setIsbn(book.getIsbn());

        model.addAttribute("bookRequest", request);
        model.addAttribute("id", id);

        return "books/edit";
    }

    @PostMapping("/books/{id}/edit")
    public String update(
            @PathVariable Long id,
            @ModelAttribute BookRequest request) {

        bookService.update(id, request);
        return "redirect:/books";
    }

    @PostMapping("/books")
    public String create(@ModelAttribute BookRequest request) {
        bookService.create(request);
        return "redirect:/books";
    }
    @PostMapping("/books/{id}/delete")
    public String delete(@PathVariable Long id) {
        bookService.delete(id);
        return "redirect:/books";
    }
}

