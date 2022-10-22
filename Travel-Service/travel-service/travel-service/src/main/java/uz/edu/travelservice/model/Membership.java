package uz.edu.travelservice.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import uz.edu.travelservice.model.genrator.IdGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
public class Membership extends IdGenerator{
    //
    @Column(name = "role_in_club")
    private RoleInClub roleInClub;
    @Column(name = "join_date")
    private String joinDate;
    @Column(name = "travel_club_id")
    private String travelClubId;

}
