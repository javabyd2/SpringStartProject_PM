package com.sda.spring.demo.controller;

import com.sda.spring.demo.dto.UserPropDTO;
import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.model.BookAuthor;
import com.sda.spring.demo.model.BookCategory;
import com.sda.spring.demo.service.AuthorService;
import com.sda.spring.demo.service.BookService;
import com.sda.spring.demo.service.CategoryService;
import com.sda.spring.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(){
        return "Hello word";
    }

    @CrossOrigin(value = "http://localhost:3000")
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> showBookList(){
        return bookService.getBooks();
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<UserPropDTO> showUserProp(){
        return userService.getUsers();
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public BookCategory addCategory(
            @RequestBody BookCategory bookCategory
                                    ){
        return categoryService.save(bookCategory);
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public Book addBook(
            @RequestBody Book book
    ){
        return bookService.save(book);
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookService.getBookById(id));
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public Optional<BookCategory> getBookCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @RequestMapping(value = "/author/{id}", method = RequestMethod.GET)
    public Optional<BookAuthor> getBookAuthorById(@PathVariable Long id){
        return authorService.getAuthorById(id);
    }

    /*
     - wszystkich autorow
     - wszystkich kategorii
     */

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public List<BookCategory> showCategories(){
        return categoryService.bookCategories();
    }

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public List<BookAuthor> showAuthors(){
        return authorService.getAuthors();
    }
}
