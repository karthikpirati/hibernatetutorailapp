package com.hibernate.relationships.manytoone.unidirec;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.HibernateTemplate4;
import com.hibernate.HibernateTemplate5;

public class P3StoreUsingOneToManyRel {

	public static void main(String[] args) {
		SessionFactory sf=null;
		Session session=null;
		Transaction transaction=null;
		try {
			sf=HibernateTemplate5.getSessionFactory();
			session=sf.openSession();
			transaction=session.beginTransaction();
			
			/*
			User user1=new User("user2");
			BankAccount b1=new BankAccount("1", "hdfc");
			BankAccount b2=new BankAccount("2", "hdfc");
			Set<BankAccount> accounts=new HashSet<BankAccount>();
			user1.setAccounts(accounts);
			session.save(user1);
			*/
			
			/*
			 * try with different cases
			 * session.save(b1);
			 * session.save(b2);
			 * session.save(user1);
			 * event try to add cascade=CasCadeType.ALL
			 * user_id will not be stored in bank_account table in any of cases
			 * which means BankAccount refers User
			 * when we try to store User by using BankAccount it is working fine
			 * eg: BankAccount b1=new BankAccount("2", "hdfc");
			 * but User not able to refer  BankAccount
			 * when we try to store BankAccount by using User as current program
			 * it is not working
			 * Means we can store data only via owing side which is BankAccount
			 * Because currently BankAccount is owning side and User is in reverse side
			 * As stated in the JPA specification under section 2.9
			 * it's a good practice to mark many-to-one side as the owning side as we currently doing
			 * Solution is below
			 */
			
			/*
			 * since hbm2ddl.auto is create first i am storing
			 * then fetching and using it
			 * If record is available we can just fetch it.
			 */
			User user=new User("user2");
			transaction.commit();
			session.save(user);
			session.close();
			
			
			session=sf.openSession();
			transaction=session.beginTransaction();
			User user1=(User) session.get(User.class, 1);
			BankAccount b1=new BankAccount("1", "hdfc",user1);
			session.save(b1);
			transaction.commit();
			session.close();
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			if(session!=null) {
			session.close();
			}
		}


	}

}
