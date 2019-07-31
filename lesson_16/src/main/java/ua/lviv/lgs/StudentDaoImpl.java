package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao{
	
	private List<Student> listOfStudents = new ArrayList<>();

	@Override
	public Student create(Student student) {
		listOfStudents.add(student);
		return student;
	}

	@Override
	public Student read(int id) {
		Student student = listOfStudents.get(id);
		return student;
	}

	@Override
	public Student update(Student student, String name, int age) {
		listOfStudents.get(student.getId()-1);
		student.setName(name);
		student.setAge(age);
		return student;
	}

	@Override
	public Student delete(Student student, int id) {
		id = student.getId() - 1;
		listOfStudents.remove(student);
		return student;
	}

	@Override
	public List<Student> readAll() {
		return listOfStudents;
	}

}
