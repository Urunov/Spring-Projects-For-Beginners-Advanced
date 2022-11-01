package uz.edu.be.spring.university.project.controller;

import com.fasterxml.jackson.databind.annotation.JsonValueInstantiator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.edu.be.spring.university.project.exception.StudentNotFoundException;
import uz.edu.be.spring.university.project.model.Student;
import uz.edu.be.spring.university.project.service.StudentService;
import uz.edu.be.spring.university.project.service.StudentServiceImpl;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @project: spring-demo-start
 * @Date: 20.09.2022
 * @author: H_Urunov
 **/

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    private final Logger LOG = LoggerFactory.getLogger(StudentController.class);

    @PostMapping("/save/student")
    public Student saveStudent(@Valid @RequestBody Student student1){
      LOG.info("Inside the save Student of Controller : ");
       return studentService.saveStudent(student1);
    }

    @GetMapping("/find/student/all")
    public List<Student> fetchStudentList() throws StudentNotFoundException {
        LOG.info("Inside the List of  Student of Controller : {}", studentService.fetchStudentList());
        return studentService.fetchStudentList();
    }

    @GetMapping("/student/{id}")
    public Optional<Student> getOnlyStudentById(@PathVariable Long id) throws StudentNotFoundException {
        LOG.info("Inside the getOnlyStudentById Student of Controller : ");
        return studentService.getOnlyStudentById(id);
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudentById(@PathVariable("id") Long studentId){
        studentService.deleteStudentId(studentId);
        LOG.info("Inside the delete Student of Controller : ");
        return "Deleted. Student . Successfully..";
    }

    @PutMapping("/update/student/{id}")
    public Student updateStudentValue(@PathVariable Long id, @RequestBody Student student){
        LOG.info("Inside the updated Student of Controller : ");
        return studentService.updateStudentInfo(id, student);
    }

    @GetMapping("/find/name/{firstName}")
    public Student fetchStudentByFirstName(@PathVariable("firstName") String firstName) throws StudentNotFoundException {
        LOG.info("Inside the getting firstName Student of Controller : ");
        return studentService.fetchStudentByFirstName(firstName);
    }

    @GetMapping("/find/lastname/{lastName}")
    public Object fetchStudentByLastNames(@PathVariable(value = "lastName", required = true) String lastName){
        LOG.info("Inside the BY LastName Student of Controller : ");
        return studentService.fetchStudentByLastNames(lastName);
    }
}
