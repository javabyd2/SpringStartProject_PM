package com.sda.spring.demo.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class BookAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastname;
    @ManyToMany(mappedBy = "bookAuthors")
    private Set<Book> books;

    public BookAuthor(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public BookAuthor() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
