package com.hibernate.sessionmethods;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.HibernateTemplate;
import com.hibernate.HibernateTemplate4;
import com.hibernate.Person;
import com.hibernate.relationships.manytoone.unidirec.User;

public class UpdateVsMerge {

	public static void main(String[] args) {
		SessionFactory sf=null;
		Session session=null;
		Transaction t=null;
		try {
			
			sf=HibernateTemplate.getSessionFactory();
			Person p1=new Person("name3", 20);
			session=sf.openSession();
			session.save(p1);
			t=session.beginTransaction();
			t.commit();
			session.close();
			p1.setName("name4");
			
			session=sf.openSession();
			t=session.beginTransaction();
			Person p2=(Person) session.get(Person.class, p1.getPrsnId());
			/*
			 * The scenario is we are updating previous state changes to object in current session.
			 * p1 an p2 are having same primary keys 
			 * Current session is already having person object with same primary key identifier
			 * Now update method will throw an org.hibernate.NonUniqueObjectException error
			 * to resolve this we have to use merge method
			 */
			//session.update(p1);
			session.merge(p1);
			t.commit();
		}catch (Exception e) {
		System.out.println(e);	
		}

	}

}
