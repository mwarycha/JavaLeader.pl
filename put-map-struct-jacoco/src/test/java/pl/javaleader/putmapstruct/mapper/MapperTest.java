package pl.javaleader.putmapstruct.mapper;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.javaleader.putmapstruct.config.MapperConfig;
import pl.javaleader.putmapstruct.dto.Item;
import pl.javaleader.putmapstruct.mappers.CartMapper;
import pl.javaleader.putmapstruct.mappers.ItemMapper;
import pl.javaleader.putmapstruct.model.ItemEntity;
import pl.javaleader.putmapstruct.repositories.CartRepository;
import pl.javaleader.putmapstruct.repositories.ItemRepository;
import pl.javaleader.putmapstruct.service.ShopService;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MapperConfig.class})
public class MapperTest {

    @SpyBean
    ShopService shopService;

    @SpyBean
    CartMapper cartMapper;

    @SpyBean
    ItemMapper itemMapper;

    @MockBean
    CartRepository cartRepository;

    @MockBean
    ItemRepository itemRepository;

    @Test
    void shouldItemToItemEntity() {

        // given
        Item item = new Item();
        item.setName("name");
        item.setCode("code");

        // when
       ItemEntity itemEntityAfterMapped = itemMapper.itemToItemEntity(item);

        // then
        assertEquals("code", itemEntityAfterMapped.getCode());
        assertEquals("name", itemEntityAfterMapped.getName());

    }

}
