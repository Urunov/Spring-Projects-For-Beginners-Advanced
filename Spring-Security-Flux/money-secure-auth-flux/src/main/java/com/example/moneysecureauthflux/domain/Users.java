package com.example.moneysecureauthflux.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Users implements Serializable {
    //
    private static final long serialVersionUID = 1L;

    private Long id;
    @JsonProperty("username")
    private String username;
    @JsonProperty("description")
    private String description;
    @JsonProperty("password")
    private String password;
    @JsonProperty("roles")
    private List<Roles> roles;
    @JsonProperty("type_code")
    public int type_code;
    @JsonProperty("type_code_name")
    public String type_code_name;
    @JsonProperty("name")
    public String name;
    @JsonProperty("branch_code")
    public String branch_code;
    @JsonProperty("tin")
    public String tin;
    public String post_code;
    @JsonProperty("region_code")
    public int region_code;
    @JsonProperty("region_name")
    public String region_name;
    @JsonProperty("district_code")
    public int district_code;
    @JsonProperty("district_name")
    public String district_name;
    @JsonProperty("locality")
    public String locality;
    @JsonProperty("street")
    public String street;
    @JsonProperty("house")
    public String house;
    @JsonProperty("building")
    public String building;
    @JsonProperty("apartment")
    public String apartment;
    @JsonProperty("cbu_code")
    private String cbuCode;
    @JsonProperty("is_enabled")
    private Boolean is_enabled;
}
