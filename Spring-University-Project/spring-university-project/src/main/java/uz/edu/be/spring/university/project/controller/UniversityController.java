package uz.edu.be.spring.university.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.edu.be.spring.university.project.exception.UniversityNotFoundException;
import uz.edu.be.spring.university.project.model.University;
import uz.edu.be.spring.university.project.service.UniversityServiceImpl;


import java.util.List;
import java.util.Optional;

/**
 * Created By hamdamboy
 * Project: spring-demo-start
 * Date: 24/09/22
 * Email: hamdamboy.urunov@gmail.com
 */
@RestController
public class UniversityController{
    //
    @Autowired
    private UniversityServiceImpl universityServiceImp;

    @PostMapping("/save/university")
    public ResponseEntity<?> saveUniversity(@RequestBody University university){
       return ResponseEntity.ok(universityServiceImp.saveUniversity(university));
    }

    @GetMapping("/university/{id}")
    public Optional<University> getAllUniversityById(@PathVariable Long id) throws UniversityNotFoundException {
        return universityServiceImp.getUniversityById(id);
    }
    @GetMapping("/university/all")
    public List<University> getAllUniversity() throws UniversityNotFoundException {
        return universityServiceImp.listUniversity();
    }

    @DeleteMapping("/university/{id}")
    public String removeUniversityById(@PathVariable Long id){
        universityServiceImp.deleteUniversityById(id);
        return "University deleted" + id;
    }
}
