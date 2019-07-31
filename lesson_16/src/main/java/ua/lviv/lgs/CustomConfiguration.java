package ua.lviv.lgs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfiguration {
	
	@Bean(name = "student")
	public Student getStudent() {
		Student student = new Student();
		student.setId(1);
		student.setName("Max");
		student.setAge(43);
		return student;
	}

	@Bean(name = "studentDao")
	public StudentDao getStudentDao() {
		return new StudentDaoImpl();
	}
	
	@Bean(name = "consoleEventLogger")
	public ConsoleEventLogger getConsoleEventLogger() {
		return new ConsoleEventLogger();
	}

}
