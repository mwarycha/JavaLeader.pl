package pl.javaleader.mappers;

import java.text.DecimalFormat;
import javax.annotation.Generated;
import pl.javaleader.dto.EmployeeDto;
import pl.javaleader.model.Employee;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-09T11:53:31+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeDto mapEmployeeToEmployeeDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        if ( employee.getSalary() != null ) {
            employeeDto.setSalary( new DecimalFormat( "$#.00" ).format( employee.getSalary() ) );
        }
        else {
            employeeDto.setSalary( new String("$1500") );
        }
        employeeDto.setId( employee.getId() );
        employeeDto.setName( employee.getName() );
        employeeDto.setSurname( employee.getSurname() );

        return employeeDto;
    }
}
