import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class App {
    private static EntityManagerFactory entityManagerFactory;
    protected static void setUp() throws Exception{
        entityManagerFactory = Persistence.createEntityManagerFactory("META-INF/persistence.xml");
    }
    public static EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }
    public static void main(String[] args) throws Exception {
        setUp();
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        //Creating employee and laptop instance
        Employee employee1 = new Employee("Ali","Yilmaz");
        Laptop laptop1 = new Laptop("HP","gaming",employee1);
        Laptop laptop2 = new Laptop("Monster","Gaming",employee1);
        //Persists employee and laptop instances
        entityManager.persist(employee1);
        entityManager.persist(laptop1);
        entityManager.persist(laptop2);
        //Creatin instances
        Passenger passenger = new Passenger("Ali");
        Passenger passenger2 = new Passenger("Syed");
        Flight flight = new Flight("h2o","Istanbul","Chicago", LocalDate.of(2018,12,12),passenger);
        //Persisting them
        entityManager.persist(passenger);
        entityManager.persist(passenger2);
        entityManager.persist(flight);
        //Creating Instances
        School school = new School("Maharishi University of Management");
        Student student1 = new Student(986213,"Ali","Yilmaz");
        Student student2 = new Student(986666,"Syed","Quamruzzaman");
        //Persisting them
        entityManager.persist(school);
        entityManager.persist(student1);
        entityManager.persist(student2);

        entityManager.getTransaction().commit();
        entityManager.clear();
        System.out.println("Record Successfully Inserted In The Database");
    }
}
