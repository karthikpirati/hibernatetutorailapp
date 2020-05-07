package com.hibernate.relationships.onetomany.bidirec;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.HibernateTemplate;

/*
 * Hibernate one to many mapping is made between two entities 
 * where first entity can have relation with multiple second entity instances
 * but second can be associated with only one instance of first entity. 
 * Its 1 to N relationship.
 * Example : Consider Customer and Payment methods
 * One Customer can have multiple bank accounts or payment methods to pay the bill 
 * But One Bank Account will be linked to one Customer
 */


public class StoreOneToManyRel {

	public static void main(String[] args) {
		SessionFactory sf=null;
		Session session=null;
		Transaction transaction=null;
		try {
			sf=HibernateTemplate.getSessionFactory();
			
			session=sf.openSession();
			transaction=session.beginTransaction();
			Customer customer=new Customer("cust1", "cust1@gmail.com");
			
			/*
			PaymentMethod pm1=new PaymentMethod("12345","hdfcvisadebitcard");
			PaymentMethod pm2=new PaymentMethod("2563474","google pay");
			List<PaymentMethod> paymentList=new ArrayList<PaymentMethod>();
			paymentList.add(pm1);
			paymentList.add(pm2);
			customer.setPaymentList(paymentList);
			
			session.save(customer);
			*/
			
			/*
			PaymentMethod pm3=new PaymentMethod("12345","hdfcvisadebitcard");
			pm3.setCustomer((Customer)session.get(Customer.class, 1));
			*/
			
			
			transaction.commit();
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			session.close();
			HibernateTemplate.shutdown();
		}

	}

}
