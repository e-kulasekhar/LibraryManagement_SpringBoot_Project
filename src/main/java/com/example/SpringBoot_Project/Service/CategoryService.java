package com.example.SpringBoot_Project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.SpringBoot_Project.EntityClasses.Category;
import com.example.SpringBoot_Project.dao.CategoryDao;
import com.example.SpringBoot_Projectcom.example.SpringBoot_Project.repository.dtp.ResponseStructure;

@Service
public class CategoryService {

    @Autowired
    private CategoryDao cd;

    public ResponseEntity<ResponseStructure<Category>> save(Category c) {

        Category ct = cd.save(c);

        ResponseStructure<Category> rs = new ResponseStructure<>();

        rs.setStatusCode(HttpStatus.CREATED.value());
        rs.setMessage("Category Saved Successfully");
        rs.setData(ct);

        return new ResponseEntity<ResponseStructure<Category>>(rs, HttpStatus.CREATED);
    }
    
    
    //getAll
    public ResponseEntity<ResponseStructure<List<Category>>> getAllBooks() {
    	
    	List<Category>list = cd.getAll();
    	
    	ResponseStructure<List<Category>> rsp = new ResponseStructure<List<Category>>();
    	
    	if(list != null) {
    	
    	rsp.setStatusCode(HttpStatus.OK.value());
    	rsp.setMessage("category got all");
    	rsp.setData(list);
    	
    	return new ResponseEntity<ResponseStructure<List<Category>>>(rsp,HttpStatus.OK);
    	}
    
    else {
    	rsp.setStatusCode(HttpStatus.NOT_FOUND.value());
    	rsp.setMessage("not found");
    	rsp.setData(list);
    	
    	return new ResponseEntity<ResponseStructure<List<Category>>>(rsp,HttpStatus.NOT_FOUND);
    }
    }
}