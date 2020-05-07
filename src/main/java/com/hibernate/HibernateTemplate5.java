package com.hibernate;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
//import org.hibernate.boot.Metadata;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.service.ServiceRegistry;

import com.hibernate.relationships.onetomany.bidirec.Customer;
import com.hibernate.relationships.onetomany.bidirec.PaymentMethod;

public class HibernateTemplate5 {
	
	//private static ServiceRegistry serviceRegistry;
	 private static SessionFactory sessionFactory;

	static {
		// Create registry
        
	}
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory==null) {
//			 Configuration configuration = new Configuration();
//			 configuration.configure();
//			 serviceRegistry = new StandardServiceRegistryBuilder()
//	                    .applySettings(configuration.getProperties()).build();
//
//			 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
			
//			 StandardServiceRegistryBuilder registryBuilder = 
//			            new StandardServiceRegistryBuilder();
//			 Map<String, String> settings = new HashMap<>();
//		        settings.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
//		        settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/sessiontest");
//		        settings.put("hibernate.connection.username", "root");
//		        settings.put("hibernate.connection.password", "pirati23");
//		        settings.put("hibernate.show_sql", "true");
//		        settings.put("hibernate.hbm2ddl.auto", "validate");
//		        
//		        registryBuilder.applySettings(settings);
//		        serviceRegistry = registryBuilder.build();
//		        
//		        MetadataSources sources = new MetadataSources(serviceRegistry)
//		                .addAnnotatedClass(Customer.class)
//		                .addAnnotatedClass(PaymentMethod.class);
//		        
//		        Metadata metadata = sources.getMetadataBuilder().build();
//		        sessionFactory = metadata.getSessionFactoryBuilder().build();
		}
		
		return sessionFactory;
	}
	
	 public static void shutdown() {
//		    if (serviceRegistry != null) {
//		      StandardServiceRegistryBuilder.destroy(serviceRegistry);
//		    }
	 }

}
