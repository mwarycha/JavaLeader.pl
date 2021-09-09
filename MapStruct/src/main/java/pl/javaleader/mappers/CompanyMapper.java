package pl.javaleader.mappers;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import pl.javaleader.dto.CompanyDto;
import pl.javaleader.model.Company;

@Mapper
public abstract class CompanyMapper {

    public abstract CompanyDto companyToCompanyDto(Company company);

    public static CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    @AfterMapping
    public void afterMappingCompanyToCompanyDto(Company company, @MappingTarget CompanyDto companyDto) {
        System.out.println("[invoke] afterMappingCompanyToCompanyDto");
        companyDto.setEmployeeId(company.getEmployee().getId());
    }

    @BeforeMapping
    public void beforeMappingCompanyToCompanyDto(Company company, @MappingTarget CompanyDto companyDto) {
        System.out.println("operations before mapping company => companyDto");
    }
}
