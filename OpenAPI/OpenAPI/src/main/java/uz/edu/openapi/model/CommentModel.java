package uz.edu.openapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

/**
 * @project: OpenAPI
 * @Date: 14.10.2022
 * @author: H_Urunov
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentModel implements Serializable {
    //
    private Long postId;
    private Long id;
    private String name;
    private String email;
    private String body;
}
