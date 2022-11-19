package uz.edu.springsecuityauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {
    //
    @GetMapping("/hello")
    public String hello(){
        return "<h2> Hey Everyone, welcome to Security </h2>";
    }

    @GetMapping("/user")
    public String user(){
        return " <h2>  Hello. USER. </h2>";
    }

    @GetMapping("/admin")
    public String admin(){
        return " <h2>  Hello. ADMIN. </h2>";
    }
}