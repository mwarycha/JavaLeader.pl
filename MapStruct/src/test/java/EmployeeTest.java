
import pl.javaleader.dto.EmployeeDto;
import pl.javaleader.mappers.EmployeeMapper;
import pl.javaleader.model.Employee;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class EmployeeTest {
    @Test
    public void shouldMappingEmployeeToEmployeeDto() {
        Employee  employee      = new Employee(1, "Java", "Leader", new Double(1200));
        Employee  employee2      = new Employee(1, "Java", "Leader");

        EmployeeDto employeeDto = EmployeeMapper.INSTANCE.mapEmployeeToEmployeeDto(employee);
        EmployeeDto employeeDto2 = EmployeeMapper.INSTANCE.mapEmployeeToEmployeeDto(employee2);
        assertThat(employeeDto.getSalary(), is("$1200,00"));
        assertThat(employeeDto2.getSalary(), is("$1500"));
    }
}
