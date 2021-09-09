package pl.javaleader.mappers;

import org.mapstruct.factory.Mappers;
import pl.javaleader.enums.DaysWeekEnumDto;
import pl.javaleader.enums.DaysWeekEnum;

import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;

@Mapper
public interface DaysMapper {

    DaysMapper INSTANCE = Mappers.getMapper(DaysMapper.class);

    @ValueMappings({
            @ValueMapping(source = "MONDAY",   target = "MON"),
            @ValueMapping(source = "TUESDAY",  target = "TUE"),
            @ValueMapping(source = "WEDNESDAY",target = "WED"),
            @ValueMapping(source = "THURSDAY", target = "THU"),
            @ValueMapping(source = "FRIDAY",   target = "FRI"),
            @ValueMapping(source = "SATURDAY", target = "SAT"),
            @ValueMapping(source = "SUNDAY",   target = "SUN")
    })
    DaysWeekEnumDto mapDaysWeekToDaysWeekDtoEnum(DaysWeekEnum daysWeekEnum);
}
