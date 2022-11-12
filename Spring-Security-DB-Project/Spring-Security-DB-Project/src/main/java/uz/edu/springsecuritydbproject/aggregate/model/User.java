package uz.edu.springsecuritydbproject.aggregate.model;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @project: Spring-Security-DB-Project
 * @Date: 12.11.2022
 * @author: H_Urunov
 **/

@Getter
@Setter
@Entity
public class User implements Serializable {

    @Id
    private Long id;
    private String username;
    private String password;
    private String role;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
