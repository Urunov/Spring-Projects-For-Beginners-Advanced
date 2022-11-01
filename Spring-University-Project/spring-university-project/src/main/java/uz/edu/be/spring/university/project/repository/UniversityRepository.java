package uz.edu.be.spring.university.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.edu.be.spring.university.project.model.University;

/**
 * Created By hamdamboy
 * Project: spring-demo-start
 * Date: 30/09/22
 * Email: hamdamboy.urunov@gmail.com
 */
@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {
    University findByName(String name);
}
