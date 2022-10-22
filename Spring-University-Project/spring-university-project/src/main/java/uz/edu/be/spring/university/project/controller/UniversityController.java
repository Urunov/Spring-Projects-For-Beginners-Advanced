package uz.edu.be.spring.university.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


@RequestMapping("/api/v1/university")
@RestController
public class UniversityController{
    //
    @Autowired
    private UniversityServiceImpl universityServiceImp;

    private final Logger LOG = LoggerFactory.getLogger(University.class);
    @PostMapping("/save")
    public ResponseEntity<?> saveUniversity(@RequestBody University university){
        LOG.info("Inside the save University of Controller : ");
        return ResponseEntity.ok(universityServiceImp.saveUniversity(university));
    }
    @GetMapping("/{id}")
    public Optional<University> getAllUniversityById(@PathVariable Long id) throws UniversityNotFoundException {
        LOG.info("Inside the getOnlyById University of Controller : ");
        return universityServiceImp.getUniversityById(id);
    }
    @GetMapping("/all")
    public List<University> getAllUniversity() throws UniversityNotFoundException {
        LOG.info("Inside the List of  getOnlyById University of Controller : ", universityServiceImp.listUniversity());
        return universityServiceImp.listUniversity();
    }
    @DeleteMapping("/{id}")
    public String removeUniversityById(@PathVariable Long id){
        LOG.info("Remove University by id of Controller : ");
        universityServiceImp.deleteUniversityById(id);
        return "Deleted. Student . Successfully..";
    }
    @PutMapping("update/{id}")
    public University updateUniversityValue(@PathVariable Long id, @RequestBody University university){
        LOG.info("Inside the update University of Controller : ");
        return universityServiceImp.updateUniversityInfo(id, university);
    }
    @GetMapping("/find/name/{name}")
    public University fetchUniversityByName(@PathVariable("name") String name) throws UniversityNotFoundException{
        LOG.info("Inside the getting name University of Controller : ");
        return universityServiceImp.fetchUniversityByName(name);
    }
}
