package uz.edu.springdemostart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.edu.springdemostart.model.Student;
import uz.edu.springdemostart.service.StudentService;
import uz.edu.springdemostart.service.StudentServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @project: spring-demo-start
 * @Date: 20.09.2022
 * @author: H_Urunov
 **/

@RestController
public class StudentController {
    //
    @GetMapping("/testagain")
    public String test(){
        return "Hello Test";
    }

    /*
    * This method:
    * @RequestParam(required = false) String firstName - is not mandatory
    * Default value: required = true.
    * */
    @GetMapping("/student")
    public Student studentMethod(@RequestParam(required = false) String firstName, @RequestParam String lastName){

        Student student = new Student(firstName, lastName);
        return student;
    }

    @GetMapping("/studentname")
    public ResponseEntity<?> studentByName(@RequestParam String firstName){
        Student student = new Student(firstName);
        student.setFirstName("Sitora");

       // step-1. Just return firstName (String)
       // return ResponseEntity.ok(student);
       // step-2. Ignore Annotation.
        return ResponseEntity.ok(student.getFirstName());
    }

    @GetMapping("/api/student/all")
    public ResponseEntity getAll(){

        Student student = new Student(1L, "Avazbek", "Azizov");
        Student student1 = new Student(2L, "Sitora", "Djanarova");
        Student student2 = new Student(3L, "Real", "Azizov");
        Student student3 = new Student(4L, "Madrid", "Azizov");
        Student student4 = new Student(5L, "Bunyod", "Abduhakimov");
        Student student5 = new Student(6L, "MirOlim", "Mirzaev");

        List<Student> studentList = new ArrayList<>();

        studentList.add(student);
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);

        return ResponseEntity.ok(studentList);
    }

    /**
     * Update services
     * -----------------------
     *
     * */
    @Autowired
    private StudentService studentService;

    @PostMapping("/save/student")
    public Student saveStudent(@RequestBody Student student1){
       return studentService.saveStudent(student1);
    }

    @GetMapping("/find/student/all")
    public List<Student> fetchStudentList(){
        return studentService.fetchStudentList();
    }
}
