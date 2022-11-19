package uz.edu.springtokenjwtmysql.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.edu.springtokenjwtmysql.entity.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, String> {

}
