package uz.edu.be.spring.university.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.edu.be.spring.university.project.model.Student;

import java.util.List;

/**
 * Created By hamdamboy
 * Project: spring-demo-start
 * Date: 27/09/22
 * Email: hamdamboy.urunov@gmail.com
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByFirstName(String firstName);

    List<Student> findByLastName(String lastName);

//    @Query(value = "", nativeQuery = true)
//    public Student findByStudentNameIgnoreCase(String firstName);
}
