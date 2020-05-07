package com.hibernate.relationships.onetomany.bidirec;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.HibernateTemplate;

public class FetchDataWithOneToMany {

	public static void main(String[] args) {
		SessionFactory sf=null;
		Session session=null;
		try {
		sf=HibernateTemplate.getSessionFactory();
		session=sf.openSession();
		/*
		 * Below is the hql query 
		 * HQL query language is database independent query language
		 * Dialect will convert HQL query language to corresponding swl language
		 */
		
	    Query query=session.createQuery("from Customer where custId=1");
	    List<Customer> cust=query.list();

	    Query query1=session.createSQLQuery("select * from payment_method pm where pm.cust_id=1");
		//query1.setInteger(1, cust.get(0).getCustId());
		List<Object[]> dbPayments=  query1.list();
		List<PaymentMethod> payments=new ArrayList<PaymentMethod>();
		for(Object[] obj:dbPayments) {
			PaymentMethod p=new PaymentMethod();
			p.setAccountNumber((String)obj[1]);
			payments.add(p);
		}
		
		for(PaymentMethod pm : payments) {
			System.out.println(pm.getAccountNumber());
		}
		
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			session.close();
		}

	}

}
