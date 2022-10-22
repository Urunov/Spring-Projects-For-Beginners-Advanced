package uz.edu.travelservice.aggregate.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.edu.travelservice.model.RoleInClub;

import javax.persistence.Column;

/**
 * Created By hamdamboy
 * Project: travel-service
 * Date: 20/10/22
 * Email: hamdamboy.urunov@gmail.com
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MembershipDto {
    //
    @JsonProperty(namespace = "role_in_club")
    private RoleInClub roleInClub;
    @JsonProperty(namespace = "join_date")
    private String joinDate;
    @JsonProperty(namespace = "travel_club_id")
    private String travelClubId;
}
