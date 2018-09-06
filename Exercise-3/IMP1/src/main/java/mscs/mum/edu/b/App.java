package mscs.mum.edu.b;

import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import mscs.mum.edu.b.Book;
import mscs.mum.edu.b.CD;
import mscs.mum.edu.b.Customer;
import mscs.mum.edu.b.DVD;
import mscs.mum.edu.b.Order;
import mscs.mum.edu.b.OrderLine;


/**
 * Hello world!
 *
 */
public class App 
{
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
			Customer c1 = new Customer("Syed", "Quamruzzaman");
			Customer c2 = new Customer("Samiul", "Jahan");
			Customer c3 = new Customer("Ali", "Yilmaz");

			session.persist(c1);
			session.persist(c2);
			session.persist(c3);
			
			Book book1 = new Book("Book 1");
			book1.setName("Academic book");
			book1.setDescription("Academic book description");
			
			Book book2 = new Book("Book 2");
			book2.setName("Academic book 2");
			book2.setDescription("Academic book2 description");
			
			session.persist(book1);
			session.persist(book2);

			
			DVD dvd1 = new DVD("Family");
			dvd1.setName("Family Genre DVD");
			dvd1.setDescription("Family Genre DVD Description");
			
			DVD dvd2 = new DVD("Romantic");
			dvd2.setName("Romantic Genre DVD");
			dvd2.setDescription("Romantic Genre DVD Description");
			
			session.persist(dvd1);
			session.persist(dvd2);
			
			CD cd1 = new CD("Madona");
			cd1.setName("Madona's CD");
			cd1.setDescription("Madona's CD Description");
			
			CD cd2 = new CD("Martin");
			cd2.setName("Martin's CD");
			cd2.setDescription("Martin's CD Description");
			
			session.persist(cd1);
			session.persist(cd2);
			
			OrderLine ol1 = new OrderLine(book1, 1);
			OrderLine ol2 = new OrderLine(dvd1, 1);
			OrderLine ol3 = new OrderLine(cd1, 1);
			
			Order order = new Order();
			order.addOrderLine(ol1);
			order.addOrderLine(ol2);
			order.addOrderLine(ol3);
			order.setCustomer(c1);
			session.persist(order);
			
					
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
			List<Order> orders = session.createQuery("from Order").list();
			for (Order o : orders) {
				System.out.println("Order: " + o.getOrderId() + ", Customer: " + o.getCustomer().getFirstName() + ",  Total Items: " + o.getOrderLines().size());
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