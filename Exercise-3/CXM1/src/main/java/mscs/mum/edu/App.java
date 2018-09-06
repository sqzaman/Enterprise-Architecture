package mscs.mum.edu;


import java.util.List;
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

            // Create Patient
            Patient p1 = new Patient("Syed Quamruzzaman", "2000 N Court St 20A", "52556", "Fairfield");

            // Create Doctor
            Doctor d1 = new Doctor("Child Specialist", "Rafael", "Nadal");
            
            Payment payment = new Payment("12/12/2009", 2000);
            
            Appointment ap = new Appointment("12/12/2009", p1, d1, payment);
            
            session.persist(ap);
            
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
			List<Appointment> appointments = session.createQuery("from Appointment").list();
			for (Appointment a : appointments) {
				System.out.println("Appointment Date: " + a.getAppdate() + ", Doctor: " + a.getDoctor().getFirstname() + 
						",  Patient: " + a.getPatient().getName() + " Patient Address:" + a.getPatient().getStreet() + ", " +
						a.getPatient().getZip() + ", " + a.getPatient().getCity() +
						" Patient has paid: $" + a.getPayment().getAmount() + " on: " + a.getPayment().getPaydate()
						);
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

