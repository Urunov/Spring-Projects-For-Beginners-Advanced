package uz.edu.springtokenjwtmysql.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.edu.springtokenjwtmysql.entity.User;

@Repository
public interface UserDao extends CrudRepository<User, String> {
    //

}
