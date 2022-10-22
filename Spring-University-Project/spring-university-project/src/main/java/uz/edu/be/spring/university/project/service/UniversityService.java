package uz.edu.be.spring.university.project.service;

import uz.edu.be.spring.university.project.exception.UniversityNotFoundException;
import uz.edu.be.spring.university.project.model.Student;
import uz.edu.be.spring.university.project.model.University;

import java.util.List;
import java.util.Optional;

/**
 * Created By hamdamboy
 * Project: spring-demo-start
 * Date: 30/09/22
 * Email: hamdamboy.urunov@gmail.com
 */
public interface UniversityService {
    //
    public University saveUniversity(University university);
    List<University> listUniversity() throws UniversityNotFoundException;

    Optional<University> getUniversityById(Long id) throws UniversityNotFoundException;

    public void deleteUniversityById(Long id);

    University updateUniversityInfo(Long id, University university);

    University fetchUniversityByName(String name) throws UniversityNotFoundException;

}
