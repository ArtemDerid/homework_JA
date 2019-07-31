package ua.lviv.lgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		Student someStudent = new Student();
		someStudent.setId(2);
		someStudent.setName("Sam");
		someStudent.setAge(23);

		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		Student student = (Student) ctx.getBean("student");
		StudentDao studentDao = (StudentDao) ctx.getBean("studentDao");
		ConsoleEventLogger consoleEventLogger = (ConsoleEventLogger) ctx.getBean("consoleEventLogger");

		consoleEventLogger.logEvent("CREATE first student ---> " + studentDao.create(student).toString());
		consoleEventLogger.logEvent("CREATE second student ---> " + studentDao.create(someStudent).toString());
		consoleEventLogger.logEvent("READ_ALL from listOfStudents ---> " + studentDao.readAll());
		consoleEventLogger.logEvent("READ from listOfStudents ---> " + studentDao.read(1).toString());
		consoleEventLogger.logEvent("UPDATE student ---> " + studentDao.update(someStudent, "Pit", 18).toString());
		consoleEventLogger.logEvent("DELETE from listOfStudents ---> " + studentDao.delete(someStudent, 1).toString());
		consoleEventLogger.logEvent("READ_ALL from listOfStudents ---> " + studentDao.readAll());

	}

}
