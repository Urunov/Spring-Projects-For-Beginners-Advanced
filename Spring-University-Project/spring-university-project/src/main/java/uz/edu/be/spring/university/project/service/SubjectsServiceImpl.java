package uz.edu.be.spring.university.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.edu.be.spring.university.project.model.Subjects;
import uz.edu.be.spring.university.project.repository.SubjectRepository;

/**
 * Created By hamdamboy
 * Project: spring-demo-start
 * Date: 01/10/22
 * Email: hamdamboy.urunov@gmail.com
 */
@Service
public class SubjectsServiceImpl implements SubjectsService{
    //
    @Autowired
    private SubjectRepository subjectRepository;


    @Override
    public Subjects saveSubjects(Subjects subjects) {
        return subjectRepository.save(subjects);
    }
}
