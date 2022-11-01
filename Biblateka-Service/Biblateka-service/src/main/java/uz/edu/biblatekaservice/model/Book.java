package uz.edu.biblatekaservice.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book implements Serializable {
    //
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String name;
    private String author;

    @NotNull
    private BigDecimal price;

}
