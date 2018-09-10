package cs544.hap2;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.SessionFactory;

public class StudentDAO {

	private SessionFactory sf = HibernateUtil.getSessionFactory();

	public void create(Student st) {
		sf.getCurrentSession().persist(st);
	}

	public Student get(long studentid) {
		return (Student) sf.getCurrentSession().get(Student.class, studentid);
	}

	public void update(Student st) {
		sf.getCurrentSession().saveOrUpdate(st);
	}

	public void delete(Student st) {
		sf.getCurrentSession().delete(st);
	}
}
