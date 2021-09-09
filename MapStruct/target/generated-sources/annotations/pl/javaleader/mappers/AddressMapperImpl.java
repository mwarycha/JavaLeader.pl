package pl.javaleader.mappers;

import javax.annotation.Generated;
import pl.javaleader.dto.AddressDto;
import pl.javaleader.model.Address;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-09T11:53:31+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressDto addressToAddressDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setStreet( address.getStreet() );
        addressDto.setCity( address.getCity() );
        addressDto.setState( address.getState() );
        addressDto.setZipCode( address.getZipCode() );

        return addressDto;
    }

    @Override
    public AddressDto addressToAddressDtoWithoutStreet(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setCity( address.getCity() );
        addressDto.setState( address.getState() );
        addressDto.setZipCode( address.getZipCode() );

        return addressDto;
    }
}
