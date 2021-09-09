package pl.javaleader.mappers;

import javax.annotation.Generated;
import pl.javaleader.enums.StatusEnum;
import pl.javaleader.enums.StatusEnumDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-09T11:53:31+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
public class StatusMapperImpl implements StatusMapper {

    @Override
    public StatusEnumDto mapStatusToStatusDto(StatusEnum statusEnum) {
        if ( statusEnum == null ) {
            return null;
        }

        StatusEnumDto statusEnumDto;

        switch ( statusEnum ) {
            case LOW: statusEnumDto = StatusEnumDto.LOW;
            break;
            case MEDIUM: statusEnumDto = StatusEnumDto.MEDIUM;
            break;
            case MAX: statusEnumDto = StatusEnumDto.HIGH;
            break;
            default: statusEnumDto = StatusEnumDto.OTHER;
        }

        return statusEnumDto;
    }
}
