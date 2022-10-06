package uz.edu.be.spring.university.project.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created By hamdamboy
 * Project: spring-demo-start
 * Date: 22/09/22
 * Email: hamdamboy.urunov@gmail.com
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class University {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String courseName;

    public University(String name, String courseName){
        this.name = name;
        this.courseName = courseName;
    }

}
