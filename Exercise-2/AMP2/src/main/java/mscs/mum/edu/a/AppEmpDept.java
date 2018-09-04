package mscs.mum.edu.a;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



public class AppEmpDept {
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


			Department d1 = new Department("HR");
			Department d2 = new Department("Sales");
			Department d3 = new Department("Marketting");
			session.persist(d1);
			session.persist(d2);
			session.persist(d3);
			
			Employee emp1 = new Employee("Syed Quamruzzaman", d1);
			Employee emp2 = new Employee("Samiul Jahan", d2);
			Employee emp3 = new Employee("Ali Yilmaz", d3);
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
		
		try {

			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			// retrieve all persons
			@SuppressWarnings("unchecked")
			List<Employee> employees = session.createQuery("from Employee").list();
			for (Employee emp : employees) {
				System.out.println("Employee: " + emp.getName() + ", Department:" + emp.getDepartment().getName());
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
