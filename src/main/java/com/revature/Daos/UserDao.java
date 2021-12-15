package com.revature.Daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.User;
import com.revature.models.Role;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	List<User> findUsersByRole(Role role);

	User findUserByEmail(String email);
	User findUserByuserID(int userID);
	
	
}
