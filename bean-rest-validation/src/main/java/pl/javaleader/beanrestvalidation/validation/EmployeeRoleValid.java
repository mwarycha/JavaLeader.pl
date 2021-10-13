package pl.javaleader.beanrestvalidation.validation;

import javax.validation.Payload;
import java.lang.annotation.*;

import javax.validation.Constraint;

@Documented
@Constraint(validatedBy = RoleEmployeeValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface EmployeeRoleValid {
    String message() default "Invalid employee role";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}