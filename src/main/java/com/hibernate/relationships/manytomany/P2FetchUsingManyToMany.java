package com.hibernate.relationships.manytomany;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.HibernateTemplate4;

public class P2FetchUsingManyToMany {

	public static void main(String[] args) {
		SessionFactory sf=null;
		Session session=null;
		Transaction transaction=null;
		try {
		sf=HibernateTemplate4.getSessionFactory();
		session=sf.openSession();
		List<Channel> channels=session.createQuery("from Channel").list();
		for(Channel c:channels) {
			System.out.println(c.getChannelName());
			Set<Subscriber> subscribers=c.getSubscribers();
			subscribers.forEach(s->System.out.println(s.getName()));
		}
		}catch (Exception e) {
			// TODO: handle exception
		}

	}

}
