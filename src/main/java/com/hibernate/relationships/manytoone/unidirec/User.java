package com.hibernate.relationships.manytoone.unidirec;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="usr")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	@Column(name="user_name",unique = true,nullable = false,length = 20)
	private String userName;

	/*
	
	Note : we should not use @OneToMany annotation in unidirectional relationship
	
	//@OneToMany(mappedBy = "user")
	private Set<BankAccount> accounts;
	 */
	
	
	public User() {
		
	}
	

	public User(String userName) {
		super();
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/*
	 * do not include accounts in to string
	 * because we dont want to fetch accounts data unnecessarily 
	 * if we require them we will fetch them by calling setter methods
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + "]";
	}
	
	
	
}
