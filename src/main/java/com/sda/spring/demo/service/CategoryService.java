package com.sda.spring.demo.service;

import com.sda.spring.demo.model.BookCategory;
import com.sda.spring.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<BookCategory> bookCategories(){
        return categoryRepository.findAll();
    }

    public BookCategory save(BookCategory bookCategory) {
        return categoryRepository.save(bookCategory);
    }

    public Optional<BookCategory> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }
}
