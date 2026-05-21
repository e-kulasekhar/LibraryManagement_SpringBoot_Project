package com.example.SpringBoot_Project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.SpringBoot_Project.EntityClasses.Book;
import com.example.SpringBoot_Project.EntityClasses.User;
import com.example.SpringBoot_Project.repository.BookRepository;
import com.example.SpringBoot_Project.repository.UserRepository;

@Repository
public class BookDao 
{

	@Autowired   //to inject obj into a has a relationship
	private BookRepository book;
	
	@Autowired      //to inject obj into a has a relationship
	private UserRepository user;
	
	public Book addBook(Book b) 
	{
		return book.save(b);
		}
	
	public List<Book> getAllBooks()
	{
		return book.findAll();
	}
	
	public Book getBookByid(int id) 
	{
		
		Optional <Book> o = book.findById(id);
		if(o.isPresent())
		{
			return o.get();
		}
		
		else {
			return null;
		}
	}
	
	
	public Book Borrow(int b_id, int u_id) 
	{
		
		Optional<Book> bookopt = book.findById(b_id);
		Optional<User> useeropt = user.findById(u_id);
		
		//if book or user not found
		if(bookopt.isEmpty() || useeropt.isEmpty()) 
		{
			return null;
		}
		
		Book b = bookopt.get();
		
		//book already borrowed
		if(b.getUser() != null) 
		{
			return null;
		}
		
		User u = useeropt.get();
		
		//config side update
		b.setUser(u);
		
		return book.save(b);
		
		
		
	}
	
	public Book returnBook(int id) 
			{
		Optional<Book> booko = book.findById(id);
		
		if(booko.isPresent()) {
			Book b = booko.get();
			b.setUser(null);
			return book.save(b);
		}
		
		else {
			return null;
		}
		
	}
	public String deleteBook(int id)
	{
	    Optional<Book> o = book.findById(id);

	    if(o.isPresent())
	    {
	        book.delete(o.get());

	        return "Book Deleted";
	    }

	    else
	    {
	        return "Book Not Found";
	    }
	}
}
