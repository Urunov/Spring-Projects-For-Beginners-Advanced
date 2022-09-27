package uz.edu.springdemostart.service;

import uz.edu.springdemostart.model.Student;

import java.util.List;

/**
 * Created By hamdamboy
 * Project: spring-demo-start
 * Date: 27/09/22
 * Email: hamdamboy.urunov@gmail.com
 */
public interface StudentService {
    public Student saveStudent(Student student1);
    public List<Student> fetchStudentList();

}
