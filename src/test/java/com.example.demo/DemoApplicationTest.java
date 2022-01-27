package com.example.demo;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DemoApplicationTest {

    @Autowired
    BookRepository bookRepo;

    @Test
    @Order(1)
    public void testCreate () {
        Book book = new Book();
        book.setBook_name("bookTest");
        book.setAuthor_name("authorTest");
        book.setIsbn("1111");
        bookRepo.save(book);
        assertNotNull(bookRepo.findById(1L).get());
    }

    @Test
    @Order(2)
    public void testReadAll () {
        List list = bookRepo.findAll();
        assertThat(list).size().isGreaterThan(0);
    }

    @Test
    @Order(3)
    public void testRead () {
        Book book = bookRepo.findById(1L).get();
        assertEquals("bookTest", book.getBook_name());
    }

    @Test
    @Order(4)
    public void testUpdate () {
        Book p = bookRepo.findById(1L).get();
        p.setBook_name("bookUpdate");
        bookRepo.save(p);
        assertNotEquals("bookTest", bookRepo.findById(1L).get().getBook_name());
    }

    @Test
    @Order(5)
    public void testDelete () {
        bookRepo.deleteById(1L);
        assertThat(bookRepo.existsById(1L)).isFalse();
    }
}
