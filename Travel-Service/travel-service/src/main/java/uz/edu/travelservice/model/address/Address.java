package uz.edu.travelservice.model.address;

import lombok.*;
import uz.edu.travelservice.model.genrator.IdGenerator;

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

public class Address extends IdGenerator {
    //
    private String country;
    private String zipAddress;
    private String zipCode;
    private String streetAddress;
    private AddressType addressType;
}
