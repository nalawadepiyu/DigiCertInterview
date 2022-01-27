package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "book_name")
    private String book_name;
    @Column(name = "author_name")
    private String author_name;
    @Column(name = "isbn")
    private String isbn;

    public Book()
    {

    }
    public Book(String book_name, String author_name, String isbn)
    {
        this.book_name=book_name;
        this.author_name=author_name;
        this.isbn=isbn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", book_name='" + book_name + '\'' +
                ", author_name='" + author_name + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
