package com.example.SpringBoot_Project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.SpringBoot_Project.EntityClasses.Auther;
import com.example.SpringBoot_Project.EntityClasses.Book;
import com.example.SpringBoot_Project.repository.AutherRepository;

@Repository
public class AuthorDao {
	
	@Autowired
	private AutherRepository author;
	
	
	public Auther save(Auther a)
	{
		return author.save(a);
	}
	
	
	public List<Auther> getAllauthore(){
		return author.findAll();
	}
	
	
	
	public List<Book> getBooks (int id){
		
		Optional<Auther> o = author.findById(id);
		if(o.isPresent()) {
			Auther a = o.get();
			return a.getBooks();
		}
		
		else {
			return null;
		}
		
		
	}

}
