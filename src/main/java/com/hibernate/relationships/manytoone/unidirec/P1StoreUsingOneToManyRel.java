package com.hibernate.relationships.manytoone.unidirec;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.HibernateTemplate;
import com.hibernate.relationships.onetomany.bidirec.Customer;

/*
 * Hibernate one to many mapping is made between two entities 
 * where first entity can have relation with multiple second entity instances
 * but second can be associated with only one instance of first entity. 
 * Its 1 to N relationship.
 * Example : Consider Customer and Payment methods
 * One Customer can have multiple bank accounts or payment methods to pay the bill 
 * But One Bank Account will be linked to one Customer
 */


/*
 * As stated in the JPA specification under section 2.9, 
 * it's a good practice to mark many-to-one side as the owning side.
 * In other words, BankAccount would be the owning side and User the inverse side
 * which is exactly what we are doing
 * By including the mappedBy attribute in the User class, we mark it as the inverse side.
 */
public class P1StoreUsingOneToManyRel {

	public static void main(String[] args) {
		SessionFactory sf=null;
		Session session=null;
		Transaction transaction=null;
		try {
			sf=HibernateTemplate.getSessionFactory();
			session=sf.openSession();
			transaction=session.beginTransaction();
			
			//User user1=new User("user2");
			
			BankAccount b1=new BankAccount("2222", "hdfc",(User)session.get(User.class, 2));
			
			//session.save(user1);
			/*
			 * First we have save user object then 
			 * we have to save bank account object
			 * otherwise we will get below exception
			 * Attempting to save one or more entities that have a non-nullable association with an unsaved transient entity. 
			 * The unsaved transient entity must be saved in an operation prior to saving these dependent entities.
			 * Solution to this problem use cascade=CascadeType.PERSIST in ManyToOne
			 * or cascade=CascadeType.ALL
			 */
			session.persist(user1);
			session.persist(b1);
			
			transaction.commit();
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			session.close();
		}

	}

}
