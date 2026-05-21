package com.example.SpringBoot_Project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBoot_Project.EntityClasses.Auther;
import com.example.SpringBoot_Project.EntityClasses.Book;
import com.example.SpringBoot_Project.Service.AuthorService;
import com.example.SpringBoot_Projectcom.example.SpringBoot_Project.repository.dtp.ResponseStructure;


@RestController
public class AuthorTestController {

    @Autowired
    private AuthorService as;

    @PostMapping("/Authersave")
    public ResponseEntity<ResponseStructure<Auther>> save(@RequestBody Auther a) {

        if(a.getBooks() != null) {

            for(Book b : a.getBooks()) {

                b.setAuther(a);

            }
        }

        return as.save(a);

    }

    @GetMapping("/AutherGet")
    public ResponseEntity<ResponseStructure<List<Auther>>> getAllAuthor() {

        return as.getAllAuthor();

    }

    @GetMapping("/AutherBook/{id}")
    public ResponseEntity<ResponseStructure<List<Book>>> getBooks(@PathVariable int id) {

        return as.getBooks(id);

    }

}