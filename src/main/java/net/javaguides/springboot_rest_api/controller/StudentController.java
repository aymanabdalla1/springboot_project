package net.javaguides.springboot_rest_api.controller;

import net.javaguides.springboot_rest_api.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // http://localhost:8080/student
    @GetMapping("/student")
    public Student getStudent(){
        Student student = new Student(
                1,
                "Ayman",
                "Abdalla"
        );
        return student;
    }

    // http://localhost:8080/students
    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1, "Ayman", "Abdalla"));
        students.add(new Student(2, "John", "Mounce"));
        students.add(new Student(3, "Jane", "Doe"));
        students.add(new Student(4, "John", "Smith"));
        return students;
    }
}
