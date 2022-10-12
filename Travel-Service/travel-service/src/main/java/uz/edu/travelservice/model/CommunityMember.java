package uz.edu.travelservice.model;

import lombok.*;
import uz.edu.travelservice.model.address.Address;
import uz.edu.travelservice.model.genrator.IdGenerator;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;

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
public class CommunityMember extends IdGenerator {
    //
    private String email;
    private String name;
    private String phoneNumber;
    private String birthDay;
    private String nickName;
    @ElementCollection
    private List<Address> addressList;
}
