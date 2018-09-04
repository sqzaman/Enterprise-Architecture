package edu.mum.cs.cs544;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Application {
	private static SessionFactory sessionFactory;

	static {
		// This step will read hibernate.cfg.xml and prepare hibernate for use
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(sr);
	}

	public static void main(String[] args) {
		// Hibernate placeholders
		Session session = null;
		Transaction tx = null;
		try {

			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			// retrieve all student
			List<Student> students = session.createQuery("from Student").list();
			for (Student s : students) {
				System.out.println(s.getName());
			}
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		try {

			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			// Create new instance of Student and set name in it
			Student s1 = new Student(999);
			s1.setName("Syed");
			s1.setEmail("sqzaman@gmail.com");
			s1.setPassword("123456");
			session.saveOrUpdate(s1);

			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		try {

			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			// retrieve all persons
			List<Student> students = session.createQuery("from Student").list();
			for (Student s : students) {
				System.out.println(s.getName());
			}
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		

		// Close the SessionFactory (not mandatory)
		sessionFactory.close();
	}
}