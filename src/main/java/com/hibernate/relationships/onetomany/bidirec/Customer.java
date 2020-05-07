package com.hibernate.relationships.onetomany.bidirec;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * we will call this as model or entity model
 */

/*
create table customer(
cust_id int not null primary key auto_increment,
name varchar(20) not null unique,
email varchar(20) not null unique
);
*/
@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	/*
	 * We will get schema exception if we did not choose strategy = GenerationType.IDENTITY
	 * we might get missing column exception 
	 * or we might get Schema-validation: missing table [hibernate_sequence]
	 */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue
	@Column(name="cust_id")
	private int custId;
	@Column(name="name",unique = true,nullable = false,length = 20)
	private String name;
	@Column(name="email",unique = true,nullable = false,length = 20)
	private String email;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="cust_id")
	private List<PaymentMethod> paymentList=new ArrayList<PaymentMethod>();
	
	
	public Customer() {
		
	}
	
	public Customer(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	
	public List<PaymentMethod> getPaymentList() {
		return paymentList;
	}

	public void setPaymentList(List<PaymentMethod> paymentList) {
		this.paymentList = paymentList;
	}

	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
	

}
