import mscs.mum.edu.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Date;
import java.util.List;


public class AppBook {
    private static SessionFactory sessionFactory;

    /* Reads hibernate.cfg.xml and prepares Hibernate for use     */
    protected static void setUp() throws Exception {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
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

            // Create new instance of Book and set values in it
            Book book1 = new Book("Intro to Java", "9863740", "Paul Deitel", 40, new Date());
            // save the book
            session.persist(book1);

            // Create new instance of Book and set values in it
            Book book2 = new Book("Intro to Java FP", "9867840", "Harvey Deitel", 60, new Date());
            // save the book
            session.persist(book2);

            // Create new instance of Book and set values in it
            Book book3 = new Book("Intro to Java Algo", "2567840", "T. H Coreman", 20, new Date());
            // save the book
            session.persist(book3);
            session.getTransaction().commit();
        }
        try (Session session  = sessionFactory.openSession()) {
            session.beginTransaction();
            new AppBook().retrieveBooks(session);
            session.getTransaction().commit();
        }

        try (Session session  = sessionFactory.openSession()) {
            session.beginTransaction();
            //Get book with id 1
            Book retrievedBook = session.get(Book.class, 1);
            System.out.println("title= " + retrievedBook.getTitle() + ", ISBN= "
                    + retrievedBook.getISBN() + ", author= " + retrievedBook.getAuthor() + ", price= " + retrievedBook.getPrice()
                    + ", publish date= " + retrievedBook.getPublish_date());

            //Set title and price
            retrievedBook.setTitle("Art of Computer Programming");
            retrievedBook.setPrice(100);

            // Delete book with id 2
            session.createQuery("delete from Book where id = 2").executeUpdate();
            session.getTransaction().commit();

        }

        try (Session session  = sessionFactory.openSession()) {
            session.beginTransaction();
            new AppBook().retrieveBooks(session);
            session.getTransaction().commit();
        }
        tearDown();

    }

    public void retrieveBooks(Session session){
        // retieve all books
        @SuppressWarnings("unchecked")
        List<Book> bookList = session.createQuery("from Book").list();
        for (Book book : bookList) {
            System.out.println("title= " + book.getTitle() + ", ISBN= "
                    + book.getISBN() + ", author= " + book.getAuthor() + ", price= " + book.getPrice()
                    + ", publish date= " + book.getPublish_date());
        }
    }
}
