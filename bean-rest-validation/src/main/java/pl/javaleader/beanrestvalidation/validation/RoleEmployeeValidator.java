package pl.javaleader.beanrestvalidation.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RoleEmployeeValidator implements ConstraintValidator<EmployeeRoleValid, String> {

    @Override
    public void initialize(EmployeeRoleValid employeeRole) {
    }

    @Override
    public boolean isValid(String employeeRole, ConstraintValidatorContext cxt) {
        return (employeeRole.contains("DEV")) ? true: false;
    }

}

