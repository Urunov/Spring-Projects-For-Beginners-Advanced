package uz.edu.springdemostart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.edu.springdemostart.model.Student;
import uz.edu.springdemostart.repository.StudentRepository;

import java.util.List;

/**
 * Created By hamdamboy
 * Project: spring-demo-start
 * Date: 27/09/22
 * Email: hamdamboy.urunov@gmail.com
 */
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student1) {
        return studentRepository.save(student1);
    }

    @Override
    public List<Student> fetchStudentList() {
        return studentRepository.findAll();
    }
}
