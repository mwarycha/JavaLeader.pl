package pl.javaleader.putmapstruct.service;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.javaleader.putmapstruct.config.MapperConfig;
import pl.javaleader.putmapstruct.dto.Cart;
import pl.javaleader.putmapstruct.mappers.CartMapper;
import pl.javaleader.putmapstruct.mappers.ItemMapper;
import pl.javaleader.putmapstruct.model.CartEntity;
import pl.javaleader.putmapstruct.repositories.CartRepository;
import pl.javaleader.putmapstruct.repositories.ItemRepository;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MapperConfig.class})
public class ServiceTest {

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
    void shouldGetEntityAfterUpdate() {

        // given
        Cart cart = new Cart();
        CartEntity cartEntity = new CartEntity();

        // when
        when(cartMapper.cartToCartEntity(cart, cartEntity)).thenReturn(cartEntity);

        // then
        assertEquals(cartEntity,  shopService.getEntityAfterUpdate(cart,cartEntity));

    }

    @Test
    void shouldGUpdate() {

        // given
        Cart cart = new Cart();
        CartEntity cartEntity = new CartEntity();

        // when
        when(cartRepository.findById(1)).thenReturn(Optional.of(cartEntity));
        when(shopService.getEntityAfterUpdate(cart, cartEntity)).thenReturn(cartEntity);

        // then
        assertEquals(cartEntity,  shopService.update(cart));

    }
}
