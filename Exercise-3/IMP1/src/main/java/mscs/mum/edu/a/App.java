package mscs.mum.edu.a;

<<<<<<< HEAD
import java.util.List;



=======
>>>>>>> 5076be259cddc9a3d54d0e1f06ecf483d90440b0
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

<<<<<<< HEAD
import mscs.mum.edu.b.Book;
import mscs.mum.edu.b.CD;
import mscs.mum.edu.b.Customer;
import mscs.mum.edu.b.DVD;
import mscs.mum.edu.b.Order;
import mscs.mum.edu.b.OrderLine;

=======
import java.util.Date;
>>>>>>> 5076be259cddc9a3d54d0e1f06ecf483d90440b0

/**
 * Hello world!
 *
 */
<<<<<<< HEAD
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
			book1.setName("Academic book 2");
			book1.setDescription("Academic book2 description");
			
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
=======
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

            // Create Products

            Product p1 = new Product("Washing Machine", "Washing Machine with dryer");
            Product p2 = new Product("HP ProBook 2018", "Laptop for business users");
            Product p3 = new Product("I Phone X", "Mobile phone by Apple");
            Product p4 = new Product("Backpack", "Bag for carrying books and laptop");
            Product p5 = new Product("MacBook Pro", "MackBook by Apple, 2018 Model");
            Product p6 = new Product("I pad Air 3 ", "New Tablet from Apple");
            Product p7 = new Product("I Mac", "Desktop from Apple");


            session.persist(p1);
            session.persist(p2);
            session.persist(p3);
            session.persist(p4);
            session.persist(p5);
            session.persist(p6);
            session.persist(p7);

            // Create OrderLine

            OrderLine ol1 = new OrderLine(1);
            ol1.setProduct(p1);
            ol1.setProduct(p2);
            ol1.setProduct(p3);

            OrderLine ol2 = new OrderLine(2);
            ol2.setProduct(p4);
            ol2.setProduct(p5);

            OrderLine ol3 = new OrderLine(1);
            ol3.setProduct(p6);
            ol3.setProduct(p7);

            session.persist(ol1);
            session.persist(ol2);
            session.persist(ol3);

            // Create Orders

            Order order1 = new Order(new Date());
            order1.addOrderLine(ol1);
            order1.addOrderLine(ol2);

            Order order2 = new Order(new Date());
            order2.addOrderLine(ol3);

            session.persist(order1);
            session.persist(order2);


            // Create Customer

            Customer customer1 = new Customer("Samiul", "Jahan");

            customer1.addOrder(order1);
            customer1.addOrder(order2);

            session.persist(customer1);


            //Load Customer
            Customer customer = session.get(Customer.class, 13);

            System.out.println("Customer = " + customer.getFirstName() + " " + customer.getLastName());

            // Orders
            System.out.println("Orders = ");
            int i = 0;
            for (Order ord: customer.getOrders()) {
                System.out.println("Order # " + ++i);
                for (OrderLine ordlLine:ord.getOrderLines()) {
                    System.out.println("Product= "+ordlLine.getProduct().getName());
                    System.out.println("Quantity= " + ordlLine.getQuantity());
                }
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

>>>>>>> 5076be259cddc9a3d54d0e1f06ecf483d90440b0
}

