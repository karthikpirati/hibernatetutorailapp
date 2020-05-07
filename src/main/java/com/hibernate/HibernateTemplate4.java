package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public final class HibernateTemplate4 {
	private static ServiceRegistry sr=null;
	private static SessionFactory sf=null;
	
	private HibernateTemplate4() {
		
	}
	
	static {
		Configuration cfg=new Configuration();
		cfg.configure();
		ServiceRegistryBuilder srb=new ServiceRegistryBuilder();
		srb.applySettings(cfg.getProperties());
		sr=srb.buildServiceRegistry();
		sf=cfg.buildSessionFactory(sr);
	}

	public static SessionFactory getSessionFactory() {
		return sf;
	}
	
	public static void closeSession(Session session) {
		session.close();
	}
}
