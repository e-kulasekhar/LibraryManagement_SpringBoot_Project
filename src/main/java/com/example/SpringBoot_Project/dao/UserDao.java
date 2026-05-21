package com.example.SpringBoot_Project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.SpringBoot_Project.EntityClasses.User;
import com.example.SpringBoot_Project.repository.UserRepository;

@Repository
public class UserDao {
	
	@Autowired
	private UserRepository userrp;
	
	//saving
	public User save(User u) {
		return userrp.save(u);
	}

	//getting all details
	public List<User> getAll(){
		return userrp.findAll();
	}
	
	
	//getting by id
	public User getById(int id)
	{
		Optional<User> o = userrp.findById(id);
		
		if(o.isPresent())
		{
			return o.get();
		}
		else 
		{
		 return null;
		}
	}
	
	
	       //update
		public User update(User u)
		{
			int id = u.getId();
			Optional<User> o = userrp.findById(id);
			if(o.isPresent()) {
				return userrp.save(u);
			}
			else {
				return null;
			}
	}
		
		
		    //delete
		public String delete(int id)
		{
			Optional<User> o = userrp.findById(id);
			if(o.isPresent())
			{
				User u = o.get();
				userrp.delete(u);
				return "User Deleted ";
			}
			else 
			{
				return "id not found";
			}
			
		}
		
		
    }














