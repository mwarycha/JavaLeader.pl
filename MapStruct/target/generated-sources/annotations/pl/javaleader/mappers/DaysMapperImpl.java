package pl.javaleader.mappers;

import javax.annotation.Generated;
import pl.javaleader.enums.DaysWeekEnum;
import pl.javaleader.enums.DaysWeekEnumDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-09T11:53:31+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
public class DaysMapperImpl implements DaysMapper {

    @Override
    public DaysWeekEnumDto mapDaysWeekToDaysWeekDtoEnum(DaysWeekEnum daysWeekEnum) {
        if ( daysWeekEnum == null ) {
            return null;
        }

        DaysWeekEnumDto daysWeekEnumDto;

        switch ( daysWeekEnum ) {
            case MONDAY: daysWeekEnumDto = DaysWeekEnumDto.MON;
            break;
            case TUESDAY: daysWeekEnumDto = DaysWeekEnumDto.TUE;
            break;
            case WEDNESDAY: daysWeekEnumDto = DaysWeekEnumDto.WED;
            break;
            case THURSDAY: daysWeekEnumDto = DaysWeekEnumDto.THU;
            break;
            case FRIDAY: daysWeekEnumDto = DaysWeekEnumDto.FRI;
            break;
            case SATURDAY: daysWeekEnumDto = DaysWeekEnumDto.SAT;
            break;
            case SUNDAY: daysWeekEnumDto = DaysWeekEnumDto.SUN;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + daysWeekEnum );
        }

        return daysWeekEnumDto;
    }
}
