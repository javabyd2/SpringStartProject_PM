package com.sda.spring.demo.service;

import com.sda.spring.demo.model.BookAuthor;
import com.sda.spring.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<BookAuthor> getAuthors(){
        return authorRepository.findAll();
    }

    public Optional<BookAuthor> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }
}
