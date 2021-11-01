package com.xworkz.mobile.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.mobile.entity.MobileEntity;

public class MobileDAOImpl implements MobileDAO {

	@Override
	public void saveMobileEntity() {

		System.out.println("Invoked saveMobileEntity()");
		SessionFactory sessionFactory = null;
		Transaction transaction = null;// Used in only insert,update and delete bcoz to change any thing we need
										// transaction
		Session session = null;
		try {
			// step1 bootstrap the hibernate framework
			Configuration configuration = new Configuration();
			
			// step2 to parse hibernate.cfg.xml
			configuration.configure("hibernate.cfg.xml");
			
			// step3 read metadata from annotations which are associated with entity class
			configuration.addAnnotatedClass(MobileEntity.class);


			//step 4 to configuration use mappings and properties to create session factory
			//establishes connection with sql which internally request DriverManager
			sessionFactory = configuration.buildSessionFactory();

			 
			session = sessionFactory.openSession();

			MobileEntity mobileEntity = new MobileEntity(5, "Oneplus5", 50000.00, "128GB", "Black", 128.00, true,
					"Android");

			transaction = session.beginTransaction();// bcoz autocommit is false in hibernate by default so we make begin transaction
			session.save(mobileEntity);

			transaction.commit();

			System.out.println("Done");
		} catch (HibernateException e) {
			System.out.println("Inside catch block!!!!!!!!!!!!!");
			transaction.rollback();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}
			if (sessionFactory != null) {
				sessionFactory.close();
				System.out.println("sessionfactory is closed");
			} else {
				System.out.println("sessionFactory is not closed");
			}
		}

	}

	@Override
	public void getMobileEntity() {
		System.out.println("Invoked getMobileEntity()");
		SessionFactory sf = null;
		Session ses = null;

		try {
			Configuration con = new Configuration();

			con.configure("hibernate.cfg.xml");
			con.addAnnotatedClass(MobileEntity.class);
			sf = con.buildSessionFactory();
			ses = sf.openSession();
			MobileEntity mobileEntity = ses.get(MobileEntity.class, 1);

			System.out.println("Read is done " + mobileEntity);

		} catch (HibernateException e) {
			System.out.println("Inside catch block");
		} finally {
			if (sf != null) {
				sf.close();
				System.out.println("session factory closed");
			} else {
				System.out.println("session factory not closed");
			}
			if (ses != null) {
				ses.close();
				System.out.println("session closed");
			} else {
				System.out.println("session not closed");
			}
		}

	}
	
	@Override
	public void updateMobileEntity() {
		System.out.println("Invoked updateMobileEntity()");
		SessionFactory se = null;
		Transaction trans = null;
		Session session = null; 
		
		try {
			Configuration con = new Configuration();
			
			con.configure("hibernate.cfg.xml");
			con.addAnnotatedClass(MobileEntity.class);
			
			se=con.buildSessionFactory();
			session = se.openSession();
			MobileEntity ent = session.get(MobileEntity.class, 2);
			System.out.println("Mobile Entity "+ent);
			
			ent.setMobileBrand("Realme");
			ent.setColor("white");
			ent.setMobilePrice(35000.00);
			
			trans = session.beginTransaction();
			
			session.update(ent);
			
			trans.commit();
			
			System.out.println("Updated");
			
		}
		catch(HibernateException e) {
			trans.rollback();
		}finally {
			if(se!=null) {
				se.close();
				System.out.println("session factory closed");
			}else {
				System.out.println("session factory not closed");
			}
			if(session!=null) {
				session.close();
				System.out.println("session closed");
			}else {
				System.out.println("session not closed");
			}
		}
	}
	
	@Override
	public void deleteMobileEntity() {
		System.out.println("Invoked deleteMobileEntity()");
		SessionFactory factory = null;
		Transaction transaction = null;
		Session session = null;
		
		try {
			Configuration conf = new Configuration();
			conf.configure("hibernate.cfg.xml");
			conf.addAnnotatedClass(MobileEntity.class);
			
			factory = conf.buildSessionFactory();
			session = factory.openSession();
			MobileEntity ent = session.get(MobileEntity.class, 2);
			System.out.println("MobileEntity "+ent);
			
			transaction = session.beginTransaction();
			session.delete(ent);
			 
			transaction.commit();
			 
			System.out.println("Deleted");
		}
		catch(HibernateException e) {
			transaction.rollback();
		}
		finally {
			if(factory!=null) {
				factory.close();
				System.out.println("Session factory is closed");
			}else {
				System.out.println("Session factory is not closed");
			}
			if(session!=null) {
				session.close();
				System.out.println("Session is closed");
			}else {
				System.out.println("Session is not closed");
			}
			
		}
	}

}
