package pl.javaleader.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;
import pl.javaleader.dto.CompanyDto;
import pl.javaleader.dto.EmployeeDto;
import pl.javaleader.enums.StatusEnum;
import pl.javaleader.enums.StatusEnumDto;
import pl.javaleader.model.Company;
import pl.javaleader.model.Employee;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(source = "salary",target = "salary", numberFormat = "$#.00", defaultExpression = "java(new String(\"$1500\"))")
    EmployeeDto mapEmployeeToEmployeeDto(Employee employee);
}
