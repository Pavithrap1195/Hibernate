package com.xworkz.mobile.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.mobile.entity.MobileEntity;
import com.xworkz.sessionfactory.SessionFactoryProvider;

public class MobileDAOImpl implements MobileDAO {

	// singleton session factory

	@Override
	public void saveMobileEntity() {

		System.out.println("Invoked saveMobileEntity()");
		SessionFactory sessionFactory = null;
		Transaction transaction = null;// Used in only insert,update and delete bcoz to change any thing we need
										// transaction
		Session session = null;
		try {
			// step1 bootstrap the hibernate framework
			// Configuration configuration = new Configuration();
			// step2 to parse hibernate.cfg.xml
			// configuration.configure("hibernate.cfg.xml");
			// step3 read metadata from annotations which are associated with entity class
			// configuration.addAnnotatedClass(MobileEntity.class);//This can be one way
			// another way is through mapping in hibernate.cfg.xml file
			// step 4 to configuration use mappings and properties to create session factory
			// establishes connection with sql which internally request DriverManager

			// Above all steps can be done by making class as singleton class and using
			// SessionFactoryProvider class as a singleton class and creating object only
			// once
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();

			MobileEntity mobileEntity = new MobileEntity("Oneplus5", 50000.00, "128GB", "Black", 128.00, true,
					"Android");

			transaction = session.beginTransaction();// bcoz autocommit is false in hibernate by default so we make
														// begin transaction
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
		SessionFactory sessionFactory = null;
		Session session = null;

		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();
			MobileEntity mobileEntity = session.get(MobileEntity.class, 1);

			System.out.println("Read is done " + mobileEntity);

		} catch (HibernateException e) {
			System.out.println("Inside catch block");
		} finally {
			if (sessionFactory != null) {
				sessionFactory.close();
				System.out.println("session factory closed");
			} else {
				System.out.println("session factory not closed");
			}
			if (session != null) {
				session.close();
				System.out.println("session closed");
			} else {
				System.out.println("session not closed");
			}
		}

	}

	@Override
	public void updateMobileEntity() {
		System.out.println("Invoked updateMobileEntity()");
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;

		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();
			MobileEntity mobileEntity = session.get(MobileEntity.class, 2);
			System.out.println("Mobile Entity " + mobileEntity);

			mobileEntity.setMobileBrand("Realme");
			mobileEntity.setColor("white");
			mobileEntity.setMobilePrice(35000.00);

			transaction = session.beginTransaction();

			session.update(mobileEntity);

			transaction.commit();

			System.out.println("Updated");

		} catch (HibernateException e) {
			transaction.rollback();
		} finally {
			if (sessionFactory != null) {
				sessionFactory.close();
				System.out.println("session factory closed");
			} else {
				System.out.println("session factory not closed");
			}
			if (session != null) {
				session.close();
				System.out.println("session closed");
			} else {
				System.out.println("session not closed");
			}
		}
	}

	@Override
	public void deleteMobileEntity() {
		System.out.println("Invoked deleteMobileEntity()");
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;

		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();
			MobileEntity mobileEntity = session.get(MobileEntity.class, 2);
			System.out.println("MobileEntity " + mobileEntity);

			transaction = session.beginTransaction();
			session.delete(mobileEntity);

			transaction.commit();

			System.out.println("Deleted");
		} catch (HibernateException e) {
			transaction.rollback();
		} finally {
			if (sessionFactory != null) {
				sessionFactory.close();
				System.out.println("Session factory is closed");
			} else {
				System.out.println("Session factory is not closed");
			}
			if (session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");
			}

		}
	}

	@Override
	public void getAllMobileEntity() {
		System.out.println("invoked getAllMobileEntity()");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();

			String hqlQuery = "from MobileEntity";
			Query query = session.createQuery(hqlQuery);
			List listOfMobileEntity = query.list();
			System.out.println(listOfMobileEntity);
		} catch (HibernateException e) {
			System.out.println("Inside catch block");
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.out.println("session is not closed");
			}
		}

	}

	@Override
	public void getMobileBrandById() {

		System.out.println("Invoked getMobileBrandById()");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();

			String hqlQuery = " select mobileBrand from MobileEntity where mobileId=3";

			Query query = session.createQuery(hqlQuery);
			Object object = query.uniqueResult();
			String mobileBrand = (String) object;
			System.out.println(mobileBrand);

		} catch (HibernateException e) {
		} finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}
		}

	}

	@Override
	public void getMobileEntityById() {

		System.out.println("Invoked getMobileEntityById()");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();

			String hqlQuery = "from MobileEntity where mobileId=4";

			Query query = session.createQuery(hqlQuery);
			Object object = query.uniqueResult();

			System.out.println("MobileEntity" + object);

		} catch (HibernateException e) {
		} finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}
		}

	}

	public void updateById() {

		System.out.println("Invoked updateById()");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			String hqlQuery = "update MobileEntity set mobilePrice=85000 where mobileId=6";

			Query query = session.createQuery(hqlQuery);
			int update = query.executeUpdate();
			session.getTransaction().commit();
			System.out.println(update);

		} catch (HibernateException e) {
			System.out.println("inside catch block");
			session.getTransaction().rollback();
			System.out.println("transaction has been rolled back");
		} finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}
		}

	}

	@Override
	public void deleteById() {

		System.out.println("Invoked deleteById()");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			String hqlQuery = "delete from MobileEntity where mobileId=6";

			Query query = session.createQuery(hqlQuery);
			int delete = query.executeUpdate();
			session.getTransaction().commit();
			System.out.println(delete);

		} catch (HibernateException e) {
			System.out.println("inside catch block");
			session.getTransaction().rollback();
			System.out.println("transaction has been rolled back");
		} finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}
		}

	}

	@Override
	public void saveMobileEntity(MobileEntity mobileEntity) {
		System.out.println("Invoked saveMobileEntity()");
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;

		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(mobileEntity);
			transaction.commit();
			System.out.println("Data Saved Successfully");
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
	public void getMobileBrandByPrice(double mobilePrice) {
		System.out.println("Invoked getMobileBrandByPrice()");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();

			String hqlQuery = "select mobileBrand from MobileEntity where mobilePrice='" + mobilePrice + "'";
			Query query = session.createQuery(hqlQuery);
			Object object = query.uniqueResult();
			String mobileName = (String) object;
			System.out.println(mobileName);

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
	public void updateMobilePriceByColor(String color) {
		System.out.println("Invoked updateMobilePriceByColor()");
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			String hqlQuery = "update MobileEntity set mobilePrice=65000.00 where color='" + color + "'";
			Query query = session.createQuery(hqlQuery);
			int update = query.executeUpdate();
			session.getTransaction().commit();
			System.out.println(update);

		} catch (HibernateException e) {
			System.out.println("Inside catch block");
			session.getTransaction().rollback();
			System.out.println("Transaction has been rolled back");
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
	public void updateMobileCameraInPixelByName(String mobileName) {
		System.out.println("Invoked updateMobileCameraInPixelByName()");
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			String hqlQuery = "update MobileEntity set cameraInPixel=64.00 where mobileBrand='" + mobileName + "'";
			Query query = session.createQuery(hqlQuery);
			int update = query.executeUpdate();
			session.getTransaction().commit();
			System.out.println(update);

		} catch (HibernateException e) {
			session.getTransaction().rollback();
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
	public void getMobileBrandByostype(String ostype) {
		System.out.println("Invoked getMobileBrandByostype()");
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			String hqlQuery = "select mobileBrand from MobileEntity where ostype='" + ostype + "'";
			Query query = session.createQuery(hqlQuery);
			Object object = query.uniqueResult();
			String mobileBrand = (String) object;
			System.out.println(mobileBrand);

		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");
			}
		}

	}

}
