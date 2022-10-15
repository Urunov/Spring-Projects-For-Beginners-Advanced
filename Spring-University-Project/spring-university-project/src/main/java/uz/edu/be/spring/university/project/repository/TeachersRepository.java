package uz.edu.be.spring.university.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.edu.be.spring.university.project.model.Teachers;

/**
 * Created By hamdamboy
 * Project: spring-demo-start
 * Date: 27/09/22
 * Email: hamdamboy.urunov@gmail.com
 */
@Repository
public interface TeachersRepository extends JpaRepository<Teachers, Long> {
    Teachers findByName(String name);

}
