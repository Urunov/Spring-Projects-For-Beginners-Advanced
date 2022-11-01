package uz.edu.travelservice.exception;

import lombok.NoArgsConstructor;

/**
 * @project: spring-university-project
 * @Date: 06.10.2022
 * @author: H_Urunov
 **/

@NoArgsConstructor
public class ApiException extends RuntimeException {
    //
    private static final long serialVersionUID = 1L;

    public static final String INTERNAL_SERVER_ERROR = "Error occurs while connecting server.";
    public static final String MEMBER_WITH_ID_NOT_FOUND = "Member cannot find it.";
    public static final String MEMBER_WITH_EMAIL_NOT_FOUND = "Member email cannot find it.";
    public static final String MEMBER_WITH_NAME_NOT_FOUND = "Member name cannot find it.";
    public static final String MEMBER_WITH_NICKNAME_NOT_FOUND = "Member nick name cannot find it.";
    public static final String MEMBER_WITH_BIRTHDAY_NOT_FOUND = "Member birthday cannot find it.";


}
