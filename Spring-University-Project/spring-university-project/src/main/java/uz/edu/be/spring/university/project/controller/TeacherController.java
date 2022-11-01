package uz.edu.be.spring.university.project.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import uz.edu.be.spring.university.project.exception.TeacherNotFoundException;
import uz.edu.be.spring.university.project.model.Teachers;
import uz.edu.be.spring.university.project.service.TeacherServiceImpl;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created By hamdamboy
 * Project: spring-university-project
 * Date: 04/10/22
 * Email: hamdamboy.urunov@gmail.com
 */

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    //
    @Autowired
    private TeacherServiceImpl teacherService;

    private final Logger LOG = LoggerFactory.getLogger(TeacherController.class);

    @PostMapping("/save")
    public Teachers saveTeacher(@Valid @RequestBody Teachers teachers) {
        LOG.info("Inside the save Teacher of Controller : ");
        return teacherService.saveTeacher(teachers);
    }

    @GetMapping("/find/all")
    public List<Teachers> fetchTeacherList() throws TeacherNotFoundException {
        LOG.info("Inside the List of Teacher of Controller : {}", teacherService.fetchTeacherList());
        return teacherService.fetchTeacherList();
    }

    @GetMapping("/{id}")
    public Optional<Teachers> getOnlyTeacherById(@PathVariable Long id) throws TeacherNotFoundException {
        LOG.info("Inside the getOnlyTeacherById Teacher of Controller : ");
        return teacherService.getOnlyTeacherById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteTeacherById(@PathVariable("id") Long teacherId) {
        teacherService.deleteTeacherId(teacherId);
        LOG.info("Inside the delete Teacher of Controller :");
        return "Deleted. Teacher. Successfully . . . ";
    }

    @PutMapping("/update/{id}")
    public Teachers updateTeacherValue(@PathVariable Long id, @RequestBody Teachers teachers) {
        LOG.info("Inside the update Teacher of Controller : ");
        return teacherService.updateTeacherInfo(id, teachers);
    }

    @GetMapping("/find/name/{name}")
    public Teachers fetchTeacherByName(@PathVariable("name") String name) throws TeacherNotFoundException {
        LOG.info("Inside the getting name Teacher of Controller ");
        return teacherService.fetchTeacherByName(name);
    }
}
