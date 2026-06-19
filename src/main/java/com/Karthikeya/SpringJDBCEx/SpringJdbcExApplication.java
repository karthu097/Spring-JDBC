package com.Karthikeya.SpringJDBCEx;

import com.Karthikeya.SpringJDBCEx.model.Student;
import com.Karthikeya.SpringJDBCEx.servi.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcExApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcExApplication.class, args);

		Student s = context.getBean(Student.class);
		s.setRollNo(7777777);
		s.setName("Thala");
		s.setMarks(7);
		StudentService service = context.getBean(StudentService.class);
		service.addStudent(s);

		List<Student> students = service.getStudent();
		System.out.println(students);
	}

}
