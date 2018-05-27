package com.sda.spring.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    @ManyToOne(cascade = CascadeType.MERGE)
    private BookCategory bookCategory;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(joinColumns =
    @JoinColumn(name = "book_id"),
            inverseJoinColumns =
            @JoinColumn(name = "author_id"))
    private Set<BookAuthor> bookAuthors;

    @ManyToOne
    private Publisher publisher;


    public Book(String title, BookCategory bookCategory, Set<BookAuthor> bookAuthors) {
        this.title = title;
        this.bookCategory = bookCategory;
        this.bookAuthors = bookAuthors;
    }

    public Book () {}

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }

    public Set<BookAuthor> getBookAuthors() {
        return bookAuthors;
    }

    public void setBookAuthors(Set<BookAuthor> bookAuthors) {
        this.bookAuthors = bookAuthors;
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

}
