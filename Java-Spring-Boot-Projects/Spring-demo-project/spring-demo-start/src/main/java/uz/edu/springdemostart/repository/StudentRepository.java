package uz.edu.springdemostart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.edu.springdemostart.model.Student;

/**
 * Created By hamdamboy
 * Project: spring-demo-start
 * Date: 27/09/22
 * Email: hamdamboy.urunov@gmail.com
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
