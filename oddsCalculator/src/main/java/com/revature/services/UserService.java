package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Role;
import com.revature.models.User;

public class UserService {
	
private List<User> users = new ArrayList<>();
	
	public UserService() {
		// Creating 4 users in our arrayList
		User a = new User();
		a.setUserID(0);
		a.setFirstName("Tricia");
		a.setLastName("Goodwin");
		a.setEmail("tricia.goodwin@revature.net");
		a.setPassword("admin");
		a.setWins(12);
		a.setRole(Role.ADMIN);
		
		User b = new User();
		a.setUserID(1);
		a.setFirstName("David");
		a.setLastName("Wysocki");
		a.setEmail("david.wysocki@revature.net");
		a.setPassword("dav");
		a.setWins(17);
		a.setRole(Role.BASIC);
		
		User c = new User();
		a.setUserID(2);
		a.setFirstName("Jeremy");
		a.setLastName("Steinhafel");
		a.setEmail("jeremy.steinhafel@revature.net");
		a.setPassword("jer");
		a.setWins(21);
		a.setRole(Role.BASIC);
		
		User d = new User();
		a.setUserID(3);
		a.setFirstName("Gerardo");
		a.setLastName("Barnett");
		a.setEmail("gerardo.barnett@revature.net");
		a.setPassword("ger");
		a.setWins(10);
		a.setRole(Role.BASIC);
		
		
		users.add(a);
		users.add(b);
		users.add(c);
		users.add(d);
	}
	
	public List<User> getAllUsers(){
		return users;
	}
	
	public User getUserById(int id) {
		for(User u : users) {
			if(u.getUserID() == id) {
				return u;
			}
		}
		// throw a custom exception
		throw new UserNotFoundException();
	}
	
	public void createUser(User u) {
		users.add(u);
	}
	
	public List<User> getUserByRole(Role role){
		List<User> temp = new ArrayList<>();
		for(User u:users) {
			if(u.getRole().equals(role)) {
				temp.add(u);
			}
		}
		
		return temp;
	}

}
