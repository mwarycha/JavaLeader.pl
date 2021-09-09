
import org.hamcrest.core.IsNull;
import pl.javaleader.dto.PersonDto;
import pl.javaleader.mappers.PersonMapper;
import pl.javaleader.model.Address;
import pl.javaleader.model.Person;
import pl.javaleader.model.Sex;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class PersonTest {

    @Test
    public void shoudlMapPersonToPersonDto() {

        //given
        Person person = new Person("Java", "Leader", Sex.M, new Address(
                "streetName",
                "cityName",
                "stateName",
                "zipCodeName"
        ));

        //*********************************************************************

        //when
        PersonDto personDto = PersonMapper.INSTANCE.personToPersonDto(person);

        //then
        assertThat(personDto, is(IsNull.notNullValue()));
        assertThat(personDto.getUsername(), is("Java"));
        assertThat(personDto.getSurname(), is("Leader"));
        assertThat(personDto.getSex(), is("M"));

        assertThat(personDto.getAddressDto(), is(IsNull.notNullValue()));
        assertThat(personDto.getAddressDto().getStreet(), is("streetName"));
        assertThat(personDto.getAddressDto().getCity(), is("cityName"));
        assertThat(personDto.getAddressDto().getState(), is("stateName"));
        assertThat(personDto.getAddressDto().getZipCode(), is("zipCodeName"));

        //*********************************************************************

        //when
        PersonDto personWithoutAddressDto = PersonMapper.INSTANCE.personToPersonDtoWithoutAddress(person);

        //then
        assertThat(personWithoutAddressDto, is(IsNull.notNullValue()));
        assertThat(personWithoutAddressDto.getUsername(), is("Java"));
        assertThat(personWithoutAddressDto.getSurname(), is("Leader"));
        assertThat(personWithoutAddressDto.getSex(), is("M"));

        assertThat(personWithoutAddressDto.getAddressDto(), is(IsNull.nullValue()));

        //*********************************************************************

        //when
        Person personDtoWithoutAddress = PersonMapper.INSTANCE.personDtoToPersonWithoutAddress(personDto);

        //then
        assertThat(personDtoWithoutAddress, is(IsNull.notNullValue()));
        assertThat(personDtoWithoutAddress.getName(), is("Java"));
        assertThat(personDtoWithoutAddress.getSurname(), is("Leader"));
        assertThat(personDtoWithoutAddress.getSex(), is(Sex.M));

        assertThat(personDtoWithoutAddress.getAddress(), is(IsNull.nullValue()));

        //*********************************************************************

    }

}
