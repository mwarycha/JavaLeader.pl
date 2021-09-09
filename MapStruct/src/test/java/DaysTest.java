import pl.javaleader.enums.DaysWeekEnum;
import pl.javaleader.enums.DaysWeekEnumDto;
import pl.javaleader.mappers.DaysMapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class DaysTest {

    @Test
    public void shouldMapEnumToEnumDto() {

        DaysWeekEnum monday   = DaysWeekEnum.MONDAY;
        DaysWeekEnum tuesday  = DaysWeekEnum.TUESDAY;
        DaysWeekEnum wednsday = DaysWeekEnum.WEDNESDAY;
        DaysWeekEnum thursday = DaysWeekEnum.THURSDAY;
        DaysWeekEnum friday   = DaysWeekEnum.FRIDAY;
        DaysWeekEnum saturday = DaysWeekEnum.SATURDAY;
        DaysWeekEnum sunday   = DaysWeekEnum.SUNDAY;

        DaysWeekEnumDto mondayToDto = DaysMapper.INSTANCE.mapDaysWeekToDaysWeekDtoEnum(monday);
        assertThat(mondayToDto, is(DaysWeekEnumDto.MON));

        DaysWeekEnumDto tuesdayToDto = DaysMapper.INSTANCE.mapDaysWeekToDaysWeekDtoEnum(tuesday);
        assertThat(tuesdayToDto, is(DaysWeekEnumDto.TUE));

        DaysWeekEnumDto wednsdayToDto = DaysMapper.INSTANCE.mapDaysWeekToDaysWeekDtoEnum(wednsday);
        assertThat(wednsdayToDto, is(DaysWeekEnumDto.WED));

        DaysWeekEnumDto thursdayToDto = DaysMapper.INSTANCE.mapDaysWeekToDaysWeekDtoEnum(thursday);
        assertThat(thursdayToDto, is(DaysWeekEnumDto.THU));

        DaysWeekEnumDto fridayToDto = DaysMapper.INSTANCE.mapDaysWeekToDaysWeekDtoEnum(friday);
        assertThat(fridayToDto, is(DaysWeekEnumDto.FRI));

        DaysWeekEnumDto saturdayToDto = DaysMapper.INSTANCE.mapDaysWeekToDaysWeekDtoEnum(saturday);
        assertThat(saturdayToDto, is(DaysWeekEnumDto.SAT));

        DaysWeekEnumDto sundayToDto = DaysMapper.INSTANCE.mapDaysWeekToDaysWeekDtoEnum(sunday);
        assertThat(sundayToDto, is(DaysWeekEnumDto.SUN));
    }
}
