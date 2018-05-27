package com.sda.spring.demo.repository;

import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.model.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository
        extends JpaRepository<BookAuthor, Long> {
}