package com.revature.Daos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.models.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	
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
