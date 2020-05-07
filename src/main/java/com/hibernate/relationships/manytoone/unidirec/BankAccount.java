package com.hibernate.relationships.manytoone.unidirec;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bank_account")
public class BankAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="accnt_id")
	private int accntId;
	/*
	 * account number will be always unique and it should not ne null
	 */
	@Column(name="accnt_number",unique = true,nullable = false,length = 20)
	private String accntNumber;
	@Column(name="bank_name",nullable = false,length = 20)
	private String bankName;
	
	/*
	 * 
	 * one bank account from any bank can be linked to only one user
	 * But accounts in multiple banks can be lined to same user.
	 * @ManyToOne annotation is associated with User class
	 * A many-to-one mapping means that many instances of this entity 
	 * are mapped to one instance of another entity
	 * @JoinColumn annotation references the mapped column.
	 * pass the database column name(not field name)
	 */
	
	/*
	 * use orphanRemoval = true attribute in ManyToOne
	 * when we want to remove child entity when we remove parent entity
	 */
	@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinColumn(name="user_id",nullable = true)
	private User user;
	
	@Override
	public String toString() {
		return "BankAccount [accntId=" + accntId + ", accntNumber=" + accntNumber + ", bankName=" + bankName + "]";
	}


	public BankAccount() {
		
	}

	
	public BankAccount(String accntNumber, String bankName) {
		super();
		this.accntNumber = accntNumber;
		this.bankName = bankName;
	}


	public BankAccount(String accntNumber, String bankName, User user) {
		super();
		this.accntNumber = accntNumber;
		this.bankName = bankName;
		this.user = user;
	}

	public int getAccntId() {
		return accntId;
	}

	public void setAccntId(int accntId) {
		this.accntId = accntId;
	}

	public String getAccntNumber() {
		return accntNumber;
	}

	public void setAccntNumber(String accntNumber) {
		this.accntNumber = accntNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}







	
	
	
}
