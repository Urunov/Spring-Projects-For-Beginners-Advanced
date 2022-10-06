package uz.edu.be.spring.university.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.edu.be.spring.university.project.exception.StudentNotFoundException;
import uz.edu.be.spring.university.project.model.Student;
import uz.edu.be.spring.university.project.repository.StudentRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    public List<Student> fetchStudentList() throws StudentNotFoundException {

        List<Student> studentList = studentRepository.findAll();

        if (studentList.isEmpty()){
            throw new StudentNotFoundException("There is not student in DB");
        }
        return studentRepository.findAll();
    }


    @Override
    public Optional<Student> getOnlyStudentById(Long id) throws StudentNotFoundException {

        Optional<Student> student = studentRepository.findById(id);

        if (student.isEmpty()){
            throw new StudentNotFoundException("Student not available ....");
        }

        return studentRepository.findById(id);
    }
    /***
     * Optional is extra using method information.
     * 1. if using optional, do not need to get() method in attaching  method
     * 2. If using get(), cannot use optional
     *
     * */
//    @Override
//    public Student getOnlyStudentById(Long id) {
//        return studentRepository.findById(id).get();
//    }

    @Override
    public Student updateStudentInfo(Long id, Student student) {
        Student studentDB = studentRepository.findById(id).get();

        if (Objects.nonNull(student.getFirstName()) &&
                !"".equalsIgnoreCase(student.getFirstName())){
            studentDB.setFirstName(student.getFirstName());
        }
        if (Objects.nonNull(student.getLastName()) &&
                !"".equalsIgnoreCase(student.getLastName())){
            studentDB.setLastName(student.getLastName());
        }
        return studentRepository.save(studentDB);
    }

    @Override
    public void deleteStudentId(Long studentId) {

        if (Objects.nonNull(studentId)) {
            studentRepository.deleteById(studentId);
        } else{
            System.out.println("Student already delete");
        }
    }

    @Override
    public Student fetchStudentByFirstName(String firstName) throws StudentNotFoundException {

        Student student = studentRepository.findByFirstName(firstName);

        if (student==null || student.equals("")){
          throw new StudentNotFoundException("Could not find the same name student. ...");
        }

        return studentRepository.findByFirstName(firstName);
    }

    @Override
    public ResponseEntity<List<Student>> fetchStudentByLastNames(String lastName) {

       List<Student> studentList = new ArrayList<>();
       studentRepository.findAll().forEach(
               student -> {
                   if (studentRepository.findByLastName(lastName).isEmpty()){
                       System.out.println("No data");
                   } else{
                       studentList.add(student);
                   }
               }
       );
        return ResponseEntity.ok(studentList);
    }

    @Override
    public Student internationalByName(String firstName) {
        //logic
        return null;
    }


}
