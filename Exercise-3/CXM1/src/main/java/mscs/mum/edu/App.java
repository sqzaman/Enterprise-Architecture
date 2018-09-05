package mscs.mum.edu;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


/**
 * Hello world!
 *
 */
public class App {
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

		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();

		

			session.getTransaction().commit();
		}

		
		tearDown();
	}
}
