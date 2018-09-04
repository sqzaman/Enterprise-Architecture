import mscs.mum.edu.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;


public class AppBook {
    private static final EntityManagerFactory emFactoryObj;
    private static final String PERSISTENCE_UNIT_NAME = "JPADemo";

    static {
        emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    // This Method Is Used To Retrieve The 'EntityManager' Object
    public static EntityManager getEntityManager() {
        return emFactoryObj.createEntityManager();
    }


    public static void main(String[] args) throws Exception {

        EntityManager entityMgr = getEntityManager();
        entityMgr.getTransaction().begin();


        // Create new instance of Book and set values in it
            Book book1 = new Book("Intro to Java", "9863740", "Paul Deitel", 40, new Date());


            // Create new instance of Book and set values in it
            Book book2 = new Book("Intro to Java FP", "9867840", "Harvey Deitel", 60, new Date());

            // Create new instance of Book and set values in it
            Book book3 = new Book("Intro to Java Algo", "2567840", "T. H Coreman", 20, new Date());
        entityMgr.getTransaction().commit();

        entityMgr.clear();
        System.out.println("Record Successfully Inserted In The Database");


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
