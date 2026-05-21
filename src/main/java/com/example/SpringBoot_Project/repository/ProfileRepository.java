package com.example.SpringBoot_Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBoot_Project.EntityClasses.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer>{

}
