package uz.edu.travelservice.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import uz.edu.travelservice.model.address.Address;
import uz.edu.travelservice.model.genrator.IdGenerator;

import javax.persistence.*;
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
    @Column(name = "email")
    private String email;
    @Column(name = "name")
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "birth_day")
    private String birthDay;
    @Column(name ="nick_name" )
    private String nickName;

    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "address_list")
    @ToString.Exclude
    private List<Address> addressList;
}
/***
 * Mapping Classes:
 * 1. OneToOne
 * 2. OneToMany
 *   - ManyToOne
 * 3. ManyToMany
 *
 * */