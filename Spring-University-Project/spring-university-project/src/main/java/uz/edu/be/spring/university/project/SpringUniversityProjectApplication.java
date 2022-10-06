package uz.edu.be.spring.university.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin("*")
public class SpringUniversityProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringUniversityProjectApplication.class, args);
    }

}
