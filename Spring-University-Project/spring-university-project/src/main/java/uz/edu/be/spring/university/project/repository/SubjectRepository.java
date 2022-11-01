package uz.edu.be.spring.university.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.edu.be.spring.university.project.model.Student;
import uz.edu.be.spring.university.project.model.Subjects;

/**
 * Created By hamdamboy
 * Project: spring-demo-start
 * Date: 01/10/22
 * Email: hamdamboy.urunov@gmail.com
 */
@Repository
public interface SubjectRepository extends JpaRepository<Subjects, Long> {
    Subjects findByName(String Name);
}
