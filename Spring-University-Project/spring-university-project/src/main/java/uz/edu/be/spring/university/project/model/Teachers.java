package uz.edu.be.spring.university.project.model;

import lombok.*;

import javax.persistence.*;

/**
 * Created By hamdamboy
 * Project: spring-demo-start
 * Date: 24/09/22
 * Email: hamdamboy.urunov@gmail.com
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
//@Table(name = "teach")
public class Teachers {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;
}
