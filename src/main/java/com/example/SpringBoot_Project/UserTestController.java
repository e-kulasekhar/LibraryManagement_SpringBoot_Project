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

import com.example.SpringBoot_Project.EntityClasses.User;
import com.example.SpringBoot_Project.Service.UserService;
import com.example.SpringBoot_Projectcom.example.SpringBoot_Project.repository.dtp.ResponseStructure;

@RestController
public class UserTestController {
	
	@Autowired
	private UserService us;
	
	@PostMapping("/usersave")
	public ResponseEntity<ResponseStructure<User>> save(@RequestBody User u){
		return us.save(u);
		
	}
	
	@GetMapping("/userget1")
	public ResponseEntity<ResponseStructure<List<User>>> getAll(){
		return us.getall();
	}
	
	@GetMapping("/usergetbyid/{id}")
	public ResponseEntity<ResponseStructure<User>> getById(@PathVariable int id){
		return us.getbyid(id);
	}
	
	@PutMapping("/userupdate")
	public ResponseEntity<ResponseStructure<User>> Update(@RequestBody User u){
		return us.Update(u);
	}
	
	@DeleteMapping("/userdelete/{u}")
	public ResponseEntity<ResponseStructure<String>> Delete(@PathVariable int u){
		return us.Delete(u);
	}
	

}
