package com.revature.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.services.UserService;

@RestController
//@Controller
@RequestMapping("/users")
@CrossOrigin
public class UserController {
	
	private UserService us;
	
	@Autowired
	public UserController(UserService us) {
		this.us = us;
	}
	@CrossOrigin
	@GetMapping
	public List<User> getAllUsers(){

		System.out.println("Getting All Users");
		return us.getAllUsers();
		
	}
	
	@CrossOrigin
	//@RequestMapping(method=RequestMethod.GET)
	@GetMapping("/{id}")
	public User getUsers(@PathVariable(name="id", required = true)int id){
		
		System.out.println("Getting User " + id);
		return us.getUser(id);
		
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> createUser(@RequestBody User user){
		us.createUser(user);
		return new ResponseEntity<>(user.getFirstName() +" " + user.getLastName() + " was created.", HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@PostMapping("/{id}/{field}")
	public ResponseEntity<String> updateUser(@PathVariable(name="id", required = true)int id, @PathVariable(name="field", required=true) String field,@RequestBody User user){
		us.updateUser(id, user, field);
		return new ResponseEntity<>(user.getFirstName() +" " + user.getLastName() + " was updated.", HttpStatus.OK);
	}
	

}
