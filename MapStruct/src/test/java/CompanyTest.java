
import pl.javaleader.dto.CompanyDto;
import pl.javaleader.mappers.CompanyMapper;
import pl.javaleader.model.Company;
import pl.javaleader.model.Employee;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class CompanyTest {
@Test
public void shouldMappingCompanyId() {

    Employee  employee = new Employee(1, "Java", "Leader",  new Double(1200));
    Company company = new Company(employee);

    CompanyDto companyDto = CompanyMapper.INSTANCE.companyToCompanyDto(company);
    assertThat(companyDto.getEmployeeId(),is(1));
}
}
