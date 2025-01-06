package net.javaguides.ems_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmsBackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(EmsBackendApplication.class, args);
		Student student = new Student();
		student.setId(1);
		student.setName("Ayman");
		student.setEmail("ayman@gmail.com");

		System.out.println(student.getId());
		System.out.println(student.getName());
		System.out.println(student.getEmail());

	}
}
