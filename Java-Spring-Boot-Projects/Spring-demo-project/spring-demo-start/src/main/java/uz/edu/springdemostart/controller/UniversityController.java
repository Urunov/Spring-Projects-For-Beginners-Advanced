package uz.edu.springdemostart.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.edu.springdemostart.model.Student;
import uz.edu.springdemostart.model.University;

/**
 * Created By hamdamboy
 * Project: spring-demo-start
 * Date: 24/09/22
 * Email: hamdamboy.urunov@gmail.com
 */
@RestController
public class UniversityController{
    //
    @GetMapping("/univ")
    public ResponseEntity<?> getOneUniversity(){
        University university = new University();
        university.setId(1L);
        university.setName("Wesmester");
        university.setCourseName("Computer Engineering");

        return ResponseEntity.ok(university);
    }

    @GetMapping("/one")
    public University getUniversity(@RequestParam Long id, @RequestParam String name, @RequestParam String courseName){
        University university = new University(id, name, courseName);

        return university;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllUniversity(){
        return null;
    }


}
