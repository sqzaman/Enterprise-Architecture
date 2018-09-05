package mscs.mum.edu.a;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Date;

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

}

