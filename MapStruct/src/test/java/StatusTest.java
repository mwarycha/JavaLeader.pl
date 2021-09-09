import org.junit.Test;

import pl.javaleader.enums.StatusEnum;
import pl.javaleader.enums.StatusEnumDto;
import pl.javaleader.mappers.StatusMapper;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StatusTest {

    @Test
    public void shouldMapStatusToStatusDto() {

        StatusEnum MAX    = StatusEnum.MAX;
        StatusEnumDto max = StatusMapper.INSTANCE.mapStatusToStatusDto(MAX);
        assertThat(max, is(StatusEnumDto.HIGH));

        StatusEnum MEDIUM    = StatusEnum.MEDIUM;
        StatusEnumDto medium = StatusMapper.INSTANCE.mapStatusToStatusDto(MEDIUM);
        assertThat(medium, is(StatusEnumDto.MEDIUM));

        StatusEnum LOW    = StatusEnum.LOW;
        StatusEnumDto low = StatusMapper.INSTANCE.mapStatusToStatusDto(LOW);
        assertThat(low, is(StatusEnumDto.LOW));

        StatusEnum VERY_LOW    = StatusEnum.VERY_LOW;
        StatusEnumDto very_low = StatusMapper.INSTANCE.mapStatusToStatusDto(VERY_LOW);
        assertThat(very_low, is(StatusEnumDto.OTHER));

    }
}