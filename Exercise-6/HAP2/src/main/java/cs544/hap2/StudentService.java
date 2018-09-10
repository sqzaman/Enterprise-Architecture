package cs544.hap2;

public class StudentService {
	private StudentDAO studentdao;

	public StudentService() {
		studentdao = new StudentDAO();
	}

	public Student getStudent(long studentid) {
		return studentdao.load(studentid);
	}
}
