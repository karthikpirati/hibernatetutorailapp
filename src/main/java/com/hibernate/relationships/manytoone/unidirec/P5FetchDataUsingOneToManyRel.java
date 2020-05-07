package com.hibernate.relationships.manytoone.unidirec;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.HibernateTemplate4;



/*
 * By default, the JPA @ManyToOne and @OneToOne annotations are fetched EAGERly,
 *  while the @OneToMany and @ManyToMany relationships are considered LAZY. 
 *  This is the default strategy, and Hibernate doesn't magically optimize your object retrieval, 
 *  it only does what is instructed to do.
 */
public class P5FetchDataUsingOneToManyRel {
	
	public static void main(String[] args) {
		SessionFactory sf=null;
		Session session=null;
		Transaction transaction=null;
		try {
		sf=HibernateTemplate4.getSessionFactory();
		session=sf.openSession();
		/*
		 * 
		 */
		List<User> users= session.createQuery("from User").list();
		
		/*
		 * The important way to use HQL query
		 * we should always use class names and field/property names
		 * below query is trying fetch all bankaccounts whose userId=1
		 * in table we have user_id foreign key column 
		 * so sql query is : select * from bank_account where user_id=1
		 * but in BankAccount we dont have column user_id
		 * instead we have private User user property and User class contains userId property
		 * we have to use user.userId
		 * hql query is select ba from BankAccount ba where ba.user.userId=:userId
		 */
		for(User user:users) {
			/*
			 * in case of sql query it wont return 
			 Query query=session.createSQLQuery("select * from bank_account where user_id="+user.getUserId());
			 List<Object[]> accounts=query.list();
			 for(Object[] ba:accounts) {
				 BankAccount b=(BankAccount);
				 b.set(ba[0])
				 System.out.println(b.getAccntId());
			}
			 * 
			 */
			Query query=session.createQuery("select ba from BankAccount ba where ba.user.userId=:userId");
			query.setParameter("userId", 1);
			List<BankAccount> accounts=query.list();
			for(BankAccount ba:accounts) {
				System.out.println(ba.getAccntId());
			}
		}
		
		
		
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			session.close();
		}

	}

}
