package com.example.SpringBoot_Project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBoot_Project.EntityClasses.Category;
import com.example.SpringBoot_Project.Service.CategoryService;
import com.example.SpringBoot_Projectcom.example.SpringBoot_Project.repository.dtp.ResponseStructure;

@RestController
public class CategoryTestController {
	
	@Autowired
	private CategoryService ct;
	
	@PostMapping("/CategoryInsert")
	public ResponseEntity<ResponseStructure<Category>> insert(@RequestBody Category c){
		return ct.save(c);
		
	}
	
	@GetMapping("/CategoryGet")
	public ResponseEntity<ResponseStructure<List<Category>>> getAll(){
		return  ct.getAllBooks();
	}

	
}
