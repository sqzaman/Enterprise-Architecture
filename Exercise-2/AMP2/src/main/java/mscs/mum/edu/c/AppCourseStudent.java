package mscs.mum.edu.c;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import mscs.mum.edu.b.Book;
import mscs.mum.edu.b.Publisher;

public class AppCourseStudent {
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


			Course course1 = new Course("CS-501", "Software Architecture");
			Course course2 = new Course("CS-502", "Software Engineering");
			Course course3 = new Course("CS-503", "Software Security");
			Course course4 = new Course("CS-504", "Software Elements");
			
			Student student1 = new Student(984811, "Syed", "Quamruzzaman");
			Student student2 = new Student(984812, "Samiul", "Jahan");
			Student student3 = new Student(984813, "Ali", "Yilmaz");
			Student student4 = new Student(984814, "Yousuf", "Abdullah");
			Student student5 = new Student(984815, "Abdullah", "Ali");
			Student student6 = new Student(984816, "Omer", "Bin Khattab");
			Student student7 = new Student(984817, "Ubaya", "Umer");
			
			student1.addCourse(course1);
			student1.addCourse(course3);
			
			student2.addCourse(course1);
			student2.addCourse(course4);
			
			student3.addCourse(course1);
			student3.addCourse(course3);
			student3.addCourse(course4);
			
			student4.addCourse(course1);
			student4.addCourse(course3);
			student4.addCourse(course4);
			
			student5.addCourse(course1);
			student5.addCourse(course2);
			student5.addCourse(course4);
			
			student6.addCourse(course1);
			student6.addCourse(course2);
			student6.addCourse(course3);
			
			student7.addCourse(course1);
			student7.addCourse(course3);
	
			session.persist(student1);			
			session.persist(student2);
			session.persist(student3);
			session.persist(student4);
			session.persist(student5);
			session.persist(student6);
			session.persist(student7);
			
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

			// retrieve all courses
			@SuppressWarnings("unchecked")
			List<Course> courses = session.createQuery("from Course").list();
			for (Course c : courses) {
				System.out.println("Course: " + c.getCourseNumber() + ": "+ c.getName() +", Total Enrolled Student: " + c.getStudents().size());
			}
			
			// retrieve all students
			@SuppressWarnings("unchecked")
			List<Student> students = session.createQuery("from Student").list();
			for (Student s : students) {
				System.out.println("Student: " + s.getStudentId() + ": "+ s.getFirstName() + " " + s.getLastName() + ", Total Enrolled courses: " + s.getCourses().size());
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
