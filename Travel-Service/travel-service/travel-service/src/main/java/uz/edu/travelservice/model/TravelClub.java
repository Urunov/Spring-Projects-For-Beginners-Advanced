package uz.edu.travelservice.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import uz.edu.travelservice.model.genrator.IdGenerator;

import javax.persistence.*;

/**
 * Created By hamdamboy
 * Project: travel-service
 * Date: 11/10/22
 * Email: hamdamboy.urunov@gmail.com
 */
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class TravelClub extends IdGenerator{
    //
    private String name;
    private String introduction;
    private long foundationTime;
}