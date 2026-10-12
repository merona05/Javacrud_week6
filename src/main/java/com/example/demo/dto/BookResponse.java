package com.example.demo.dto;

public class BookResponse {
    private Long id;
    private String title;
    private String author;
    private int price;
    private String category;
    private String isbn;

    public BookResponse(String isbn, String category, int price, String author, String title, Long id) {
        this.isbn = isbn;
        this.category = category;
        this.price = price;
        this.author = author;
        this.title = title;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
