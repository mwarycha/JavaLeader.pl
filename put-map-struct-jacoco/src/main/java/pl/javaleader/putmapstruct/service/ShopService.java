package pl.javaleader.putmapstruct.service;

import pl.javaleader.putmapstruct.dto.Cart;
import pl.javaleader.putmapstruct.mappers.CartMapper;
import pl.javaleader.putmapstruct.model.CartEntity;
import pl.javaleader.putmapstruct.repositories.CartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShopService {

    @Autowired
    CartMapper cartMapper;

    @Autowired
    CartRepository cartRepository;

    public CartEntity getEntityAfterUpdate(Cart cart, CartEntity cartEntity) {
        return cartMapper.cartToCartEntity(cart, cartEntity);
    }

    public CartEntity update(Cart cart) {

        CartEntity cartEntityToUpdate =  cartRepository.findById(1).get();
        CartEntity cartEntityAfterUpdate = getEntityAfterUpdate(cart, cartEntityToUpdate);
        cartRepository.save(cartEntityAfterUpdate);

        return cartEntityAfterUpdate;
    }
}
