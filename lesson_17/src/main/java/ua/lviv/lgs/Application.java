package ua.lviv.lgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ua.lviv.lgs.domain.University;
import ua.lviv.lgs.service.UniversityService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		UniversityService service = ctx.getBean(UniversityService.class);
		
		University firstUniversity =  new University();
		firstUniversity.setName("Economical");
		firstUniversity.setNumberOfInstitutes(5);
		firstUniversity.setNumberOfStudents(5942);
		firstUniversity.setAccreditationLevel(4);
		firstUniversity.setAddress("nice address");
		
		service.save(firstUniversity);
		
		University secondUniversity =  new University();
		secondUniversity.setName("Medical");
		secondUniversity.setNumberOfInstitutes(3);
		secondUniversity.setNumberOfStudents(15942);
		secondUniversity.setAccreditationLevel(3);
		secondUniversity.setAddress("other address");
		
		service.save(secondUniversity);
		
		University thirdUniversity =  new University();
		thirdUniversity.setName("Pedagogical");
		thirdUniversity.setNumberOfInstitutes(13);
		thirdUniversity.setNumberOfStudents(18674);
		thirdUniversity.setAccreditationLevel(4);
		thirdUniversity.setAddress("good address");
		
		service.save(thirdUniversity);
		
		University fourthUniversity =  new University();
		fourthUniversity.setName("Technical");
		fourthUniversity.setNumberOfInstitutes(7);
		fourthUniversity.setNumberOfStudents(9865);
		fourthUniversity.setAccreditationLevel(3);
		fourthUniversity.setAddress("some address");
		
		service.save(fourthUniversity);
		
		University fifthUniversity =  new University();
		fifthUniversity.setName("National");
		fifthUniversity.setNumberOfInstitutes(12);
		fifthUniversity.setNumberOfStudents(30574);
		fifthUniversity.setAccreditationLevel(4);
		fifthUniversity.setAddress("simple address");
		
		service.save(fifthUniversity);
		
		System.out.println(service.findById((long)3));
		System.out.println("-------------------------------------");
		
		System.out.println(service.findByName("Economical"));
		System.out.println("-------------------------------------");
		System.out.println(service.findByAddress("some address"));
		System.out.println("-------------------------------------");
		
		University universityToUpdate = service.findById((long)1);
		universityToUpdate.setAccreditationLevel(5);
		universityToUpdate.setNumberOfStudents(500);
		service.update(universityToUpdate);
		
		service.findAll().stream().forEach(System.out::println);
		
		System.out.println("-------------------------------------");
		
		service.deleteById((long)5);
		
		service.findAll().stream().forEach(System.out::println);
	}

}
