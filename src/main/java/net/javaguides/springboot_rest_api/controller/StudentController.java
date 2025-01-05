package net.javaguides.springboot_rest_api.controller;

import net.javaguides.springboot_rest_api.bean.Student;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // http://localhost:8080/student
    @GetMapping("/student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(
                1,
                "Ayman",
                "Abdalla"
        );
        return ResponseEntity.ok().header("custom-header","ayman").body(student);
    }

    // http://localhost:8080/students
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1, "Ayman", "Abdalla"));
        students.add(new Student(2, "John", "Mounce"));
        students.add(new Student(3, "Jane", "Doe"));
        students.add(new Student(4, "John", "Smith"));
        return ResponseEntity.ok(students);
    }

    // Spring Boot REST API with Path Variable
    // {id} = URI template variable
    // http://localhost:8080/students/1
    @GetMapping("/students/{id}/{first-name}/{last-name}")
    public ResponseEntity <Student> studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }
    // Spring Boot REST API with Request Param
    // http://localhost:8080/students/query?id=1&firstName=Ayman&lastName=Abdalla
    @GetMapping("/students/query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // Spring Boot REST handles HTTP POST Request
    // @PostMapping and @RequestBody
    // http://localhost:8080/students/create
    @PostMapping("/students/create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // Spring Boot REST API handles HTTP PUT Request
    @PutMapping("/students/{id}/update")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") int studentId, @RequestBody Student student){
        student.setId(studentId);
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    // Spring Boot REST API handles HTTP DELETE Request
    @DeleteMapping("/students/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok("Student deleted!");
    }
}
