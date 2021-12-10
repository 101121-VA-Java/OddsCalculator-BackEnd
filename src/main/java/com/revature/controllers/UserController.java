package com.revature.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
		// if a query param of name "role" is passed in, returns users of this role
//		if(role != null) {
//			return us.getUserByRole(role);
//		}
		System.out.println("Getting All Users");
		return us.getAllUsers();
		
	}
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, value="/users")
	public ResponseEntity<String> createUser(@RequestBody User user){
		us.createUser(user);
		System.out.println("We here!");
		return new ResponseEntity<>(user.getFirstName() +" " + user.getLastName() + " was created.", HttpStatus.CREATED);
	}

}
