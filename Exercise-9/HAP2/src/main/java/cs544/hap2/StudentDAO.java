package cs544.hap2;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;

@Transactional()
public class StudentDAO {
	
	private SessionFactory sf;
	@Transactional()
	public void setSessionFactory(SessionFactory sf) {
		this.sf = sf;
	}

	public void create(Student student) {
		sf.getCurrentSession().persist(student);
	}
	public Student get(Long id) {
		return (Student) sf.getCurrentSession().get(Student.class, id);
	}
	public void update(Student student) {
		sf.getCurrentSession().saveOrUpdate(student);
	}
	public void delete(Student student) {
		sf.getCurrentSession().delete(student);
	}
	
	
}
