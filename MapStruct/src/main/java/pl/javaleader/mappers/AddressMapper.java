package pl.javaleader.mappers;

import org.mapstruct.Mapping;
import org.mapstruct.Named;
import pl.javaleader.dto.AddressDto;
import pl.javaleader.model.Address;

import org.mapstruct.Mapper;

@Mapper
public interface AddressMapper {

    AddressDto addressToAddressDto(Address address);

    @Mapping(ignore = true, target = "street")
    @Named("addressToAddressDtoWithoutStreet")
    AddressDto addressToAddressDtoWithoutStreet(Address address);
}
