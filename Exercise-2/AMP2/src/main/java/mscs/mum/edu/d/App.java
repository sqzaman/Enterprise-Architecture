package mscs.mum.edu.d;

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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


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

			// Create Reservations
			Reservation r1 = new Reservation(new SimpleDateFormat( "yyyyMMdd" ).parse( "20170520" ));
			Reservation r2 = new Reservation(new SimpleDateFormat( "yyyyMMdd" ).parse( "20170521" ));
			Reservation r3 = new Reservation(new SimpleDateFormat( "yyyyMMdd" ).parse( "20170522" ));

			session.persist(r1);
			session.persist(r2);
			session.persist(r3);

			// Create Customer

			Customer cu = new Customer("Samiul Jahan");

			cu.addReservation(r1);
			cu.addReservation(r2);
			cu.addReservation(r3);
			session.persist(cu);
			
			tx.commit();


			// Load the customer
			session = sessionFactory.openSession();
			@SuppressWarnings("unchecked")
			Customer customer = session.get(Customer.class, 4);

			// Load reservations
			System.out.println("Reservations = " + customer.getName());
			for (Reservation reserve: customer.reservations) {
				System.out.print("Date = " + reserve.getDate() + "\n");
			}

			tx = session.beginTransaction();


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
