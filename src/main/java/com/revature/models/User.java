package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.context.annotation.Primary;


@Entity(name="users")
@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private int userid;
	@Column(name = "first_name", nullable=false)
	private String firstName;
	@Column(name = "last_name", nullable=false)
	private String lastName;
	private String password;
	private String email;
	private Role role;
	@Column(nullable=true)
	private int wins;
	@Column(nullable=true)
	private int losses;
<<<<<<< HEAD
	@Column(nullable=false)
	private int balance;
=======

>>>>>>> 8404df48d4462c6411c69dd70bbe58ae7d34ccb4
	

	public User() {
	}



	public User( String firstName, String lastName, String password, String email, Role role) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.role = role;
	}



	public User(int userID, String firstName, String lastName, String password, String email, Role role, int wins,
			int losses) {
		super();
		this.userid = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.role = role;
		this.wins = wins;
		this.losses = losses;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + losses;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + userid;
		result = prime * result + wins;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (losses != other.losses)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role != other.role)
			return false;
		if (userid != other.userid)
			return false;
		if (wins != other.wins)
			return false;
		return true;
	}



	public int getUserID() {
		return userid;
	}



	public void setUserID(int userid) {
		this.userid = userid;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}



	public int getWins() {
		return wins;
	}



	public void setWins(int wins) {
		this.wins = wins;
	}



	public int getLosses() {
		return losses;
	}



	public void setLosses(int losses) {
		this.losses = losses;
	}



	public int getUserid() {
		return userid;
	}



	public void setUserid(int userid) {
		this.userid = userid;
	}



	public int getBalance() {
		return balance;
	}



	public void setBalance(int balance) {
		this.balance = balance;
	}



	@Override
	public String toString() {
		return "User [userid=" + userid + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", email=" + email + ", role=" + role + ", wins=" + wins + ", losses=" + losses
				+ ", balance=" + balance + "]";
	}



	
	}
	
	

