package uz.edu.springtokenjwtmysql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.edu.springtokenjwtmysql.dao.RoleDao;
import uz.edu.springtokenjwtmysql.entity.Role;

@Service
public class RoleService {
    //
    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(Role role){
        return roleDao.save(role);
    }
}