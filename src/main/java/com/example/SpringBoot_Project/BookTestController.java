package com.example.SpringBoot_Project;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBoot_Project.EntityClasses.Book;
import com.example.SpringBoot_Project.Service.BookService;
import com.example.SpringBoot_Projectcom.example.SpringBoot_Project.repository.dtp.ResponseStructure;


@RestController
public class BookTestController {

    @Autowired
    private BookService bs;

    @PostMapping("/Booksave")
    public ResponseEntity<ResponseStructure<Book>> save(@RequestBody Book b) {

        return bs.save(b);
    }

    @GetMapping("/Getbook")
    public ResponseEntity<ResponseStructure<List<Book>>> getallbooks() {

        return bs.getAllBooks();
    }

    @GetMapping("/getbook/{id}")
    public ResponseEntity<ResponseStructure<Book>> getbookbyid(@PathVariable int id) {

        return bs.getById(id);
    }
    
    @PutMapping("/borrow/{bookid}/{userid}")
    public ResponseEntity<ResponseStructure<Book>> borrowBook(
            @PathVariable int bookid,
            @PathVariable int userid)
    {
        return bs.borrowBook(bookid, userid);
    }
    
    @PutMapping("/returnbook/{id}")
    public ResponseEntity<ResponseStructure<Book>> returnBook(
            @PathVariable int id)
    {
        return bs.returnBook(id);
    }
    
    @DeleteMapping("/bookdelete/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteBook(
            @PathVariable int id)
    {
        return bs.deleteBook(id);
    }
}