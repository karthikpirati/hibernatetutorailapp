package com.hibernate.sessionmethods;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.HibernateTemplate;
import com.hibernate.Person;

public class LoadVsGet {

	public static void main(String[] args) {
		SessionFactory sf=null;
		Session session=null;
		Transaction t=null;
		try {
			sf=HibernateTemplate.getSessionFactory();
			session=sf.openSession();
			t=session.beginTransaction();
			/*
			 * get() will fetch the real data from database
			 * load() will not fetch the data from database but 
			 * instead it will create proxy/dummy object and set id 
			 * if you observe below we are updating his name
			 * and we are not fetching any value from that record and using
			 * so in this case we dont need to unnecessarily fire query

			 * load() should be used when we are sure about existence of record in databse
			 * let say we know Person with primary key identifier 1 is available 
			 * then only we have to use load()
			 * otherwise it will throw exception
			 * No row with given identifer exists
			 */
			//Person p1=(Person) session.get(Person.class, 1);
			
			Person p1=(Person) session.get(Person.class, 1);
			p1.setName("name6");
			session.update(p1);
			t.commit();
		}catch (Exception e) {
			System.out.println(e);	
		}

	}

}
