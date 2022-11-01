package uz.edu.be.spring.university.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.edu.be.spring.university.project.exception.StudentNotFoundException;
import uz.edu.be.spring.university.project.exception.UniversityNotFoundException;
import uz.edu.be.spring.university.project.model.Student;
import uz.edu.be.spring.university.project.model.University;
import uz.edu.be.spring.university.project.repository.UniversityRepository;

import java.util.List;
import java.util.Objects;
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

    @Autowired
    private UniversityRepository universityRepository;

    @Override
    public University saveUniversity(University university) {
        return universityRepository.save(university);
    }
    @Override
    public List<University> listUniversity() throws UniversityNotFoundException {

        List<University> universityList = universityRepository.findAll();

        if (universityList.isEmpty()){
            throw new UniversityNotFoundException("There is not university in DB");
        }

        return universityRepository.findAll();
    }
    @Override
    public Optional<University> getUniversityById(Long id) throws UniversityNotFoundException {

        Optional<University> university = universityRepository.findById(id);

        if (university.isEmpty()){
            throw new UniversityNotFoundException("University not available ....");
        }


        return universityRepository.findById(id);
    }

    @Override
    public void deleteUniversityById(Long id) {
       universityRepository.deleteById(id);
    }

    @Override
    public University updateUniversityInfo(Long id, University university) {
        University universityDB = universityRepository.findById(id).get();

        if (Objects.nonNull(university.getName()) &&
                !"".equalsIgnoreCase(university.getName())){
            universityDB.setName(university.getName());
        }
        if (Objects.nonNull(university.getCourseName()) &&
                !"".equalsIgnoreCase(university.getCourseName())){
            universityDB.setCourseName(university.getCourseName());
        }
        return universityRepository.save(universityDB);
    }

    @Override
    public University fetchUniversityByName(String name) throws UniversityNotFoundException {
        University university = universityRepository.findByName(name);

        if(university==null||university.equals("")){
            throw new UniversityNotFoundException("Cloud not find the same name university . . . ");
        }
        return universityRepository.findByName(name);
    }
}
