package uz.edu.be.spring.university.project.service;


import org.springframework.http.ResponseEntity;
import uz.edu.be.spring.university.project.exception.StudentNotFoundException;
import uz.edu.be.spring.university.project.exception.SubjectNotFoundException;
import uz.edu.be.spring.university.project.model.Subjects;

import java.util.List;
import java.util.Optional;

/**
 * Created By hamdamboy
 * Project: spring-demo-start
 * Date: 01/10/22
 * Email: hamdamboy.urunov@gmail.com
 */
public interface SubjectsService {

    public Subjects saveSubjects(Subjects subjects);

    public List<Subjects> fetchSubjectList() throws SubjectNotFoundException;

    Optional<Subjects> getOnlySubjectById(Long id) throws SubjectNotFoundException;

    Subjects updateSubjectInfo(Long id, Subjects subjects);

    void deleteSubjectId(Long subjectId);

    Subjects fetchSubjectByName(String name) throws SubjectNotFoundException;
}
