package com.revature.controllers;

import java.util.List;

import org.apache.tomcat.util.buf.UDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace.Principal;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@CrossOrigin(exposedHeaders = "Authorization")
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
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> createUser(@RequestBody User user) {
		us.createUser(user);
		System.out.println("We here!");
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		System.out.println("Hitting Get user by ID");
		return new ResponseEntity<>(us.getUserById(id), HttpStatus.OK);
	}

	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<String> updateUser(@PathVariable(name = "id") int id, @RequestBody User user) {
		us.updateUser(id, user);
		return new ResponseEntity<>( HttpStatus.OK);

	}
	

	

}
