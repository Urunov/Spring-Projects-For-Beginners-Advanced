package uz.edu.be.spring.university.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.edu.be.spring.university.project.exception.StudentNotFoundException;
import uz.edu.be.spring.university.project.exception.SubjectNotFoundException;
import uz.edu.be.spring.university.project.model.Student;
import uz.edu.be.spring.university.project.model.Subjects;
import uz.edu.be.spring.university.project.repository.SubjectRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    @Override
    public List<Subjects> fetchSubjectList() throws SubjectNotFoundException {
        List<Subjects> subjectList = subjectRepository.findAll();

        if (subjectList.isEmpty()){
            throw new SubjectNotFoundException("There is not subject in DB");
        }
        return subjectList;
    }

    @Override
    public Optional<Subjects> getOnlySubjectById(Long id) throws SubjectNotFoundException {
        Optional<Subjects> subject = subjectRepository.findById(id);

        if (subject.isEmpty()){
            throw new SubjectNotFoundException("Subject not available ....");
        }

        return subject;
    }

    @Override
    public Subjects updateSubjectInfo(Long id, Subjects subjects) {
        Subjects subjectDB = subjectRepository.findById(id).get();

        if (Objects.nonNull(subjects.getName()) &&
                !"".equalsIgnoreCase(subjects.getName())){
            subjectDB.setName(subjects.getName());
        }
        if (Objects.nonNull(subjects.getSubjectCode()) &&
                !"".equalsIgnoreCase(subjects.getSubjectCode())){
            subjectDB.setSubjectCode(subjects.getSubjectCode());
        }
        return subjectRepository.save(subjectDB);
    }

    @Override
    public void deleteSubjectId(Long subjectId) {
        if (Objects.nonNull(subjectId)) {
            subjectRepository.deleteById(subjectId);
        } else{
            System.out.println("Subject already delete");
        }
    }

    @Override
    public Subjects fetchSubjectByName(String name) throws SubjectNotFoundException {
        Subjects subject = subjectRepository.findByName(name);

        if (subject==null || subject.equals("")){
            throw new SubjectNotFoundException("Could not find the same name subject. ...");
        }

        return subject;
    }
}
