package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateTemplate43 {

	private static SessionFactory sf=null;
	
	private HibernateTemplate43() {
		
	}
	
	static {
//		Configuration cfg=new Configuration();
//		cfg.configure();
//		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
//		builder.applySettings(cfg.getProperties());
//		sf=cfg.buildSessionFactory(builder.build());
	}

	public static SessionFactory getSessionFactory() {
		return sf;
	}
	
	public static void closeSession(Session session) {
		session.close();
	}

}
