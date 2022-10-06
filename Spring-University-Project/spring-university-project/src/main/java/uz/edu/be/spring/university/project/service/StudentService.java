package uz.edu.be.spring.university.project.service;


import org.springframework.http.ResponseEntity;
import uz.edu.be.spring.university.project.exception.StudentNotFoundException;
import uz.edu.be.spring.university.project.model.Student;

import java.util.List;
import java.util.Optional;

/**
 * Created By hamdamboy
 * Project: spring-demo-start
 * Date: 27/09/22
 * Email: hamdamboy.urunov@gmail.com
 */
public interface StudentService {
    public Student saveStudent(Student student1);

    public List<Student> fetchStudentList() throws StudentNotFoundException;

    Optional<Student> getOnlyStudentById(Long id) throws StudentNotFoundException;

    Student updateStudentInfo(Long id, Student student);

    void deleteStudentId(Long studentId);

    Student fetchStudentByFirstName(String firstName) throws StudentNotFoundException;

    ResponseEntity<List<Student>> fetchStudentByLastNames(String lastName);

    Student internationalByName(String firstName);
}
