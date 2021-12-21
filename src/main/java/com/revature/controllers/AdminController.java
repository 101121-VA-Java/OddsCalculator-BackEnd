package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;
@RestController
@RequestMapping("/admin")
@CrossOrigin(exposedHeaders="Authorization")
public class AdminController {

	
		
		private UserService us;
		
		@Autowired
		public AdminController(UserService us) {
			this.us = us;
		}
		@CrossOrigin
		@GetMapping
		public List<User> getAllUsers(){
			// if a query param of name "role" is passed in, returns users of this role
//			if(role != null) {
//				return us.getUserByRole(role);
//			}
			System.out.println("Getting All Users");
			return us.getAllUsers();
		}		
}
