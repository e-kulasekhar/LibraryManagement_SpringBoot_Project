package com.example.SpringBoot_Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBoot_Project.EntityClasses.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
