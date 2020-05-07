package com.hibernate.sessionmethods;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.HibernateTemplate;
import com.hibernate.HibernateTemplate4;
import com.hibernate.Person;

public class SaveVsPersist {

	public static void main(String[] args) {
		SessionFactory sf=null;
		Session session=null;
		Transaction t=null;
		try {
			
			sf=HibernateTemplate.getSessionFactory();
			session=sf.openSession();
			/*
			 * save() save the changes to the db outside of the transaction.
			 * persist() will not save the changes outside of transaction
			 */
			 t=session.beginTransaction();
			//session.persist(new Person("name2", 20));
			session.save(new Person("name2", 20));
			t.commit();
			
			/*
			 * lets try with detached object
			 * 
			 */
//			session=sf.openSession();
//			t=session.beginTransaction();
//			Person p=new Person("name2",35);
//			session.persist(p);
//			t.commit();
//			session.close();
			
			/*
			 *  now person object is detached from session
			 *  now we are trying to store detached object with save() and persist().
			 *  if you observe person object it is persistent which means object is already stored in db
			 *  we can confirm that by checking primary key column
			 *  If primary key is not empty then it is persistent. 
			 *  If you tried to store the persistent record using persist()
			 *  then we will get below exception
			 *  org.hibernate.PersistentObjectException: detached entity passed to persist: com.hibernate.Person
			 *  if you try the same with save() it will allow you to store it as new record in database
			 *  which will duplicate the data
			 *  So it is better to choose persist() to save the record into database
			 */
			
//			session=sf.openSession();
//			t=session.beginTransaction();
			
			
			//Person p1=new Person("name2",35);
			//p.setPrsnId(0);
			//session.persist(p1);
			
//			session.update(p);
//			t.commit();
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			session.close();
		}

	}

}
