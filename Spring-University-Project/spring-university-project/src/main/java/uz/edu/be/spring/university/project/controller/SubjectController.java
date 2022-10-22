package uz.edu.be.spring.university.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.edu.be.spring.university.project.exception.SubjectNotFoundException;
import uz.edu.be.spring.university.project.model.Subjects;
import uz.edu.be.spring.university.project.service.SubjectsServiceImpl;

import java.util.List;
import java.util.Optional;


/**
 * Created By hamdamboy
 * Project: spring-demo-start
 * Date: 01/10/22
 * Email: hamdamboy.urunov@gmail.com
 */
@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/subject")
public class SubjectController {
    //
    @Autowired
    private SubjectsServiceImpl subjectsService;

    private final Logger LOG = LoggerFactory.getLogger(SubjectController.class);

    @PostMapping("/save")
    public ResponseEntity<?> storeSubject(@RequestBody Subjects subjects){
       return ResponseEntity.ok(subjectsService.saveSubjects(subjects));
    }

    @GetMapping("/find/all")
    public List<Subjects> fetchSubjectList() throws SubjectNotFoundException {
        LOG.info("Inside the List of Subject of Controller : {}", subjectsService.fetchSubjectList());
        return subjectsService.fetchSubjectList();
    }

    @GetMapping("/{id}")
    public Optional<Subjects> getOnlySubjectById(@PathVariable Long id) throws SubjectNotFoundException {
        LOG.info("Inside the getOnlySubjectById Subject of Controller : ");
        return subjectsService.getOnlySubjectById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteSubjectById(@PathVariable("id") Long subjectId){
        subjectsService.deleteSubjectId(subjectId);
        LOG.info("Inside the delete Subject of Controller : ");
        return "Deleted. Subject . Successfully..";
    }
    @PutMapping("/update/{id}")
    public Subjects updateSubjectValue(@PathVariable Long id, @RequestBody Subjects subjects){
        LOG.info("Inside the updated Subject of Controller : ");
        return subjectsService.updateSubjectInfo(id, subjects);
    }
    @GetMapping("/find/name/{name}")
    public Subjects fetchSubjectByName(@PathVariable("name") String name) throws SubjectNotFoundException {
        LOG.info("Inside the getting name Subject of Controller : ");
        return subjectsService.fetchSubjectByName(name);
    }
}
