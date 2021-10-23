package pl.javaleader.beanrestvalidation.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.javaleader.beanrestvalidation.model.Employee;
import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class EmployeeValidator implements Validator {

    String[] blackList = {"?", "|", "-", "="};

    public boolean supports(Class clazz) {
        return Employee.class.equals(clazz);
    }
    
    public void validate(Object obj, Errors e) {

        Employee employee = (Employee) obj;

        boolean blackListCheckName    = Arrays.stream(blackList).anyMatch(employee.getName()::contains);
        boolean blackListCheckSurname = Arrays.stream(blackList).anyMatch(employee.getSurname()::contains);

        if(blackListCheckName) {
           e.reject("name", "name contains forbidden characters");
        }

        if(blackListCheckSurname) {
            e.reject("surname", "surname contains forbidden characters");
        }
    }
}