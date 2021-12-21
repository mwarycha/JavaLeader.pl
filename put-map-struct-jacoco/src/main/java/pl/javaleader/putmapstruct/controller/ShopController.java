package pl.javaleader.putmapstruct.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.javaleader.putmapstruct.dto.Cart;
import pl.javaleader.putmapstruct.mappers.CartMapper;
import pl.javaleader.putmapstruct.model.CartEntity;
import pl.javaleader.putmapstruct.model.ItemEntity;
import pl.javaleader.putmapstruct.repositories.CartRepository;
import pl.javaleader.putmapstruct.service.ShopService;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class ShopController {

    @Autowired
    CartMapper cartMapper;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ShopService shopService;

    @PostMapping("/createSampleData")
    public void createSampleData() {

        CartEntity cartEntity = new CartEntity();

        ItemEntity itemEntity1 = new ItemEntity("item-1", "A");
        ItemEntity itemEntity2 = new ItemEntity("item-2", "B");
        ItemEntity itemEntity3 = new ItemEntity("item-3", "C");

        cartEntity.itemEntities = new HashSet<>();
        cartEntity.itemEntities.addAll(List.of(itemEntity1, itemEntity2, itemEntity3));
        cartRepository.save(cartEntity);

    }

    @GetMapping("getCart")
    public ResponseEntity<Cart> getCart() {
        Cart cart = cartMapper.cartEntityToDto(cartRepository.findById(1).get());
        return new ResponseEntity<Cart>(cart, HttpStatus.OK);
    }

    @PutMapping("updateCart")
    public ResponseEntity<CartEntity> updateCart(@RequestBody Cart cart) {
        CartEntity cartEntity = shopService.update(cart);
        return new ResponseEntity<CartEntity>(cartEntity, HttpStatus.OK);
    }

}
