package uz.edu.be.spring.university.project.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

/**
 * @project: spring-demo-start
 * @Date: 20.09.2022
 * @author: H_Urunov
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity // connect to db
public class Student {
    //
    @Id // Primiry Key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Please, add Student name !")
    @Length(max = 15, min = 1)
    @Size(max = 10, min = 1)
    private String firstName;
    @NotBlank(message = "Please, add Student last Name !")
    private String lastName;

    public Student(String firstName){
        this.firstName = firstName;
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

 }
