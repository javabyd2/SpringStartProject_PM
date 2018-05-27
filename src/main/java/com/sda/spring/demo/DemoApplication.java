package com.sda.spring.demo;

import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.model.BookAuthor;
import com.sda.spring.demo.model.BookCategory;
import com.sda.spring.demo.repository.BookRepository;
import com.sda.spring.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	public BookRepository bookRepository;
	@Autowired
	public CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Book book = new Book("Przygoda");
//		bookRepository.save(book);

//		Book book = bookRepository.findByTitle("Przygoda");

//		Set<BookAuthor> authors = new HashSet<BookAuthor>();
//		authors.add(new BookAuthor("Jan", "Kowalski"));
//		authors.add(new BookAuthor("Zbigniew", "Nowak"));
//
//		BookCategory category = new BookCategory("Lektury szkolne");
//
//
//		Book book = new Book("Przygoda", category, authors);
//		bookRepository.save(book);

//		authors = new HashSet<BookAuthor>();
//		authors.add(new BookAuthor("Adam", "Mickiewicz"));
//
//		BookCategory bookCategory = categoryRepository.findByName("Lektury szkolne");
//
//		Book book2 = new Book("Przygoda", bookCategory, authors);
//		bookRepository.save(book2);

	}
}
