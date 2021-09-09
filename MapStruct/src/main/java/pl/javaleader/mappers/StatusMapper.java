package pl.javaleader.mappers;

import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;
import pl.javaleader.enums.StatusEnum;
import pl.javaleader.enums.StatusEnumDto;

import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;

@Mapper
public interface StatusMapper {

    StatusMapper INSTANCE = Mappers.getMapper(StatusMapper.class);

    @ValueMapping(source = "LOW",target = "LOW")
    @ValueMapping(source = "MEDIUM",target = "MEDIUM")
    @ValueMapping(source = "MAX",target = "HIGH")
    @ValueMapping(source =  MappingConstants.ANY_REMAINING, target = "OTHER")
    StatusEnumDto mapStatusToStatusDto(StatusEnum statusEnum);
}
