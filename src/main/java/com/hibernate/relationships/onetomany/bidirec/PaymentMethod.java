package com.hibernate.relationships.onetomany.bidirec;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * One employee has the multiple bank accounts
 * 
 */



/*
create table payment_method(
p_id int not null primary key auto_increment,
accnt_number varchar(20) not null unique,
account_type varchar(20) not null,
cust_id int,
foreign key(cust_id) references customer(cust_id)
);

*/
@Entity
@Table(name="payment_method")
public class PaymentMethod {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="p_id")
	private int pId;
	@Column(name="accnt_number",unique = true,nullable = false,length = 20)
	private String accountNumber;
	@Column(name="account_type",unique = false,nullable = false,length = 20)
	private String accountType;
	/*
	 * A many-to-one mapping means that many instances of this entity 
	 * are mapped to one instance of another entity 
	 * Many instances of cart 
	 */
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cust_id")
	private Customer customer;
	
	
	public PaymentMethod() {
		
	}

	public PaymentMethod(String accountNumber, String accountType) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
	}
	
	
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "PaymentMethod [pId=" + pId + ", accountNumber=" + accountNumber + ", accountType=" + accountType
				+ ", customer=" + customer + "]";
	} 
	
	
	
	
	
	

}
