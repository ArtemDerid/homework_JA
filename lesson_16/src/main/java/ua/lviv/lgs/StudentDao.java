package ua.lviv.lgs;

import java.util.List;

public interface StudentDao {
	
	Student create(Student student);
	Student read(int id);
	Student update(Student student, String name, int age);
	Student delete(Student student, int id);
	List<Student> readAll();

}
