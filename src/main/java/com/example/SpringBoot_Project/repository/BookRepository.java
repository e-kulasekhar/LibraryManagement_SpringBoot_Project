package com.example.SpringBoot_Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBoot_Project.EntityClasses.Book;

public interface BookRepository  extends JpaRepository<Book, Integer>{

}
