package com.revature.Daos;


import java.util.List;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;
import com.revature.models.Role;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

	List<User> findUsersByRole(Role role);

	User findUserByEmail(String email);
	User findUserByuserid(int userid);

	

	
	@Transactional
	@Modifying
	@Query("UPDATE users u SET u.firstName = ?2 WHERE u.userid = ?1")
	void updateUserFirstName(int userid, String firstname);
	
	@Transactional
	@Modifying
	@Query("UPDATE users u SET u.lastName = ?2 WHERE u.userid = ?1")
	void updateUserLastName(int userid, String lastname);
	
	@Transactional
	@Modifying
	@Query("UPDATE users u SET u.password = ?2 WHERE u.userid = ?1")
	void updateUserPassword(int userid, String password);
	
	@Transactional
	@Modifying
	@Query("UPDATE users u SET u.wins = ?2 WHERE u.userid = ?1")
	void updateUserWins(int userid, int wins);
	
	@Transactional
	@Modifying
	@Query("UPDATE users u SET u.losses = ?2 WHERE u.userid = ?1")
	void updateUserLosses(int userid, int losses);

}
