package com.xworkz.store.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xworkz.sessionfactory.SessionFactoryProvider;
import com.xworkz.store.entity.PlayStoreEntity;

public class PlayStoreDAOImpl implements PlayStoreDAO {

	@Override
	public void savePlayStoreEntity(PlayStoreEntity playStoreEntity) {
		System.out.println("Invoked savePlayStoreEntity()");
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;

		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(playStoreEntity);
			transaction.commit();
			System.out.println("Data saved successfully");
		} catch (HibernateException e) {
			System.out.println("Inside catch block");
			transaction.rollback();
			System.out.println("Transaction rolled back");
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");
			}
		}

	}

	@Override
	public void updateSizeById(int applicationId, int sizeInMb) {
		System.out.println("Invoked updateSizeById()");
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query query = session.getNamedQuery("updateSizeById");
			query.setParameter("ApplicationId", applicationId);
			query.setParameter("Size", sizeInMb);

			int noOfRowsAffected = query.executeUpdate();
			session.getTransaction().commit();
			System.out.println("noOfRowsAffected " + noOfRowsAffected);
			SessionFactoryProvider.closeSessionFactory();

		} catch (HibernateException e) {
			System.out.println("Inside catch block");
			session.getTransaction().rollback();
			System.out.println("Transaction rolled back");
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");
			}
		}
	}

	@Override
	public void updateRatingByName(double ratedInStar, String name) {
		System.out.println("Invoked updateRatingByName()");
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;

		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query query = session.getNamedQuery("updateRatingByName");
			query.setParameter("Rating", ratedInStar);
			query.setParameter("ApplicationName", name);
			int rows = query.executeUpdate();
			session.getTransaction().commit();
			System.out.println("rows " + rows);
			SessionFactoryProvider.closeSessionFactory();
		} catch (HibernateException e) {
			System.out.println("Inside catch block");
			session.getTransaction().rollback();
			System.out.println("Transaction rolled back");
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");
			}
		}

	}

	@Override
	public void getTypeByName(String applicationName) {
		System.out.println("Invoked getTypeByName()");
		SessionFactory sessionFactory = null;
		Session session = null;

		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();

			Query query = session.getNamedQuery("getTypeByName");
			query.setParameter("ApplicationName", applicationName);
			Object object = query.uniqueResult();
			System.out.println("Type :- " + object);
			SessionFactoryProvider.closeSessionFactory();
		} catch (HibernateException e) {

		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");

			}
		}

	}

	@Override
	public void getPlayStoreEntityByRating(double ratedInStar) {
		System.out.println("Invoked getPlayStoreEntityByRating()");
		SessionFactory sessionFactory = null;
		Session session = null;

		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();
			Query query = session.getNamedQuery("getPlayStoreEntityByRating");
			query.setParameter("Rating", ratedInStar);
			Object object = query.uniqueResult();
			System.out.println("PlayStoreEntity :- " + object);
			SessionFactoryProvider.closeSessionFactory();

		} catch (HibernateException e) {

		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");
			}
		}
	}

	@Override
	public void maxRatingOfPlayStoreEntity() {
		System.out.println("Invoked maxRatingOfPlayStoreEntity()");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();
			Query query = session.getNamedQuery("maxRatingOfPlayStoreEntity");
			
			Object object = query.uniqueResult();
			System.out.println("Max Rating:- " + object);
			SessionFactoryProvider.closeSessionFactory();
		} catch (HibernateException e) {

		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");
			}
		}

	}
	
	@Override
	public void deleteById(int applicationId) {
		System.out.println("Invoked deleteById()");
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction transaction=null;
		
		try {
			sessionFactory=SessionFactoryProvider.getSessionFactory();
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			Query query=session.getNamedQuery("deleteById");
			query.setParameter("ApplicationId", applicationId);
			int rows = query.executeUpdate();
			session.getTransaction().commit();
			System.out.println("Rows:- "+ rows);
			SessionFactoryProvider.closeSessionFactory();
			
		}catch(HibernateException e) {
			System.out.println("Inside catch block");
			session.getTransaction().rollback();
			System.out.println("Transaction rolled back");
		}finally {
			if(session!=null) {
				session.close();
				System.out.println("Session is closed");
			}else {
				System.out.println("Session is not closed");
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
