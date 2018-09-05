package mscs.mum.edu.f;

import mscs.mum.edu.f.Department;
import mscs.mum.edu.f.Employee;
import mscs.mum.edu.f.Office;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


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
		Session session = null;
		Transaction tx = null;
		try {

			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			// Create Departments

			Department d1 = new Department("HR");
			Department d2 = new Department("Sales");
			Department d3 = new Department("Marketting");

			session.persist(d1);
			session.persist(d2);
			session.persist(d3);

			// Create Office
			Office o1 = new Office("Build A");
			Office o2 = new Office("Build B");
			Office o3 = new Office("Build C");

			session.persist(o1);
			session.persist(o2);
			session.persist(o3);

			Employee emp1 = new Employee("Syed Quamruzzaman", d1, o1);
			Employee emp2 = new Employee("Samiul Jahan", d2, o1);
			Employee emp3 = new Employee("Ali Yilmaz", d3, o1);
			session.persist(emp1);
			session.persist(emp2);
			session.persist(emp3);
			
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
