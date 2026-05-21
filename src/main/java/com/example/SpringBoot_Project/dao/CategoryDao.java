package com.example.SpringBoot_Project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.SpringBoot_Project.EntityClasses.Category;
import com.example.SpringBoot_Project.repository.BookRepository;
import com.example.SpringBoot_Project.repository.CategoryRepository;

@Repository
public class CategoryDao {

	@Autowired
	private CategoryRepository cat;
	
	  
    public Category save(Category c) {
        return cat.save(c);
    }
    
    public List<Category> getAll(){
    	
    	return cat.findAll();
    }
}

