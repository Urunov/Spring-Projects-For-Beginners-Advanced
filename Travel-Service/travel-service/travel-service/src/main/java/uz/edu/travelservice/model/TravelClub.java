package uz.edu.travelservice.model;

import com.sun.istack.NotNull;
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
    @NotNull
    @Column(name = "name")
    private String clubName;
    @Column(name = "introduction")
    private String introduction;
    @Column(name = "foundation_time")
    private long foundationTime;
}