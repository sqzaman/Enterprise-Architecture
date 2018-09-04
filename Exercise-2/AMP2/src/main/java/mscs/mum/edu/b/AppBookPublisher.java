package mscs.mum.edu.b;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import mscs.mum.edu.a.Department;
import mscs.mum.edu.a.Employee;

public class AppBookPublisher {
	private static SessionFactory sessionFactory;

	/* Reads hibernate.cfg.xml and prepares Hibernate for use */
	protected static void setUp() throws Exception {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

	protected static void tearDown() throws Exception {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}

	public static void main(String[] args) throws Exception {
		setUp();
		Session session = null;
		Transaction tx = null;
		try {

			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			// retrieve all student


			Publisher p1 = new Publisher("Samrat Publisher");
			Publisher p2 = new Publisher("ISO Publisher");
			Publisher p3 = new Publisher("DMO Publisher");
			session.persist(p1);
			session.persist(p2);
			session.persist(p3);
			
			Book book1 = new Book("1234-3434-34343", "Book 1", "Syed Quamruzzaman", p1);
			Book book2 = new Book("1234-3434-56344", "Book 2", "Samiul Jahan", p2);
			Book book3 = new Book("1234-3434-45454", "Book 3", "Ali Yilmaz", p3);
			Book book4 = new Book("1234-3434-23223", "Book 4", "Rafael Nadal", null);
			
			session.persist(book1);
			session.persist(book2);
			session.persist(book3);
			session.persist(book4);
			
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

			// retrieve all books
			@SuppressWarnings("unchecked")
			List<Book> books = session.createQuery("from Book").list();
			for (Book b : books) {
				System.out.println("Book: " + b.getTitle() + ", Publisher: " + ( b.getPublisher() == null ? "": b.getPublisher().getName()));
			}
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}


		tearDown();
	}


}
