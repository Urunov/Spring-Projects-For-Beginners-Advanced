package uz.edu.biblatekaservice.model;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = AuthorValidator.class)
public @interface Author {
    //
    String message() default "Author is not allowed";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}


