package uz.openAPI.model.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListUsers {

    private Long page;
    @JsonProperty("per_page")
    private Long perPage;
    @JsonProperty("total")
    private Long total;
    @JsonProperty("total_pages")
    private Long totalPages;
    @JsonProperty("data")
    private List<DataAPI> dataAPIList;
    @JsonProperty("support")
    private SupportAPI supportAPI;
}
