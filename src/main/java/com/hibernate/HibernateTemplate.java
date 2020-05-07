package com.hibernate;

import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateTemplate {
	
	public static SessionFactory getSessionFactory() {
		return HibernateTemplate4.getSessionFactory();
	}
	
	 public static void shutdown() {
		// HibernateTemplate5.shutdown();
	 }

}
