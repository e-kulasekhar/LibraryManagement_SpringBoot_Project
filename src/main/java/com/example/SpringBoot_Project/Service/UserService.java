package com.example.SpringBoot_Project.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.SpringBoot_Project.EntityClasses.Book;
import com.example.SpringBoot_Project.EntityClasses.Category;
import com.example.SpringBoot_Project.EntityClasses.User;
import com.example.SpringBoot_Project.dao.CategoryDao;
import com.example.SpringBoot_Project.dao.UserDao;
import com.example.SpringBoot_Projectcom.example.SpringBoot_Project.repository.dtp.ResponseStructure;

@Service
public class UserService {
	
	@Autowired
	private UserDao ud;
	
	//save
    public ResponseEntity<ResponseStructure<User>> save(User u) {

      User ur = ud.save(u);

        ResponseStructure<User> rs = new ResponseStructure<>();

        rs.setStatusCode(HttpStatus.CREATED.value());
        rs.setMessage("user Saved Successfully");
        rs.setData(ur);

        return new ResponseEntity<ResponseStructure<User>>(rs, HttpStatus.CREATED);
    }

    //getting all details
    public ResponseEntity<ResponseStructure<List<User>>> getall() {

    	List<User> ur1 = ud.getAll();
          
    	ResponseStructure<List<User>> rs = new ResponseStructure<List<User>>();
          if(ur1 != null) {
          rs.setStatusCode(HttpStatus.OK.value());
          rs.setMessage("user got all Successfully");
          rs.setData(ur1);
          return new ResponseEntity<ResponseStructure<List<User>>>(rs,HttpStatus.OK);

          } 
          else {
        	  rs.setStatusCode(HttpStatus.NOT_FOUND.value());
              rs.setMessage("Not found");
              rs.setData(ur1);
              return new ResponseEntity<ResponseStructure<List<User>>>(rs,HttpStatus.NOT_FOUND);
        	  
          }
    }
          
          //get by id

	public ResponseEntity<ResponseStructure<User>> getbyid(int id)
	{
		User user= ud.getById(id);
		
		ResponseStructure<User> response = new ResponseStructure<User>();
		
		
		if(user != null) {
			
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("books fetched");
			response.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(response,HttpStatus.OK);
			
		}
		
		else {
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setMessage("authore or books not found");
			response.setData(null);
			return new ResponseEntity<ResponseStructure<User>>(response,HttpStatus.NOT_FOUND);
			
		}
	}
	
	 // update
	public ResponseEntity<ResponseStructure<User>> Update(User u){

	    User user = ud.update(u);

	    ResponseStructure<User> response = new ResponseStructure<User>();

	    if(user != null) {

	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("User updated successfully");
	        response.setData(user);

	        return new ResponseEntity<ResponseStructure<User>>(response, HttpStatus.OK);

	    }

	    else {

	        response.setStatusCode(HttpStatus.NOT_FOUND.value());
	        response.setMessage("User not found");
	        response.setData(null);

	        return new ResponseEntity<ResponseStructure<User>>(response, HttpStatus.NOT_FOUND);

	    }
	}
	
	//delete 
	public ResponseEntity<ResponseStructure<String>> Delete(int id ){

	    ResponseStructure<String> response =
	            new ResponseStructure<String>();

	    try {

	        String result = ud.delete(id);

	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Deleted Successfully");
	        response.setData(result);

	        return new ResponseEntity<ResponseStructure<String>>
	        (response, HttpStatus.OK);

	    }

	    catch (Exception e) {

	        response.setStatusCode(HttpStatus.BAD_REQUEST.value());
	        response.setMessage("User has borrowed books. Return books first.");
	        response.setData("Cannot Delete User");

	        return new ResponseEntity<ResponseStructure<String>>
	        (response, HttpStatus.BAD_REQUEST);

	    }
	}
		
	
	
	
	
	
	
}