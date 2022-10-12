package uz.edu.travelservice.model.genrator;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created By hamdamboy
 * Project: travel-service
 * Date: 11/10/22
 * Email: hamdamboy.urunov@gmail.com
 */
@Getter
@Setter
@Entity
public abstract class IdGenerator implements Serializable {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
}
