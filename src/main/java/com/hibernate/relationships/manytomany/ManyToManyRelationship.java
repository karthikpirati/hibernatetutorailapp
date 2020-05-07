package com.hibernate.relationships.manytomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.HibernateTemplate;

public class ManyToManyRelationship {
	
	public static void main(String[] args) {
		SessionFactory sf=null;
		Session session=null;
		Transaction transaction=null;
		ServiceRegistry sr=null;
		try {
			sf=HibernateTemplate.getSessionFactory();
			
			session=sf.openSession();
			transaction=session.beginTransaction();
			
			Set<Subscriber> subs=new HashSet<Subscriber>();
			Subscriber sub1=new Subscriber("sub1");
			Subscriber sub2=new Subscriber("sub2");
			subs.add(sub1);
			subs.add(sub2);
			
			Channel c1=new Channel("Java Tutorial");
			c1.setSubscribers(subs);
			
			session.persist(c1);
			transaction.commit();
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			session.close();
			sf.close();
		}

	}


}
