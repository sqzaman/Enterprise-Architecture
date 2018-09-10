package cs544.hap2;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentService {
	private StudentDAO studentdao;
	private SessionFactory sf = HibernateUtil.getSessionFactory();
	public StudentService() {
		studentdao = new StudentDAO();
	}

	public Student getStudent(long studentid) {
		Transaction tx = sf.getCurrentSession().beginTransaction();
		Student st = studentdao.get(studentid);
		Hibernate.initialize(st.getCourselist());
		tx.commit();
		return st;

	}
}
