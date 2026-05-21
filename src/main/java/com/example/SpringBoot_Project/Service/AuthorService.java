package com.example.SpringBoot_Project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.SpringBoot_Project.EntityClasses.Auther;
import com.example.SpringBoot_Project.EntityClasses.Book;
import com.example.SpringBoot_Project.dao.AuthorDao;
import com.example.SpringBoot_Projectcom.example.SpringBoot_Project.repository.dtp.ResponseStructure;

@Service
public class AuthorService {

	@Autowired
	private AuthorDao au;
	
	public ResponseEntity<ResponseStructure<Auther>> save(Auther a)
	{
		Auther auther = au.save(a);
		
		ResponseStructure<Auther> rsp = new ResponseStructure<Auther>();
		rsp.setStatusCode(HttpStatus.CREATED.value());
		rsp.setMessage("AUTHOR ADDED");
		rsp.setData(auther);
		
		return new ResponseEntity<ResponseStructure<Auther>>(rsp,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Auther>>> getAllAuthor()
	{
		List<Auther> list = au.getAllauthore();
		ResponseStructure<List<Auther>> response = new ResponseStructure<List<Auther>>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("getting details");
		response.setData(list);
		
		return new ResponseEntity<ResponseStructure<List<Auther>>>(response,HttpStatus.OK);
		
	} 
	
	public ResponseEntity<ResponseStructure<List<Book>>> getBooks(int id)
	{
		List<Book> books = au.getBooks(id);
		ResponseStructure<List<Book>> response = new ResponseStructure<List<Book>>();
		
		if(books != null) {
			
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("books fetched");
			response.setData(books);
			return new ResponseEntity<ResponseStructure<List<Book>>>(response,HttpStatus.OK);
			
		}
		
		else {
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setMessage("authore or books not found");
			response.setData(books);
			return new ResponseEntity<ResponseStructure<List<Book>>>(response,HttpStatus.NOT_FOUND);
			
		}
	}
	
}
