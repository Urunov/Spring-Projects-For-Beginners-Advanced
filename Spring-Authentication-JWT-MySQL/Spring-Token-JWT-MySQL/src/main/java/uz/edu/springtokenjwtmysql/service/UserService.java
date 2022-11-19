package uz.edu.springtokenjwtmysql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.edu.springtokenjwtmysql.dao.RoleDao;
import uz.edu.springtokenjwtmysql.dao.UserDao;
import uz.edu.springtokenjwtmysql.entity.Role;
import uz.edu.springtokenjwtmysql.entity.User;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;
    public User registerNewUser(User user){
        return userDao.save(user);
    }

    public void initRolesAndUser(){

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        adminRole.setRoleName("User");
        adminRole.setRoleDescription("Default role for newly created record.");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserName("admin123");
        adminUser.setUserPassword("admin@pass");

        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        userDao.save(adminUser);




    }
}
