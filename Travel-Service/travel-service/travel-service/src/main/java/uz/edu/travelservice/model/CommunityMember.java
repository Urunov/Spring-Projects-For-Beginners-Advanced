package uz.edu.travelservice.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import uz.edu.travelservice.model.address.Address;
import uz.edu.travelservice.model.genrator.IdGenerator;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

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
