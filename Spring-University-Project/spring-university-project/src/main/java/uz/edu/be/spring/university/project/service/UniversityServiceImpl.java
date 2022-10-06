package uz.edu.be.spring.university.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.edu.be.spring.university.project.model.University;
import uz.edu.be.spring.university.project.repository.UniversityRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created By hamdamboy
 * Project: spring-demo-start
 * Date: 30/09/22
 * Email: hamdamboy.urunov@gmail.com
 */
@Service
public class UniversityServiceImpl implements UniversityService {
    //

    @Autowired  // Construcoter
    private UniversityRepository universityRepository;

    @Override
    public University saveUniversity(University university) {
        University university1 = universityRepository.save(university);
        return university1;
    }


    @Override
    public List<University> listUniversity() {

        return universityRepository.findAll();
    }

    @Override
    public Optional<University> getUniversityById(Long id) {
        return universityRepository.findById(id);
    }

    @Override
    public void deleteUniversityById(Long id) {
       universityRepository.deleteById(id);
    }
}
