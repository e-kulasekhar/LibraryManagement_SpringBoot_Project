package com.example.SpringBoot_Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBoot_Project.EntityClasses.User;

public interface UserRepository  extends JpaRepository<User, Integer>{

}
