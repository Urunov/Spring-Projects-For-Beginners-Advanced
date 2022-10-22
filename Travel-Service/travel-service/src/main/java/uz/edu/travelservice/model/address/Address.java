package uz.edu.travelservice.model.address;

import lombok.*;
import uz.edu.travelservice.model.CommunityMember;
import uz.edu.travelservice.model.genrator.IdGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
@Entity
public class Address extends IdGenerator {
    //
    @Column(name = "country")
    private String country;
    @Column(name = "zip_address")
    private String zipAddress;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "street_address")
    private String streetAddress;
    @Column(name = "address_type")
    private AddressType addressType;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private CommunityMember member;

}
