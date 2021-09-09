package pl.javaleader.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.mapstruct.factory.Mappers;
import pl.javaleader.dto.PersonDto;
import pl.javaleader.model.Person;
import pl.javaleader.model.Sex;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-09T11:53:30+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
public class PersonMapperImpl implements PersonMapper {

    private final AddressMapper addressMapper = Mappers.getMapper( AddressMapper.class );

    @Override
    public PersonDto personToPersonDto(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDto personDto = new PersonDto();

        personDto.setUsername( person.getName() );
        personDto.setAddressDto( addressMapper.addressToAddressDto( person.getAddress() ) );
        personDto.setSurname( person.getSurname() );
        if ( person.getSex() != null ) {
            personDto.setSex( person.getSex().name() );
        }

        return personDto;
    }

    @Override
    public PersonDto personToPersonDtoWithoutAddress(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDto personDto = new PersonDto();

        personDto.setUsername( person.getName() );
        personDto.setSurname( person.getSurname() );
        if ( person.getSex() != null ) {
            personDto.setSex( person.getSex().name() );
        }

        return personDto;
    }

    @Override
    public PersonDto personToPersonDtoWithAddressWithoutStreet(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDto personDto = new PersonDto();

        personDto.setUsername( person.getName() );
        personDto.setAddressDto( addressMapper.addressToAddressDtoWithoutStreet( person.getAddress() ) );
        personDto.setSurname( person.getSurname() );
        if ( person.getSex() != null ) {
            personDto.setSex( person.getSex().name() );
        }

        return personDto;
    }

    @Override
    public Person personDtoToPersonWithoutAddress(PersonDto personDto) {
        if ( personDto == null ) {
            return null;
        }

        Person person = new Person();

        person.setName( personDto.getUsername() );
        person.setSurname( personDto.getSurname() );
        if ( personDto.getSex() != null ) {
            person.setSex( Enum.valueOf( Sex.class, personDto.getSex() ) );
        }

        return person;
    }

    @Override
    public List<PersonDto> personListToPersonListDto(List<Person> personList) {
        if ( personList == null ) {
            return null;
        }

        List<PersonDto> list = new ArrayList<PersonDto>( personList.size() );
        for ( Person person : personList ) {
            list.add( personToPersonDtoWithoutAddress( person ) );
        }

        return list;
    }
}
