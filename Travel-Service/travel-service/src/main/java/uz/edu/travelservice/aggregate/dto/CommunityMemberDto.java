package uz.edu.travelservice.aggregate.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import uz.edu.travelservice.model.address.Address;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

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
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommunityMemberDto {
    //
    @JsonProperty(namespace = "email")
    private String email;
    @JsonProperty(namespace = "name")
    private String name;
    @JsonProperty(namespace = "phone_number")
    private String phoneNumber;
    @JsonProperty(namespace = "birth_day")
    private String birthDay;
    @JsonProperty(namespace ="nick_name" )
    private String nickName;
    @JsonProperty(namespace = "address")
    private List<Address> addressList;
}
