package pl.javaleader.putmapstruct.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.javaleader.putmapstruct.config.MapperConfig;
import pl.javaleader.putmapstruct.dto.Cart;
import pl.javaleader.putmapstruct.mappers.CartMapper;
import pl.javaleader.putmapstruct.mappers.ItemMapper;
import pl.javaleader.putmapstruct.model.CartEntity;
import pl.javaleader.putmapstruct.model.ItemEntity;
import pl.javaleader.putmapstruct.repositories.CartRepository;
import pl.javaleader.putmapstruct.repositories.ItemRepository;
import pl.javaleader.putmapstruct.service.ShopService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.context.annotation.Import;

@ExtendWith(SpringExtension.class)
@Import(ShopController.class)
@ContextConfiguration(classes = {MapperConfig.class})
public class ControllerTest {

    @SpyBean
    CartMapper cartMapper;

    @SpyBean
    ItemMapper itemMapper;

    @MockBean
    CartRepository cartRepository;

    @MockBean
    ItemRepository itemRepository;

    @MockBean
    ShopService shopService;

    @Autowired
    ShopController shopController;

    @Test
    void shouldCreateSampleData() {

        // given
        CartEntity cartEntity  = new CartEntity();
        ItemEntity itemEntity1 = new ItemEntity("item-1", "A");
        ItemEntity itemEntity2 = new ItemEntity("item-2", "B");
        ItemEntity itemEntity3 = new ItemEntity("item-3", "C");

        cartEntity.itemEntities = new HashSet<>();
        cartEntity.itemEntities.addAll(List.of(
                itemEntity1,
                itemEntity2,
                itemEntity3)
        );

        // when
        Cart cart = shopController.createSampleData();

        // then
        assertEquals(3, cart.getItems().size());

    }

    @Test
    void shouldGetCart() {

        // given
        CartEntity cartEntity = new CartEntity();
        ItemEntity itemEntity = new ItemEntity("item-1", "A");

        cartEntity.itemEntities.add(itemEntity);

        // when
        when(cartRepository.findById(1)).thenReturn(Optional.of(cartEntity));
        ResponseEntity<Cart> response = shopController.getCart();

        // then
       response.getBody().getItems().forEach(
               item -> {
                   assertEquals(item.getCode(),"A");
                   assertEquals(item.getName(),"item-1");
               }
       );

       assertEquals(200, response.getStatusCodeValue());
       assertNotNull(response.getBody());
    }


    @Test
    void shouldUpdateCart() {

        // given
        Cart cart = new Cart();
        CartEntity cartEntity = new CartEntity();

        // when
        when(shopService.update(cart)).thenReturn(cartEntity);
        ResponseEntity<CartEntity> response = shopController.updateCart(cart);

        // then
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
    }

}
