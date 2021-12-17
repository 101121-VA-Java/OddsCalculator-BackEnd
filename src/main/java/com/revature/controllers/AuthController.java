package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;
@RestController
@RequestMapping("/auth")
@CrossOrigin(exposedHeaders="Authorization")
public class AuthController {
	private UserService us;
	@Autowired
	public AuthController(UserService us) {
		this.us = us;
	}
	@CrossOrigin
	@PostMapping
	public ResponseEntity<User> loginSystem(@RequestParam(name="email")String email, @RequestParam(name="password")String password){
		User u = us.loginSystem(email, password);
		HttpHeaders responseHeaders = new HttpHeaders();
		String t = us.tokenSystem(email,password);
		System.out.println(t);
		responseHeaders.set("Authorization", t);
		return new ResponseEntity<>(u,responseHeaders,HttpStatus.OK);
}
}