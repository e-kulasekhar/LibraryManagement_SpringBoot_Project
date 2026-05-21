package com.example.SpringBoot_Project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.SpringBoot_Project.EntityClasses.Book;
import com.example.SpringBoot_Project.dao.BookDao;
import com.example.SpringBoot_Projectcom.example.SpringBoot_Project.repository.dtp.ResponseStructure;

@Service
public class BookService {
	
	@Autowired
	private BookDao bd;
	
	//add book
	public ResponseEntity<ResponseStructure<Book>> save(Book b){
		
		Book book = bd.addBook(b);
		ResponseStructure<Book> rsp = new ResponseStructure<Book>();
		rsp.setStatusCode(HttpStatus.CREATED.value());
		rsp.setMessage("books added");
		rsp.setData(book);
		
		return new ResponseEntity<ResponseStructure<Book>>(rsp,HttpStatus.CREATED);
	}
	
	//borrow methods
	public ResponseEntity<ResponseStructure<Book>> borrowBook(int b_id, int u_id)
	{
	    Book book = bd.Borrow(b_id, u_id);

	    ResponseStructure<Book> response =
	            new ResponseStructure<Book>();

	    if(book != null)
	    {
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Book Borrowed Successfully");
	        response.setData(book);

	        return new ResponseEntity<ResponseStructure<Book>>
	        (response, HttpStatus.OK);
	    }

	    else
	    {
	        response.setStatusCode(HttpStatus.BAD_REQUEST.value());
	        response.setMessage("Book already borrowed or invalid id");
	        response.setData(null);

	        return new ResponseEntity<ResponseStructure<Book>>
	        (response, HttpStatus.BAD_REQUEST);
	    }
	}
	
	//return book
	public ResponseEntity<ResponseStructure<Book>> returnBook(int id)
	{
	    Book book = bd.returnBook(id);

	    ResponseStructure<Book> response =
	            new ResponseStructure<Book>();

	    if(book != null)
	    {
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Book Returned Successfully");
	        response.setData(book);

	        return new ResponseEntity<ResponseStructure<Book>>
	        (response, HttpStatus.OK);
	    }

	    else
	    {
	        response.setStatusCode(HttpStatus.NOT_FOUND.value());
	        response.setMessage("Book Not Found");
	        response.setData(null);

	        return new ResponseEntity<ResponseStructure<Book>>
	        (response, HttpStatus.NOT_FOUND);
	    }
	}
	
	//getting all books
	public ResponseEntity<ResponseStructure<List<Book>>> getAllBooks(){
		List<Book> list = bd.getAllBooks();
		ResponseStructure<List<Book>> rsp = new ResponseStructure<List<Book>>();
		rsp.setStatusCode(HttpStatus.OK.value());
		rsp.setMessage("got all books");
		rsp.setData(list);
		return new ResponseEntity<ResponseStructure<List<Book>>>(rsp,HttpStatus.OK);
			
	}
	public ResponseEntity<ResponseStructure<Book>> getById(int id)
	{
	    Book book = bd.getBookByid(id);

	    ResponseStructure<Book> rsp = new ResponseStructure<Book>();

	    if(book != null)
	    {
	        rsp.setStatusCode(HttpStatus.OK.value());
	        rsp.setMessage("Book Found");
	        rsp.setData(book);

	        return new ResponseEntity<ResponseStructure<Book>>( rsp, HttpStatus.OK);
	    }

	    else
	    {
	        rsp.setStatusCode(HttpStatus.NOT_FOUND.value());
	        rsp.setMessage("Book Not Found");
	        rsp.setData(book);

	        return new ResponseEntity<ResponseStructure<Book>>( rsp,HttpStatus.NOT_FOUND);
	    }
	}
		
	//delte book
	public ResponseEntity<ResponseStructure<String>> deleteBook(int id)
	{
	    ResponseStructure<String> response =
	            new ResponseStructure<String>();

	    String result = bd.deleteBook(id);

	    if(result.equals("Book Deleted"))
	    {
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Book Deleted Successfully");
	        response.setData(result);

	        return new ResponseEntity<ResponseStructure<String>>
	        (response, HttpStatus.OK);
	    }

	    else
	    {
	        response.setStatusCode(HttpStatus.NOT_FOUND.value());
	        response.setMessage("Book Not Found");
	        response.setData(result);

	        return new ResponseEntity<ResponseStructure<String>>
	        (response, HttpStatus.NOT_FOUND);
	    }
	}
		
		
	

}
