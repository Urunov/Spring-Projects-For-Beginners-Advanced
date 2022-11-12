package uz.edu.springsecuritydbproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.edu.springsecuritydbproject.aggregate.model.User;

/**
 * @project: Spring-Security-DB-Project
 * @Date: 12.11.2022
 * @author: H_Urunov
 **/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
