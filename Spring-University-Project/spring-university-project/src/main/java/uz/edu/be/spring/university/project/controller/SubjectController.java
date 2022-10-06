package uz.edu.be.spring.university.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.edu.be.spring.university.project.model.Subjects;
import uz.edu.be.spring.university.project.service.SubjectsServiceImpl;


/**
 * Created By hamdamboy
 * Project: spring-demo-start
 * Date: 01/10/22
 * Email: hamdamboy.urunov@gmail.com
 */
@RestController
public class SubjectController {
    //
    @Autowired
    private SubjectsServiceImpl subjectsService;

    @PostMapping("/subject/save")
    public ResponseEntity<?> storeSubject(@RequestBody Subjects subjects){
       return ResponseEntity.ok(subjectsService.saveSubjects(subjects));
    }
}
