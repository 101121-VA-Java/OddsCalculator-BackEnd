package com.revature.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.Daos.UserDao;

import com.revature.models.Role;

import com.revature.models.History;

import com.revature.models.User;

@Service
public class UserService {
	private UserDao ud;
	
	@Autowired
	public UserService(UserDao ud) {
		this.ud = ud;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void createUser(User u) {
		u.setRole(Role.BASIC);
		ud.save(u);
	}
	
	public List<User> getAllUsers(){
		return ud.findAll();
		
	}
	

        public String tokenSystem(String email, String password) {
		
		String token = null;
		
		User principal = ud.findUserByEmail(email);
		System.out.println(principal);
		if(principal != null && principal.getPassword().equals(password)) {
			token = principal.getUserID() + ":" + principal.getRole();
		}
		
		System.out.println(token);
		return token;
	}
        
        public User loginSystem(String email, String password) {
    		
    	
    		
    		User principal = ud.findUserByEmail(email);
    		System.out.println(principal);
    		
    		
    		System.out.println(principal);
    		return principal;
    	}
        
        public boolean authPermission(String token, Role... allowedRoles) {
    		
    		if(token == null) {
    			return false;
    		}
    		
    		String[] info = token.split(":");
    		int token_id = Integer.parseInt(info[0]);
    		Role token_role = Role.valueOf(info[1]);
    		User principal = ud.getById(token_id);
    		
    		if(principal != null && token_role.equals(principal.getRole())
    				&& Arrays.asList(allowedRoles).contains(token_role)) {
    			return true;
    		}
    		return false;
    		
    	}
        public User getUserById(int id) {
    		return ud.getById(id);
    	}
        public void updateUser(int id, User u) {
    		 
    			ud.updateUserFirstName(id, u.getFirstName());
    			ud.updateUserLastName(id, u.getLastName());
    			ud.updateUserPassword(id, u.getPassword());
    		
    			 
    		}
    	}
        
       

