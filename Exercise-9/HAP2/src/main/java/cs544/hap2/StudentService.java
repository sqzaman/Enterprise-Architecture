package cs544.hap2;

import javax.transaction.Transactional;

public class StudentService {

	private StudentDAO studentdao;

	public StudentService() {
		studentdao = new StudentDAO();
	}
	
	public StudentDAO getStudentdao() {
		return studentdao;
	}

	public void setStudentdao(StudentDAO studentdao) {
		this.studentdao = studentdao;
	}
	@Transactional
	public Student getStudent(long studentid) {
		return studentdao.get(studentid);
	}
}
