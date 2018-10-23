package config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

@WebListener
public class Config implements ServletContextListener {

	public static SessionFactory sessionFactory;
	
	public void contextInitialized(ServletContextEvent sce) {
		
		System.out.println("Context Initialized");
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		sessionFactory = meta.getSessionFactoryBuilder().build();
		
	}

	public void contextDestroyed(ServletContextEvent sce) {

		sessionFactory.close();
		
		System.out.println("Context Destroyed");
		
	}

	
	
	
	
}
