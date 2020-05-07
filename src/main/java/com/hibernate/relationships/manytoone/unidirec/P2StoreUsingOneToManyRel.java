package com.hibernate.relationships.manytoone.unidirec;

import javax.persistence.JoinColumn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.HibernateTemplate4;
import com.hibernate.HibernateTemplate5;

public class P2StoreUsingOneToManyRel {
	
	public static void main(String[] args) {
		SessionFactory sf=null;
		Session session=null;
		Transaction transaction=null;
		try {
			sf=HibernateTemplate5.getSessionFactory();
			session=sf.openSession();
			transaction=session.beginTransaction();
			
			User user1=new User("user2");
			BankAccount b1=new BankAccount("2", "hdfc");
			
			session.save(user1);
			/*
			 * Now insert new user into database first
			 * Then insert bank account into user without passing user object
			 * Then you will get below exception
			 * org.hibernate.exception.ConstraintViolationException: Column 'user_id' cannot be null
			 * Because we have set @JoinColumn(name="user_id",nullable = false)
			 * Since user_id cannot be nullable we are getting exception
			 * try modifying it to true by modifying hbm2ddl.auto =create 
			 * because we have alter the table
			 */
			session.save(b1);
			
			transaction.commit();
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			session.close();
		}

	}

}
