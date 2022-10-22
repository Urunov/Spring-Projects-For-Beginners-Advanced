package uz.edu.travelservice.aggregate.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

/**
 * Created By hamdamboy
 * Project: travel-service
 * Date: 15/10/22
 * Email: hamdamboy.urunov@gmail.com
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TravelClubDto {
    //
    @JsonProperty(namespace = "name")
    private String name;
    @JsonProperty(namespace = "introduction")
    private String introduction;
    @JsonProperty(namespace = "foundation_time")
    private long foundationTime;
}
