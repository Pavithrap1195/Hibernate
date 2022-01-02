package com.xworkz.sessionfactory;

import java.sql.Connection;
import java.util.Objects;
import java.util.Collections;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class SessionFactoryProvider {
	
			private static SessionFactory sessionFactory = null;
		static {
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			
		}
		public static SessionFactory getSessionFactory() {
			System.out.println("Invoked getSessionFactory");
			if(Objects.nonNull(sessionFactory)) {
				return sessionFactory;
			}
			else {
				System.out.println("SessionFactory is not created");
				return sessionFactory;
			}
	}
		public static void closeSessionFactory() {
			System.out.println("Invoked closeSessionFactory");
			try {
				if(sessionFactory!=null) {
					sessionFactory.close();
				}else {
					System.out.println("");
				}
				
			} catch (Exception e) {
				
			}
		}
//		
//public static void main(String[] args) {
//	
//	SessionFactory sessionFactory= getSessionFactory();
//	System.out.println(sessionFactory.hashCode());
//	closeSessionFactory();
	
	
	
	


}
