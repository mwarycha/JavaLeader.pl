package pl.javaleader.mappers;

import javax.annotation.Generated;
import pl.javaleader.dto.CompanyDto;
import pl.javaleader.model.Company;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-09T11:53:31+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
public class CompanyMapperImpl extends CompanyMapper {

    @Override
    public CompanyDto companyToCompanyDto(Company company) {
        if ( company == null ) {
            return null;
        }

        CompanyDto companyDto = new CompanyDto();

        beforeMappingCompanyToCompanyDto( company, companyDto );

        afterMappingCompanyToCompanyDto( company, companyDto );

        return companyDto;
    }
}
