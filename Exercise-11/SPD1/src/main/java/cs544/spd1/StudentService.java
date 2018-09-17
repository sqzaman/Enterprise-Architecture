package cs544.spd1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//@Service
public class StudentService {
	@Autowired
	private StudentDao studentdao;
//	private static SessionFactory sf = HibernateUtil.getSessionFactory();

	public void setStudentdao(StudentDao studentdao) {
		//this.studentdao = studentdao;
	}

	@Transactional
	public Student getStudent(long studentid) {
		//Transaction tx = sf.getCurrentSession().beginTransaction();
		Student student = studentdao.findById(studentid).orElse(null);
		//Hibernate.initialize(student.getCourselist());
		//tx.commit();
		return student;
	}
}
