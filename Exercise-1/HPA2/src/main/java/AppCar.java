import mscs.mum.edu.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AppCar {

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


            // Create new instance of Car and set values in it
            Car car1 = new Car("BMW", "SDA231", 30221.00);
            // save the car

            // Create new instance of Car and set values in it
            Car car2 = new Car("Mercedes", "HOO100", 4088.00);
            // save the car

        entityMgr.getTransaction().commit();

        entityMgr.clear();
        System.out.println("Record Successfully Inserted In The Database");



    }
}

