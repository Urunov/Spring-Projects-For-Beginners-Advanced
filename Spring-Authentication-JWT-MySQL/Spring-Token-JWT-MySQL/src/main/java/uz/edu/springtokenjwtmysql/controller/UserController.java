package uz.edu.springtokenjwtmysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.edu.springtokenjwtmysql.entity.User;
import uz.edu.springtokenjwtmysql.service.UserService;
import javax.annotation.PostConstruct;
@RestController
public class UserController {
    //
    @Autowired
    private UserService userService;

    @PostConstruct
    public void initRoleAndUsers(){
        userService.initRolesAndUser();
    }

    @PostMapping("/registerNewUser")
    public User registerNewUser(@RequestBody User user){
        return userService.registerNewUser(user);
    }
}