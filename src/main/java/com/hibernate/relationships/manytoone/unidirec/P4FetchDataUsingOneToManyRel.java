package com.hibernate.relationships.manytoone.unidirec;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.HibernateTemplate4;

public class P4FetchDataUsingOneToManyRel {
	
	
	public static void main(String[] args) {
		SessionFactory sf=null;
		Session session=null;
		Transaction transaction=null;
		try {
		sf=HibernateTemplate4.getSessionFactory();
		session=sf.openSession();
		/*
		 * Before executing this query add below attrbute in ManyToOne 
		 * fetch = FetchType.EAGER
		 * @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
		 * you will observe two select queries will be fired
		 * First query will fetch BankAccount data
		 * Second Query will fetch User data linked BankAccount
		 * This is called eager execution
		 * We write a query for getting bank account but internally 
		 * it is also fetching Users linked to BankAccounts
		 * Which is called eager execution
		 * I dont want user data unnecessarily until unless i called getAccounts()
		 * then use fetch = FetchType.Lazy
		 * You will observe only one select query will be executed to fetch Bank Accounts
		 * By default ManyToOne is eager execution
		 */
		List<User> users= session.createQuery("from User").list();
		for(User user:users) {
			System.out.println(user.getUserId());
		}
		
		List<BankAccount> bas= session.createQuery("from BankAccount").list();
		for(BankAccount ba:bas) {
			System.out.println(ba.getAccntNumber());
		}
		
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
		}

	}

}
