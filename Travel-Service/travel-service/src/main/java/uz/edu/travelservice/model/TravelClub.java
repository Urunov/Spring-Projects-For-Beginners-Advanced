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
//@Table(name = "travel_club")
//public class TravelClub extends IdGenerator{
public class TravelClub extends IdGenerator{
    //
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private String id;

    private String name;
    private String introduction;
    private long foundationTime;

}
