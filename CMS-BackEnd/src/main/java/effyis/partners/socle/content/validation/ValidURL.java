package effyis.partners.socle.content.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = URLConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE,ElementType.CONSTRUCTOR,ElementType.PARAMETER})
public @interface ValidURL {

    String message() default "Invalid URL";

    Class<?>[] group() default {};
    Class<? extends Payload>[] payload() default {};
}
