package uz.edu.springtokenjwtmysql.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Role {

    @Id
    private String roleName;
    private String roleDescription;
}
