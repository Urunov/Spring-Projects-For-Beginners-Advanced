package uz.edu.client.model;

import lombok.*;

/**
 * @project: RestTemplateStackAPI
 * @Date: 18.10.2022
 * @author: H_Urunov
 **/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    //
    private Integer id;
    private String name;
    private double salary;
}
