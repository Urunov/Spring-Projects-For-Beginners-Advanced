package uz.edu.travelservice.model;

import lombok.*;
import uz.edu.travelservice.model.genrator.IdGenerator;

import javax.persistence.Entity;

/**
 * Created By hamdamboy
 * Project: travel-service
 * Date: 11/10/22
 * Email: hamdamboy.urunov@gmail.com
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Membership extends IdGenerator {
    //
    private String membershipId;
    private RoleInClub roleInClub;
    private String joinDate;
    private String travelClubId;

}
