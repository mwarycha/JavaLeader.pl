package pl.javaleader.mappers;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import pl.javaleader.dto.PersonDto;
import pl.javaleader.model.Person;

import java.util.List;

@Mapper(uses = AddressMapper.class)
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(source = "name", target = "username")
    @Mapping(source = "address", target = "addressDto")
    PersonDto personToPersonDto(Person person);

    @InheritConfiguration(name = "personToPersonDto")
    @Mapping(ignore = true, target = "addressDto")
    @Named("personToPersonDtoWithoutAddress")
    PersonDto personToPersonDtoWithoutAddress(Person person);

    @Mapping(source = "name", target = "username")
    @Mapping(source = "address", target = "addressDto", qualifiedByName = "addressToAddressDtoWithoutStreet")
    PersonDto personToPersonDtoWithAddressWithoutStreet(Person person);

    @InheritInverseConfiguration(name = "personToPersonDto")
    @Mapping(ignore = true, target = "address")
    Person personDtoToPersonWithoutAddress(PersonDto personDto);

    @IterableMapping(qualifiedByName = "personToPersonDtoWithoutAddress")
    List<PersonDto> personListToPersonListDto(List<Person> personList);

}

