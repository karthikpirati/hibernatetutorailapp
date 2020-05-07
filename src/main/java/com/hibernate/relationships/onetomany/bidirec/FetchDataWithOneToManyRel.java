package com.hibernate.relationships.onetomany.bidirec;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.HibernateTemplate;

public class FetchDataWithOneToManyRel {

	
	public static void main(String[] args) {
		SessionFactory sf=null;
		Session session=null;
		try {
		sf=HibernateTemplate.getSessionFactory();
		session=sf.openSession();
		/*
		 * Below is the hql query 
		 * HQL query language is database independent query language
		 * Dialect will convert HQL query language to corresponding sql language
		 */
		Query query=session.createQuery("from Customer customer where customer.custId=1");
		
		List<Customer> customers=query.list();
		
		for(Customer customer :customers) {
			System.out.println(customer.getCustId());
			List<PaymentMethod> payments=  customer.getPaymentList();
			for(PaymentMethod pm:payments) {
				System.out.println(pm.getAccountNumber());
			}
		}
		
		}catch (Exception e) {
			
		}finally {
			session.close();
		}

	}

}
