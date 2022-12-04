package uz.openAPI.model.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupportAPI {
    //
    @JsonProperty("url")
    private String url;
    @JsonProperty("text")
    private String text;
}
