package mscs.mum.edu.e;

import mscs.mum.edu.e.Customer;
import mscs.mum.edu.d.Reservation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.text.SimpleDateFormat;


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

			// Create Book
            Book book1 = new Book("14789863", "Intro Algo", "T H Coreman");
            book1.addReservation(r1);
            book1.addReservation(r2);
            book1.addReservation(r3);
            session.persist(book1);

            tx.commit();


			// Load the book
			session = sessionFactory.openSession();
			@SuppressWarnings("unchecked")
			Book book = session.get(Book.class, 5);

			// Load reservations
			System.out.println("Book Reservations = " + book.getTitle());
			for (Reservation reserve: book.getReservations()) {
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
