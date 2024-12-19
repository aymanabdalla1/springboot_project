package net.javaguides.springboot_rest_api.controller;

import net.javaguides.springboot_rest_api.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    // Spring Boot REST API with Path Variable
    // {id} = URI template variable
    // http://localhost:8080/students/1
    @GetMapping("/students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){
        return new Student(studentId, firstName, lastName);
    }

    // Spring Boot REST API with Request Param
    // http://localhost:8080/students/query?id=1&firstName=Ayman&lastName=Abdalla
    @GetMapping("/students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        return new Student(id, firstName, lastName);
    }

    // Spring Boot REST handles HTTP POST Request
    // @PostMapping and @RequestBody
    // http://localhost:8080/students/create
    @PostMapping("/students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    // Spring Boot REST API handles HTTP PUT Request
    @PutMapping("/students/{id}/update")
    @ResponseStatus(HttpStatus.OK)
    public Student updateStudent(@PathVariable("id") int studentId, @RequestBody Student student){
        student.setId(studentId);
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }
}
